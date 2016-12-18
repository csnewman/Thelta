package com.error22.thelta.pipeline;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraftforge.fml.relauncher.Side;

public class TheltaPipeline {
	private Side side;
	private Map<String, PipelineStage> stages;
	private List<PipelineNode> order;

	public TheltaPipeline(Side side) {
		this.side = side;
		stages = new HashMap<String, PipelineStage>();
	}

	public void construct(Class<?>... classes) throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		for (Class<?> clazz : classes) {
			Object instance = null;
			for (Field f : clazz.getDeclaredFields()) {
				if (f.isAnnotationPresent(PipelineInstance.class)) {
					if (!Modifier.isStatic(f.getModifiers())) {
						throw new RuntimeException(
								"PipelineInstance annotation on none static field in " + clazz.getName() + "!");
					}
					if (instance != null) {
						throw new RuntimeException("Multiple PipelineInstance fields in " + clazz.getName() + "!");
					}
					if (!f.getType().isAssignableFrom(clazz)) {
						throw new RuntimeException(
								"PipelineInstance annotation on none assignable field in " + clazz.getName() + "!");
					}
					instance = clazz.getConstructor().newInstance();
					f.setAccessible(true);
					f.set(null, instance);
				}
			}

			for (Field f : clazz.getDeclaredFields()) {
				if (f.isAnnotationPresent(FieldStage.class)) {
					if (!f.getType().isAssignableFrom(PipelineStage.class)) {
						throw new RuntimeException(
								"FieldStage annotation on none assignable field in " + clazz.getName() + "!");
					}

					FieldStage fs = f.getAnnotation(FieldStage.class);
					PipelineStage stage = newStage(fs.name());
					stage.before(fs.before());
					stage.after(fs.after());

					f.setAccessible(true);
					if (Modifier.isStatic(f.getModifiers())) {
						if (instance == null) {
							throw new RuntimeException(
									"FieldStage annotation on non static field where no PipelineInstance exists in "
											+ clazz.getName() + "!");
						}
						f.set(null, stage);
					} else {
						f.set(instance, stage);
					}
				}
			}

			// TODO: Pure method stages

			for (Method m : clazz.getDeclaredMethods()) {
				if (m.isAnnotationPresent(StageMethod.class)) {
					StageMethod sm = m.getDeclaredAnnotation(StageMethod.class);
					if (!stages.containsKey(sm.stage())) {
						throw new RuntimeException("Unknown stage name " + sm.stage() + " in " + clazz.getName() + "!");
					}

					PipelineStage stage = stages.get(sm.stage());
					MethodPipelineAction mpa;
					if (Modifier.isStatic(m.getModifiers())) {
						mpa = new MethodPipelineAction(null, m);
					} else {
						if (instance == null) {
							throw new RuntimeException(
									"StageMethod annotation on non static method where no PipelineInstance exists in "
											+ clazz.getName() + "!");
						}
						mpa = new MethodPipelineAction(instance, m);
					}

					if (!sm.client() && !sm.server()) {
						stage.setAction(sm.pass(), mpa);
					} else if (sm.client() && side == Side.CLIENT) {
						stage.setClientAction(sm.pass(), mpa);
					} else if (sm.server() && side == Side.SERVER) {
						stage.setServerAction(sm.pass(), mpa);
					}
				}

			}

			if (instance != null && instance instanceof IPipelineAware) {
				construct((IPipelineAware) instance);
			}
		}
	}

	public void construct(IPipelineAware awareObject) {
		awareObject.definePipeline(this);
		if (side == Side.CLIENT) {
			awareObject.defineClientPipeline(this);
		} else if (side == Side.SERVER) {
			awareObject.defineServerPipeline(this);
		}
	}

	public void rebuild() {

		Map<String, PipelineNode> nodeMap = new HashMap<String, PipelineNode>();

		for (PipelineStage stage : stages.values()) {
			nodeMap.put(stage.getName(), new PipelineNode(stage));
		}

		for (PipelineStage stage : stages.values()) {
			PipelineNode node = nodeMap.get(stage.getName());

			List<String> after = stage.getAfter();
			for (String sub : after) {
				node.addDependency(nodeMap.get(sub));
			}

			List<String> before = stage.getBefore();
			for (String sub : before) {
				nodeMap.get(sub).addDependency(node);
			}
		}

		List<String> notLoaded = new ArrayList<String>();
		notLoaded.addAll(nodeMap.keySet());
		for (PipelineNode node : nodeMap.values()) {
			for (PipelineNode dep : node.getDependencies()) {
				notLoaded.remove(dep.getStage().getName());
			}
		}

		PipelineNode root = new PipelineNode(null);
		for (String name : notLoaded) {
			root.addDependency(nodeMap.get(name));
		}

		List<PipelineNode> resolved = new LinkedList<PipelineNode>();
		List<PipelineNode> unresolved = new ArrayList<PipelineNode>();

		resolve(root, resolved, unresolved);

		resolved.remove(root);
		order = resolved;
	}

	private void resolve(PipelineNode node, List<PipelineNode> resolved, List<PipelineNode> unresolved) {
		System.out.println("Resolving " + node.getName());
		unresolved.add(node);
		for (PipelineNode dep : node.getDependencies()) {
			if (!resolved.contains(dep)) {
				if (unresolved.contains(dep))
					throw new RuntimeException(
							"Circular dependency detected! " + node.getName() + " to " + dep.getName());
				resolve(dep, resolved, unresolved);
			}
		}
		resolved.add(node);
		unresolved.add(node);
	}

	public PipelineStage newStage(String name) {
		if (stages.containsKey(name))
			throw new RuntimeException("Stage name already in use! " + name);
		PipelineStage stage = new PipelineStage(this, name);
		stages.put(name, stage);
		return stage;
	}

	public void performPass(Pass pass) {
		long start = System.currentTimeMillis();

		for (PipelineNode node : order) {
			PipelineStage stage = node.getStage();
			if (stage.hasCommonPass(pass)) {
				stage.getCommonAction(pass).perform();
			}

			if (side == Side.CLIENT && stage.hasClientPass(pass)) {
				stage.getClientAction(pass).perform();
			} else if (side == Side.SERVER && stage.hasServerPass(pass)) {
				stage.getServerAction(pass).perform();
			}
		}

		System.out.println("Pass " + pass + " took " + (System.currentTimeMillis() - start) + "ms");
	}

}

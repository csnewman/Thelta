package com.error22.thelta.pipeline;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PipelineStage {
	private TheltaPipeline pipeline;
	private String name;
	private EnumSet<Pass> commonPasses, clientPasses, serverPasses;
	private Map<Pass, IPipelineAction> commonActions, clientActions, serverActions;
	private List<String> before, after;

	public PipelineStage(TheltaPipeline pipeline, String name) {
		this.pipeline = pipeline;
		this.name = name;
		before = new ArrayList<String>();
		after = new ArrayList<String>();
		commonPasses = EnumSet.noneOf(Pass.class);
		commonActions = new HashMap<Pass, IPipelineAction>();
		clientPasses = EnumSet.noneOf(Pass.class);
		clientActions = new HashMap<Pass, IPipelineAction>();
		serverPasses = EnumSet.noneOf(Pass.class);
		serverActions = new HashMap<Pass, IPipelineAction>();
	}

	public void setAction(Pass pass, IPipelineAction act) {
		if (commonPasses.contains(pass)) {
			throw new RuntimeException("Pass " + pass + " already contains a common action in stage " + name);
		}
		commonPasses.add(pass);
		commonActions.put(pass, act);
	}

	public void setClientAction(Pass pass, IPipelineAction act) {
		if (clientPasses.contains(pass)) {
			throw new RuntimeException("Pass " + pass + " already contains a client action in stage " + name);
		}
		clientPasses.add(pass);
		clientActions.put(pass, act);
	}

	public void setServerAction(Pass pass, IPipelineAction act) {
		if (serverPasses.contains(pass)) {
			throw new RuntimeException("Pass " + pass + " already contains a server action in stage " + name);
		}
		serverPasses.add(pass);
		serverActions.put(pass, act);
	}

	public boolean hasCommonPass(Pass pass) {
		return commonPasses.contains(pass);
	}

	public IPipelineAction getCommonAction(Pass pass) {
		return commonActions.get(pass);
	}

	public boolean hasClientPass(Pass pass) {
		return clientPasses.contains(pass);
	}

	public IPipelineAction getClientAction(Pass pass) {
		return clientActions.get(pass);
	}

	public boolean hasServerPass(Pass pass) {
		return serverPasses.contains(pass);
	}

	public IPipelineAction getServerAction(Pass pass) {
		return serverActions.get(pass);
	}

	public void before(String... stages) {
		before.addAll(Arrays.asList(stages));
	}

	public void after(String... stages) {
		after.addAll(Arrays.asList(stages));
	}

	public void before(PipelineStage... stages) {
		for (PipelineStage stage : stages) {
			before.add(stage.name);
		}
	}

	public void after(PipelineStage... stages) {
		for (PipelineStage stage : stages) {
			after.add(stage.name);
		}
	}

	public List<String> getBefore() {
		return before;
	}

	public List<String> getAfter() {
		return after;
	}

	public String getName() {
		return name;
	}

}

package com.error22.thelta.mobapi;

import java.util.ArrayList;
import java.util.List;

import com.error22.thelta.Thelta;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

@Stages({
	@Stage(name = MobAPI.stagenameInit),
	@Stage(name = "mobapi-load")
})
public class MobAPI {
	
	public static final String stagenameInit = "mobapi-init";
	private static List<MobListItem> mobsToRegister = new ArrayList<MobListItem>();
	

	@StageMethod(stage = MobAPI.stagenameInit,	pass = Pass.PreInit)	public static void initMobs() {
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		System.out.println("Registering mob entities");
		for(MobListItem item : mobsToRegister) {
			EntityRegistry.registerModEntity(new ResourceLocation(Thelta.MODID, "Entity"+item.mobname), item.entityClass, item.mobname, item.mobid, Thelta.INSTANCE, 80, 3, true, 0, 0);
		}
	}
	
	
	@StageMethod(stage = "mobapi-load",	pass = Pass.Init)	public static void loadMobs() {
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		System.out.println("Registering mob renderers");
		for(MobListItem item : mobsToRegister) {
			System.out.println("CREATE");
			RenderingRegistry.registerEntityRenderingHandler(item.entityClass,
					item.renderInstance);
		}
	}
	
	//This registers a new mob to get registered in the queue
	public static void registerNewMob(int mobid, String mobname, Class<? extends Entity> entityClass, Render<? extends Entity> renderInstance) {
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		System.out.println("Creating mob, "+mobname);
		mobsToRegister.add(new MobListItem(mobid, mobname, entityClass, renderInstance));
	}
}

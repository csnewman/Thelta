package com.error22.thelta.mobapi;

import java.util.ArrayList;
import java.util.List;

import com.error22.thelta.Thelta;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({
	@Stage(name = MobAPI.stagenameInit),
	@Stage(name = "mobapi-load")
})
public class MobAPI {
	
	public static final String stagenameInit = "mobapi-init";
	private static List<MobListItem> mobsToRegister = new ArrayList<MobListItem>();
	

	@StageMethod(stage = MobAPI.stagenameInit,	pass = Pass.PreInit)	public static void initMobs() {
		System.out.println("Registering mob entities");
		for(MobListItem item : mobsToRegister) {
			System.out.println("Registering "+item.mobname);
			EntityRegistry.registerModEntity(new ResourceLocation(Thelta.MODID, "Entity"+item.mobname), item.entityClass, item.mobname, item.mobid, Thelta.INSTANCE, 80, 3, true, 0, 0);
		}
	}
	
	
	//Here we are handleing registering the entity renderers
	@SideOnly(Side.CLIENT)
	@StageMethod(stage = "mobapi-load",	pass = Pass.Init, client = true)	public static void loadMobs() {
		System.out.println("Registering mob renderers");
		for(MobListItem item : mobsToRegister) {
			System.out.println("Regestering renderer to "+item.mobname);
			try {
				RenderingRegistry.registerEntityRenderingHandler(item.entityClass,
						item.renderClass.newInstance());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//This registers a new mob to get registered in the queue
	public static void registerNewMob(int mobid, String mobname, Class<? extends Entity> entityClass, Class<? extends RenderLiving> renderClass) {
		System.out.println("Creating mob, "+mobname);
		mobsToRegister.add(new MobListItem(mobid, mobname, entityClass, renderClass));
	}
}

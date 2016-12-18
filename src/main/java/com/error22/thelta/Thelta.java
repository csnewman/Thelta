package com.error22.thelta;

import com.error22.thelta.computers.TheltaComputers;
import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.mobapi.MobAPI;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.TheltaPipeline;
import com.error22.thelta.pipelineaddons.PipelineAddons;
import com.error22.thelta.tubes.TheltaTubes;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Thelta.MODID, version = Thelta.VERSION)
public class Thelta {
	public static final String MODID = "thelta";
	public static final String VERSION = "1.0";

	@Instance(value = MODID)
	public static Thelta INSTANCE;

	public static TheltaPipeline pipeline;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) throws Exception {
		pipeline = new TheltaPipeline(event.getSide());

		/*
		 * Register your pipeline aware objects here (Order does NOT matter, it
		 * is rearranged as needed)
		 */
		pipeline.construct(TheltaComputers.class);
		pipeline.construct(Minivox.class);
		pipeline.construct(MobAPI.class);
		pipeline.construct(PipelineAddons.class);
		pipeline.construct(TheltaTubes.class);

		pipeline.rebuild();

		pipeline.performPass(Pass.Config);
		pipeline.performPass(Pass.PreInit);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		pipeline.performPass(Pass.Init);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		pipeline.performPass(Pass.PostInit);
	}
}

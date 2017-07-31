package com.error22.thelta;

import com.error22.thelta.common.CraftingMaterials;
import com.error22.thelta.common.Smeltables;
import com.error22.thelta.computers.TheltaComputers;
import com.error22.thelta.machines.Machines;
import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.tubes.TheltaTubes;
import com.error22.thelta.worldgen.WorldGenHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = Thelta.MODID, version = Thelta.VERSION)
public class Thelta {
	public static final String MODID = "thelta";
	public static final String VERSION = "1.0";

	@Instance(value = MODID)
	public static Thelta INSTANCE;

	@SidedProxy(modId = MODID, clientSide = "com.error22.thelta.ClientContext", serverSide = "com.error22.thelta.Context")
	public static Context context;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		OBJLoader.INSTANCE.addDomain(MODID);
		MinecraftForge.EVENT_BUS.register(this);

		context.addModule(new CraftingMaterials());
		context.addModule(new Smeltables());
		context.addModule(new TheltaComputers());
		context.addModule(new Machines());
		context.addModule(new TheltaTubes());
		context.addModule(new Minivox());
		// I will post the new world gen example with the world gen noobs api here.
		context.addModule(new WorldGenHandler());

		// The old world gen from yesterday
		// context.addModule(new TheltaWorld());
		context.preInit(event);
	}

	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {

	}

	@SubscribeEvent
	public void onSomething(TextureStitchEvent.Pre pre) {
		Minecraft.getMinecraft().getTextureMapBlocks().registerSprite(new ResourceLocation("thelta:blocks/newmodel"));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		context.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		context.postInit(event);
	}
}

package com.error22.thelta;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.client.resources.SimpleReloadableResourceManager;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientContext extends Context {
	private List<Item> autoItemRendererRegistrations;
	private TextureMap currentTextureMap;
	private List<AutoModel> autoModels;

	public ClientContext() {
		autoItemRendererRegistrations = new ArrayList<Item>();
		autoModels = new ArrayList<AutoModel>();
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		OBJLoader.INSTANCE.addDomain(Thelta.MODID);
		super.preInit(event);
		state = ContextState.ModelRegistration;
		for (TheltaModule module : modules) {
			module.registerModels(this);
		}
	}

	@SubscribeEvent
	public void onTexturePreStitch(TextureStitchEvent.Pre pre) {
		state = ContextState.LoadingTextures;
		currentTextureMap = pre.getMap();
		for (AutoModel model : autoModels) {
			for (ResourceLocation location : model.getTextures()) {
				currentTextureMap.registerSprite(location);
			}
		}
		for (TheltaModule module : modules) {
			module.loadTextures(this);
		}
		state = ContextState.Intermediary;
	}

	@SubscribeEvent
	public void onModelBake(ModelBakeEvent event) {
		state = ContextState.LoadingModels;
		for (AutoModel model : autoModels) {
			model.loadModelAndBake();
		}
		for (TheltaModule module : modules) {
			module.loadModels(this);
		}
		state = ContextState.Intermediary;
	}

	@Override
	protected void addAutoItemRendererRegistration(Item item) {
		autoItemRendererRegistrations.add(item);
	}

	@Override
	protected void initRenderers() {
		state = ContextState.Intermediary;
		for (Item item : autoItemRendererRegistrations) {
			Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(
					Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory"));
		}
		state = ContextState.RendererRegistration;
		for (TheltaModule module : modules) {
			module.registerRenderers(this);
		}
	}

	public <T extends TileEntity> void registerTESR(Class<T> tileEntityClass,
			TileEntitySpecialRenderer<? super T> specialRenderer) {
		assertState(ContextState.RendererRegistration);
		ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, specialRenderer);
	}

	public void registerEntityRenderingHandler(Class<? extends Entity> entityClass, Render<? extends Entity> renderer) {
		assertState(ContextState.RendererRegistration);
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderer);
	}

	public IModel loadModel(String model) {
		return loadModel(new ResourceLocation(Thelta.MODID, model));
	}

	public IModel loadModel(ResourceLocation location) {
		assertState(ContextState.LoadingModels);
		try {
			return ModelLoaderRegistry.getModel(location);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public IBakedModel bakeSimple(IModel model) {
		return model.bake(TRSRTransformation.identity(), DefaultVertexFormats.ITEM, ModelLoader.defaultTextureGetter());
	}

	public void loadTexture(String file) {
		loadTexture(new ResourceLocation(Thelta.MODID, file));
	}

	public void loadTexture(ResourceLocation location) {
		assertState(ContextState.LoadingTextures);
		currentTextureMap.registerSprite(location);
	}

	public AutoModel registerAutoModel(String name) {
		return registerAutoModel(new ResourceLocation(Thelta.MODID, "models/" + name + ".json"));
	}

	public AutoModel registerAutoModel(ResourceLocation location) {
		assertState(ContextState.ModelRegistration);
		AutoModel model = AutoModel.load(location);
		autoModels.add(model);
		return model;
	}

}

package com.error22.thelta;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientContext extends Context {
	private List<Item> autoItemRendererRegistrations;

	public ClientContext() {
		autoItemRendererRegistrations = new ArrayList<Item>();
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
		ClientRegistry.bindTileEntitySpecialRenderer(tileEntityClass, specialRenderer);
	}

}

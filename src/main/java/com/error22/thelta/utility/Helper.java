package com.error22.thelta.utility;

import com.error22.thelta.Thelta;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class Helper {
	public static void registerBlockRenderer(Block block) {
		registerBlockRenderer(block, 0);
	}
	
	public static void registerBlockRenderer(Block block, int meta) {
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(Thelta.MODID + ":" + block.getRegistryName().getResourcePath(), "inventory"));

	}
}

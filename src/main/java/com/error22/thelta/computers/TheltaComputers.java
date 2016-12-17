package com.error22.thelta.computers;

import com.error22.thelta.Thelta;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheltaComputers {
	public static BasicMonitor basicMonitor;

	public static void preInit() {
		basicMonitor = new BasicMonitor("basicMonitor");
		registerSimpleBlock(basicMonitor);
	}

	public static void init() {

	}

	public static void postInit() {

	}
	
	private static void registerSimpleBlock(Block block) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(block);
		GameRegistry.register(item);
		Thelta.proxy.registerItemRenderer(item, 0, block.getRegistryName().getResourcePath());
	}

}

package com.error22.thelta.computers;

import com.error22.thelta.Thelta;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheltaComputers {
	public static BlockComputer testComputer;

	public static void preInit() {
		testComputer = new BlockComputer("computer_test");
		registerSimpleBlock(testComputer);
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

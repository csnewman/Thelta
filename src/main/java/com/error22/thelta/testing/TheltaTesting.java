package com.error22.thelta.testing;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheltaTesting {
	public static Item testItem;
	public static Block testBlock;

	public static void preInit() {
		GameRegistry.register(new QuickItem("test"));
	}

	public static void init() {

	}

	public static void postInit() {

	}

}

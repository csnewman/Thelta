package com.error22.thelta.minivox;

import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TheltaTesting {
	public static Item testItem;
	public static Block testBlock;

	public static void preInit() {
		Items.testItem = new QuickItem("test");
	}

	public static void init() {
		
	}

	public static void postInit() {
		
	}

}

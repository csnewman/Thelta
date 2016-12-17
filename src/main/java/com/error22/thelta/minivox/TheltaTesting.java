package com.error22.thelta.minivox;

import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class TheltaTesting {
	public static Item testItem;
	public static Block testBlock;

	public static void preInit() {
		Items.testItem = new QuickItem("testitem");
		Blocks.testBlock = new QuickBlock("testblock");
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
		
	}

}

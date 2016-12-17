package com.error22.thelta.minivox;

import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Minivox {
	public static Item testItem;
	public static Block testBlock;
	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");

	public static void preInit() {
		testItem = new QuickItem("testitem");
		testBlock = new QuickBlock("testblock");
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
		
	}

}

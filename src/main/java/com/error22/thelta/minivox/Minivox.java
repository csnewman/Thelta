package com.error22.thelta.minivox;

import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

public class Minivox {
	//items
	public static Item testItem;
	
	//blocks
	public static Block testBlock;
	public static Block rottenFleshBlock;
	
	//creative tabs
	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");

	public static void preInit() {
		testItem = new QuickItem("testitem");
		testBlock = new QuickBlock("testblock");
		rottenFleshBlock = new QuickBlock("rottenfleshblock");
		
		registerItemRenderers();
		registerBlockRenderers();
		
	}
	
	public static void init() {
		//Here we are handling the item renderers
		MinivoxItemRenderRegistry.registerItemRenderer();
	}
	
	public static void postInit() {
		
	}
	
	public static void registerItemRenderers() {
		
	}
	
	public static void registerBlockRenderers() {
		
	}

}

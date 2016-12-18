package com.error22.thelta.minivox;

import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Minivox {
	//items
	public static Item testItem;
	
	//blocks
	public static Block testBlock;
	public static Block rottenFleshBlock;
	
	//creative tabs
	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");

	public static void preInit() {
		//Item creation
		testItem = new QuickItem("testitem");
		rottenFleshBlock = new QuickBlock("rottenfleshblock");
		
		//recipes
		//rotten flesh block
		GameRegistry.addRecipe(new ItemStack(rottenFleshBlock),
		    	"AAA",
		    	"AAA",
		    	"AAA",
		    	'A', Items.ROTTEN_FLESH
		);
	}
	
	public static void init() {
		//Here we are handling the item renderers
		MinivoxItemRenderRegistry.registerItemRenderer();
	}
	
	public static void postInit() {
		
	}
}

package com.error22.thelta.minivox;

import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;
import com.error22.thelta.minivox.entities.render.RenderMinivox;
import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		
		//Model renderers
		//TODO: Change this to load on client after newman uploads his code
		EntityRegistry.addSpawn(EntityMinivox.class, 6, 1, 5, EnumCreatureType.CREATURE, 
			      Biomes.PLAINS); //change the values to vary the spawn rarity, biome, etc. 

	}
	
	//@SideOnly(Side.CLIENT)
	public static void init() {
		//Here we are handling the item renderers
		MinivoxItemRenderRegistry.registerItemRenderer();
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityMinivox.class, 
		//	      new RenderMinivox(new ModelMinivox(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMinivox.class, new RenderMinivox(Minecraft.getMinecraft().getRenderManager()));
		
	}
	
	public static void postInit() {
		
	}
}

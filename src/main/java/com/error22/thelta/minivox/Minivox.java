package com.error22.thelta.minivox;

import com.error22.thelta.ClientContext;
import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;

public class Minivox extends TheltaModule {
	// forge variables
	public static CreativeTabs creativetab;
	public static SoundEvent ENTITY_MINIVOX_IDLE;
	public static SoundEvent ENTITY_MINIVOX_ATTACK;
	public static SoundEvent ENTITY_MINIVOX_TAKEDAMAGE;
	public static SoundEvent ENTITY_MINIVOX_POOP;
	public static SoundEvent ENTITY_MINIVOX_WALK;
	public static SoundEvent ENTITY_MINIVOX_FALL;
	public static SoundEvent ENTITY_MINIVOX_DEATH;
	public static Item testItem;
	public static Item tacogodring;
	public static Block rottenFleshBlock;
	public static BlockTestRender testRenderBlock;

	@Override
	public void init(Context context) {
		creativetab = context.createTabWithItem("minivox", () -> testItem);
	}

	@Override
	public void registerSounds(Context context) {
		ENTITY_MINIVOX_IDLE = context.registerSound("entity.minivox.idle");
		ENTITY_MINIVOX_ATTACK = context.registerSound("entity.minivox.attack");
		ENTITY_MINIVOX_TAKEDAMAGE = context.registerSound("entity.minivox.takedamage");
		ENTITY_MINIVOX_POOP = context.registerSound("entity.minivox.poop");
		ENTITY_MINIVOX_WALK = context.registerSound("entity.minivox.walk");
		ENTITY_MINIVOX_FALL = context.registerSound("entity.minivox.fall");
		ENTITY_MINIVOX_DEATH = context.registerSound("entity.minivox.death");
	}

	@Override
	public void registerBlocks(Context context) {
		rottenFleshBlock = context.createSimpleBlock("rottenfleshblock", Material.ROCK, creativetab);
		testRenderBlock = new BlockTestRender();
		context.registerBlock(testRenderBlock, "blocktestrender", creativetab);

		context.registerTileEntity(TileEntityTestRender.class, "thelta_testrenderblock");
	}

	@Override
	public void registerItems(Context context) {
		testItem = context.createSimpleItem("testitem", creativetab);
		tacogodring = new TacoGodRing();
		context.registerItem(tacogodring, "tacogodsummonring", creativetab);
	}

	@Override
	public void registerRecipes(Context context) {
		// GameRegistry.addRecipe(new ItemStack(rottenFleshBlock), "AAA", "AAA", "AAA",
		// 'A', Items.ROTTEN_FLESH);
		// GameRegistry.addRecipe(new ItemStack(tacogodring), " A ", "B B", " B ", 'A',
		// Blocks.LAPIS_BLOCK, 'B', Items.GOLD_INGOT);
	}

	@Override
	public void registerEntities(Context context) {
		context.registerMob(1, "Minivox", EntityMinivox.class);
	}

	@Override
	public void registerRenderers(ClientContext context) {
		context.registerTESR(TileEntityTestRender.class, new TileEntityTestRenderRenderer());
		context.registerEntityRenderingHandler(EntityMinivox.class, new RenderMinivox());
	}

}

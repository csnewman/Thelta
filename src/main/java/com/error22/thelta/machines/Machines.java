package com.error22.thelta.machines;

import com.error22.thelta.common.CraftingItem;
import com.error22.thelta.common.CreativeTabCraftingMaterials;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({ @Stage(name = "craft_init_config"), @Stage(name = "craft_init_items"),
		@Stage(name = "craft_init_blocks"), @Stage(name = "craft_init_entities", after = { "craft_init_blocks" }),
		@Stage(name = "craft_init_recipes", after = { "craft_init_items", "craft_init_blocks" }),
		@Stage(name = "craft_init_renderers") })
public class Machines {

	// blocks
	public static Block blockConvayorT1;
	public static Block blockBurnerMachineArm;

	// block items
	public static Item blockItemConvayorT1;
	public static Item blockItemBurnerMachineArm;

	@StageMethod(stage = "craft_init_config", pass = Pass.PreInit)
	private static void init_config() {

	}

	@StageMethod(stage = "craft_init_blocks", pass = Pass.PreInit)
	private static void init_blocks() {

	}

	@StageMethod(stage = "craft_init_items", pass = Pass.PreInit)
	private static void init_items() {
		
	}

	@StageMethod(stage = "craft_init_entities", pass = Pass.PreInit)
	private static void init_entities() {

	}

	@StageMethod(stage = "craft_init_recipes", pass = Pass.PreInit)
	private static void init_recipes() {

	}

	@SideOnly(Side.CLIENT)
	@StageMethod(stage = "craft_init_renderers", pass = Pass.PreInit, client = true)
	private static void init_renderers() {

	}
}

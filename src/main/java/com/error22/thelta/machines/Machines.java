package com.error22.thelta.machines;

import com.error22.thelta.machines.blocks.BlockConvayorBelt;
import com.error22.thelta.machines.blocks.BlockMachinearm;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({ @Stage(name = "craft_init_config"), @Stage(name = "craft_init_items"), @Stage(name = "craft_init_blocks"),
		@Stage(name = "craft_init_entities", after = { "craft_init_blocks" }),
		@Stage(name = "craft_init_recipes", after = { "craft_init_items", "craft_init_blocks" }),
		@Stage(name = "craft_init_renderers") })
public class Machines {

	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");
	// blocks
	public static Block blockConvayorT1;
	public static Block blockBurnerMachineArm;
	public static Block blockMachinearm;

	// block items
	public static Item blockItemConvayorT1;
	public static Item blockItemBurnerMachineArm;

	@StageMethod(stage = "craft_init_config", pass = Pass.PreInit)
	private static void init_config() {
		//ResourceLocation texture = new ResourceLocation(YourMod.MODID, "models/[Your Block]Texture.png");
        //ResourceLocation objModelLocation = new ResourceLocation(YourMod.MODID, "models/[Your Block]Model.obj");
        //IModel model = OBJLoader.INSTANCE.loadModel(objModelLocation);
	}

	@StageMethod(stage = "craft_init_blocks", pass = Pass.PreInit)
	private static void init_blocks() {
		blockConvayorT1 = new BlockConvayorBelt("convayorbeltt1");
		blockMachinearm = new BlockMachinearm("machinearm");
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

package com.error22.thelta.common;

import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({ @Stage(name = "machine_init_config"), @Stage(name = "machine_init_items"),
		@Stage(name = "machine_init_blocks"), @Stage(name = "machine_init_entities", after = { "machine_init_blocks" }),
		@Stage(name = "machine_init_recipes", after = { "machine_init_items", "machine_init_blocks" }),
		@Stage(name = "machine_init_renderers") })
public class CraftingMaterials {

	// Creative Tab
	public static CreativeTabCraftingMaterials creativeTabCraftingMaterials = new CreativeTabCraftingMaterials(
			"machinecraftingmaterials");;

	// items
	// ingots
	public static Item itemSteelIngot;
	public static Item itemBronzeIngot;
	public static Item itemTinIngot;
	public static Item itemCopperIngot;

	// crafting materials
	public static Item itemRubber;
	public static Item itemPlastic;
	public static Item itemBallBearing;
	public static Item itemIronGear;
	public static Item itemSteelGear;
	public static Item itemRubberGasket;
	public static Item itemMetalGasket;
	public static Item itemPlasticGasket;
	public static Item itemPipeSealent;
	public static Item itemServeoMoter;
	public static Item itemElectricMotor;
	public static Item itemBurnerMotor;
	public static Item itemPCBBoard;
	public static Item itemBasicCircuitBoard;
	public static Item itemAdvancedCircuitBoard;
	public static Item itemCopperWire;
	public static Item itemGoldWire;
	public static Item itemRubberJacket;
	public static Item itemSmallRubberWasher;
	public static Item itemSmallIronWasher;
	public static Item itemSmallSteelWasher;
	public static Item itemRubberWasher;
	public static Item itemIronWasher;
	public static Item itemSteelWasher;
	public static Item itemLargeRubberWasher;
	public static Item itemLargeIronWasher;
	public static Item itemLargeSteelWasher;
	public static Item itemThickRubberWasher;
	public static Item itemThickIronWasher;
	public static Item itemThickSteelWasher;
	
	public static Item itemIronNut;
	public static Item itemSteelNut;
	public static Item itemIronBolt;
	public static Item itemSteelBolt;
	public static Item itemPlasticRivets;
	public static Item itemIronRivets;
	public static Item itemSteelRivets;
	public static Item itemPlasticCasing;
	public static Item itemIronCasing;
	public static Item itemSteelCasing;
	public static Item itemPlasticHousing;
	public static Item itemIronHousing;
	public static Item itemSteelHousing;
	public static Item itemPlasticPanel;
	public static Item itemIronPanel;
	public static Item itemSteelPanel;

	@StageMethod(stage = "machine_init_config", pass = Pass.PreInit)
	private static void init_config() {

	}

	@StageMethod(stage = "machine_init_blocks", pass = Pass.PreInit)
	private static void init_blocks() {

	}

	@StageMethod(stage = "machine_init_items", pass = Pass.PreInit)
	private static void init_items() {
		// Ingots
		itemSteelIngot = new CraftingItem("steelingot");
		itemBronzeIngot = new CraftingItem("bronzeingot");
		itemTinIngot = new CraftingItem("tiningot");
		itemCopperIngot = new CraftingItem("copperingot");

		// crafting materials
		itemRubber = new CraftingItem("rubber");
		itemPlastic = new CraftingItem("plastic");
		itemBallBearing = new CraftingItem("bearing");
		itemIronGear = new CraftingItem("irongear");
		itemSteelGear = new CraftingItem("steelgear");
		itemRubberGasket = new CraftingItem("rubbergasket");
		itemMetalGasket = new CraftingItem("metalgasket");
		itemPlasticGasket = new CraftingItem("plasticgasket");
		itemPipeSealent = new CraftingItem("pipesealent");
		itemServeoMoter = new CraftingItem("servomoter");
		itemElectricMotor = new CraftingItem("electricmotor");
		itemBurnerMotor = new CraftingItem("burnermotor");
		itemPCBBoard = new CraftingItem("pcbboard");
		itemBasicCircuitBoard = new CraftingItem("basiccircuit");
		itemAdvancedCircuitBoard = new CraftingItem("advancedcircuit");
		itemCopperWire = new CraftingItem("coperwire");
		itemGoldWire = new CraftingItem("goldwire");
		itemRubberJacket = new CraftingItem("rubberjacket");
		itemSmallRubberWasher = new CraftingItem("smallrubberwasher");
		itemSmallIronWasher = new CraftingItem("smallironwasher");
		itemSmallSteelWasher = new CraftingItem("smallsteelwasher");
		itemRubberWasher = new CraftingItem("rubberwasher");
		itemIronWasher = new CraftingItem("ironwasher");
		itemSteelWasher = new CraftingItem("steelwasher");
		itemLargeRubberWasher = new CraftingItem("largerubberwasher");
		itemLargeIronWasher = new CraftingItem("largeironwasher");
		itemLargeSteelWasher = new CraftingItem("largesteelwasher");
		itemThickRubberWasher = new CraftingItem("thickrubberwasher");
		itemThickIronWasher = new CraftingItem("thickironwasher");
		itemThickSteelWasher = new CraftingItem("thicksteelwasher");
		itemIronNut = new CraftingItem("ironnut");
		itemSteelNut = new CraftingItem("steelnut");
		itemIronBolt = new CraftingItem("ironbolt");
		itemSteelBolt = new CraftingItem("steelbolt");
		itemPlasticRivets = new CraftingItem("plasticrivets");
		itemIronRivets = new CraftingItem("ironrivets");
		itemSteelRivets = new CraftingItem("steelrivets");
		itemPlasticCasing = new CraftingItem("plasticcasing");
		itemIronCasing = new CraftingItem("ironcasing");
		itemSteelCasing = new CraftingItem("steelcasing");
		itemPlasticHousing = new CraftingItem("plastichousing");
		itemIronHousing = new CraftingItem("ironhousing");
		itemSteelHousing = new CraftingItem("steelhousing");
		itemPlasticPanel = new CraftingItem("plasticpanel");
		itemIronPanel = new CraftingItem("ironpanel");
		itemSteelPanel = new CraftingItem("steelpanel");
	}

	@StageMethod(stage = "machine_init_entities", pass = Pass.PreInit)
	private static void init_entities() {

	}

	@StageMethod(stage = "machine_init_recipes", pass = Pass.PreInit)
	private static void init_recipes() {

	}

	@SideOnly(Side.CLIENT)
	@StageMethod(stage = "machine_init_renderers", pass = Pass.PreInit, client = true)
	private static void init_renderers() {

	}
}

package com.error22.thelta.common;

import java.util.ArrayList;
import java.util.List;

import com.error22.thelta.Context;
import com.error22.thelta.Thelta;
import com.error22.thelta.TheltaModule;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class CraftingMaterials extends TheltaModule {
	// Creative Tab
	public static CreativeTabs materialsTab;

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

	@Override
	public void init(Context context) {
		materialsTab = context.createTabWithItem("machinecraftingmaterials", () -> itemElectricMotor);
	}
	
	//Here we are regestering the forge ore dictionary for items
	private void registerOreDict() {
		OreDictionary.registerOre("ingotSteel", itemSteelIngot);
		OreDictionary.registerOre("ingotBronze", itemBronzeIngot);
		OreDictionary.registerOre("ingotTin", itemTinIngot);
		OreDictionary.registerOre("ingotCopper", itemCopperIngot);
	}

	@Override
	public void registerItems(Context context) {
		// Ingots
		itemSteelIngot = context.createSimpleItem("steelingot", materialsTab);
		itemBronzeIngot = context.createSimpleItem("bronzeingot", materialsTab);
		itemTinIngot = context.createSimpleItem("tiningot", materialsTab);
		itemCopperIngot = context.createSimpleItem("copperingot", materialsTab);

		// crafting materials
		itemRubber = context.createSimpleItem("rubber", materialsTab);
		itemPlastic = context.createSimpleItem("plastic", materialsTab);
		itemBallBearing = context.createSimpleItem("bearing", materialsTab);
		itemIronGear = context.createSimpleItem("irongear", materialsTab);
		itemSteelGear = context.createSimpleItem("steelgear", materialsTab);
		itemRubberGasket = context.createSimpleItem("rubbergasket", materialsTab);
		itemMetalGasket = context.createSimpleItem("metalgasket", materialsTab);
		itemPlasticGasket = context.createSimpleItem("plasticgasket", materialsTab);
		itemPipeSealent = context.createSimpleItem("pipesealent", materialsTab);
		itemServeoMoter = context.createSimpleItem("servomoter", materialsTab);
		itemElectricMotor = context.createSimpleItem("electricmotor", materialsTab);
		itemBurnerMotor = context.createSimpleItem("burnermotor", materialsTab);
		itemPCBBoard = context.createSimpleItem("pcbboard", materialsTab);
		itemBasicCircuitBoard = context.createSimpleItem("basiccircuit", materialsTab);
		itemAdvancedCircuitBoard = context.createSimpleItem("advancedcircuit", materialsTab);
		itemCopperWire = context.createSimpleItem("coperwire", materialsTab);
		itemGoldWire = context.createSimpleItem("goldwire", materialsTab);
		itemRubberJacket = context.createSimpleItem("rubberjacket", materialsTab);
		itemSmallRubberWasher = context.createSimpleItem("smallrubberwasher", materialsTab);
		itemSmallIronWasher = context.createSimpleItem("smallironwasher", materialsTab);
		itemSmallSteelWasher = context.createSimpleItem("smallsteelwasher", materialsTab);
		itemRubberWasher = context.createSimpleItem("rubberwasher", materialsTab);
		itemIronWasher = context.createSimpleItem("ironwasher", materialsTab);
		itemSteelWasher = context.createSimpleItem("steelwasher", materialsTab);
		itemLargeRubberWasher = context.createSimpleItem("largerubberwasher", materialsTab);
		itemLargeIronWasher = context.createSimpleItem("largeironwasher", materialsTab);
		itemLargeSteelWasher = context.createSimpleItem("largesteelwasher", materialsTab);
		itemThickRubberWasher = context.createSimpleItem("thickrubberwasher", materialsTab);
		itemThickIronWasher = context.createSimpleItem("thickironwasher", materialsTab);
		itemThickSteelWasher = context.createSimpleItem("thicksteelwasher", materialsTab);
		itemIronNut = context.createSimpleItem("ironnut", materialsTab);
		itemSteelNut = context.createSimpleItem("steelnut", materialsTab);
		itemIronBolt = context.createSimpleItem("ironbolt", materialsTab);
		itemSteelBolt = context.createSimpleItem("steelbolt", materialsTab);
		itemPlasticRivets = context.createSimpleItem("plasticrivets", materialsTab);
		itemIronRivets = context.createSimpleItem("ironrivets", materialsTab);
		itemSteelRivets = context.createSimpleItem("steelrivets", materialsTab);
		itemPlasticCasing = context.createSimpleItem("plasticcasing", materialsTab);
		itemIronCasing = context.createSimpleItem("ironcasing", materialsTab);
		itemSteelCasing = context.createSimpleItem("steelcasing", materialsTab);
		itemPlasticHousing = context.createSimpleItem("plastichousing", materialsTab);
		itemIronHousing = context.createSimpleItem("ironhousing", materialsTab);
		itemSteelHousing = context.createSimpleItem("steelhousing", materialsTab);
		itemPlasticPanel = context.createSimpleItem("plasticpanel", materialsTab);
		itemIronPanel = context.createSimpleItem("ironpanel", materialsTab);
		itemSteelPanel = context.createSimpleItem("steelpanel", materialsTab);
		
		registerOreDict();
	}

}

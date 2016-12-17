package com.error22.thelta.computers;

import com.error22.thelta.Thelta;

import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TheltaComputers {
	public static BasicMonitor basicMonitor;

	public static void preInit() {
		basicMonitor = new BasicMonitor("computer_monitor_basic");
		registerSimpleBlock(basicMonitor);
		GameRegistry.registerTileEntity(TileEntityComputerMonitor.class, "thelta_computer_monitor");
		
	}

	@SideOnly(Side.CLIENT)
	public static void preInitClient() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputerMonitor.class, new TileEntityComputerMonitorRenderer());
	}

	public static void init() {

	}

	public static void postInit() {

	}

	private static void registerSimpleBlock(Block block) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(block);
		GameRegistry.register(item);
		ModelLoader.setCustomModelResourceLocation(item, 0,
				new ModelResourceLocation(Thelta.MODID + ":" + block.getRegistryName().getResourcePath(), "inventory"));
	}

}

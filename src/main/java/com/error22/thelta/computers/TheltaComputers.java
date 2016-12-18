package com.error22.thelta.computers;

import com.error22.thelta.Thelta;
import com.error22.thelta.pipeline.FieldStage;
import com.error22.thelta.pipeline.PipelineInstance;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.PipelineStage;
import com.error22.thelta.pipeline.StageMethod;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TheltaComputers {
	public static final String monitorStage = "computers-monitors";
	@FieldStage(name = monitorStage)
	private static PipelineStage monitorStageInst;
	private static BasicMonitor basicMonitor;

	@StageMethod(stage = monitorStage, pass = Pass.PreInit)
	private static void registerMonitors() {
		basicMonitor = new BasicMonitor("computer_monitor_basic");
		registerSimpleBlock(basicMonitor);
		GameRegistry.registerTileEntity(TileEntityComputerMonitor.class, "thelta_computer_monitor");
	}

	@SideOnly(Side.CLIENT)
	@StageMethod(stage = monitorStage, pass = Pass.PreInit, client = true)
	private static void registerMonitorsRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputerMonitor.class,
				new TileEntityComputerMonitorRenderer());
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

package com.error22.thelta.computers;

import com.error22.thelta.Thelta;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({ @Stage(name = TheltaComputers.monitorStage),
		@Stage(name = TheltaComputers.renderersStage, after = { TheltaComputers.monitorStage }) })
public class TheltaComputers {
	public static final String monitorStage = "computers-monitors";
	public static final String renderersStage = "computers-renderers";
	public static BasicMonitor basicMonitor;
	public static ItemBlock basicMonitorItem;

	@StageMethod(stage = monitorStage, pass = Pass.PreInit)
	private static void registerMonitors() {
		basicMonitor = new BasicMonitor("computer_monitor_basic");
		ForgeRegistries.BLOCKS.register(basicMonitor);
		GameRegistry.registerTileEntity(TileEntityComputerMonitor.class, "thelta_computer_monitor");

		basicMonitorItem = new ItemBlock(basicMonitor);
		basicMonitorItem.setRegistryName(basicMonitor.getRegistryName());
		ForgeRegistries.ITEMS.register(basicMonitorItem);
	}

	@SideOnly(Side.CLIENT)
	@StageMethod(stage = renderersStage, pass = Pass.PreInit, client = true)
	private static void registerClientRenderers() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityComputerMonitor.class,
				new TileEntityComputerMonitorRenderer());

		ModelLoader.setCustomModelResourceLocation(basicMonitorItem, 0, new ModelResourceLocation(
				Thelta.MODID + ":" + basicMonitor.getRegistryName().getResourcePath(), "inventory"));
	}
}

package com.error22.thelta.computers;

import com.error22.thelta.ClientContext;
import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class TheltaComputers extends TheltaModule {
	public static BasicMonitor basicMonitor;
	public static ItemBlock basicMonitorItem;

	@Override
	public void registerBlocks(Context context) {
		basicMonitor = new BasicMonitor("computer_monitor_basic");
		basicMonitorItem = context.registerBlock(basicMonitor);
		context.registerTileEntity(TileEntityComputerMonitor.class, "thelta_computer_monitor");
	}

	@Override
	public void registerRenderers(ClientContext context) {
		context.registerTESR(TileEntityComputerMonitor.class, new TileEntityComputerMonitorRenderer());
	}
}

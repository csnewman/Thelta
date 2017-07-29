package com.error22.thelta.machines;

import com.error22.thelta.ClientContext;
import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

public class Machines extends TheltaModule {
	public static CreativeTabs creativetab;
	// blocks
	public static Block blockConvayorT1;
	public static Block blockBurnerMachineArm;
	public static Block blockMachinearm;

	@Override
	public void init(Context context) {
		creativetab = context.createTabWithBlock("machinescreativetab", () -> blockConvayorT1);
	}

	@Override
	public void registerBlocks(Context context) {
		blockConvayorT1 = new BlockConvayorBelt();
		context.registerBlock(blockConvayorT1, "convayorbeltt1", creativetab);

		blockMachinearm = new BlockMachinearm();
		context.registerBlock(blockMachinearm, "machinearm", creativetab);
		context.registerTileEntity(TileEntityMachinearm.class, "thelta_machinearm");
	}

	@Override
	public void registerRenderers(ClientContext context) {
		context.registerTESR(TileEntityMachinearm.class, new TileEntityRendererMachineArm());
	}

}

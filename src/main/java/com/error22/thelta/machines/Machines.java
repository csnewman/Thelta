package com.error22.thelta.machines;

import com.error22.thelta.AutoModel;
import com.error22.thelta.ClientContext;
import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Machines extends TheltaModule {
	public static CreativeTabs creativetab;

	// blocks
	public static Block blockBurnerCrusher, blockConvayorT1, blockMachinearm;

	@SideOnly(Side.CLIENT)
	public static AutoModel newModel;

	@Override
	public void init(Context context) {
		creativetab = context.createTabWithBlock("machinescreativetab", () -> blockConvayorT1);
	}

	@Override
	public void registerBlocks(Context context) {
		blockBurnerCrusher = new BlockBurnerCrusher();
		blockConvayorT1 = new BlockConvayorBelt();
		blockMachinearm = new BlockMachinearm();

		context.registerBlock(blockBurnerCrusher, "burnercrusher", creativetab);
		context.registerBlock(blockConvayorT1, "convayorbeltt1", creativetab);
		context.registerBlock(blockMachinearm, "machinearm", creativetab);
		context.registerTileEntity(TileEntityBurnerCrusher.class, "thelta_burnercrusher");
		context.registerTileEntity(TileEntityMachinearm.class, "thelta_machinearm");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerRenderers(ClientContext context) {
		context.registerTESR(TileEntityBurnerCrusher.class, new TileEntityRendererBurnerCrusher());
		context.registerTESR(TileEntityMachinearm.class, new TileEntityRendererMachineArm());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ClientContext context) {
		newModel = context.registerAutoModel("block/newmodel");
	}

}

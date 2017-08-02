package com.error22.thelta.machines.powercable;

import com.error22.thelta.machines.powercable.core.TileEntityPowerCable;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class PowerCable extends BlockContainer {

	public PowerCable(Material materialIn) {
		super(materialIn);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		System.out.println("Test1");
		return new TileEntityPowerCable(64);
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player,
			EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
		// TODO Auto-generated method stub
		TileEntityPowerCable test = (TileEntityPowerCable)world.getTileEntity(pos);
		test.curEnergy++;
		player.sendMessage(new TextComponentString("test.curEnergy: " + test.curEnergy));
		
		return super.onBlockActivated(world, pos, state, player, hand, facing, hitX, hitY, hitZ);
	}


}

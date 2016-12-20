package com.error22.thelta.common;

import com.error22.thelta.tubes.BlockTube;
import com.error22.thelta.tubes.TileEntityTube;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BlockContainerWrapped extends BlockContainer {

	protected BlockContainerWrapped(Material material) {
		super(material);
	}
	
	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		for (int x = -1; x < 2; x++) {
			for (int y = -1; y < 2; y++) {
				for (int z = -1; z < 2; z++) {
					if (x == 0 && y == 0 && z == 0)
						continue;
					BlockPos pos1 = pos.add(x, y, z);
					if (worldIn.getBlockState(pos1).getBlock() instanceof BlockContainerWrapped) {
						getTileEntity(worldIn, pos1).onNeighborChange(pos);
					}
				}
			}
		}
		return getDefaultState();
	}
	
	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		getTileEntity(worldIn, pos).onBlockPlacedBy(state, placer, stack);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) {
		return getTileEntity(worldIn, pos).onBlockActivated(state, playerIn, hand, heldItem, side, hitX, hitY);
	}

	@Override
	public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor) {
		getTileEntity(world, pos).onNeighborChange(neighbor);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
	}

	public TileEntityWrapped getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TileEntityWrapped) world.getTileEntity(pos);
	}

}

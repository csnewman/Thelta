package com.error22.thelta.machines;

import java.util.List;

import javax.annotation.Nullable;

import com.error22.thelta.common.CraftingMaterials;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMachinearm extends BlockContainer {

	public Item blockItem;

	// Temporary, update this later!
	public static final AxisAlignedBB MainColisionBox = new AxisAlignedBB(-0.5D, 0.0D, -0.5D, 1.5D, 2D, 1.5D);

	public BlockMachinearm() {
		super(Material.ROCK);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityMachinearm();
	}

	// This makes it so the light passes through the object
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}

	// This makes it so the cube will render adjasent block verticies
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox,
			List<AxisAlignedBB> collidingBoxes, Entity entityIn, boolean p_185477_7_) {
		addCollisionBoxToList(pos, entityBox, collidingBoxes, MainColisionBox);
	}

	// This handles the boundingbox that you see whemn you move your mouse over
	// the object
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return MainColisionBox;
	}

}

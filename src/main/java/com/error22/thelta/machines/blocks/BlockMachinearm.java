package com.error22.thelta.machines.blocks;

import java.util.List;

import javax.annotation.Nullable;

import com.error22.thelta.common.CraftingMaterials;
import com.error22.thelta.machines.Machines;
import com.error22.thelta.machines.tileentities.TileEntityMachinearm;

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
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockMachinearm extends BlockContainer {
	
	public Item blockItem;
	
	//Temporary, update this later!
    public static final AxisAlignedBB MainColisionBox = new AxisAlignedBB(-0.5D, 0.0D, -0.5D, 1.5D, 2D, 1.5D);

	public BlockMachinearm(String itemname) {
		super(Material.ROCK);
		
		//Here we are creating the block
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Machines.creativetab);
		
		//Pre-Registering the block
		blockItem = new ItemBlock(this);
		blockItem.setRegistryName(getRegistryName());
		GameRegistry.register(this);
		GameRegistry.register(blockItem);
		//Here we are adding out item to the render queue, so we dont have to register it ourselves :P
		//(the lazy way out)
		CraftingMaterials.itemsToBeRegisteredByRender.add(blockItem);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityMachinearm();
	}
	
	//This makes it so the light passes through the object
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		// TODO Auto-generated method stub
		return false;
	}
	
	//This makes it so the cube will render adjasent block verticies
	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

	//This handles the main collision for the block
	@Override
    public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, @Nullable Entity entityIn)
    {
        addCollisionBoxToList(pos, entityBox, collidingBoxes, MainColisionBox);
    }
	
	//This handles the boundingbox that you see whemn you move your mouse over the object
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return MainColisionBox;
    }

}

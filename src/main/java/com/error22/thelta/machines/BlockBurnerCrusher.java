package com.error22.thelta.machines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockBurnerCrusher extends BlockContainer {
	
	protected BlockBurnerCrusher() {
		super(Material.IRON);
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityBurnerCrusher();
	}

}

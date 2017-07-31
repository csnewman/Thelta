package com.error22.thelta.machines;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBurnerCrusher extends BlockContainer {
	
	protected BlockBurnerCrusher() {
		super(Material.IRON);
	}


    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    
    @Override
    public boolean isOpaqueCube(IBlockState state) {
    	// TODO Auto-generated method stub
    	return false;
    }
    
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityBurnerCrusher();
	}

}

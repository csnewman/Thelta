package com.error22.thelta.minivox.blocks;

import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.minivox.entities.tiles.TileEntityTestRender;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockTestRender extends BlockContainer {

	public Item blockItem;
	
	public BlockTestRender(String itemname) {
		super(Material.ROCK);
		
		//Here we are creating the block
		setUnlocalizedName(itemname);
		setRegistryName(itemname);
		setCreativeTab(Minivox.creativetab);
		
		blockItem = registerSimpleBlock();
		
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityTestRender();
	}

	
	//Copied from newmans code (did i use this?)
	private ItemBlock registerSimpleBlock() {
		ItemBlock item = new ItemBlock(this);
		item.setRegistryName(getRegistryName());
		GameRegistry.register(this);
		GameRegistry.register(item);
		return item;
	}

}

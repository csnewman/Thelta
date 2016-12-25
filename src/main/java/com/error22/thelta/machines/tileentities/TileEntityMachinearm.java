package com.error22.thelta.machines.tileentities;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMachinearm extends TileEntity {
	public float animplace = 0f;
	ItemStack stack = new ItemStack(Items.STONE_AXE);
    
    public EntityItem entityitem;
	
	public TileEntityMachinearm() {
		super();
        entityitem = new EntityItem(this.getWorld(), 0.0D, 0.0D, 0.0D, stack);
	}
}

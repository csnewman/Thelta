package com.error22.thelta.machines.powercable.core;

import com.error22.thelta.powerapi.TheltaEnergyHybrid;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityPowerCable extends TileEntity {
	
	public int maxTransmit;
	public TheltaEnergyHybrid energyStorage;
	
	public int curEnergy = 0;
	public int maxEnergy = 0;
	
	public TileEntityPowerCable(int maxTransmit) {
		
		this.maxTransmit = maxTransmit;
		energyStorage = new TheltaEnergyHybrid(this, maxTransmit, maxTransmit, maxTransmit, 0);
		maxEnergy = maxTransmit;
	}
	
	public void init() {
		
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readFromNBT(compound);
		System.out.println("load");
		curEnergy = compound.getInteger("curEnergy");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		System.out.println("Save");
		compound.setInteger("curEnergy", curEnergy);
		return super.writeToNBT(compound);
	}

}

package com.error22.thelta.powerapi;

import com.error22.thelta.machines.powercable.core.TileEntityPowerCable;

import net.minecraftforge.energy.EnergyStorage;

public class TheltaEnergyStorage extends EnergyStorage {
	
	public TileEntityPowerCable entity;
	
	
	public TheltaEnergyStorage(TileEntityPowerCable entity, int capacity, int maxReceive, int maxExtract, int energy) {
		super(capacity, maxReceive, maxExtract, energy);
		this.entity = entity;
	}


	@Override
	public int receiveEnergy(int maxReceive, boolean simulate) {
		// TODO Auto-generated method stub
		return super.receiveEnergy(maxReceive, simulate);
	}


	@Override
	public int extractEnergy(int maxExtract, boolean simulate) {
		// TODO Auto-generated method stub
		return super.extractEnergy(maxExtract, simulate);
	}


	@Override
	public int getEnergyStored() {
		// TODO Auto-generated method stub
		return super.getEnergyStored();
	}


	@Override
	public int getMaxEnergyStored() {
		// TODO Auto-generated method stub
		return super.getMaxEnergyStored();
	}
	
	
	

}

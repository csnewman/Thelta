package com.error22.thelta.powerapi;

import com.error22.thelta.machines.powercable.core.TileEntityPowerCable;

public class TheltaEnergyHybrid extends TheltaEnergyStorage {
	
	public TheltaEnergyHybrid(TileEntityPowerCable entity, int capacity, int maxReceive, int maxExtract, int energy) {
		super(entity, capacity, maxReceive, maxExtract, energy);
	}

	@Override
	public boolean canExtract() {
		return true;
	}

	@Override
	public boolean canReceive() {
		return true;
	}

}

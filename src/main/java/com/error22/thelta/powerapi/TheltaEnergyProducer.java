package com.error22.thelta.powerapi;

import com.error22.thelta.machines.powercable.core.TileEntityPowerCable;

public class TheltaEnergyProducer extends TheltaEnergyStorage {

	public TheltaEnergyProducer(TileEntityPowerCable entity, int capacity, int maxReceive, int maxExtract, int energy) {
		super(entity, capacity, maxReceive, maxExtract, energy);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExtract() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canReceive() {
		// TODO Auto-generated method stub
		return false;
	}

}

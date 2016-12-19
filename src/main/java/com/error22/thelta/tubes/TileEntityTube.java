package com.error22.thelta.tubes;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityTube extends TileEntity implements ITickable {
	private TubeColour colour;
	private boolean[] connections;

	public TileEntityTube() {
		colour = TubeColour.Generic;
		connections = new boolean[6];
	}

	@Override
	public void onLoad() {

	}

	@Override
	public void update() {
		System.out.println(colour);
		updateConnections();
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);
		System.out.println("writeToNBT "+colour.ordinal());
		compound.setInteger("colour", colour.ordinal());
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		System.out.println("readFromNBT "+compound.getInteger("colour"));
		colour = TubeColour.values()[compound.getInteger("colour")];
	}

	public void updateConnections() {
		connections[EnumFacing.UP.getIndex()] = canConnect(EnumFacing.UP);
		connections[EnumFacing.DOWN.getIndex()] = canConnect(EnumFacing.DOWN);
		connections[EnumFacing.NORTH.getIndex()] = canConnect(EnumFacing.NORTH);
		connections[EnumFacing.EAST.getIndex()] = canConnect(EnumFacing.EAST);
		connections[EnumFacing.SOUTH.getIndex()] = canConnect(EnumFacing.SOUTH);
		connections[EnumFacing.WEST.getIndex()] = canConnect(EnumFacing.WEST);
		worldObj.markBlockRangeForRenderUpdate(pos, pos);
	}

	private boolean canConnect(EnumFacing direction) {
		IBlockState state = worldObj.getBlockState(pos.offset(direction));
		return state.getBlock() instanceof BlockTube;
	}

	public void setColour(TubeColour colour) {
		this.colour = colour;
		worldObj.markBlockRangeForRenderUpdate(pos, pos);
		markDirty();
	}

	public TubeColour getColour() {
		return colour;
	}

	public boolean isConnected(EnumFacing direction) {
		return connections[direction.getIndex()];
	}

}

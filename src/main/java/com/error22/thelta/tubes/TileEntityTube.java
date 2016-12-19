package com.error22.thelta.tubes;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityTube extends TileEntity implements ITickable {
	private TubeColour colour;
	private boolean[] connections;
	private boolean needsRefresh;

	public TileEntityTube() {
		colour = TubeColour.Generic;
		connections = new boolean[6];
		markForRefresh();
	}

	@Override
	public void update() {
		if (needsRefresh) {
			updateConnections();
			needsRefresh = false;
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound = super.writeToNBT(compound);
		compound.setString("colour", colour.getName());
		return compound;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		colour = TubeColour.getColourByName(compound.getString("colour"));
	}

	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound data = new NBTTagCompound();
		data.setString("colour", colour.getName());
		return new SPacketUpdateTileEntity(this.pos, 0, data);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		NBTTagCompound data = pkt.getNbtCompound();
		setColour(TubeColour.getColourByName(data.getString("colour")));
	}

	public void updateConnections() {
		connections[EnumFacing.UP.getIndex()] = canConnect(EnumFacing.UP);
		connections[EnumFacing.DOWN.getIndex()] = canConnect(EnumFacing.DOWN);
		connections[EnumFacing.NORTH.getIndex()] = canConnect(EnumFacing.NORTH);
		connections[EnumFacing.EAST.getIndex()] = canConnect(EnumFacing.EAST);
		connections[EnumFacing.SOUTH.getIndex()] = canConnect(EnumFacing.SOUTH);
		connections[EnumFacing.WEST.getIndex()] = canConnect(EnumFacing.WEST);
		if (worldObj.isRemote) {
			worldObj.markBlockRangeForRenderUpdate(pos, pos);
		}
	}

	private boolean canConnect(EnumFacing direction) {
		IBlockState state = worldObj.getBlockState(pos.offset(direction));
		return state.getBlock() instanceof BlockTube;
	}

	public void setColour(TubeColour colour) {
		this.colour = colour;
		if (worldObj.isRemote) {
			worldObj.markBlockRangeForRenderUpdate(pos, pos);
		} else {
			worldObj.notifyBlockUpdate(pos, worldObj.getBlockState(pos), worldObj.getBlockState(pos), 0);
			markDirty();
		}
	}

	public TubeColour getColour() {
		return colour;
	}

	public boolean isConnected(EnumFacing direction) {
		return connections[direction.getIndex()];
	}

	public void markForRefresh() {
		needsRefresh = true;
	}

}

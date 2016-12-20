package com.error22.thelta.tubes;

import com.error22.thelta.common.TileEntityWrapped;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;

public class TileEntityTube extends TileEntityWrapped {
	private TubeColour colour;
	private boolean[] connections;

	public TileEntityTube() {
		colour = TubeColour.Generic;
		connections = new boolean[6];
	}

	@Override
	public void update() {
		super.update();
	}

	@Override
	public void onFirstRun() {
		updateConnections();
	}

	@Override
	public void onBlockPlacedBy(IBlockState state, EntityLivingBase placer, ItemStack stack) {
		updateConnections();
	}
	
	@Override
	public boolean onBlockActivated(IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
			float side, float hitX, float hitY) {
		if (worldObj.isRemote)
			return false;
		boolean shouldDye = (playerIn.getHeldItemMainhand().getItem() instanceof ItemDye);

		if (shouldDye) {
			setColour(TubeColour.Red);
			return true;
		}

		return false;
	}

	@Override
	public void onNeighborChange(BlockPos neighbor) {
		updateConnections();
	}

	public void updateConnections() {
		System.out.println("updateConnections " + pos);

		double x = getPos().getX() + 0.5;
		double y = getPos().getY() + 0.5;
		double z = getPos().getZ() + 0.5;
		worldObj.spawnParticle(EnumParticleTypes.BARRIER, x, y, z, 0, 0, 0);

		connections[EnumFacing.UP.getIndex()] = canConnect(EnumFacing.UP);
		connections[EnumFacing.DOWN.getIndex()] = canConnect(EnumFacing.DOWN);
		connections[EnumFacing.NORTH.getIndex()] = canConnect(EnumFacing.NORTH);
		connections[EnumFacing.EAST.getIndex()] = canConnect(EnumFacing.EAST);
		connections[EnumFacing.SOUTH.getIndex()] = canConnect(EnumFacing.SOUTH);
		connections[EnumFacing.WEST.getIndex()] = canConnect(EnumFacing.WEST);
		markForRedraw();
	}

	private boolean canConnect(EnumFacing direction) {
		IBlockState state = worldObj.getBlockState(pos.offset(direction));
		return state.getBlock() instanceof BlockTube;
	}

	public boolean isConnected(EnumFacing direction) {
		return connections[direction.getIndex()];
	}

	public void setColour(TubeColour colour) {
		System.out.println("setColour " + colour);
		this.colour = colour;
		markForUpdate();
		markDirty();
	}

	public TubeColour getColour() {
		return colour;
	}

	@Override
	protected void writeNetworkData(NBTTagCompound data) {
		data.setString("colour", colour.getName());
	}

	@Override
	protected void readNetworkData(NBTTagCompound data) {
		setColour(TubeColour.getColourByName(data.getString("colour")));
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
		setColour(TubeColour.getColourByName(compound.getString("colour")));
	}

}

package com.error22.thelta.common;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityWrapped extends TileEntity implements ITickable {
	private boolean hasRanFirstUpdate;

	@Override
	public void update() {
		if (!hasRanFirstUpdate) {
			hasRanFirstUpdate = true;
			onFirstRun();
		}
	}

	public void onFirstRun() {
	}

	public void onBlockPlacedBy(IBlockState state, EntityLivingBase placer,
			ItemStack stack){
	}

	public boolean onBlockActivated(IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing,
			float side, float hitX, float hitY) {
		return false;
	}

	public void onNeighborChange(BlockPos neighbor) {
	}

	public void markForRedraw() {
		if (hasWorldObj() && worldObj.isRemote) {
			IBlockState state = worldObj.getBlockState(pos);
			worldObj.notifyBlockUpdate(pos, state, state, 0);

			double x = getPos().getX() + 0.5;
			double y = getPos().getY() + 0.5;
			double z = getPos().getZ() + 0.5;
			worldObj.spawnParticle(EnumParticleTypes.HEART, x, y, z, 0, 0, 0);
		}
	}

	public void markForUpdate() {
		if (hasWorldObj()) {
			IBlockState state = worldObj.getBlockState(pos);
			worldObj.notifyBlockUpdate(pos, state, state, 0);
		}
	}

	protected void readNetworkData(NBTTagCompound data) {
	}

	protected void writeNetworkData(NBTTagCompound data) {
	}

	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound compound = super.getUpdateTag();
		writeNetworkData(compound);
		return compound;
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		super.handleUpdateTag(tag);
		readNetworkData(tag);
	}

	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound data = new NBTTagCompound();
		writeNetworkData(data);
		return new SPacketUpdateTileEntity(this.pos, 0, data);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) {
		readNetworkData(pkt.getNbtCompound());
	}

}

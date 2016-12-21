package com.error22.thelta.minivox.items;

import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TacoGodRing extends QuickItem {
	
	public TacoGodRing(String itemname) {
		super(itemname);
		this.setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing side, float x, float y, float z) {
		
		if(
				check(world, pos.getX(), pos.getY(), pos.getZ()+1) &&
				check(world, pos.getX()+1, pos.getY(), pos.getZ()+1) &&
				check(world, pos.getX()-1, pos.getY(), pos.getZ()+1) &&
				check(world, pos.getX()+1, pos.getY(), pos.getZ()) &&
				check(world, pos.getX()-1, pos.getY(), pos.getZ()) &&
				check(world, pos.getX(), pos.getY(), pos.getZ()-1) &&
				check(world, pos.getX()+1, pos.getY(), pos.getZ()-1) &&
				check(world, pos.getX()-1, pos.getY(), pos.getZ()-1)
				) {
				EntityLightningBolt lightning = new EntityLightningBolt(world, pos.getX(), pos.getY(), pos.getZ(), true);
				world.spawnEntityInWorld(lightning);
				player.inventory.deleteStack(player.getHeldItem(hand));

			if(world.isRemote == false) {
				EntityMinivox minivox = new EntityMinivox(world);
				minivox.setLocationAndAngles(pos.getX()+0.5f,pos.getY()+1,pos.getZ()+0.5f,0f, 0f);
				world.spawnEntityInWorld(minivox);
			}
			
			for(int _x = -1; _x <= 1; _x++) {
				for(int _z = -1; _z <= 1; _z++) {
					IBlockState blockstate = Blocks.STONE.getDefaultState();
					if(_x == 0) {
						if(_z==0) {
							blockstate = Blocks.COBBLESTONE.getDefaultState();
						}
					}
					world.setBlockState(new BlockPos(pos.getX()+_x, pos.getY(), pos.getZ()+_z), blockstate);
				}
			}
			
		}else{
			System.out.println("No");
		}
		
		return super.onItemUse(player, world, pos, hand, side, x, y, z);
		
		
	}
	
	public boolean check(World world, int x, int y, int z) {
		Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
		
		if(block == Minivox.rottenFleshBlock) {
			return true;
		}
		
		return false;
	}

}

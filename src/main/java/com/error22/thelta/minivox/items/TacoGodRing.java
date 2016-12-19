package com.error22.thelta.minivox.items;

import com.error22.thelta.minivox.Minivox;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;

import net.minecraft.block.Block;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class TacoGodRing extends QuickItem {
	
	public TacoGodRing(String itemname) {
		super(itemname);
		this.setMaxStackSize(1);
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing side, float x, float y, float z) {
		
		if(world.isRemote == false) {
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
				EntityLightningBolt lightning = new EntityLightningBolt(world, pos.getX(), pos.getY()+1, pos.getZ(), false);
				world.spawnEntityInWorld(lightning);
				player.inventory.deleteStack(player.getHeldItem(hand));
				
				EntityMinivox minivox = new EntityMinivox(world);
				minivox.posX = pos.getX();
				minivox.posY = pos.getY()+1;
				minivox.posZ = pos.getZ();
				world.spawnEntityInWorld(minivox);
				
			}else{
				System.out.println("No");
			}
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

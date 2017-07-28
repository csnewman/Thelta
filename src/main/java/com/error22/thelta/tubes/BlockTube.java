package com.error22.thelta.tubes;

import com.error22.thelta.common.BlockContainerWrapped;
import com.error22.thelta.common.TileEntityWrapped;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTube extends BlockContainerWrapped {
	public static final PropertyEnum<TubeColour> COLOUR = PropertyEnum.create("colour", TubeColour.class);
	public static final PropertyEnum<TubeMode> MODE = PropertyEnum.create("mode", TubeMode.class);
	public static final PropertyBool UP = PropertyBool.create("up");
	public static final PropertyBool DOWN = PropertyBool.create("down");
	public static final PropertyBool SOUTH = PropertyBool.create("south");
	public static final PropertyBool NORTH = PropertyBool.create("north");
	public static final PropertyBool EAST = PropertyBool.create("east");
	public static final PropertyBool WEST = PropertyBool.create("west");

	public BlockTube(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setHardness(3f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.REDSTONE);
	}

	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		return getDefaultState().withProperty(COLOUR, TubeColour.Generic).withProperty(MODE, TubeMode.X);
	}

	@Override
	public IBlockState getActualState(IBlockState state, IBlockAccess world, BlockPos pos) {
		TileEntityTube tube = (TileEntityTube) world.getTileEntity(pos);
		
		state = getDefaultState();
		state = state.withProperty(COLOUR, tube.getColour());

		boolean up = tube.isConnected(EnumFacing.UP);
		boolean down = tube.isConnected(EnumFacing.DOWN);
		boolean north = tube.isConnected(EnumFacing.NORTH);
		boolean east = tube.isConnected(EnumFacing.EAST);
		boolean south = tube.isConnected(EnumFacing.SOUTH);
		boolean west = tube.isConnected(EnumFacing.WEST);

		if (!up && !down && !north && east && !south && west) {
			state = state.withProperty(MODE, TubeMode.X);
			up = down = north = east = south = west = false;
		} else if (up && down && !north && !east && !south && !west) {
			state = state.withProperty(MODE, TubeMode.Y);
			up = down = north = east = south = west = false;
		} else if (!up && !down && north && !east && south && !west) {
			state = state.withProperty(MODE, TubeMode.Z);
			up = down = north = east = south = west = false;
		} else {
			state = state.withProperty(MODE, TubeMode.Joint);
		}

		state = state.withProperty(UP, up);
		state = state.withProperty(DOWN, down);
		state = state.withProperty(NORTH, north);
		state = state.withProperty(EAST, east);
		state = state.withProperty(SOUTH, south);
		state = state.withProperty(WEST, west);
		return state;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COLOUR, MODE, UP, DOWN, NORTH, EAST, SOUTH, WEST });
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTube();
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean doesSideBlockRendering(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing face) {
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
}

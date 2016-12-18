package com.error22.thelta.tubes;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTube extends BlockContainer {
	public static enum TubeColour implements IStringSerializable {
		Red("red"), Generic("generic");

		private String name;

		private TubeColour(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	public static enum TubeMode implements IStringSerializable {
		Joint("joint"), X("x"), Z("z");

		private String name;

		private TubeMode(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}
	}

	// public static final PropertyAxis FACING = PropertyAxis.create("facing");
	public static final PropertyEnum<TubeColour> COLOUR = PropertyEnum.create("colour", TubeColour.class);
	public static final PropertyEnum<TubeMode> MODE = PropertyEnum.create("mode", TubeMode.class);
	public static final PropertyBool SIDE_ZPOS = PropertyBool.create("sidezpos");

	public BlockTube(String name) {
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);

		setDefaultState(blockState.getBaseState().withProperty(COLOUR, TubeColour.Generic)
				.withProperty(MODE, TubeMode.Joint).withProperty(SIDE_ZPOS, true));
		setHardness(3f);
		setResistance(5f);
		setCreativeTab(CreativeTabs.REDSTONE);
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ,
			int meta, EntityLivingBase placer) {
		System.out
				.println(facing + "  1 " + placer.getHorizontalFacing() + "=" + placer.getHorizontalFacing().getAxis());
		// return this.getDefaultState().withProperty(FACING,
		// placer.getHorizontalFacing().getAxis());
		return this.getDefaultState().withProperty(COLOUR, TubeColour.Red).withProperty(MODE, TubeMode.Joint).withProperty(SIDE_ZPOS, true);
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer,
			ItemStack stack) {
		System.out.println(placer.getHorizontalFacing() + "=" + placer.getHorizontalFacing().getAxis());
		// worldIn.setBlockState(pos, state.withProperty(FACING,
		// placer.getHorizontalFacing().getAxis()), 2);
	}

	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state) {
		// return this.getDefaultState().withProperty(FACING,
		// EnumFacing.Axis.Z);
		return getDefaultState().withProperty(COLOUR, TubeColour.Generic)
				.withProperty(MODE, TubeMode.X).withProperty(SIDE_ZPOS, false);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		// return this.getDefaultState().withProperty(FACING,
		// EnumFacing.Axis.values()[meta]);
		return getDefaultState();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return 0;
		// return ((EnumFacing.Axis) state.getValue(FACING)).ordinal();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { COLOUR, MODE, SIDE_ZPOS });
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
	public boolean isBlockSolid(IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
		return false;
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

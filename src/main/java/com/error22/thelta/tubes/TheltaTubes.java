package com.error22.thelta.tubes;

import com.error22.thelta.Context;
import com.error22.thelta.Thelta;
import com.error22.thelta.TheltaModule;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TheltaTubes extends TheltaModule {
	public static BlockTube basicTube;
	public static ItemBlock basicTubeItem;

	@Override
	public void registerBlocks(Context context) {
		basicTube = new BlockTube("tube_basic");
		basicTubeItem = context.registerBlock(basicTube);
		GameRegistry.registerTileEntity(TileEntityTube.class, "thelta_tube");
	}

}

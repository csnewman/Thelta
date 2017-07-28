package com.error22.thelta.tubes;

import com.error22.thelta.Thelta;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({ @Stage(name = TheltaTubes.tubesStage) })
public class TheltaTubes {
	public static final String tubesStage = "tubes-tubes";
	public static BlockTube basicTube;
	public static ItemBlock basicTubeItem;

	@StageMethod(stage = tubesStage, pass = Pass.PreInit)
	private static void registerTubes() {
		basicTube = new BlockTube("tube_basic");
		ForgeRegistries.BLOCKS.register(basicTube);
		GameRegistry.registerTileEntity(TileEntityTube.class, "thelta_tube");

		basicTubeItem = new ItemBlock(basicTube);
		basicTubeItem.setRegistryName(basicTube.getRegistryName());
		ForgeRegistries.ITEMS.register(basicTubeItem);
	}

	@SideOnly(Side.CLIENT)
	@StageMethod(stage = tubesStage, pass = Pass.PreInit, client = true)
	private static void registerClientRenderers() {
		ModelLoader.setCustomModelResourceLocation(basicTubeItem, 0, new ModelResourceLocation(
				Thelta.MODID + ":" + basicTubeItem.getRegistryName().getResourcePath(), "inventory"));
	}

}

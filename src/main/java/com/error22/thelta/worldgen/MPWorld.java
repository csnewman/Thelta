package com.error22.thelta.worldgen;

import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class MPWorld extends TheltaModule {

	public static BlockTheltaWorld block;
	public static ItemBlock blockItem;
		
	public void registerBlocks(Context context) {
		block = new BlockTheltaWorld("Thelta_Test_Ore");
		blockItem = context.registerBlock(block);
	}
}

package com.error22.thelta.worldgen;

import com.error22.thelta.Context;
import com.error22.thelta.TheltaModule;
import com.error22.thelta.common.Smeltables;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldGenHandler extends TheltaModule {

	@Override
	public void postInit(Context context) {
		GameRegistry.registerWorldGenerator(new WorldGenerator(), 3);
	}

	@Override
	public void registerWorldGenerators(Context context) {
		context.registerWorldGenOre(Smeltables.blockOreCopper);
		context.registerWorldGenOre(Smeltables.blockOreTin);
	}

}

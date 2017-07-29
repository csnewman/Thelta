package com.error22.thelta;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class TheltaModule {

	public void loadConfig(Context context) {
	}

	public void init(Context context) {
	}

	public void registerBlocks(Context context) {
	}

	public void registerItems(Context context) {
	}

	public void registerRecipes(Context context) {
	}

	@SideOnly(Side.CLIENT)
	public void registerRenderers(Context context) {
	}

	public void lateInit(Context context) {
	}

	public void postInit(Context context) {
	}
}

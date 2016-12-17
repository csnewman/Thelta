package com.error22.thelta;

import com.error22.thelta.computers.TheltaComputers;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
		TheltaComputers.preInitClient();
	}
	
	@Override
	public void init() {
		super.init();
	}
	
	@Override
	public void postInit() {
		super.postInit();
	}

}

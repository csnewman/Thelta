package com.error22.thelta;

import com.error22.thelta.computers.TheltaComputers;
import com.error22.thelta.craftingcomponents.CraftingComponents;
import com.error22.thelta.minivox.Minivox;

import net.minecraft.item.Item;

public class CommonProxy {

	public void preInit() {
		TheltaComputers.preInit();
		Minivox.preInit();
		CraftingComponents.preInit();
	}

	public void init() {
		TheltaComputers.init();
		Minivox.init();
		CraftingComponents.init();
	}

	public void postInit() {
		TheltaComputers.postInit();
		Minivox.postInit();
		CraftingComponents.postInit();
	}

}

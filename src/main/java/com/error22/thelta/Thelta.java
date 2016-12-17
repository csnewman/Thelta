package com.error22.thelta;

import com.error22.thelta.computers.BlockComputer;
import com.error22.thelta.computers.TheltaComputers;
import com.error22.thelta.minivox.TheltaTesting;
import com.error22.thelta.minivox.items.QuickItem;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = Thelta.MODID, version = Thelta.VERSION)
public class Thelta {
	public static final String MODID = "thelta";
	public static final String VERSION = "1.0";

	@Instance(value = MODID)
	public static Thelta INSTANCE;

	@SidedProxy(serverSide = "com.error22.thelta.CommonProxy", clientSide = "com.error22.thelta.ClientProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		TheltaComputers.preInit();
		TheltaTesting.preInit();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		TheltaComputers.init();
		TheltaTesting.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		TheltaComputers.postInit();
		TheltaTesting.postInit();
	}
}

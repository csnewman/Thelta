package com.error22.thelta;

import com.error22.thelta.computers.BlockComputer;
import com.error22.thelta.items.QuickItem;

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

	public BlockComputer testComputer;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		testComputer = new BlockComputer("computer_test");
		registerSimpleBlock(testComputer);
		
		GameRegistry.register(new QuickItem("test"));
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}

	private void registerSimpleBlock(Block block) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(block);
		GameRegistry.register(item);
		proxy.registerItemRenderer(item, 0, block.getRegistryName().getResourcePath());
	}
}

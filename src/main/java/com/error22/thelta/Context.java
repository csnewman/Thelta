package com.error22.thelta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;

public class Context {
	protected ContextState state;
	protected List<TheltaModule> modules;

	public Context() {
		state = ContextState.Uninitialized;
		modules = new ArrayList<TheltaModule>();
	}

	public void addModule(TheltaModule module) {
		assertState(ContextState.Uninitialized);
		modules.add(module);
	}

	public void preInit(FMLPreInitializationEvent event) {
		assertState(ContextState.Uninitialized);
		state = ContextState.ConfigLoading;
		for (TheltaModule module : modules) {
			module.loadConfig(this);
		}
		state = ContextState.Initialization;
		for (TheltaModule module : modules) {
			module.init(this);
		}
		state = ContextState.BlockRegistration;
		for (TheltaModule module : modules) {
			module.registerBlocks(this);
		}
		state = ContextState.ItemRegistration;
		for (TheltaModule module : modules) {
			module.registerItems(this);
		}
		state = ContextState.Intermediary;
	}

	public void init(FMLInitializationEvent event) {
		assertState(ContextState.Intermediary);
		state = ContextState.RecipeRegistration;
		for (TheltaModule module : modules) {
			module.registerRecipes(this);
		}
		initRenderers();
		state = ContextState.LateInitialization;
		for (TheltaModule module : modules) {
			module.lateInit(this);
		}
		state = ContextState.Intermediary;
	}

	protected void initRenderers() {
	}

	public void postInit(FMLPostInitializationEvent event) {
		assertState(ContextState.Intermediary);
		state = ContextState.PostInitialization;
		for (TheltaModule module : modules) {
			module.postInit(this);
		}
		state = ContextState.Finished;
	}

	public CreativeTabs creativeTab(String name, Supplier<Item> icon) {
		assertState(ContextState.Initialization);
		return new CreativeTabs(name) {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(icon.get());
			}
		};
	}

	public Item createSimpleItem(String name, CreativeTabs tab) {
		assertState(ContextState.ItemRegistration);
		Item item = new Item();
		item.setRegistryName(name);
		item.setUnlocalizedName(name);
		item.setCreativeTab(tab);
		ForgeRegistries.ITEMS.register(item);
		addAutoItemRendererRegistration(item);
		return item;
	}

	protected void addAutoItemRendererRegistration(Item item) {
	}

	protected void assertState(ContextState state) {
		if (this.state != state)
			throw new RuntimeException(
					"Action is not possible outside of " + state + " state, currently in " + this.state);
	}

}

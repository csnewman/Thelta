package com.error22.thelta;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.error22.thelta.worldgen.WorldGenStaticVars;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
		
		//Edit: rater193 (This is used for worldgen registration)
		state = ContextState.WorldgenRegistration;
		for (TheltaModule module : modules) {
			module.registerWorldGenerators(this);
		}
		//End Edit
		
		state = ContextState.Intermediary;
	}

	public void init(FMLInitializationEvent event) {
		assertState(ContextState.Intermediary);
		state = ContextState.RecipeRegistration;
		for (TheltaModule module : modules) {
			module.registerRecipes(this);
		}
		state = ContextState.SoundRegistration;
		for (TheltaModule module : modules) {
			module.registerSounds(this);
		}
		state = ContextState.EntityRegistration;
		for (TheltaModule module : modules) {
			module.registerEntities(this);
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


	//Edit: rater193 (This is used for worldgen registration)
	//The api starts here
	public void registerWorldGenOre(Block oreToGenerate) {
		registerWorldGenOre(oreToGenerate, 1, 64, 8, 30);
	}

	public void registerWorldGenOre(Block oreToGenerate, int minHeight, int maxHeight, int size, int spawnAttempts) {
		assertState(ContextState.WorldgenRegistration);
		WorldGenStaticVars.registerNewWorldGenerator(oreToGenerate, minHeight, maxHeight, size, spawnAttempts);
	}
	//End Edit
	
	public CreativeTabs createTabWithItem(String name, Supplier<Item> icon) {
		assertState(ContextState.Initialization);
		return new CreativeTabs(name) {
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(icon.get());
			}
		};
	}

	public CreativeTabs createTabWithBlock(String name, Supplier<Block> icon) {
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
		return registerItem(new Item(), name, tab);
	}

	public Item registerItem(Item item, String name, CreativeTabs tab) {
		assertState(ContextState.ItemRegistration);
		item.setRegistryName(name);
		item.setUnlocalizedName(name);
		item.setCreativeTab(tab);
		ForgeRegistries.ITEMS.register(item);
		addAutoItemRendererRegistration(item);
		return item;
	}

	public Block createSimpleBlock(String name, Material material, CreativeTabs tab) {
		Block block = new Block(material);
		registerBlock(block, name, tab);
		return block;
	}

	public ItemBlock registerBlock(Block block, String name, CreativeTabs tab) {
		assertState(ContextState.BlockRegistration);
		block.setUnlocalizedName(name);
		block.setRegistryName(name);
		block.setCreativeTab(tab);
		return registerBlock(block);
	}

	public ItemBlock registerBlock(Block block) {
		assertState(ContextState.BlockRegistration);
		ForgeRegistries.BLOCKS.register(block);

		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		ForgeRegistries.ITEMS.register(item);
		addAutoItemRendererRegistration(item);
		return item;
	}

	public void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String key) {
		assertState(ContextState.BlockRegistration);
		GameRegistry.registerTileEntity(tileEntityClass, key);
	}

	protected void addAutoItemRendererRegistration(Item item) {
	}

	public SoundEvent registerSound(String soundName) {
		assertState(ContextState.SoundRegistration);
		ResourceLocation soundID = new ResourceLocation(Thelta.MODID, soundName);
		SoundEvent event = new SoundEvent(soundID).setRegistryName(soundID);
		ForgeRegistries.SOUND_EVENTS.register(event);
		return event;
	}

	public void registerMob(int id, String name, Class<? extends Entity> entityClass) {
		assertState(ContextState.EntityRegistration);
		EntityRegistry.registerModEntity(new ResourceLocation(Thelta.MODID, "Entity" + name), entityClass, name, id,
				Thelta.INSTANCE, 80, 3, true, 0, 0);
	}

	protected void assertState(ContextState state) {
		if (this.state != state)
			throw new RuntimeException(
					"Action is not possible outside of " + state + " state, currently in " + this.state);
	}

}

package com.error22.thelta.minivox;

import com.error22.thelta.Thelta;
import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;
import com.error22.thelta.minivox.entities.render.RenderMinivox;
import com.error22.thelta.minivox.items.QuickItem;
import com.error22.thelta.pipeline.FieldStage;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.PipelineInstance;
import com.error22.thelta.pipeline.PipelineStage;
import com.error22.thelta.pipeline.StageMethod;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Minivox {
	public static final String rottenFleshStage = "minivox-rotten-flesh";
	public static final String postStage = "minivox-post";
	public static final String testStage = "minivox-test";
	@PipelineInstance
	public static Minivox instance;
	@FieldStage(name = rottenFleshStage)
	private static PipelineStage rottenFleshStageInst;
	@FieldStage(name = testStage)
	private static PipelineStage testStageInst;
	@FieldStage(name = postStage, after = { rottenFleshStage, testStage })
	private static PipelineStage postStageInst;

	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");
	public static Item testItem;
	public static Block rottenFleshBlock;
	public static Item rottenFleshBlockItem;

	@StageMethod(stage = testStage, pass = Pass.PreInit)
	private static void registerTest() {
		testItem = new QuickItem("testitem");
	}

	@StageMethod(stage = rottenFleshStage, pass = Pass.PreInit)
	private static void registerRottenFlesh() {
		rottenFleshBlock = new QuickBlock("rottenfleshblock");
		rottenFleshBlockItem = registerSimpleBlock(rottenFleshBlock);
	}

	@StageMethod(stage = postStage, pass = Pass.Init)
	private static void postCommon() {
		GameRegistry.addRecipe(new ItemStack(rottenFleshBlock), "AAA", "AAA", "AAA", 'A', Items.ROTTEN_FLESH);
		EntityRegistry.addSpawn(EntityMinivox.class, 6, 1, 5, EnumCreatureType.CREATURE, Biomes.PLAINS);
	}

	@StageMethod(stage = postStage, pass = Pass.Init, client = true)
	private static void postClient() {
		registerItemRenderer(rottenFleshBlockItem);
		registerItemRenderer(testItem);

		RenderingRegistry.registerEntityRenderingHandler(EntityMinivox.class,
				new RenderMinivox(Minecraft.getMinecraft().getRenderManager()));
	}

	private static ItemBlock registerSimpleBlock(Block block) {
		ItemBlock item = new ItemBlock(block);
		item.setRegistryName(block.getRegistryName());
		GameRegistry.register(block);
		GameRegistry.register(item);
		return item;
	}

	private static void registerItemRenderer(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory"));
	}

}

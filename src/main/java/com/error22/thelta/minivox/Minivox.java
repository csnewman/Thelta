package com.error22.thelta.minivox;

import com.error22.thelta.Thelta;
import com.error22.thelta.minivox.blocks.BlockTestRender;
import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;
import com.error22.thelta.minivox.entities.render.RenderMinivox;
import com.error22.thelta.minivox.entities.render.TileEntityTestRenderRenderer;
import com.error22.thelta.minivox.entities.tiles.TileEntityTestRender;
import com.error22.thelta.minivox.items.QuickItem;
import com.error22.thelta.minivox.items.TacoGodRing;
import com.error22.thelta.mobapi.MobAPI;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({
	@Stage(name = Minivox.stagenameInit),
	@Stage(name = Minivox.stagenameCreateItems),
	@Stage(name = Minivox.stagenameCreateBlocks),
	@Stage(name = Minivox.stagenameCreateMobs, before = { MobAPI.stagenameInit }),
	@Stage(name = Minivox.stagenameHandleRender)
})
public class Minivox {
	
	//Staging variables
	public static final String stagenameInit			= "minivox-init";
	public static final String stagenameCreateItems		= "minivox-createitems";
	public static final String stagenameCreateBlocks	= "minivox-createblocks";
	public static final String stagenameCreateMobs		= "minivox-createmobs";
	public static final String stagenameHandleRender	= "minivox-handlerenderers";
	
	//forge variables
	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("minivox");
	public static Item testItem;
	public static Item tacogodring;
	public static QuickBlock rottenFleshBlock;
	public static BlockTestRender testRenderBlock;
	public static Item rottenFleshBlockItem;
	public static Item testRenderBlockItem;
	
	@StageMethod(stage = stagenameInit,	pass = Pass.PreInit)	private static void init() {
		MinivoxSoundEvents.registerSoundEvents();
	}
	
	@StageMethod(stage = stagenameCreateItems,	pass = Pass.PreInit)	private static void createItems() {
		testItem = new QuickItem("testitem");
		tacogodring = new TacoGodRing("tacogodsummonring");
	}

	@StageMethod(stage = stagenameCreateBlocks,	pass = Pass.PreInit)	private static void createBlocks() {
		rottenFleshBlock = new QuickBlock("rottenfleshblock");
		rottenFleshBlockItem = rottenFleshBlock.blockItem;
		
		testRenderBlock = new BlockTestRender("blocktestrender");
		testRenderBlockItem = testRenderBlock.blockItem;

		GameRegistry.registerTileEntity(TileEntityTestRender.class, "thelta_testrenderblock");
		
		GameRegistry.addRecipe(new ItemStack(rottenFleshBlock), "AAA", "AAA", "AAA", 'A', Items.ROTTEN_FLESH);
		GameRegistry.addRecipe(new ItemStack(tacogodring), " A ", "B B", " B ", 'A', Blocks.LAPIS_BLOCK, 'B', Items.GOLD_INGOT);
	}
	
	
	@StageMethod(stage = stagenameCreateMobs,	pass = Pass.PreInit)	private static void createMobs() {
		MobAPI.registerNewMob(1, "Minivox", EntityMinivox.class);
	}
	
	@SideOnly(Side.CLIENT)
	@StageMethod(stage = stagenameCreateMobs,	pass = Pass.PreInit, client = true)	private static void createMobsClient() {
		MobAPI.registerMobRender(EntityMinivox.class, RenderMinivox.class);
	}
	
	@SideOnly(Side.CLIENT) @StageMethod(stage = stagenameHandleRender,	pass = Pass.Init, client = true)
																		private static void handlerRenders() {
		registerItemRenderer(rottenFleshBlockItem);
		registerItemRenderer(testRenderBlockItem);
		registerItemRenderer(testItem);
		registerItemRenderer(tacogodring);

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTestRender.class,
				new TileEntityTestRenderRenderer());
		
	}

	private static void registerItemRenderer(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory"));
	}

}

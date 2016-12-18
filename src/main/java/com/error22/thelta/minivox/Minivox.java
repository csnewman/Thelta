package com.error22.thelta.minivox;

import com.error22.thelta.Thelta;
import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.minivox.entities.mobs.EntityMinivox;
import com.error22.thelta.minivox.entities.render.RenderMinivox;
import com.error22.thelta.minivox.items.QuickItem;
import com.error22.thelta.mobapi.MobAPI;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.PipelineStage;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;
import com.error22.thelta.pipeline.Stages;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Stages({
	@Stage(name = Minivox.stagenameCreateItems),
	@Stage(name = Minivox.stagenameCreateBlocks),
	@Stage(name = Minivox.stagenameCreateMobs, before = { MobAPI.stagenameInit }),
	@Stage(name = Minivox.stagenameHandleRender)
})
public class Minivox {
	
	//Staging variables
	public static final String stagenameCreateItems		= "minivox-createitems";
	public static final String stagenameCreateBlocks	= "minivox-createblocks";
	public static final String stagenameCreateMobs		= "minivox-createmobs";
	public static final String stagenameHandleRender	= "minivox-handlerenderers";
	
	//forge variables
	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");
	public static Item testItem;
	public static QuickBlock rottenFleshBlock;
	public static Item rottenFleshBlockItem;
	
	@StageMethod(stage = stagenameCreateItems,	pass = Pass.PreInit)	private static void createItems() {
		testItem = new QuickItem("testitem");
	}

	@StageMethod(stage = stagenameCreateBlocks,	pass = Pass.PreInit)	private static void createBlocks() {
		rottenFleshBlock = new QuickBlock("rottenfleshblock");
		rottenFleshBlockItem = rottenFleshBlock.blockItem;
		GameRegistry.addRecipe(new ItemStack(rottenFleshBlock), "AAA", "AAA", "AAA", 'A', Items.ROTTEN_FLESH);
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
		registerItemRenderer(testItem);
		
	}

	private static void registerItemRenderer(Item item) {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0,
				new ModelResourceLocation(Thelta.MODID + ":" + item.getRegistryName().getResourcePath(), "inventory"));
	}

}

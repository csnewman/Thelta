package com.error22.thelta.minivox;

import com.error22.thelta.minivox.blocks.QuickBlock;
import com.error22.thelta.minivox.creativetabs.CreativeTabMinivox;
import com.error22.thelta.pipeline.Pass;
import com.error22.thelta.pipeline.PipelineStage;
import com.error22.thelta.pipeline.Stage;
import com.error22.thelta.pipeline.StageMethod;

import net.minecraft.item.Item;

public class Minivox {
	
	//Staging variables
	public static final String stagenameCreateItems		= "minivox-createitems";
	public static final String stagenameCreateBlocks	= "minivox-createblocks";
	public static final String stagenameCreateMobs		= "minivox-createmobs";
	public static final String stagenameHandleRender	= "minivox-handlerenderers";

	@Stage(name = stagenameCreateItems)	private static PipelineStage stageCreateItems;
	@Stage(name = stagenameCreateBlocks)	private static PipelineStage stageCreateBlocks;
	@Stage(name = stagenameCreateMobs)		private static PipelineStage stageCreateMobs;
	@Stage(name = stagenameHandleRender)	private static PipelineStage stageHandleRender;
	
	//forge variables
	public static final CreativeTabMinivox creativetab = new CreativeTabMinivox("myMod");
	public static Item testItem;
	public static QuickBlock rottenFleshBlock;
	public static Item rottenFleshBlockItem;
	
	@StageMethod(stage = stagenameCreateItems,	pass = Pass.PreInit)	private static void createItems() {
		
	}

	@StageMethod(stage = stagenameCreateBlocks,	pass = Pass.PreInit)	private static void createBlocks() {
		
	}

	@StageMethod(stage = stagenameCreateMobs,	pass = Pass.PreInit)	private static void createMobs() {
		
	}
	
	@StageMethod(stage = stagenameHandleRender,	pass = Pass.Init)		private static void handlerRenders() {
		
	}

}

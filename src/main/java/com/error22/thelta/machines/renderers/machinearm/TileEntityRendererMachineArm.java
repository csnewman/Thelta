package com.error22.thelta.machines.renderers.machinearm;

import java.util.List;

import org.lwjgl.opengl.GL11;

import com.error22.thelta.Thelta;
import com.error22.thelta.machines.tileentities.TileEntityMachinearm;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.pipeline.LightUtil;
import net.minecraftforge.common.model.TRSRTransformation;

public class TileEntityRendererMachineArm extends TileEntitySpecialRenderer<TileEntityMachinearm> {

	IModel modelBase;
	IBakedModel bakedModel;

	public TileEntityRendererMachineArm() {



	}

	
	//Ripped from:
	//https://github.com/M4thG33k/PipeDream/blob/master/src/main/java/com/m4thg33k/pipedream/client/render/models/ModelHelper.java
	public static IBakedModel bake(IModel model) {
		return model.bake(TRSRTransformation.identity(), Attributes.DEFAULT_BAKED_FORMAT,
				ModelLoader.defaultTextureGetter());
	}
	
	//Ripped from:
	//https://github.com/M4thG33k/PipeDream/blob/master/src/main/java/com/m4thg33k/pipedream/client/render/models/ModelHelper.java
	public static void renderModel(IBlockState state, IBakedModel model, int color) {
		Tessellator tessellator = Tessellator.getInstance();
		VertexBuffer buffer = tessellator.getBuffer();
		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.ITEM);

		List<BakedQuad> quads = model.getQuads(null, EnumFacing.NORTH, 0);

		for (BakedQuad bakedQuad : quads) {
			LightUtil.renderQuadColor(buffer, bakedQuad, color);
		}

		tessellator.draw();
	}

	@Override
	public void renderTileEntityAt(TileEntityMachinearm te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		//super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		//GlStateManager.pushMatrix();
		/*GlStateManager.disableLighting();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);
		

		GlStateManager.translate(x + 0.06f, y + 0.9375f, z + 0.0625f);
		GlStateManager.rotate(270, 0, 1, 0);
		*/
		//renderModel(bake(modelBase), 0);

		// Here we are loading the models
		try {
			ResourceLocation texture = new ResourceLocation(Thelta.MODID, "textures/items/placeholder.png");
			ResourceLocation objModelLocation = new ResourceLocation(Thelta.MODID,
					"models/block/obj/machinearm_base.obj");
			modelBase = OBJLoader.INSTANCE.loadModel(objModelLocation);
			bakedModel = bake(modelBase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        GlStateManager.pushMatrix();
		GlStateManager.translate(x + 0.06f, y + 0.9375f, z + 0.0625f);
        renderModel(te.getWorld().getBlockState(new BlockPos(x, y, z)), bakedModel, 0);
        GlStateManager.popMatrix();

		//GlStateManager.disableRescaleNormal();
		//GlStateManager.enableLighting();
		//GlStateManager.popMatrix();
	}

}

package com.error22.thelta.machines;

import java.nio.ByteBuffer;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.error22.thelta.Thelta;
import com.error22.thelta.computers.CGAColor;
import com.google.common.collect.ImmutableMap;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.TRSRTransformation;

public class TileEntityRendererBurnerCrusher extends TileEntitySpecialRenderer<TileEntityBurnerCrusher> {
	private IModel model;
	private IBakedModel bakedModel;

	public TileEntityRendererBurnerCrusher() {
	}

	private IBakedModel getBakedModel() {
		if (bakedModel == null) {
			try {
				model = ModelLoaderRegistry.getModel(new ResourceLocation(Thelta.MODID, "block/newmodel.obj"));
				model = model.process(ImmutableMap.<String, String>builder().put("flip-v", "true").build());
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
			// Might need to replace DefaultVertexFormats.ITEM with
			// Attributes.DEFAULT_BAKED_FORMAT
			bakedModel = model.bake(TRSRTransformation.identity(), DefaultVertexFormats.ITEM,
					ModelLoader.defaultTextureGetter());
		}

		return bakedModel;
	}

	@Override
	public void render(TileEntityBurnerCrusher te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {

		GlStateManager.pushAttrib();
		GlStateManager.pushMatrix();

		GlStateManager.translate(x, y, z);
		GlStateManager.disableRescaleNormal();

		GlStateManager.pushMatrix();

		RenderHelper.disableStandardItemLighting();

		this.bindTexture(TextureMap.LOCATION_BLOCKS_TEXTURE);
		if (Minecraft.isAmbientOcclusionEnabled()) {
			GlStateManager.shadeModel(GL11.GL_SMOOTH);
		} else {
			GlStateManager.shadeModel(GL11.GL_FLAT);
		}
		World world = te.getWorld();

		GlStateManager.translate(-te.getPos().getX(), -te.getPos().getY(), -te.getPos().getZ());

		Tessellator tessellator = Tessellator.getInstance();
		tessellator.getBuffer().begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);

		Minecraft.getMinecraft().getBlockRendererDispatcher().getBlockModelRenderer().renderModel(world,
				getBakedModel(), world.getBlockState(te.getPos()), te.getPos(), Tessellator.getInstance().getBuffer(),
				false);
		tessellator.draw();

		RenderHelper.enableStandardItemLighting();
		GlStateManager.popMatrix();

		GlStateManager.popMatrix();
		GlStateManager.popAttrib();

	}

}

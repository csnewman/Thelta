package com.error22.thelta.machines;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.world.World;

public class TileEntityRendererBurnerCrusher extends TileEntitySpecialRenderer<TileEntityBurnerCrusher> {

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
				Machines.newModel.getBakedModel(), world.getBlockState(te.getPos()), te.getPos(),
				Tessellator.getInstance().getBuffer(), false);
		tessellator.draw();

		RenderHelper.enableStandardItemLighting();
		GlStateManager.popMatrix();

		GlStateManager.popMatrix();
		GlStateManager.popAttrib();

	}

}

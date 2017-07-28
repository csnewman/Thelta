package com.error22.thelta.computers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class TileEntityComputerMonitorRenderer extends TileEntitySpecialRenderer<TileEntityComputerMonitor> {

	@Override
	public void render(TileEntityComputerMonitor te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder bufferbuilder = tessellator.getBuffer();
		int meta = te.getBlockMetadata();
		TileEntityComputerMonitor monitor = (TileEntityComputerMonitor) te;

		float ratio = (float) monitor.getResolutionHeight() / (float) monitor.getResolutionWidth();

		GlStateManager.pushMatrix();
		GlStateManager.disableLighting();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);

		if (monitor.getTextureId() == -1) {
			System.out.println("Monitor texture id does not exist");
		} else if (meta == 4) {
			// XNeg
			GlStateManager.translate(x + 0.06f, y + 0.9375f, z + 0.0625f);
			GlStateManager.rotate(270, 0, 1, 0);
		} else if (meta == 5) {
			// XPos
			GlStateManager.translate(x + 0.94f, y + 0.9375f, z + 0.9375f);
			GlStateManager.rotate(90, 0, 1, 0);
		} else if (meta == 2) {
			// ZNeg
			GlStateManager.translate(x + 0.9375f, y + 0.9375f, z + 0.06f);
			GlStateManager.rotate(180, 0, 1, 0);
		} else if (meta == 3) {
			// ZPos
			GlStateManager.translate(x + 0.0625f, y + 0.9375f, z + 0.94f);
		}

		GlStateManager.scale(0.875f, -0.875f, 1);
		GlStateManager.translate(0, (1f - ratio) / 2f, 0);
		GlStateManager.scale(1f, ratio, 1);

		GlStateManager.bindTexture(monitor.getTextureId());
		bufferbuilder.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
		bufferbuilder.pos(1, 0, 0).tex(1, 0).color(1f, 1f, 1f, 1f).endVertex();
		bufferbuilder.pos(0, 0, 0).tex(0, 0).color(1f, 1f, 1f, 1f).endVertex();
		bufferbuilder.pos(0, 1, 0).tex(0, 1).color(1f, 1f, 1f, 1f).endVertex();
		bufferbuilder.pos(1, 1, 0).tex(1, 1).color(1f, 1f, 1f, 1f).endVertex();
		tessellator.draw();

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

}

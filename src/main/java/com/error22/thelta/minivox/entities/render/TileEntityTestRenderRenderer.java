package com.error22.thelta.minivox.entities.render;

import org.lwjgl.opengl.GL11;

import com.error22.thelta.minivox.entities.tiles.TileEntityTestRender;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class TileEntityTestRenderRenderer extends TileEntitySpecialRenderer<TileEntityTestRender> {

	@Override
	public void render(TileEntityTestRender te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {

		GlStateManager.pushMatrix();
		GlStateManager.disableLighting();
		GlStateManager.enableRescaleNormal();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 240.0F);

		GlStateManager.translate(x + 0.06f, y + 0.9375f, z + 0.0625f);
		GlStateManager.rotate(270, 0, 1, 0);

		GlStateManager.disableRescaleNormal();
		GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

}

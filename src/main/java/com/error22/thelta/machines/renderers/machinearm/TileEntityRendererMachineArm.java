package com.error22.thelta.machines.renderers.machinearm;

import com.error22.thelta.machines.tileentities.TileEntityMachinearm;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class TileEntityRendererMachineArm extends TileEntitySpecialRenderer<TileEntityMachinearm> {
	
	public TileEntityRendererMachineArm() {
		
	}

	@Override
	public void renderTileEntityAt(TileEntityMachinearm te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		//super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
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

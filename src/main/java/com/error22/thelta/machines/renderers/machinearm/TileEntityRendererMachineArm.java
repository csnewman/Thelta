package com.error22.thelta.machines.renderers.machinearm;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.error22.thelta.Thelta;
import com.error22.thelta.computers.CGAColor;
import com.error22.thelta.machines.tileentities.TileEntityMachinearm;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.Attributes;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.client.model.obj.OBJModel;
import net.minecraftforge.common.model.TRSRTransformation;

public class TileEntityRendererMachineArm extends TileEntitySpecialRenderer<TileEntityMachinearm> {

	IBakedModel bakedModelBase;
	IBakedModel bakedModelSwivel;
	IBakedModel bakedModelArmLower;
	IBakedModel bakedModelArmUpper;

	private int textureId = -1;

	public TileEntityRendererMachineArm() {
		/*
		 * // Here we are loading the models try {
		 * 
		 * ResourceLocation texture = new ResourceLocation(Thelta.MODID,
		 * "textures/items/placeholder.png"); ResourceLocation objModelLocation
		 * = new ResourceLocation(Thelta.MODID, "models/block/machinearm_base");
		 * modelBase = OBJLoader.INSTANCE.loadModel(objModelLocation);
		 * bakedModel = bake(modelBase);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); }
		 */

		/*
		 * try {
		 * 
		 * ResourceLocation texture = new ResourceLocation(Thelta.MODID,
		 * "textures/items/placeholder.png"); ResourceLocation objModelLocation
		 * = new ResourceLocation(Thelta.MODID,
		 * "models/block/obj/machinearm_base.obj"); modelBase = (OBJModel)
		 * OBJLoader.INSTANCE.loadModel(objModelLocation); bakedModel =
		 * bake(modelBase); }catch(Exception e) { e.printStackTrace(); }
		 */

		bakedModelBase = loadModel("models/block/obj/machinearm_base.obj");
		bakedModelSwivel = loadModel("models/block/obj/machinearm_swivel.obj");
		bakedModelArmLower = loadModel("models/block/obj/machinearm_arm_lower.obj");
		bakedModelArmUpper = loadModel("models/block/obj/machinearm_arm_upper.obj");
	}

	public IBakedModel loadModel(String modelname) {
		IBakedModel ret = null;

		try {
			ret = bake((OBJModel) OBJLoader.INSTANCE.loadModel(new ResourceLocation(Thelta.MODID, modelname)));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ret;
	}

	// Ripped from:
	// https://github.com/M4thG33k/PipeDream/blob/master/src/main/java/com/m4thg33k/pipedream/client/render/models/ModelHelper.java
	public static IBakedModel bake(IModel model) {
		return model.bake(TRSRTransformation.identity(), Attributes.DEFAULT_BAKED_FORMAT,
				ModelLoader.defaultTextureGetter());
	}

	// Ripped from:
	// https://github.com/M4thG33k/PipeDream/blob/master/src/main/java/com/m4thg33k/pipedream/client/render/models/ModelHelper.java
	public static void renderModel(IBakedModel model) {

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();

		// System.out.println("123");

		buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.BLOCK);

		List<BakedQuad> quads = model.getQuads(null, null, 0);

		for (BakedQuad bakedQuad : quads) {
			buffer.addVertexData(bakedQuad.getVertexData());
			// LightUtil.renderQuadColor(buffer, bakedQuad, color);
		}
		buffer.endVertex();

		tessellator.draw();
	}

	public static int createTexture() {
		GlStateManager.enableTexture2D();
		int textureId = GlStateManager.generateTexture();
		GlStateManager.bindTexture(textureId);
		GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		GlStateManager.bindTexture(0);
		return textureId;
	}

	public int getResolutionHeight() {
		return 32;
	}

	public int getResolutionWidth() {
		return 32;
	}

	public static void pushTextureArray(int textureId, int textureWidth, int textureHeight, byte[] data) {
		ByteBuffer buffer = BufferUtils.createByteBuffer(textureWidth * textureHeight * 3);
		buffer.put(data);
		buffer.flip();
		pushTextureBuffer(textureId, textureWidth, textureHeight, buffer);
	}

	public static void pushTextureBuffer(int textureId, int textureWidth, int textureHeight, ByteBuffer data) {
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGB8, textureWidth, textureHeight, 0, GL11.GL_RGB,
				GL11.GL_UNSIGNED_BYTE, data);
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, 0);
	}

	private void drawPlane_z(BufferBuilder vertexbuffer, double x1, double y1, double x2, double y2, double z) {

		vertexbuffer.pos(x2, y1, z).tex(1, 0).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x1, y1, z).tex(0, 0).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x1, y2, z).tex(0, 1).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x2, y2, z).tex(1, 1).color(1f, 1f, 1f, 1f).endVertex();
	}

	private void drawPlane_x(BufferBuilder vertexbuffer, double z1, double y1, double z2, double y2, double x) {

		vertexbuffer.pos(x, y1, z2).tex(1, 0).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x, y1, z1).tex(0, 0).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x, y2, z1).tex(0, 1).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x, y2, z2).tex(1, 1).color(1f, 1f, 1f, 1f).endVertex();
	}

	private void drawPlane_y(BufferBuilder vertexbuffer, double x1, double z1, double x2, double z2, double y) {
		vertexbuffer.pos(x1, y, z2).tex(1, 0).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x1, y, z1).tex(0, 0).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x2, y, z1).tex(0, 1).color(1f, 1f, 1f, 1f).endVertex();
		vertexbuffer.pos(x2, y, z2).tex(1, 1).color(1f, 1f, 1f, 1f).endVertex();
	}

	private void drawBlock(double x1, double y1, double z1, double x2, double y2, double z2) {

		Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder vertexbuffer = tessellator.getBuffer();

		vertexbuffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX_COLOR);
		// front/back
		drawPlane_z(vertexbuffer, x1, y1, x2, y2, z1);
		drawPlane_z(vertexbuffer, x1, y2, x2, y1, z2);
		// left/right
		drawPlane_x(vertexbuffer, z1, y1, z2, y2, x2);
		drawPlane_x(vertexbuffer, z1, y2, z2, y1, x1);
		// top/bottom
		drawPlane_y(vertexbuffer, x1, z2, x2, z1, y2);
		drawPlane_y(vertexbuffer, x1, z1, x2, z2, y1);
		vertexbuffer.endVertex();

		tessellator.draw();

	}
	
	@Override
	public void render(TileEntityMachinearm te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {
		// Here we are generating a temporary texture
		if (textureId == -1) {
			textureId = createTexture();

			byte[] c_textureData = new byte[getResolutionWidth() * getResolutionHeight() * 3];

			Random rand = new Random();
			for (int x1 = 0; x1 < getResolutionWidth(); x1++) {
				for (int y1 = 0; y1 < getResolutionHeight(); y1++) {
					int base = ((y1 * getResolutionWidth()) + x1) * 3;

					byte[] colorData = CGAColor.getColorBytesData(CGAColor.findColor(255, 255, 255));
					c_textureData[base] = colorData[0];
					c_textureData[base + 1] = colorData[1];
					c_textureData[base + 2] = colorData[2];
				}
			}

			pushTextureArray(textureId, getResolutionWidth(), getResolutionHeight(), c_textureData);
		}

		// super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		// This variable is used for handeling animating the arm
		te.animplace = te.animplace + (partialTicks / 200);
		float animplace = te.animplace;

		GlStateManager.pushMatrix();
		// GlStateManager.disableLighting();
		// GlStateManager.enableRescaleNormal();
		// GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		// OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
		// 240.0F, 240.0F);

		GlStateManager.translate(x + 0.5d, y, z + 0.5d);
		GlStateManager.rotate((float) (animplace * 0), 0, 1, 0);
		GlStateManager.bindTexture(textureId);

		double strength = 110d;
		float rotAmm = (float) ((((Math.sin(animplace) + 1) / 2) - 0.5) * strength);

		renderModel(bakedModelBase);
		// drawBlock(-0.5d, 0d, -0.5d, 0.5d, 1d, 0.5d);
		GlStateManager.translate(0, 0.5, 0);
		// drawBlock(-0.2d, 0d, -0.2d, 0.2d, length, 0.2d);
		renderModel(bakedModelSwivel);
		GlStateManager.translate(0, 0.5, 0);
		GlStateManager.rotate(rotAmm, 0, 0, 1);
		renderModel(bakedModelArmLower);
		GlStateManager.translate(0, 1.2, 0);
		GlStateManager.rotate(rotAmm * 1.8f, 0, 0, 1);
		renderModel(bakedModelArmUpper);
		GlStateManager.translate(0, 1.2, 0);
		
		try {
			if(te.entityitem!=null) {
				te.entityitem.height = 0f;
				te.entityitem.hoverStart = 0f;
				te.entityitem.setRotationYawHead(0);
				te.entityitem.setRenderYawOffset(0);
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(te.entityitem, 0, 0, 0, 0, 0, false);
			}
		}catch(Exception e) {
			System.err.println("[ERR] [RENDERING] Failed to render machine arm item!");
		}

		// GlStateManager.disableRescaleNormal();
		// GlStateManager.enableLighting();
		GlStateManager.popMatrix();
	}

}

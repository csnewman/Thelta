package com.error22.thelta.machines;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.error22.thelta.Thelta;
import com.error22.thelta.computers.CGAColor;

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


public class TileEntityRendererBurnerCrusher extends TileEntitySpecialRenderer<TileEntityBurnerCrusher> {
	IBakedModel
		modelMachineBase;
	
	private int textureId = -1;
	
	public TileEntityRendererBurnerCrusher() {
		modelMachineBase = loadModel("models/block/obj/burner_crusher.obj");
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
//		try {
			List<BakedQuad> quads = model.getQuads(null, null, 0);
			for (BakedQuad bakedQuad : quads) {
				buffer.addVertexData(bakedQuad.getVertexData());
				// LightUtil.renderQuadColor(buffer, bakedQuad, color);
			}
//		}catch(NullPointerException err) {
//			System.out.println("Unable to render model, maybe it didnt load properly?");
//			err.printStackTrace();
//		}
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


	
	@Override
	public void render(TileEntityBurnerCrusher te, double x, double y, double z, float partialTicks, int destroyStage,
			float alpha) {

		if (textureId == -1) {
			textureId = createTexture();

			byte[] c_textureData = new byte[getResolutionWidth() * getResolutionHeight() * 3];

			Random rand = new Random();
			for (int x1 = 0; x1 < getResolutionWidth(); x1++) {
				for (int y1 = 0; y1 < getResolutionHeight(); y1++) {
					int base = ((y1 * getResolutionWidth()) + x1) * 3;

					c_textureData[base] = (byte) 255;
					c_textureData[base + 1] = (byte) 255;
					c_textureData[base + 2] = (byte) 255;
				}
			}

			pushTextureArray(textureId, getResolutionWidth(), getResolutionHeight(), c_textureData);
		}

		GlStateManager.pushMatrix();
		// GlStateManager.disableLighting();
		// GlStateManager.enableRescaleNormal();
		// GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		// OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
		// 240.0F, 240.0F);

		GlStateManager.translate(x + 0.5d, y, z + 0.5d);
		GlStateManager.bindTexture(textureId);
		//try {
		renderModel(modelMachineBase);
		//}catch(NullPointerException err) {
		//	
		//}
		GlStateManager.popMatrix();
		
	}

}

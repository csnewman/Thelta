package com.error22.thelta.computers;

import java.nio.ByteBuffer;
import java.util.Random;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.tileentity.TileEntity;

public class TileEntityComputerMonitor extends TileEntity {
	private int textureId = -1;

	public TileEntityComputerMonitor() {

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

	public int getResolutionHeight() {
		return 200;
	}

	public int getResolutionWidth() {
		return 320;
	}

	public int getTextureId() {
		// textureId = -1;
		if (textureId == -1) {
			textureId = createTexture();

			byte[] c_textureData = new byte[getResolutionWidth() * getResolutionHeight() * 3];

			Random rand = new Random();
			for (int x = 0; x < getResolutionWidth(); x++) {
				for (int y = 0; y < getResolutionHeight(); y++) {
					int base = ((y * getResolutionWidth()) + x) * 3;

					CGAColor color = CGAColor.values()[rand.nextInt(CGAColor.values().length)];

					c_textureData[base] = color.getR();
					c_textureData[base + 1] = color.getG();
					c_textureData[base + 2] = color.getB();
				}
			}

			pushTextureArray(textureId, getResolutionWidth(), getResolutionHeight(), c_textureData);
		}

		return textureId;
	}

}

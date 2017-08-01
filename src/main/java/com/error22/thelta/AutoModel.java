package com.error22.thelta;

import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ForgeBlockStateV1;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class AutoModel {
	private static Gson GSON = (new GsonBuilder()).registerTypeAdapter(AutoModel.class, AutoModel.Deserializer.INSTANCE)
			.create();

	public static AutoModel load(ResourceLocation location) {
		try {
			return GSON.fromJson(new InputStreamReader(
					Minecraft.getMinecraft().getResourceManager().getResource(location).getInputStream(),
					StandardCharsets.UTF_8), AutoModel.class);
		} catch (JsonSyntaxException | JsonIOException | IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static class Deserializer implements JsonDeserializer<AutoModel> {
		static Deserializer INSTANCE = new Deserializer();

		@Override
		public AutoModel deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {

			JsonObject obj = json.getAsJsonObject();
			String objPath = obj.get("obj").getAsString();

			JsonElement texturesElement = obj.get("textures");

			List<ResourceLocation> textures = new ArrayList<ResourceLocation>();
			if (texturesElement.isJsonArray()) {
				JsonArray textureArray = texturesElement.getAsJsonArray();
				textureArray.forEach(e -> textures.add(new ResourceLocation(e.getAsString())));
			} else
				throw new NotImplementedException();

			boolean flipV = obj.has("flip-v") && obj.get("flip-v").getAsBoolean();

			return new AutoModel(objPath, textures, flipV);
		}

	}

	private String objPath;
	private List<ResourceLocation> textures;
	private boolean flipV;
	private IModel model;
	private IBakedModel bakedModel;

	private AutoModel(String objPath, List<ResourceLocation> textures, boolean flipV) {
		this.objPath = objPath;
		this.textures = textures;
		this.flipV = flipV;
	}

	public void loadModelAndBake() {
		try {
			model = ModelLoaderRegistry.getModel(new ResourceLocation(objPath));
			if (flipV)
				model = model.process(ImmutableMap.<String, String>builder().put("flip-v", "true").build());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		bakedModel = model.bake(TRSRTransformation.identity(), DefaultVertexFormats.ITEM,
				ModelLoader.defaultTextureGetter());
	}

	public List<ResourceLocation> getTextures() {
		return textures;
	}

	public IModel getModel() {
		return model;
	}

	public IBakedModel getBakedModel() {
		return bakedModel;
	}

}

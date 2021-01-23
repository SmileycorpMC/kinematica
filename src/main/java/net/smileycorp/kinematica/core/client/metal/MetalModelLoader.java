package net.smileycorp.kinematica.core.client.metal;

import java.io.IOException;
import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ItemLayerModel;
import net.minecraftforge.client.model.ModelLoader;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.materials.ItemMetal;
import net.smileycorp.kinematica.core.common.materials.Materials;

@SuppressWarnings("deprecation")
public class MetalModelLoader implements ICustomModelLoader, IResourceManagerReloadListener {
	
	protected static Map<String, Map<String, TextureAtlasSprite>> sprites = Maps.newHashMap();
	
	public static final Function<ResourceLocation, TextureAtlasSprite> metalTextureGetter = x -> getTexture(x);

	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
		for(Map<String, TextureAtlasSprite> map : sprites.values()) {
			map.clear();
	    }
	}

	@Override
	public boolean accepts(ResourceLocation resource) {
		if (resource.getResourcePath().contains("/metal/")&&resource.getResourceDomain().equals(ModDefinitions.modid)) {
			return true;
		}
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation resource) throws Exception {
		return new ItemLayerModel(ImmutableList.of(), MetalOverrideList.INSTANCE);
	}

	public static void stitchTextures(TextureMap map) {
		for (ItemMetal item : Materials.metal_items) {
			
			MetalType type = item.type;
			
			ResourceLocation base = ModDefinitions.getResource("items/metal/"+type.getName().toLowerCase()+"_base");
			Map<String, TextureAtlasSprite> dict = Maps.newHashMap();
			dict.put("base", map.registerSprite(base));
			
			for (String metal : MetalRegistry.getMetalsFor(type)) {
				if (!metal.toLowerCase().equals("base")) {
					ResourceLocation texture = ModDefinitions.getResource("textures/items/metal/" + type.getName().toLowerCase()+"_"+metal.toLowerCase()+".png");	
					try {
					      Minecraft.getMinecraft().getResourceManager().getAllResources(texture);
					      ResourceLocation location = ModDefinitions.getResource("items/metal/" + type.getName().toLowerCase()+"_"+metal.toLowerCase());	
					      dict.put(metal.toLowerCase(), map.registerSprite(location));
					      System.out.println("stitched texture for " + type.getName() + "_" + metal.toLowerCase());
				    } catch(IOException e) {
				    	System.out.println("failed stitching texture for " + type.getName().toLowerCase() + "_" + metal.toLowerCase() + " using base instead");
				    }
				}
			}
			sprites.put(type.getName().toLowerCase(), dict);
		}
		
	}
	protected static boolean hasTexture(MetalType type, String metal) {
		if (sprites.containsKey(type.getName().toLowerCase())) {
			if (sprites.get(type.getName().toLowerCase()).containsKey(metal.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

	private static TextureAtlasSprite getTexture(String type, String metal) {
		if (sprites.containsKey(type.toLowerCase())) {
			Map<String, TextureAtlasSprite> map = sprites.get(type.toLowerCase());
			if (map.containsKey(metal.toLowerCase())) {
				return map.get(metal.toLowerCase());
			} else {
				return map.get("base");
			}
		}
		return null;
	}
	
	public static TextureAtlasSprite getTexture(MetalType type, String metal) {
		return getTexture(type.getName(), metal);
	}
	
	private static TextureAtlasSprite getTexture(ResourceLocation location) {
		String[] resource=location.getResourcePath().split("_");
		System.out.println("TextureAtlas getting for " + location + ", split as " + resource);
		if (resource!=null&&resource.length>1) {
			return getTexture(resource[0], resource[1]);
		} else {
			return ModelLoader.defaultTextureGetter().apply(location);
		}
	}

}

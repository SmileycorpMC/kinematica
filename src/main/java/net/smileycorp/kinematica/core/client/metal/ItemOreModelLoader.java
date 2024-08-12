package net.smileycorp.kinematica.core.client.metal;

import com.google.common.collect.ImmutableMap;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.smileycorp.kinematica.api.ores.OresAPI;
import net.smileycorp.kinematica.core.common.ModDefinitions;

import java.util.List;

public class ItemOreModelLoader implements ICustomModelLoader {
	
	public static final ItemOreModelLoader INSTANCE = new ItemOreModelLoader();
	
	@Override
	public void onResourceManagerReload(IResourceManager resourceManager) {
	}

	@Override
	public boolean accepts(ResourceLocation resource) {
		if (resource.getResourcePath().contains("item_ore.")) {
			//System.out.println("[Kinematica Ores] registering ore model for " + resource.toString());
			return true;
		}
		//System.out.println("[Kinematica Ores] " + resource.toString() + " is not a valid ore model");
		return false;
	}

	@Override
	public IModel loadModel(ResourceLocation resource) throws Exception {
		ResourceLocation model = ModDefinitions.getResource("item/item_ore");
		try {	
			String name = resource.getResourcePath().split("[.]")[1];
			Block ore = OresAPI.getBlockFor(name);
			Block base = OresAPI.getBaseFor(ore);
			//ResourceLocation baseModel = new ResourceLocation(base.getRegistryName().getResourceDomain(), "block/"+ base.getRegistryName().getResourcePath());
			Minecraft mc = Minecraft.getMinecraft();
			BlockRendererDispatcher dispatcher = mc.getBlockRendererDispatcher();
			IBlockState state = base.getDefaultState();
			IBakedModel bakedmodel = dispatcher.getModelForState(state);
			List<BakedQuad> quads = bakedmodel.getQuads(state, EnumFacing.NORTH, 0);
			BakedQuad quad = quads.get(0);
			TextureAtlasSprite sprite = quad.getSprite();
			ImmutableMap<String, String> textures = ImmutableMap.<String, String>builder().put("overlay", new ResourceLocation(resource.getResourceDomain(), "blocks/ores/"+name).toString()).put("base", sprite.getIconName()).build();
			return ModelLoaderRegistry.getModel(model).retexture(textures);
		} catch(Exception e) {
			return ModelLoaderRegistry.getModel(model);
		}
	}

}

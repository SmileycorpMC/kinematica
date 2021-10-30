package net.smileycorp.kinematica.core.client.tesr;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.client.model.animation.FastTESR;

import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKineOre;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class TESRKineOre extends FastTESR<TileEntityKineOre> {
	
	protected static Map<ResourceLocation, TextureAtlasSprite> textures = new HashMap<ResourceLocation, TextureAtlasSprite>();
	protected static Map<ResourceLocation, ResourceLocation> resources = new HashMap<ResourceLocation, ResourceLocation>();
	
	public static void stitchTextures(TextureMap map) {
		for (Block block : KineWorld.ores) {
			ResourceLocation resource = block.getRegistryName();
			ResourceLocation textureLoc = new ResourceLocation(resource.getResourceDomain(), "blocks/ores/" + resource.getResourcePath());
			TextureAtlasSprite sprite = map.registerSprite(textureLoc);
			textures.put(resource, sprite);
			resources.put(resource, textureLoc);
		}
		
	}
	
	@Override
	public void renderTileEntityFast(TileEntityKineOre te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {
		/*EntityPlayer player = Minecraft.getMinecraft().player;
		if (!Minecraft.getMinecraft().player.isSpectator()&&!.getPosition()) {*/
			TextureAtlasSprite sprite = textures.get(te.getOre());
			World world = te.getWorld();
			BlockPos pos = te.getPos();
			int luminance = te.getBlockType().getLightValue(world.getBlockState(pos), world, pos);
			RenderingUtils.renderCubeQuad(buffer, x, y, z, 1, Color.WHITE, sprite, world, luminance, pos);
		//}
	}
}

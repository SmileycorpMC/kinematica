package net.smileycorp.kinematica.core.client.tesr;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.world.World;
import net.minecraftforge.client.model.animation.FastTESR;
import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityLatexLog;

public class TESRLatexLog extends FastTESR<TileEntityLatexLog> {
	
	@Override
	public void renderTileEntityFast(TileEntityLatexLog te, double x, double y, double z, float partialTicks, int destroyStage, float partial, BufferBuilder buffer) {
		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(ModDefinitions.getResourceName("blocks/log_rubber_leaking"));
		World world = te.getWorld();
		RenderingUtils.renderPlanarQuad(buffer, te.getFacing(), x, y, z, 1, Color.WHITE, sprite, 240, world.getLightFromNeighbors(te.getPos()));
	}
}

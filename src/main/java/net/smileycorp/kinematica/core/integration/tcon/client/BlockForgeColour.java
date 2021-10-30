package net.smileycorp.kinematica.core.integration.tcon.client;

import java.awt.Color;

import slimeknights.tconstruct.shared.tileentity.TileTable;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.fml.common.registry.ForgeRegistries;

import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.core.common.materials.BlockMetal;

public class BlockForgeColour implements IBlockColor {

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) {
		Color colour = Color.WHITE;
		if (tintIndex == 0) {
			TileEntity te = world.getTileEntity(pos);
			if (te instanceof TileTable) {
				Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(((TileTable)te).getTextureBlock().getString("id")));
				if (block instanceof BlockMetal) colour = MetalRegistry.getColour(((BlockMetal)block).metal);
			}
		}
		return colour.getRGB();
	}

}

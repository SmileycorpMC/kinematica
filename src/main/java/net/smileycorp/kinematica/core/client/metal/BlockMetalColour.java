package net.smileycorp.kinematica.core.client.metal;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.core.common.materials.BlockMetal;

public class BlockMetalColour implements IBlockColor {

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) {
		Block block = state.getBlock();
		if (block instanceof BlockMetal) {
			return MetalRegistry.getColour(((BlockMetal) block).metal).getRGB();
		}
		return Color.WHITE.getRGB();
	}



}

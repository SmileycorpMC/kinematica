package net.smileycorp.kinematica.core.client.metal;

import java.awt.Color;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityMetalBlock;

public class BlockMetalColour implements IBlockColor {

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess world, BlockPos pos, int tintIndex) {
		if (world.getTileEntity(pos) instanceof TileEntityMetalBlock) {
			return ((TileEntityMetalBlock) world.getTileEntity(pos)).getColour().getRGB();
		}
		return Color.WHITE.getRGB();
	}



}

package net.smileycorp.kinematica.core.integration.tcon.client;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockForgeColour implements IBlockColor {

	@Override
	public int colorMultiplier(IBlockState state, IBlockAccess worldIn,
			BlockPos pos, int tintIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

}

package net.smileycorp.kinematica.core.common.recipes;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.smileycorp.kinematica.core.common.construction.KineConstruction;

public class WorldRecipes {

	public static void cookBricks(World world, BlockPos pos) {
		for(int i = -1; i<2; i++) {
			for(int j = -1; j<2; j++) {
				for(int k = -1; k<2; k++) {
					if (Math.abs(i)+Math.abs(j)+Math.abs(k)>1) continue;
					BlockPos newpos = pos.east(i).up(j).south(k);
					IBlockState state = world.getBlockState(newpos);
					IBlockState newstate;
					if (state.getBlock()==KineConstruction.MUDBRICK.getBase()) {
						newstate = KineConstruction.FIRED_MUDBRICK.getBase().getDefaultState();
					} else if (state.getBlock()==KineConstruction.MUDBRICK.getStairs()) {
						newstate = KineConstruction.FIRED_MUDBRICK.getStairs().getDefaultState().withProperty(BlockStairs.HALF, state.getValue(BlockStairs.HALF))
								.withProperty(BlockStairs.FACING, state.getValue(BlockStairs.FACING)).withProperty(BlockStairs.SHAPE, state.getValue(BlockStairs.SHAPE));
					} else if (state.getBlock()==KineConstruction.MUDBRICK.getSlab()) {
						newstate = KineConstruction.FIRED_MUDBRICK.getSlab().getDefaultState().withProperty(BlockSlab.HALF, state.getValue(BlockSlab.HALF));
					} else if (state.getBlock()==KineConstruction.MUDBRICK.getSlab(true)) {
						newstate = KineConstruction.FIRED_MUDBRICK.getSlab(true).getDefaultState();
					} else {
						continue;
					}
					world.setBlockState(newpos, newstate, 3);
					if (world.isRemote) world.playSound(newpos.getX(), newpos.getY(), newpos.getZ(), SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 0.3f, 1f, true);
				}
			}
		}
	}
	
	public static void itemInWater(World world, BlockPos pos) {
		
	}

}

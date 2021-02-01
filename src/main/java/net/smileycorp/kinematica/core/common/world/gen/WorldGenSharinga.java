package net.smileycorp.kinematica.core.common.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraftforge.common.IPlantable;
import net.smileycorp.atlas.api.util.PositionUtils;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityLatexLog;
import net.smileycorp.kinematica.core.common.world.blocks.WorldBlocks;

public class WorldGenSharinga extends WorldGenAbstractTree {
	
	final boolean isGenerated;
	
	public WorldGenSharinga(boolean isGenerated) {
		super(false);
		this.isGenerated=isGenerated;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		int height = rand.nextInt(2)+7;
		int y = pos.getY();
		if(y >= 1 && y + height + 2 <= 256) {
			for(int i = -1; i<2; i++) {
				for (int j = 0; j<height+2; j++) {
					for (int k = -1; k<2; k++) {
						BlockPos pos0 = pos.add(i, j, k);
						IBlockState state = world.getBlockState(pos0);
						if (!(state.getMaterial()==Material.PLANTS||world.isAirBlock(pos0))) {
							return false;
						}
					}
				}
			}
			IBlockState state = world.getBlockState(pos.down());
			Block block = state.getBlock();
			if(block != Blocks.AIR && block.canSustainPlant(state, world, pos.down(), EnumFacing.UP, (IPlantable) WorldBlocks.SHARINGA_SAPLING)) {
				block.onPlantGrow(state, world, pos.down(), pos);
				generateTree(world, rand, pos, height);
				return true;
			}
		}
		return false;
	}

	public void generateTree(World world, Random rand, BlockPos pos, int height) {
		int curveheight = rand.nextInt(3)+2;
		//trunk
		for (int j = 0; j<=height; j++){
			if (j==curveheight) {
				world.setBlockState(pos.up(j), WorldBlocks.SHARINGA_LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.NONE), 3);
				switch (rand.nextInt(4)) {
					case 0:
						pos=pos.north();
						break;
					case 1:
						pos=pos.south();
						break;
					case 2:
						pos=pos.east();
						break;
					case 3:
						pos=pos.west();
						break;
				}
				world.setBlockState(pos.up(j), WorldBlocks.SHARINGA_LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, BlockLog.EnumAxis.NONE), 3);
			} else {
				world.setBlockState(pos.up(j), WorldBlocks.SHARINGA_LOG.getDefaultState(), 3);
				if (j<curveheight&&rand.nextInt(4)==0) {
					EnumFacing facing = PositionUtils.getRandomDirection(rand);
					world.setTileEntity(pos.up(j), new TileEntityLatexLog(facing, isGenerated));
				}
			}
		}
		//leaves
		float r0 = 3.5f;
		for (int r1 = 0; r1 < 3; r1++ ) {
			float r = r0-r1;
			for(float i = 0; i < r; i += 0.5) {
				for(float k = 0; k < 2 * Math.PI * i; k += 0.5) {
					BlockPos pos1 = new BlockPos(Math.round(pos.getX() + Math.sin(k) * i), pos.getY() + height -1 + r1, Math.round(pos.getZ() + Math.cos(k) * i));
					IBlockState state = world.getBlockState(pos1);
					if (state.getBlock().canBeReplacedByLeaves(state, world, pos1)) {
						world.setBlockState(pos1, WorldBlocks.SHARINGA_LEAVES.getDefaultState(), 2);
					}
				}
			}
		}
	}	
}

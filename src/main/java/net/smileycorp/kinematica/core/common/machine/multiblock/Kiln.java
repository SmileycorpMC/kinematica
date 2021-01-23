package net.smileycorp.kinematica.core.common.machine.multiblock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;

public class Kiln {

	public static boolean tryToCreate(World world, BlockPos pos) {
		for (int i = -1; i<2; i++) {
			for (int j = -1; j<2; j++) {
				for (int k = -1; k<2; k++) {
					BlockPos newpos = pos.east(i).up(j).north(k);
					if(hasRequiredBlocks(world, newpos)) {
						int flag = 0;
						if (world.isAirBlock(newpos.north())) flag=flag+4;
						else if (validBlock(world, newpos.north())) flag--;
						if (world.isAirBlock(newpos.east())) flag=flag+4;
						else if (validBlock(world, newpos.east())) flag--;
						if (world.isAirBlock(newpos.south())) flag=flag+4;
						else if (validBlock(world, newpos.south())) flag--;
						if (world.isAirBlock(newpos.west())) flag=flag+4;
						else if (validBlock(world, newpos.west())) flag--;
						System.out.println("flag = " + flag);
						if (flag==1) placeKiln(world, newpos);
					}
				}
			}
		}
		System.out.println("kiln falied");
		return false;
	}
	
	private static void placeKiln(World world, BlockPos pos) {
		for (int i = -1; i<2; i++) {
			for (int j = -1; j<2; j++) {
				for (int k = -1; k<2; k++) {
					if (i==0 && j == 0 && k==0) {
						world.setBlockState(pos, MachineBlocks.KILN_CORE.getDefaultState(), 3);
					} else {
						BlockPos newpos = pos.east(i).up(j).north(k);
						if (Math.abs(i) == 1  ^ Math.abs(k) == 1) {
							if (j==-1) {
							} else if (j==0) {
							}
							world.setBlockState(newpos, MachineBlocks.KILN.getDefaultState(), 3);
						}
					}
				}
			}
		}
	}

	private static boolean hasRequiredBlocks(World world, BlockPos pos) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		for (int i = -1; i<2; i++) {
			for (int k = -1; k<2; k++) {
				if(i==0&&k==0) {
					if(!validBlock(world, new BlockPos(x+i, y+3, z+k))) {
						return false;
					}
				}
				if (Math.abs(i)!=1&&Math.abs(k)!=1) {
					if(!validBlock(world, new BlockPos(x+i, y+2, z+k))) {
						return false;
					}
				}
				if(!validBlock(world, new BlockPos(x+i, y+1, z+k))) {
					return false;
				}
			}
		}
		if (world.getBlockState(pos).getBlock()!=Blocks.FIRE) {
			return false;
		}
		System.out.println("has required");
		return true;
	}
	
	private static boolean validBlock(World world, BlockPos pos) {
		Block block = world.getBlockState(pos).getBlock();
		if(block==MachineBlocks.KILN_BRICK) {
			return true;
		}
		return false;
	}

}

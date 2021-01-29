package net.smileycorp.kinematica.core.common.machine.multiblock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;

public class Kiln {

	public static boolean tryToCreate(World world, BlockPos pos) {
		if (isValid(world, pos, pos.north())) return true;
		else if (isValid(world, pos, pos.south())) return true;
		else if (isValid(world, pos, pos.east())) return true;
		else if (isValid(world, pos, pos.west())) return true;
		//System.out.println("Kiln falied at "+pos);
		return false;
	}
	
	private static boolean isValid(World world, BlockPos basePos, BlockPos openSide) {
		//System.out.println("Trying kiln with opening "+openSide);
		for (int i = -1; i< 2; i++) {
			for (int j = 0; j< 3; j++) {
				for (int k = -1; k< 2; k++) {
					BlockPos pos = basePos.east(i).up(j).south(k);
					Block block = world.getBlockState(pos).getBlock();
					if (pos==basePos) {
						if(block!=Blocks.FIRE) {
							//System.out.println("Fire Failed at "+pos);
							return false;
						}
					}
					else if (pos.equals(openSide)||(i==0&&j==1&&k==0)) {
						if (!world.isAirBlock(pos))	{
							//System.out.println("Air Failed at "+pos);
							return false;
						}
					}
					else {
						if (block!=MachineBlocks.MUDBRICK&&block!=MachineBlocks.FIRED_MUDBRICK){
							//System.out.println("Mud Brick Failed at "+pos);
							return false;
						}
					}
				}
			}
		}
		placeKiln(world, basePos, openSide);
		return true; 
	}

	private static void placeKiln(World world, BlockPos basePos, BlockPos openSide) {
		for (int i = -1; i<2; i++) {
			for (int j = 0; j<3; j++) {
				for (int k = -1; k<2; k++) {
					BlockPos pos = basePos.east(i).up(j).south(k);
					if (i==0 && j == 0 && k==0) {
						world.setBlockState(basePos, MachineBlocks.KILN_CORE.getDefaultState(), 3);
					} else if(world.getBlockState(pos)==MachineBlocks.MUDBRICK.getDefaultState()) world.setBlockState(pos, MachineBlocks.FIRED_MUDBRICK.getDefaultState(), 3);
					else {
						if (Math.abs(i) == 1  ^ Math.abs(k) == 1) {
							if (j==-1) {
							} else if (j==0) {
							}
							//world.setBlockState(pos, MachineBlocks.KILN.getDefaultState(), 3);
						}
					}
				}
			}
		}
		//System.out.println("Placed kiln at "+basePos);
	}

}

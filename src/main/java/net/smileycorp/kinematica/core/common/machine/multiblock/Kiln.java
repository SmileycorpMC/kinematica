package net.smileycorp.kinematica.core.common.machine.multiblock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.atlas.api.util.DirectionUtils;
import net.smileycorp.kinematica.core.common.machine.blocks.BlockKiln;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;

public class Kiln {

	public static boolean tryToCreate(World world, BlockPos pos) {
		for (int i = 0; i<4; i++) {
			if (isValid(world, pos, DirectionUtils.getDirection(i))) return true;
		}
		//System.out.println("Kiln falied at "+pos);
		return false;
	}
	
	private static boolean isValid(World world, BlockPos basePos, EnumFacing facing) {
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
					else if (pos.equals(DirectionUtils.getPos(basePos, facing))||(i==0&&j==1&&k==0)) {
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
		placeKiln(world, basePos, facing);
		return true; 
	}

	private static void placeKiln(World world, BlockPos basePos, EnumFacing facing) {
		world.setBlockState(basePos, MachineBlocks.KILN_CORE.getDefaultState(), 3);
		world.setBlockState(DirectionUtils.getPos(basePos.up(), facing), MachineBlocks.KILN.getDefaultState().withProperty(BlockKiln.facing, facing), 3);
		for (int i = -1; i<2; i++) {
			for (int j = 0; j<3; j++) {
				for (int k = -1; k<2; k++) {
					BlockPos pos = basePos.east(i).up(j).south(k);
					if(world.getBlockState(pos)==MachineBlocks.MUDBRICK.getDefaultState()) world.setBlockState(pos, MachineBlocks.FIRED_MUDBRICK.getDefaultState(), 3);	
				}
			}
		}
		//System.out.println("Placed kiln at "+basePos);
	}

}

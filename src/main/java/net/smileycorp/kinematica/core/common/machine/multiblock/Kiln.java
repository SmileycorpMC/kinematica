package net.smileycorp.kinematica.core.common.machine.multiblock;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.atlas.api.util.DirectionUtils;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.machine.BasicMachines;
import net.smileycorp.kinematica.core.common.machine.blocks.BlockKilnChamber;

public class Kiln {

	public static boolean tryToCreate(World world, BlockPos pos) {
		for (int i = 0; i<4; i++) {
			if (isValid(world, pos, DirectionUtils.getDirection(i))) return true;
		}
		//System.out.println("Kiln falied at "+pos);
		return false;
	}
	
	private static boolean isValid(World world, BlockPos pos, EnumFacing facing) {
		//System.out.println("Trying kiln with opening "+openSide);
		for (int i = -1; i< 2; i++) {
			for (int j = 0; j< 3; j++) {
				for (int k = -1; k< 2; k++) {
					BlockPos newpos = pos.east(i).up(j).south(k);
					Block block = world.getBlockState(newpos).getBlock();
					if (newpos==pos) {
						if(block!=Blocks.FIRE) {
							//System.out.println("Fire Failed at "+pos);
							return false;
						}
					}
					else if (newpos.equals(DirectionUtils.getPos(pos, facing))||(i==0&&j==1&&k==0)) {
						if (!world.isAirBlock(newpos))	{
							//System.out.println("Air Failed at "+pos);
							return false;
						}
					}
					else {
						if (block!=KineConstruction.MUDBRICK.getBase()&&block!=KineConstruction.FIRED_MUDBRICK.getBase()){
							//System.out.println("Mud Brick Failed at "+pos);
							return false;
						}
					}
				}
			}
		}
		placeKiln(world, pos, facing);
		return true; 
	}

	private static void placeKiln(World world, BlockPos pos, EnumFacing facing) {
		world.setBlockState(pos, BasicMachines.KILN_FIRE.getDefaultState(), 3);
		if (world.isRemote) world.playSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.3f, 1f, true);
		BlockPos chamberpos = DirectionUtils.getPos(pos.up(), facing);
		world.setBlockState(chamberpos, BasicMachines.KILN_CHAMBER.getDefaultState().withProperty(BlockKilnChamber.facing, facing), 3);
		if (world.isRemote) world.playSound(chamberpos.getX(), chamberpos.getY()+1, chamberpos.getZ(), SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 0.3f, 1f, true);
		for (int i = -1; i<2; i++) {
			for (int j = 0; j<3; j++) {
				for (int k = -1; k<2; k++) {
					BlockPos newpos = pos.east(i).up(j).south(k);
					if(world.getBlockState(newpos)==KineConstruction.MUDBRICK.getBase().getDefaultState()) {
						world.setBlockState(newpos, KineConstruction.FIRED_MUDBRICK.getBase().getDefaultState(), 3);
						if (world.isRemote) world.playSound(newpos.getX(), newpos.getY(), newpos.getZ(), SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 0.3f, 1f, true);
					}
				}
			}
		}
		//System.out.println("Placed kiln at "+basePos);
	}

}

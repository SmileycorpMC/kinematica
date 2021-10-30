package net.smileycorp.kinematica.core.common.world.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class BlockBauxiteSoil extends BlockBase {
	
	public BlockBauxiteSoil() {
		this("Bauxite_Soil", Material.CLAY, SoundType.GROUND);
	}
	
	public BlockBauxiteSoil(String name, Material mat, SoundType sound) {
		super(name, ModDefinitions.modid, mat, sound, 0.5f, 1f,  "shovel", 0, KineTabs.BLOCKS);
	}
	
	@Override
	public boolean canSustainPlant(IBlockState state, IBlockAccess world, BlockPos pos, EnumFacing direction, IPlantable plantable)	{
        EnumPlantType plantType = plantable.getPlantType(world, pos.offset(direction));
        switch (plantType) {
            case Plains: return true;
            case Water:  return true;
            case Beach:
                return (world.getBlockState(pos.east()).getMaterial() == Material.WATER ||
                                    world.getBlockState(pos.west()).getMaterial() == Material.WATER ||
                                    world.getBlockState(pos.north()).getMaterial() == Material.WATER ||
                                    world.getBlockState(pos.south()).getMaterial() == Material.WATER);
			default:
				break;
        }

        return false;
    }
}

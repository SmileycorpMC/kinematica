package net.smileycorp.kinematica.core.common.world.blocks;

import javax.annotation.Nullable;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class BlockMud extends BlockBase {
	
	public BlockMud() {
		this("Mud", Material.CLAY, SoundType.GROUND);
	}
	
	public BlockMud(String name, Material mat, SoundType sound) {
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
	
	//copied from BlockSoulSand
	
	static final AxisAlignedBB MUD_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.875D, 1.0D);
	
	@Override
	@Nullable
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return MUD_AABB;
    }

    /**
     * Called When an Entity Collided with the Block
     */
    @Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
    {
        entityIn.motionX *= 0.4D;
        entityIn.motionZ *= 0.4D;
    }

}

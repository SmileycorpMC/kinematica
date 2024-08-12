package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.Random;

public class WorldGenPolarite extends WorldGenOre {
 
	private final IBlockState polarite = KineWorld.POLARITE.getDefaultState();
	private final IBlockState osmian = KineWorld.OSMIAN.getDefaultState();
    
    public WorldGenPolarite() {
        super(7, Blocks.STONE.getDefaultState());
    }
    
    @Override
    protected IBlockState getState(World world, Random rand, BlockPos pos) {
        return rand.nextInt(7) == 0 ? osmian : polarite;
    }
    
}

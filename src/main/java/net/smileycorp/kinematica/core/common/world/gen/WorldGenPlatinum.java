package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.Random;

public class WorldGenPlatinum extends WorldGenOre {
 
	private final IBlockState braggite = KineWorld.BRAGGITE.getDefaultState();
	private final IBlockState cooperite = KineWorld.COOPERITE.getDefaultState();
	private final IBlockState vysotskite = KineWorld.VYSOTSKITE.getDefaultState();
    
    public WorldGenPlatinum() {
        super(7, Blocks.STONE.getDefaultState());
    }
    
    @Override
    protected IBlockState getState(World world, Random rand, BlockPos pos) {
        int randint = rand.nextInt(7);
        if(randint == 0) return vysotskite;
        else if(randint <4) return braggite;
        return cooperite;
    }
    
}

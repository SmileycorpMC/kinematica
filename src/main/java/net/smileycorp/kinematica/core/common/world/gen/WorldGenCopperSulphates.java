package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.Random;

public class WorldGenCopperSulphates extends WorldGenOre {
	
	private final IBlockState bornite = KineWorld.BORNITE.getDefaultState();
	private final IBlockState chalcocite = KineWorld.CHALCOCITE.getDefaultState();
	private final IBlockState covellite = KineWorld.COVELLITE.getDefaultState();
	private final IBlockState chalcopyrite = KineWorld.CHALCOPYRITE.getDefaultState();
    
    public WorldGenCopperSulphates() {
        super(11, Blocks.STONE.getDefaultState());
    }
    
    @Override
    protected IBlockState getState(World world, Random rand, BlockPos pos) {
        int r = rand.nextInt(12);
        if(r == 0) return chalcocite;
        else if(r < 4) return covellite;
        else if(r < 7) return bornite;
        return chalcopyrite;
    }
    
}

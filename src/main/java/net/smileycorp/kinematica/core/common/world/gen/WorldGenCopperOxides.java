package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.Random;

public class WorldGenCopperOxides extends WorldGenOre {
	
	private final IBlockState azurite = KineWorld.AZURITE.getDefaultState();
	private final IBlockState cuprite = KineWorld.CUPRITE.getDefaultState();
	private final IBlockState dioptase = KineWorld.DIOPTASE.getDefaultState();
	private final IBlockState malachite = KineWorld.MALACHITE.getDefaultState();
    
    public WorldGenCopperOxides() {
        super(9, Blocks.STONE.getDefaultState());
    }
    
    @Override
    protected IBlockState getState(World world, Random rand, BlockPos pos) {
        int r = rand.nextInt(12);
        if(r == 0) return cuprite;
        else if(r < 4) return dioptase;
        else if(r < 7) return azurite;
        return malachite;
    }
}

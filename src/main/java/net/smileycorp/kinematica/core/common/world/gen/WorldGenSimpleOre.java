package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class WorldGenSimpleOre extends WorldGenOre {
    
    private final IBlockState state;
    
    public WorldGenSimpleOre(int num, IBlockState state) {
        this(num, state, Blocks.STONE.getDefaultState());
    }
    
    public WorldGenSimpleOre(int num, IBlockState state, IBlockState base) {
        super(num, base);
        this.state = state;
    }
    
    @Override
    protected IBlockState getState(World world, Random rand, BlockPos pos) {
        return state;
    }
    
}

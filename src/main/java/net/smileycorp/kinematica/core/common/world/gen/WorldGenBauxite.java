package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.Random;

public class WorldGenBauxite extends WorldGenOre {
 
	private final IBlockState blockBauxite = KineWorld.BAUXITE.getDefaultState();
	private final IBlockState blockIlmenite = KineWorld.ILMENITE.getDefaultState();
    
    public WorldGenBauxite() {
        super(8, Blocks.STONE.getDefaultState());
    }
    
    @Override
    protected IBlockState getState(World world, Random rand, BlockPos pos) {
        return rand.nextInt(7) == 0 ? blockIlmenite : blockBauxite;
    }
    
}

package net.smileycorp.kinematica.core.common.world.gen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.smileycorp.atlas.api.world.WorldGenOreIn;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKineOre;

public class WorldGenKineOre extends WorldGenOreIn {
	
	protected final List<Block> replace;
	
	public WorldGenKineOre(Block block, int blockCount, List<Block> replace) {
        super(block, blockCount, replace.get(0));
        this.replace = replace;
    }
    
    @Override
	protected void tryGenerate(World world, Random rand, BlockPos pos) {
		 IBlockState state = world.getBlockState(pos);
		 Block block = state.getBlock();
         if (this.replace.contains(block)) {
        	 String background  = block.getRegistryName().toString();
        	 int meta = block.getMetaFromState(state);
        	 if (meta!=0) background += ":" + meta;
             world.setBlockState(pos, this.oreBlock, 18);
             TileEntity te = world.getTileEntity(pos);
             if (te instanceof TileEntityKineOre) {
            	 ((TileEntityKineOre) te).setBackgroundBlock(background);
             }
         }
	}
}

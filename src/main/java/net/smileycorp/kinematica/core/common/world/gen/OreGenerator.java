package net.smileycorp.kinematica.core.common.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		ChunkGeneratorSettings chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(world.getWorldInfo().getGeneratorOptions()).build();
		switch(world.provider.getDimension()) {
		case -1:
			
			break;
		default:
			
			break;
		}

	}

	private void genOre(Block block, int amount,  int chance, int minHeight, int maxHeight, Block replace, World world, Random rand, int chunkX, int chunkZ){
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		WorldGenMinable generator = new WorldGenMinable(block.getDefaultState(), amount, (BlockMatcher.forBlock(replace)));
		int heightdiff = maxHeight - minHeight +1;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
}

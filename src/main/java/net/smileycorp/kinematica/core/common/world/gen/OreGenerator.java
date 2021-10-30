package net.smileycorp.kinematica.core.common.world.gen;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.smileycorp.kinematica.core.common.world.KineWorld;
import net.smileycorp.kinematica.core.common.world.OresHandler;

public class OreGenerator implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
			IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		//ChunkGeneratorSettings chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(world.getWorldInfo().getGeneratorOptions()).build();
		switch(world.provider.getDimension()) {
		case -1:
			genOre(KineWorld.NETHER_GOLD_ORE, 5, 7, 0, 120, OresHandler.netherBlocks, world, rand, chunkX, chunkZ);
			genOre(KineWorld.NETHER_SULPHUR_ORE, 8, 12, 0, 120, OresHandler.netherBlocks, world, rand, chunkX, chunkZ);
			break;
		default:
			genOre(KineWorld.TIN_ORE, 8, 6, 20, 50, world, rand, chunkX, chunkZ);
			genOre(KineWorld.COPPER_ORE, 8, 7, 32, 62, world, rand, chunkX, chunkZ);
			genOre(KineWorld.LEAD_ORE, 5, 6, 16, 50, world, rand, chunkX, chunkZ);
			genOre(KineWorld.SILVER_ORE, 6, 5, 14, 45, world, rand, chunkX, chunkZ);
			genOre(KineWorld.COBALT_ORE, 8, 3, 35, 65, world, rand, chunkX, chunkZ);
			genOre(KineWorld.NICKEL_ORE, 8, 4, 25, 46, world, rand, chunkX, chunkZ);
			genOre(KineWorld.CHROMIUM_ORE, 6, 5, 6, 32, world, rand, chunkX, chunkZ);
			genOre(KineWorld.ZINC_ORE, 7, 5, 35, 75, world, rand, chunkX, chunkZ);
			genOre(KineWorld.MANGANESE_ORE, 3, 4, 40, 60, world, rand, chunkX, chunkZ);
			break;
		}

	}

	private void genOre(Block block, int amount, int chance, int minHeight, int maxHeight, World world, Random rand, int chunkX, int chunkZ){
		genOre(block, amount, chance, minHeight, maxHeight, OresHandler.stoneBlocks, world, rand, chunkX, chunkZ);
	}
	
	private void genOre(Block block, int amount,  int chance, int minHeight, int maxHeight, List<Block> replace, World world, Random rand, int chunkX, int chunkZ){
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		WorldGenKineOre generator = new WorldGenKineOre(block, amount, replace);
		int heightdiff = maxHeight - minHeight +1;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
}

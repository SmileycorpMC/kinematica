package net.smileycorp.kinematica.core.common.world.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import net.smileycorp.kinematica.core.common.world.KineWorld;
import net.smileycorp.kinematica.core.integration.ModIntegration;

public class StoneGenerator implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		mudGen(world, rand, chunkX, chunkZ);
		bauxiteSoilGen(world, rand, chunkX, chunkZ);
		if (ModIntegration.ubInstalled) {
			
		} else {
			limeGen(world, rand, chunkX, chunkZ);
			generateStone(KineWorld.DOLOMITE, 24, 12, 45, 105, world, rand, chunkZ, chunkZ);
		}
	}
	
	private void generateStone(Block block, int amount,  int chance, int minHeight, int maxHeight, World world, Random rand, int chunkX, int chunkZ){
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		WorldGenMinable generator = new WorldGenMinable(block.getDefaultState(), amount, (BlockMatcher.forBlock(Blocks.STONE)));
		int heightdiff = maxHeight - minHeight +1;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunkZ * 16 + rand.nextInt(16);

			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void mudGen(World world, Random rand, int chunkX, int chunkZ){
		
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)) {
			int chance = 35;
			WorldGenSoil generator = new WorldGenSoil(KineWorld.MUD, KineWorld.BOG_GRASS);
			for (int i=0; i<chance; i++){
				int x = chunkX * 16 +rand.nextInt(16);
				int y = 55 + rand.nextInt(20);
				int z = chunkZ * 16 + rand.nextInt(16);
				BlockPos pos = new BlockPos(x, y, z);
				generator.generate(world, rand, pos);
			}
		} else {
			int chance = 45;
			WorldGenMud generator = new WorldGenMud();
			for (int i=0; i<chance; i++){
				int x = chunkX * 16 +rand.nextInt(16);
				int y = 55 + rand.nextInt(40);
				int z = chunkZ * 16 + rand.nextInt(16);
				BlockPos pos = new BlockPos(x, y, z);
				generator.generate(world, rand, pos);
			}
		}
	}
	
	private void bauxiteSoilGen(World world, Random rand, int chunkX, int chunkZ){
		
		int chance = 45;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) {
			WorldGenSoil generator = new WorldGenSoil(KineWorld.BAUXITE_SOIL, KineWorld.BAUXITE_GRASS);
			for (int i=0; i<chance; i++){
				int x = chunkX * 16 +rand.nextInt(16);
				int y = 60 + rand.nextInt(40);
				int z = chunkZ * 16 + rand.nextInt(16);
				BlockPos pos = new BlockPos(x, y, z);
				generator.generate(world, rand, pos);
			}
		}
	}

	private void limeGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenLimestone generator = new WorldGenLimestone();
		int chance = 3;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 45 + rand.nextInt(25);
			int z = chunkZ * 16 + rand.nextInt(16);
			BlockPos pos = new BlockPos(x, y, z);
			generator.generate(world, rand, pos);
		}
	}

}


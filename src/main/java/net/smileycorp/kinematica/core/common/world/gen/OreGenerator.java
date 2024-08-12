package net.smileycorp.kinematica.core.common.world.gen;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

import static net.smileycorp.kinematica.core.common.world.KineWorld.*;

public class OreGenerator implements IWorldGenerator {
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world,
						 IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		ChunkGeneratorSettings chunkProviderSettings = ChunkGeneratorSettings.Factory.jsonToFactory(world.getWorldInfo().getGeneratorOptions()).build();
		switch(world.provider.getDimension()) {
			case -1:
				genOre(IGNISITE, 8, 12, 0, 120, Blocks.NETHERRACK, world, rand, chunkX, chunkZ);
				genOre(AURAGMUS, 5, 7, 0, 120, Blocks.NETHERRACK, world, rand, chunkX, chunkZ);
				genOre(MYAGMINITE, 4, 5, 0, 120, Blocks.NETHERRACK, world, rand, chunkX, chunkZ);
				break;
			default:
				genOre(ACANTHITE, 6, 5, 30, 60, Blocks.STONE, world, rand, chunkX, chunkZ);
				bauxiteGen(world, rand, chunkX, chunkZ);
				genOre(BISMUTHINITE, 8, 7, 5, 45, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(CARROLLITE, 8, 4, 35, 65, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(CASSITERITE, 8, 7, 20, 50, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(CHROMITE, 6, 5, 6, 32, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(CINNABAR, 6, 5, 12, 45, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(CUPRITE, 3, 7, 8, 65, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(ERYTHRITE, 5, 4, 25, 45, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(GALENA, 5, 6, 30, 55, Blocks.STONE, world, rand, chunkX, chunkZ);
				limoniteGen(world, rand, chunkX, chunkZ);
				genOre(MALDONITE, chunkProviderSettings.goldSize, chunkProviderSettings.goldCount, chunkProviderSettings.goldMinHeight, chunkProviderSettings.goldMaxHeight, Blocks.STONE, world, rand, chunkX, chunkZ);
				genOre(NICKELINE, 8, 4, 33, 46, Blocks.STONE, world, rand, chunkX, chunkZ);
				polariteGen(world, rand, chunkX, chunkZ);
				sphaleriteGen(world, rand, chunkX, chunkZ);
				tealliteGen(world, rand, chunkX, chunkZ);
				copperOxideGen(world, rand, chunkX, chunkZ);
				copperSulphateGen(world, rand, chunkX, chunkZ);
				platinumGen(world, rand, chunkX, chunkZ);
				groutiteGen(world, rand, chunkX, chunkZ);
				hematiteGen(world, rand, chunkX, chunkZ);
				rhodoniteGen(world, rand, chunkX, chunkZ);
				
				//surface ores
				goethiteGen(world, rand, chunkX, chunkZ);
				magnetiteGen(world, rand, chunkX, chunkZ);
				pyrolusiteGen(world, rand, chunkX, chunkZ);
				
				//pegmatite ores
				genOre(CORUNDUM, 8, 24, 0, 58, PEGMATITE, world, rand, chunkX, chunkZ);
				genOre(RUTILE, 6, 12, 0, 25, PEGMATITE, world, rand, chunkX, chunkZ);
				wolframiteGen(world, rand, chunkX, chunkZ);
				
				break;
		}
		
	}
	
	private void genOre(Block block, int amount,  int chance, int minHeight, int maxHeight, Block replace, World world, Random rand, int chunkX, int chunkZ){
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");
		
		WorldGenSimpleOre generator = new WorldGenSimpleOre(amount, block.getDefaultState(), replace.getDefaultState());
		int heightdiff = maxHeight - minHeight +1;
		for (int i = 0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightdiff);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void bauxiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenBauxite generator = new WorldGenBauxite();
		int chance = 4;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) chance=10;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 30 + rand.nextInt(25);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void limoniteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(8, LIMONITE.getDefaultState(), Blocks.STONE.getDefaultState());
		int chance = 3;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP)) chance=chance*3;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 45 + rand.nextInt(30);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void polariteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenPolarite generator = new WorldGenPolarite();
		int chance = 3;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN)) chance=chance*2;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 45 + rand.nextInt(40);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void sphaleriteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(7, SPHALERITE.getDefaultState(), Blocks.STONE.getDefaultState());
		int chance = 5;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.MOUNTAIN)) chance=chance*2;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 35 + rand.nextInt(55);
			int z = chunkZ * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void tealliteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(7, TEALLITE.getDefaultState(), Blocks.STONE.getDefaultState());
		int chance = 4;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA)) chance=chance*2;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 28 + rand.nextInt(36);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void wolframiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(7, WOLFRAMITE.getDefaultState(), PEGMATITE.getDefaultState());
		int chance = 15;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)) chance=chance*2;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 0 + rand.nextInt(58);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void copperOxideGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenCopperOxides generator = new WorldGenCopperOxides();
		int chance = 7;
		int variation = 24;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.HILLS))
		{chance=14; variation = 40;}
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 38 + rand.nextInt(variation);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void copperSulphateGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenCopperSulphates generator = new WorldGenCopperSulphates();
		int chance = 8;
		int variation = 30;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.DRY))
		{chance=14;}
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 5 + rand.nextInt(variation);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void platinumGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenPlatinum generator = new WorldGenPlatinum();
		int chance = 3;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.CONIFEROUS)) chance=chance*2;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 15 + rand.nextInt(40);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void groutiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(8, GROUTITE.getDefaultState(), Blocks.STONE.getDefaultState());
		int chance = 5;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)) chance=11;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 45 + rand.nextInt(25);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void hematiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(10, HEMATITE.getDefaultState(), Blocks.STONE.getDefaultState());
		int chance = 5;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)) chance=12;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 5 + rand.nextInt(45);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void rhodoniteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(8, RHODONITE.getDefaultState(), Blocks.STONE.getDefaultState());
		int chance = 3;
		Biome biome = world.getBiome(new BlockPos(chunkX*16, 0, chunkZ*16));
		if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.FOREST)) chance=7;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 20 + rand.nextInt(35);
			int z = chunkZ * 16 + rand.nextInt(16);
			
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}
	
	private void goethiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(3, GOETHITE.getDefaultState(), MUD.getDefaultState());
		int chance = 20;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 54 + rand.nextInt(9);
			int z = chunkZ * 16 + rand.nextInt(16);
			Biome biome= world.getBiome(new BlockPos(x,y,z));
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)){
				generator.generate(world, rand, new BlockPos(x, y, z));
			}
		}
	}
	
	private void magnetiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(5, MAGNETITE.getDefaultState(), Blocks.SAND.getDefaultState());
		int chance = 6;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 62 + rand.nextInt(11);
			int z = chunkZ * 16 + rand.nextInt(16);
			Biome biome= world.getBiome(new BlockPos(x,y,z));
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.BEACH) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)){
				generator.generate(world, rand, new BlockPos(x, y, z));
			}
		}
	}
	
	private void pyrolusiteGen(World world, Random rand, int chunkX, int chunkZ){
		WorldGenSimpleOre generator = new WorldGenSimpleOre(3, PYROLUSITE.getDefaultState(), MUD.getDefaultState());
		int chance = 14;
		for (int i=0; i<chance; i++){
			int x = chunkX * 16 +rand.nextInt(16);
			int y = 54 + rand.nextInt(9);
			int z = chunkZ * 16 + rand.nextInt(16);
			Biome biome= world.getBiome(new BlockPos(x,y,z));
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SWAMP) || BiomeDictionary.hasType(biome, BiomeDictionary.Type.OCEAN)){
				generator.generate(world, rand, new BlockPos(x, y, z));
			}
		}
	}
	
}

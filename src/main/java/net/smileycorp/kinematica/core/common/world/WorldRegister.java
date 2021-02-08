package net.smileycorp.kinematica.core.common.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.smileycorp.kinematica.core.common.world.gen.WorldGenSharinga;

public class WorldRegister {
	
	public static void registerGeneration() {
		GameRegistry.registerWorldGenerator(new StoneGenerator(), 0);
		GameRegistry.registerWorldGenerator(new OreGenerator(), 45);
	}
	
	@SuppressWarnings("deprecation")
	@SubscribeEvent
	public void biomeGenerationEvent(DecorateBiomeEvent.Decorate event) {
		World world = event.getWorld();
		Random rand = event.getRand();
		if (event.getType()==EventType.TREE) {
			int x = event.getPos().getX();
			int z = event.getPos().getZ();
			BlockPos pos = new BlockPos(x, world.getHeight(x, z), z);
			Biome biome = world.getBiome(pos);
			if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.JUNGLE)) {
				if (rand.nextInt(3)==0) {
					WorldGenerator tree = new WorldGenSharinga(true);
					tree.generate(world, rand, pos);
				}
			}
		}
	}
}

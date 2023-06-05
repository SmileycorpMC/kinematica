package net.smileycorp.kinematica.core.common.world;

public class WorldRegister {

	/*public static void registerGeneration() {
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
	}*/
}

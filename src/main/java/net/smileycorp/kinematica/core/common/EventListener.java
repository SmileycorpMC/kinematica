package net.smileycorp.kinematica.core.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.smileycorp.kinematica.core.common.machine.multiblock.Kiln;
import net.smileycorp.kinematica.core.common.world.gen.WorldGenSharinga;

public class EventListener {
	
	@SubscribeEvent
	public void blockPlaceEvent(BlockEvent.EntityPlaceEvent event) {
		//System.out.println("place");
		World world = event.getWorld();
		if (!world.isRemote) {
			BlockPos pos = event.getPos();
			Block block = event.getPlacedBlock().getBlock();
			Entity entity = event.getEntity();
			if (entity instanceof EntityPlayer) {
				if (block == Blocks.FIRE) {
					Kiln.tryToCreate(world, pos);
				}
			}
		}
	}
	
	@SuppressWarnings("deprecation")
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

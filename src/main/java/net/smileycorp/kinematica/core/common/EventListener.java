package net.smileycorp.kinematica.core.common;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.smileycorp.kinematica.core.common.machine.multiblock.Kiln;
import net.smileycorp.kinematica.core.common.recipes.WorldRecipes;

public class EventListener {
	
	@SubscribeEvent
	public void blockPlaceEvent(BlockEvent.EntityPlaceEvent event) {
		System.out.println("place");
		World world = event.getWorld();
		if (!world.isRemote) {
			BlockPos pos = event.getPos();
			Block block = event.getPlacedBlock().getBlock();
			if (block == Blocks.FIRE) {
				if (!Kiln.tryToCreate(world, pos)) {
					WorldRecipes.cookBricks(world, pos);
				}
			}
		}
	}
}

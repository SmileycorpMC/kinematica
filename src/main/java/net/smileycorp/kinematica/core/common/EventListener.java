package net.smileycorp.kinematica.core.common;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.smileycorp.kinematica.core.common.machine.multiblock.Kiln;

public class EventListener {
	
	protected static List<String> metals = new ArrayList<String>();
	
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
}

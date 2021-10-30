package net.smileycorp.kinematica.core.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import net.smileycorp.kinematica.core.common.machine.multiblock.Kiln;
import net.smileycorp.kinematica.core.common.recipes.WorldRecipes;
import net.smileycorp.kinematica.core.common.world.entity.EntityBlueWitherSkeleton;



@EventBusSubscriber(modid=ModDefinitions.modid)
public class EventListener {
	
	static Random rand = new Random();
	
	@SubscribeEvent
	public static void entitySpawn(LivingSpawnEvent.CheckSpawn event) {
		World world = event.getWorld();
		EntityLivingBase entity = event.getEntityLiving();
		if (entity.getClass() == EntityWitherSkeleton.class) {
			if (rand.nextInt(10)==0) {
				EntityBlueWitherSkeleton newentity = new EntityBlueWitherSkeleton(world);
				BlockPos pos = entity.getPosition();
				newentity.setPosition(pos.getX(), pos.getY(), pos.getZ());
				newentity.onInitialSpawn(world.getDifficultyForLocation(pos), null);
				world.spawnEntity(newentity);
				event.setResult(Result.DENY);
			}
		}
	}
	
	@SubscribeEvent
	public static void lightingStrike(EntityStruckByLightningEvent event) {
		World world = event.getLightning().world;
		if (event.getEntity().getClass() == EntityWitherSkeleton.class) {
			EntityWitherSkeleton entity = (EntityWitherSkeleton) event.getEntity();
			EntityBlueWitherSkeleton newentity = new EntityBlueWitherSkeleton(world);
			BlockPos pos = entity.getPosition();
			newentity.setPosition(pos.getX(), pos.getY(), pos.getZ());
			for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
				newentity.setItemStackToSlot(slot, entity.getItemStackFromSlot(slot));
			}
			newentity.renderYawOffset = entity.renderYawOffset;
			if (entity.hasCustomName()) newentity.setCustomNameTag(entity.getCustomNameTag());
			world.spawnEntity(newentity);
			entity.setDead();
		}
	}
	
	@SubscribeEvent
	public void blockPlaceEvent(BlockEvent.EntityPlaceEvent event) {
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

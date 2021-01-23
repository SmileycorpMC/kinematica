package net.smileycorp.kinematica.core.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;
import net.smileycorp.kinematica.core.common.materials.Materials;
import net.smileycorp.kinematica.core.common.recipes.CraftingMethods;
import net.smileycorp.kinematica.core.common.recipes.OreDictRegistry;
import net.smileycorp.kinematica.core.common.recipes.FurnaceRecipes;
import net.smileycorp.kinematica.core.common.world.blocks.WorldBlocks;

@EventBusSubscriber(modid = ModDefinitions.modid)
public class ContentRegistry {
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		Materials.registerItems(registry);
		WorldBlocks.registerItems(registry);
		MachineBlocks.registerItems(registry);
	}
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		Materials.registerBlocks(registry);
		WorldBlocks.registerBlocks(registry);
		MachineBlocks.registerBlocks(registry);
	}
	
	public static void registerRecipes() {
		OreDictRegistry.registerOreDicts();
		//OreDictRecipes.registerRecipes();
		CraftingMethods.registerRecipes();
		FurnaceRecipes.registerRecipes();
	}
}

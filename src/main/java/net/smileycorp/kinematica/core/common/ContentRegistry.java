package net.smileycorp.kinematica.core.common;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.machine.BasicMachines;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.recipes.CraftingMethods;
import net.smileycorp.kinematica.core.common.recipes.MachineRecipes;
import net.smileycorp.kinematica.core.common.recipes.OreDictRecipes;
import net.smileycorp.kinematica.core.common.recipes.OreDictRegistry;
import net.smileycorp.kinematica.core.common.recipes.SmeltingRecipes;
import net.smileycorp.kinematica.core.common.tools.Tools;
import net.smileycorp.kinematica.core.common.world.KineWorld;

@EventBusSubscriber(modid = ModDefinitions.modid)
public class ContentRegistry {
	@SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		KineConstruction.registerItems(registry);
		BasicMachines.registerItems(registry);
		KineMaterials.registerItems(registry);
		Tools.registerItems(registry);
		KineWorld.registerItems(registry);
	}
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		KineConstruction.registerBlocks(registry);
		KineMaterials.registerBlocks(registry);
		BasicMachines.registerBlocks(registry);
		KineWorld.registerBlocks(registry);
	}
	
	public static void registerRecipes() {
		OreDictRegistry.registerOreDicts();
		OreDictRecipes.registerRecipes();
		CraftingMethods.registerRecipes();
		SmeltingRecipes.registerRecipes();
		MachineRecipes.registerRecipes();
	}
}

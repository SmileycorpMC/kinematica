package net.smileycorp.kinematica.core.common;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.fluids.KineFluids;
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
		KineMaterials.registerItems(registry);
		Tools.registerItems(registry);
		KineWorld.registerItems(registry);
		KineConstruction.registerItems(registry);
		BasicMachines.registerItems(registry);
	}
	
	@SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
		IForgeRegistry<Block> registry = event.getRegistry();
		KineMaterials.registerBlocks(registry);
		KineWorld.registerBlocks(registry);
		KineConstruction.registerBlocks(registry);
		BasicMachines.registerBlocks(registry);
		KineFluids.registerBlocks(registry);
	}
	
	@SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
		IForgeRegistry<EntityEntry> registry = event.getRegistry();
		KineWorld.registerEntities(registry);
	}
	
	public static void registerRecipes() {
		OreDictRegistry.registerOreDicts();
		OreDictRecipes.registerRecipes();
		CraftingMethods.registerRecipes();
		SmeltingRecipes.registerRecipes();
		SmeltingRecipes.registerFuel();
		MachineRecipes.registerRecipes();
	}
	
	public static void registerLateRecipes() {
		MachineRecipes.registerLateRecipes();
	}
	
	@SubscribeEvent
	public static void recipeModifier(RegistryEvent.Register<IRecipe> event){
		//Gson gson = new Gson();
		IForgeRegistryModifiable<IRecipe> recipes = (IForgeRegistryModifiable<IRecipe>) event.getRegistry();
		RecipeModifier.modifyRecipes(recipes);
		Blocks.IRON_ORE.setHarvestLevel("pickaxe", 2);
	}
}

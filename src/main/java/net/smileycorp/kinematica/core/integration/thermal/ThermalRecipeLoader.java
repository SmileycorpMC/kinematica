package net.smileycorp.kinematica.core.integration.thermal;

import java.util.Map.Entry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreIngredient;
import net.smileycorp.atlas.api.recipe.OreIngredientReadable;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.api.recipes.KilnRecipes;
import cofh.core.util.helpers.ItemHelper;
import cofh.thermalexpansion.util.managers.machine.CompactorManager;
import cofh.thermalexpansion.util.managers.machine.CompactorManager.Mode;
import cofh.thermalexpansion.util.managers.machine.SmelterManager;

public class ThermalRecipeLoader {

	public static void loadRecipes() {
		for (Entry<Ingredient[], ItemStack> entry : KilnRecipes.getRecipeMap().entrySet()) {
			Ingredient[] inputs = entry.getKey();
			if (inputs.length>1) {
				if (inputs[0] instanceof OreIngredientReadable && inputs[1] instanceof OreIngredientReadable) {
					SmelterManager.addRecipe(3500, ItemHelper.getOre(((OreIngredientReadable) inputs[0]).getOreName()), ItemHelper.getOre(((OreIngredientReadable) inputs[1]).getOreName()), entry.getValue());
				} else if (inputs[0] instanceof OreIngredientReadable) {
					addOreCompaction(inputs[1], (OreIngredientReadable) inputs[0], entry.getValue());
				} else if (inputs[1] instanceof OreIngredient) {
					addOreCompaction(inputs[0], (OreIngredientReadable) inputs[1], entry.getValue());
				} else {
					for (ItemStack input0 : inputs[0].getMatchingStacks()) {
						for (ItemStack input1 : inputs[1].getMatchingStacks()) {
							SmelterManager.addRecipe(3500, input0, input1, entry.getValue());
						}
					}
				}
			}
		}
		
		for (String metal : MetalRegistry.getMetalsFor(MetalType.GEAR)) {
			CompactorManager.addRecipe(4000, ItemHelper.getOre("ingot"+metal.replace("_", ""), 4), MetalRegistry.getItemFor(metal, MetalType.GEAR), Mode.GEAR);
		}
		for (String metal : MetalRegistry.getMetalsFor(MetalType.PLATE)) {
			CompactorManager.addRecipe(4000, ItemHelper.getOre("ingot"+metal.replace("_", "")), MetalRegistry.getItemFor(metal, MetalType.PLATE), Mode.PLATE);
		}
		for (String metal : MetalRegistry.getMetalsFor(MetalType.COIN)) {
			CompactorManager.addRecipe(4000, ItemHelper.getOre("ingot"+metal.replace("_", "")), MetalRegistry.getItemFor(metal, MetalType.COIN, 3), Mode.COIN);
		}
	}
	
	private static void addOreCompaction(Ingredient input0, OreIngredientReadable input1, ItemStack output) {
		for (ItemStack stack : input0.getMatchingStacks()) {
			SmelterManager.addRecipe(3500, stack, ItemHelper.getOre(input1.getOreName()), output);
		}
	}

}

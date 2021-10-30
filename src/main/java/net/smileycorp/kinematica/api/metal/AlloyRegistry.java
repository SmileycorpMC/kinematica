package net.smileycorp.kinematica.api.metal;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.crafting.Ingredient;

import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalStack;

public class AlloyRegistry {
	private static List<AlloyRecipeEntry> alloys = new ArrayList<AlloyRecipeEntry>();
	
	public static void registerAlloy(MetalStack result, Ingredient catalyst, MetalStack... ingredients) {
		registerAlloy(result.getMetal().getName(), new AlloyRecipeEntry(result, catalyst, ingredients));
	}
	
	public static void registerAlloy(MetalStack result, MetalStack... ingredients) {
		registerAlloy(result.getMetal().getName(), new AlloyRecipeEntry(result, ingredients));
	}
	
	public static void registerAlloy(String result, AlloyRecipeEntry recipe) {
		alloys.add(recipe);
	}
	
	public static List<AlloyRecipeEntry> getRecipes() {
		return alloys;
	}

}

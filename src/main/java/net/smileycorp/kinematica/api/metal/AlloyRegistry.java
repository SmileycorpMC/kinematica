package net.smileycorp.kinematica.api.metal;

import java.util.Map;

import com.google.common.collect.Maps;

public class AlloyRegistry {
	private static Map<String, AlloyRecipeEntry> alloys = Maps.<String, AlloyRecipeEntry>newHashMap();
	
	public static void registerAlloy(String result, MetalStack... ingredients) {
		registerAlloy (result, new AlloyRecipeEntry(ingredients));
	}
	
	public static void registerAlloy(String result, AlloyRecipeEntry recipe) {
		alloys.put(result, recipe);
	}
	
	public AlloyRecipeEntry getRecipe(String alloy) {
		return alloys.get(alloy);
	}

}

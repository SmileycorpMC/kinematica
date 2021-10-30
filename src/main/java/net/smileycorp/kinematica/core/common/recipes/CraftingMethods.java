package net.smileycorp.kinematica.core.common.recipes;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreIngredient;

import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class CraftingMethods {
	
	static String block = "ingot_to_block";
	static String unblock = "block_to_ingot";
	static String nugget = "ingot_to_nugget";
	static String ingot = "nugget_to_ingot";

	public static void registerRecipes() {
		System.out.println("Attempting to create MetalAPI recipes");
		System.out.println(MetalRegistry.getMetalsFor(MetalType.INGOT));
		for (String metal : MetalRegistry.getMetalsFor(MetalType.INGOT)) {
			System.out.println("Attempting to create recipies for MetalAPI registry " + metal);
			metal.replace("_", "");
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+block), ModDefinitions.getResource(block), MetalRegistry.getItemFor(metal, MetalType.BLOCK), 
					new Object[]{"###", "###", "###", '#', new OreIngredient("ingot"+metal)});
			
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+unblock), ModDefinitions.getResource(unblock), MetalRegistry.getItemFor(metal, MetalType.INGOT, 9), 
					new Object[]{"#", '#', new OreIngredient("block"+metal)});
			
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+ingot), ModDefinitions.getResource(ingot), MetalRegistry.getItemFor(metal, MetalType.INGOT), 
					new Object[]{"###", "###", "###", '#', new OreIngredient("nugget"+metal)});
			
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+nugget), ModDefinitions.getResource(nugget), MetalRegistry.getItemFor(metal, MetalType.NUGGET, 9), 
					new Object[]{"#", '#', new OreIngredient("ingot"+metal)});
		}
	}

}

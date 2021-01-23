package net.smileycorp.kinematica.core.common.recipes;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class CraftingMethods {

	public static void registerRecipes() {
		String block = "ingot_to_block";
		String unblock = "block_to_ingot";
		String nugget = "ingot_to_nugget";
		String ingot = "nugget_to_ingot";
		
		for (String metal : MetalRegistry.getMetalsFor(MetalType.INGOT)) {
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+block), ModDefinitions.getResource(block), MetalRegistry.getItemFor(metal, MetalType.BLOCK), 
					new Object[]{"###", "###", "###", '#', MetalRegistry.getItemFor(metal, MetalType.INGOT)});
			
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+unblock), ModDefinitions.getResource(unblock), MetalRegistry.getItemFor(metal, MetalType.INGOT, 9), 
					new Object[]{"#", '#', MetalRegistry.getItemFor(metal, MetalType.BLOCK)});
			
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+ingot), ModDefinitions.getResource(ingot), MetalRegistry.getItemFor(metal, MetalType.INGOT), 
					new Object[]{"###", "###", "###", '#', MetalRegistry.getItemFor(metal, MetalType.NUGGET)});
			
			GameRegistry.addShapedRecipe(ModDefinitions.getResource(metal+"_"+nugget), ModDefinitions.getResource(nugget), MetalRegistry.getItemFor(metal, MetalType.NUGGET, 9), 
					new Object[]{"#", '#', MetalRegistry.getItemFor(metal, MetalType.INGOT)});
		}
	}

}

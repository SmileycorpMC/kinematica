package net.smileycorp.kinematica.core.common.recipes;

import java.util.Map.Entry;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

public class MachineRecipes {
	
	public static void registerRecipes() {
		for (Entry<ItemStack, ItemStack> recipe : FurnaceRecipes.instance().getSmeltingList().entrySet()) {
			//KilnRecipes.addRecipe(Ingredient.fromStacks(recipe.getKey()), ItemStack.EMPTY, recipe.getValue());		
		}
	}
}

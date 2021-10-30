package net.smileycorp.kinematica.core.integration.jei.kiln;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

public class KilnRecipeWrapper implements IRecipeWrapper {
	
	private final Ingredient[] inputs;
	private final ItemStack output;
	
	public KilnRecipeWrapper(IJeiHelpers jeiHelpers, Ingredient[] inputs, ItemStack output) {
		this.inputs=inputs;
		this.output=output;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void getIngredients(IIngredients ingredients) {
		List<List<ItemStack>> inputs = new ArrayList<List<ItemStack>>();
		for (Ingredient input : this.inputs) {
			inputs.add(Arrays.asList(input.getMatchingStacks()));
		}
		ingredients.setInputLists(ItemStack.class, inputs);
		ingredients.setOutput(ItemStack.class, output);
	}

}

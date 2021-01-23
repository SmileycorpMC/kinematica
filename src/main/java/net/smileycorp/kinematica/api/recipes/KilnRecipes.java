package net.smileycorp.kinematica.api.recipes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.smileycorp.atlas.api.util.RecipeUtils;

import com.google.common.collect.Maps;

public class KilnRecipes {

	public static KilnRecipes instance() {
		return new KilnRecipes();
	}
	
	private static final Map<Ingredient[], ItemStack> results = Maps.<Ingredient[], ItemStack>newHashMap();
	
	public Map<Ingredient[], ItemStack> getRecipeMap() {
		return results;
	}
	
	public void addRecipe(Ingredient input1, Ingredient input2, ItemStack output) {
		results.put(new Ingredient[] {input1, input2}, output);
	}
	
	public boolean canSmelt(ItemStack slot0, ItemStack slot1) {
		return !getSmeltingOutput(slot0, slot1).isEmpty();
	}
	
	public ItemStack getSmeltingOutput(ItemStack slot0, ItemStack slot1) {
		ItemStack result = ItemStack.EMPTY;
		Set<Entry<Ingredient[], ItemStack>> entries = results.entrySet();
		for (Entry<Ingredient[], ItemStack> entry : entries) {
			Ingredient[] ingredients = entry.getKey();
			int check = 0;
			for (Ingredient ingredient : ingredients) {
				ItemStack[] stacks = ingredient.getMatchingStacks();
				for (ItemStack stack : stacks) {
					if (RecipeUtils.compareItemStacks(slot0, stack)
							||RecipeUtils.compareItemStacks(slot1, stack)) {
						check++;
						break;
					}
				}
			}
			if (check==2) {
				result = entry.getValue();
			}
		}
		return result;
	}
}

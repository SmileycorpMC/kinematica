package net.smileycorp.kinematica.api.recipes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.smileycorp.atlas.api.util.RecipeUtils;

import com.google.common.collect.Maps;

public class KilnRecipes {
	
	private static final Map<Ingredient[], ItemStack> results = Maps.<Ingredient[], ItemStack>newHashMap();
	private static final Map<ItemStack, ItemStack> returnItem = Maps.<ItemStack, ItemStack>newHashMap();
	
	public static Map<Ingredient[], ItemStack> getRecipeMap() {
		return results;
	}
	
	public static void addRecipe(ItemStack slot0, ItemStack slot1, ItemStack output) {
		addRecipe(Ingredient.fromStacks(slot0), Ingredient.fromStacks(slot1), output);
	}
	
	public static void addRecipe(Ingredient slot0, ItemStack slot1, ItemStack output) {
		addRecipe(slot0, Ingredient.fromStacks(slot1), output);
	}
	
	public static void addRecipe(ItemStack slot0, Ingredient slot1, ItemStack output) {
		addRecipe(Ingredient.fromStacks(slot0), slot1, output);
	}
	
	public static void addRecipe(Ingredient input1, Ingredient input2, ItemStack output) {
		results.put(new Ingredient[] {input1, input2}, output);
	}
	
	public static void setReturnItem(ItemStack input, ItemStack returnitem) {
		input.setCount(1);
		returnitem.setCount(1);
		returnItem.put(input, returnitem);
	}
	
	public static boolean canSmelt(ItemStack slot0, ItemStack slot1) {
		return !getSmeltingOutput(slot0, slot1).isEmpty();
	}
	
	public static ItemStack getSmeltingOutput(ItemStack slot0, ItemStack slot1) {
		ItemStack result = ItemStack.EMPTY;
		Set<Entry<Ingredient[], ItemStack>> entries = results.entrySet();
		for (Entry<Ingredient[], ItemStack> entry : entries) {
			Ingredient[] ingredients = entry.getKey();
			int check = 0;
			for (Ingredient ingredient : ingredients) {
				ItemStack[] stacks = ingredient.getMatchingStacks();
				for (ItemStack stack : stacks) {
					if (RecipeUtils.compareItemStacks(slot0, stack, true)
							||RecipeUtils.compareItemStacks(slot1, stack, true)) {
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
	
	public static ItemStack getReturnItem(ItemStack stack){
		if (stack.getCount()==1) {
			if (stack.getItem().hasContainerItem(stack)) {
				return stack.getItem().getContainerItem(stack);
			}
			for (Entry<ItemStack, ItemStack> entry:returnItem.entrySet()) {
				if (RecipeUtils.compareItemStacks(stack, entry.getKey(), true)){
					return entry.getValue().copy();
				}
			}
		}
		return null;
	}
}

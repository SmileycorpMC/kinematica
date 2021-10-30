package net.smileycorp.kinematica.api.recipes;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.oredict.OreIngredient;
import net.smileycorp.atlas.api.recipe.OreIngredientReadable;
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
		Ingredient[] inputs;
		if (input1 instanceof OreIngredient) input1 = OreIngredientReadable.from((OreIngredient) input1);
		if (input2 instanceof OreIngredient) input2 = OreIngredientReadable.from((OreIngredient) input2);
		if (input2 == null||input2.test(ItemStack.EMPTY)) {
			inputs = new Ingredient[]{input1};
		} else {
			inputs = new Ingredient[]{input1, input2};
		}
		if (!recipeExists(inputs)) results.put(inputs, output);
	}
	
	public static boolean recipeExists(Ingredient[] inputs) {
		for (Ingredient[] ingredients : results.keySet()) {
			if (inputs.length==ingredients.length) {
				if (inputs.length==1) {
					if (inputs[0].equals(ingredients[0])) return true;
				} else if ((inputs[0].equals(ingredients[0])&&inputs[1].equals(ingredients[1]))
						||inputs[0].equals(ingredients[1])&&inputs[1].equals(ingredients[0])) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void setReturnItem(ItemStack input, ItemStack returnitem) {
		input.setCount(1);
		returnitem.setCount(1);
		returnItem.put(input, returnitem);
	}
	
	public static ItemStack getSmeltingOutput(ItemStack slot0, ItemStack slot1) {
		Set<Entry<Ingredient[], ItemStack>> entries = results.entrySet();
		for (Entry<Ingredient[], ItemStack> entry : entries) {
			Ingredient[] ingredients = entry.getKey();
			int check = 0;
			boolean areStacksEqual = RecipeUtils.compareItemStacks(slot0, slot1, true);
			if (ingredients.length==1 && (slot0.isEmpty() || slot1.isEmpty() || areStacksEqual)) {
					for (ItemStack stack : ingredients[0].getMatchingStacks()) {
						if (areStacksEqual && RecipeUtils.compareItemStacks(slot0, stack, true)) {
							ItemStack output = entry.getValue().copy();
							output.setCount(output.getCount()*2);
							return output;
						} else if (RecipeUtils.compareItemStacks(slot0, stack, true)||RecipeUtils.compareItemStacks(slot1, stack, true)) return entry.getValue();
					}
			}
			else{
				for (Ingredient ingredient : ingredients) {
					if (ingredient.apply(slot0)||ingredient.apply(slot1)) {
						check++;
					}
				}
				if (check>=2) {
					return entry.getValue().copy();
				}
			}
		}
		return ItemStack.EMPTY;
	}
	
	public static boolean canSmelt(ItemStack slot0, ItemStack slot1, ItemStack output) {
		ItemStack result = getSmeltingOutput(slot0, slot1);
		return result.isEmpty() ? false : RecipeUtils.compareItemStacksCanFit(result, output);
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

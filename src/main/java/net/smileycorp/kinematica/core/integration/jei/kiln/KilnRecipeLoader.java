package net.smileycorp.kinematica.core.integration.jei.kiln;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import mezz.jei.api.IJeiHelpers;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.smileycorp.kinematica.api.recipes.KilnRecipes;

public class KilnRecipeLoader {
	@SuppressWarnings("unchecked")
	public static List<KilnRecipeWrapper> getRecipes(IJeiHelpers jeiHelpers) {
		List<KilnRecipeWrapper> recipes = new ArrayList<KilnRecipeWrapper> ();
		Map<Ingredient[], ItemStack> kilnMap = KilnRecipes.getRecipeMap();
		Set<Entry<Ingredient[], ItemStack>> set = kilnMap.entrySet();
		Iterator<?> iterator = set.iterator();
		while(iterator.hasNext()) {
			Map.Entry<Ingredient[], ItemStack> entry = (Map.Entry<Ingredient[], ItemStack>)iterator.next();
			Ingredient[] inputs = entry.getKey().clone();
			ItemStack output = entry.getValue().copy();
			recipes.add(new KilnRecipeWrapper(jeiHelpers, inputs, output));
		}
		return recipes;
	}

}

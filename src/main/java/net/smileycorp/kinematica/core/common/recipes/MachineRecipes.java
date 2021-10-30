package net.smileycorp.kinematica.core.common.recipes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import net.minecraft.init.Items;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;

import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;

import net.smileycorp.kinematica.api.recipes.KilnRecipes;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;

public class MachineRecipes {
	
	public static void registerRecipes() {
		KilnRecipes.addRecipe(new ItemStack(Items.CHORUS_FRUIT), ItemStack.EMPTY, new ItemStack(Items.CHORUS_FRUIT_POPPED));
		KilnRecipes.addRecipe(new ItemStack(KineConstruction.DUSTS, 1, 4), new ItemStack(Items.CLAY_BALL), new ItemStack(KineConstruction.DUSTS, 1, 5));
		KilnRecipes.addRecipe(new OreIngredient("dustDolomite"), new OreIngredient("dustAluminium"), new ItemStack(KineConstruction.MATERIALS, 1, 0));
	}
	
	public static void registerLateRecipes() {
		List<ItemStack> toRemove = new ArrayList<ItemStack>();
		main:for (Entry<ItemStack, ItemStack> recipe : FurnaceRecipes.instance().getSmeltingList().entrySet()) {
			ItemStack input = recipe.getKey();
			ItemStack output = recipe.getValue();
			for (int i : OreDictionary.getOreIDs(output)) {
				if (OreDictionary.getOreName(i).startsWith("ingot")) {
					toRemove.add(input);
					continue main;
				}
			}
			if (!(input.getItem() instanceof ItemFood)&&!(output.getItem() instanceof ItemFood)) {
				KilnRecipes.addRecipe(input, ItemStack.EMPTY, output);
			}
		}
		for (ItemStack stack : toRemove) {
			FurnaceRecipes.instance().getSmeltingList().remove(stack);
		}
	}
}

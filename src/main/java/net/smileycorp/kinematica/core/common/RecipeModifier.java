package net.smileycorp.kinematica.core.common;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.registries.IForgeRegistryModifiable;

import net.smileycorp.atlas.api.util.RecipeUtils;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;

public class RecipeModifier {
	
	
	public static void modifyRecipes(IForgeRegistryModifiable<IRecipe> recipes) {
		for (IRecipe recipe : recipes) {
			if (hasCoal(recipe)) {
				/*IRecipe copy = gson.fromJson(gson.toJson(recipe), IRecipe.class);
				NonNullList<Ingredient> inputs = NonNullList.<Ingredient>create();
				for (Ingredient ingredient : recipe.getIngredients()) {
					if (ingredient.test(new ItemStack(Items.COAL, 1, 1))) inputs.add(Ingredient.fromStacks(new ItemStack(KineMaterials.MATERIALS, 1, 1)));
					else inputs.add(ingredient);
				}
				recipe.*/
			}
		}
		for (EnumDyeColor colour : EnumDyeColor.values()) {
			recipes.remove(new ResourceLocation("minecraft", colour.getName()+"_concrete_powder"));
			GameRegistry.addShapedRecipe(new ResourceLocation("minecraft", colour.getName()+"_concrete_powder"), new ResourceLocation("minecraft", "concrete_powder"), 
					new ItemStack(Blocks.CONCRETE_POWDER, 1, colour.getMetadata()), "CAC", "ADA", "CAC", 'C', 
					new ItemStack(KineConstruction.DUSTS, 1, 5), 'A', new ItemStack(KineConstruction.DUSTS), 'D', new ItemStack(Items.DYE, 1, colour.getDyeDamage()));
		}
		recipes.remove(new ResourceLocation("minecraft", "furnace"));
		
	}
	
	private static boolean hasCoal(IRecipe recipe) {
		for (Ingredient ingredient : recipe.getIngredients()) {
			if (ingredient.test(new ItemStack(Items.COAL, 1, 1))) return RecipeUtils.compareItemStacks(recipe.getRecipeOutput(), new ItemStack(Blocks.COAL_BLOCK), false);
		}
		return false;
	}
}

package net.smileycorp.kinematica.api.metal;

import net.minecraft.item.ItemStack;

class AlloyRecipeEntry {
	
	final ItemStack catalyst;
	final MetalStack[] ingredients;

	public AlloyRecipeEntry(MetalStack... ingredients) {
		this(null, ingredients);
	}

	public AlloyRecipeEntry(ItemStack catalyst, MetalStack... ingredients) {
		this.catalyst = catalyst;
		this.ingredients=ingredients;
	}

	public boolean hasCatalyst() {
		return catalyst!=null;
	}

	public ItemStack getCatalyst() {
		return catalyst;
	}

	public MetalStack[] getIngredients() {
		return ingredients;
	}
	
}
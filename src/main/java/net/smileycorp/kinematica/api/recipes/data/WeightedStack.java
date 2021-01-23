package net.smileycorp.kinematica.api.recipes.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public final class WeightedStack {
	private final ItemStack stack;
	private final int chance;

	/*
	 * block - the block to be used as a dropchance - the chance an item will
	 * show up, a higher chance being, more likely to show up
	 */
	public WeightedStack(Block block, int chance) {
		this(new ItemStack(block), chance);
	}

	/*
	 * item - the item to be used as a dropchance - the chance an item will show
	 * up, a higher chance being, more likely to show up
	 */
	public WeightedStack(Item item, int chance) {
		this(new ItemStack(item), chance);
	}

	/*
	 * stack - the ItemStack to be used as a dropchance - the chance an item
	 * will show up, a higher chance being, more likely to show up
	 */
	public WeightedStack(ItemStack stack, int chance) {
		this.stack = stack;
		this.chance = chance;
	}

	public ItemStack getStack() {
		return stack;
	}

	public int getWeight() {
		return chance;
	}
}

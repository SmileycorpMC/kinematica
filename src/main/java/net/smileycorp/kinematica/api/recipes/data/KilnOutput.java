package net.smileycorp.kinematica.api.recipes.data;

import net.minecraft.item.ItemStack;

public class KilnOutput {
	
	private final ItemStack stack;
	private final int decr0;
	private final int decr1;
	
	public KilnOutput(ItemStack stack, int decr0, int decr1) {
		this.stack=stack;
		this.decr0=decr0;
		this.decr1=decr1;
	}
	
	public ItemStack getStack() {
		return stack.copy();
	}
	
	public void deacrease(ItemStack stack0, ItemStack stack1) {
		stack0.shrink(decr0);
		stack1.shrink(decr1);
	}
	
	@Override
	public String toString() {
		return "KilnOutput(" + stack + ", {" + decr0 + ", " + decr1 + "})";
    }
}

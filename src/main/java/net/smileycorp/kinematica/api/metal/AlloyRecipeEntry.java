package net.smileycorp.kinematica.api.metal;

import net.minecraft.item.crafting.Ingredient;

import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalStack;

public class AlloyRecipeEntry {
	
	final Ingredient catalyst;
	final MetalStack output;
	final MetalStack[] inputs;

	public AlloyRecipeEntry(MetalStack output, MetalStack... inputs) {
		this(output, null, inputs);
	}

	public AlloyRecipeEntry(MetalStack output, Ingredient catalyst, MetalStack... inputs) {
		this.output = output;
		this.catalyst = catalyst;
		this.inputs = inputs;
	}
	
	public MetalStack getOutput() {
		return output;
	}

	public boolean hasCatalyst() {
		return catalyst!=null;
	}

	public Ingredient getCatalyst() {
		return catalyst;
	}

	public MetalStack[] getInputs() {
		return inputs;
	}
	
}
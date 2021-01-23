package net.smileycorp.kinematica.api.metal;

import java.awt.Color;
import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;

class MetalEntry {
	final int index;
	final Color colour;
	final boolean isShapeable;
	
	Map<MetalType, ItemStack> items = Maps.<MetalType, ItemStack>newHashMap();
	
	Fluid fluid = null;
	
	public MetalEntry(int index, Color colour, boolean isShapeable) {
		this.index=index;
		this.colour=colour;
		this.isShapeable=isShapeable;
	}
	
	void setFluid(Fluid fluid) {
		this.fluid=fluid;
	}

	void setMetalItem(MetalType type, ItemStack stack) {
		items.put(type, stack);
	}
	
	public boolean hasCustomFluid() {
		return fluid!=null;
	}
	
	public Fluid getCustomFluid() {
		return fluid;
	}
	
	public boolean hasItem(MetalType type) {
		return items.containsKey(type);
	}
	
	public ItemStack getItem(MetalType type) {
		return items.get(type);
	}
}

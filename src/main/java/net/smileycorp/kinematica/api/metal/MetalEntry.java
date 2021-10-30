package net.smileycorp.kinematica.api.metal;

import java.awt.Color;
import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;

import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;

public class MetalEntry {

	final int index;
	final String modid;
	final String name;
	final Color colour;
	final boolean isShapeable;
	boolean registerFluid = true;
	final int meltingTemp;
	final int density;
	
	Map<MetalType, ItemStack> items = Maps.<MetalType, ItemStack>newHashMap();
	
	Fluid fluid = null;
	
	public MetalEntry(int index, String modid, String name, Color colour, boolean isShapeable, int meltingTemp, int density) {
		this.index=index;
		this.modid=modid;
		this.name=name;
		this.colour=colour;
		this.isShapeable=isShapeable;
		this.meltingTemp=meltingTemp;
		this.density=density;
	}
	
	void setFluid(Fluid fluid) {
		this.fluid=fluid;
	}

	void setMetalItem(MetalType type, ItemStack stack) {
		items.put(type, stack);
	}
	
	public void setFluidEnabled(boolean registerFluid) {
		this.registerFluid = registerFluid;
	}
	
	public boolean hasFluid() {
		return fluid!=null&&shouldHaveFluid();
	}
	
	public boolean shouldHaveFluid() {
		return registerFluid;
	}

	public String getName() {
		return name;
	}
	
	public String getMod() {
		return modid;
	}
	
	public Fluid getFluid() {
		return fluid;
	}
	
	public boolean hasItem(MetalType type) {
		return items.containsKey(type);
	}
	
	public ItemStack getItem(MetalType type) {
		return items.get(type);
	}

	public int getMeltingTemp() {
		return meltingTemp;
	}

	public int getDensity() {
		return density;
	}

}

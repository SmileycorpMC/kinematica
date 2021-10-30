package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;

import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class FluidMetal extends Fluid {
	
	public static ResourceLocation MOLTEN_FLUID_STILL = new ResourceLocation("atlaslib", "blocks/fluids/molten_metal");
	public static ResourceLocation MOLTEN_FLUID_FLOWING = new ResourceLocation("atlaslib", "blocks/fluids/molten_metal_flowing");
	
	final protected String metal;
	final protected String modid;

	public FluidMetal(String metal) {
		super(metal.toLowerCase(), MOLTEN_FLUID_STILL, MOLTEN_FLUID_FLOWING, MetalRegistry.getColour(metal));
		this.metal=metal;
		this.modid=MetalRegistry.getMod(metal);
		this.setUnlocalizedName(ModDefinitions.getName(this.modid, metal));
		this.temperature = MetalRegistry.getMeltingTemp(metal);
		this.density = MetalRegistry.getDensity(metal);
		this.viscosity = 10000;
		this.luminosity = 10;
	}
	
	public String getMetal() {
		return metal;
	}

	public String getModid() {
		return modid;
	}
	
	@Override
	public String getLocalizedName(FluidStack stack) {
		String result = I18n.translateToLocal("localisation.Molten").trim();
		result += " ";
		result += I18n.translateToLocal("localisation." + metal.replace("_", "")).trim();
		return result;
    }

}

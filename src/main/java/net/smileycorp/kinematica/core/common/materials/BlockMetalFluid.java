package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class BlockMetalFluid extends BlockFluidClassic {
	
	protected final Fluid fluid;
	
	public BlockMetalFluid(FluidMetal fluid) {
		super(fluid, Material.LAVA);
		this.fluid=fluid;
		this.setUnlocalizedName(ModDefinitions.getName(fluid.getModid(), fluid.getMetal()));
		this.setRegistryName(new ResourceLocation(fluid.getModid(), fluid.getMetal().toLowerCase()));
	}
	
	@Override
	public String getLocalizedName() {
		return fluid.getLocalizedName(new FluidStack(fluid, 1));
    }

}

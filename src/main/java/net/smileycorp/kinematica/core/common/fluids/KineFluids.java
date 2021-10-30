package net.smileycorp.kinematica.core.common.fluids;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.registries.IForgeRegistry;

import net.smileycorp.atlas.api.client.FluidStateMapper;

public class KineFluids {
	
	public static final List<BlockFluidBase> FLUID_BLOCKS = new ArrayList<BlockFluidBase>();
	
	//Gasses
	public static Fluid HYDROGEN;
	public static Fluid OXYGEN;
	public static Fluid STEAM;
	
	public static Fluid CARBON_MONOXIDE;
	public static Fluid CARBON_DIOXIDE;
	public static Fluid SULPHUR_DIOXIDE;
	public static Fluid SULPHUR_TRIOXIDE;
	public static Fluid HYDROGEN_PEROXIDE;

	public static Fluid PRESSURISED_AIR;

	public static Fluid DEUTERIUM;
	public static Fluid TRIIUM;

	public static Fluid HELIUM;
	public static Fluid ARGON;
	public static Fluid CHLORINE;

	//Liquids
	public static Fluid HEAVY_WATER;
	public static Fluid SUPERHEAVY_WATER;
	
	public static Fluid LATEX_RESIN;
	public static Fluid TAR;
	public static Fluid RUBBER;
	public static Fluid CRUDE_OIL;
	public static Fluid LPG;
	public static Fluid PETROLEUM;
	public static Fluid DIESEL;
	public static Fluid BITUMEN;
	
	public static Fluid SULPHURIC_ACID;
	public static Fluid HYDROCHLORIC_ACID;

	public static Fluid MERCURY;
	public static Fluid AMALGAM;
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		
	}
	
	public static void registerModels(ModelRegistryEvent event) {
		for (BlockFluidBase block : FLUID_BLOCKS) {
			ModelLoader.setCustomStateMapper(block, new FluidStateMapper(block.getFluid()));
		}
	}
	
	
}
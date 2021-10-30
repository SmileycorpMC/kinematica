package net.smileycorp.kinematica.core.integration.tcon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;
import net.smileycorp.kinematica.api.metal.AlloyRecipeEntry;
import net.smileycorp.kinematica.api.metal.AlloyRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalStack;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

public class TConRecipeLoader {
	
	public static Map<MetalType, ItemStack> castMap = new HashMap<MetalType, ItemStack>();
	
	public static void loadRecipes() {
		
		//load casts
		castMap.put(MetalType.INGOT, TinkerSmeltery.castIngot);
		castMap.put(MetalType.NUGGET, TinkerSmeltery.castNugget);
		castMap.put(MetalType.PLATE, TinkerSmeltery.castPlate);
		castMap.put(MetalType.GEAR, TinkerSmeltery.castGear);
		//castMap.put(MetalType.ROD, TinkerSmelte);
		
		//load item recipes
		for (MetalType type : MetalType.values()) {
			if (type.isItem()) {
				for (String metal : MetalRegistry.getMetalsFor(type, false)) {
					if (MetalRegistry.getFluid(metal)!=null && type.fluidAmount()>0) {
						//melting
						TinkerRegistry.registerMelting(MetalRegistry.getItemFor(metal, type), MetalRegistry.getFluid(metal), type.fluidAmount());
						//cating
						if (castMap.containsKey(type)) {
							TinkerRegistry.registerTableCasting(MetalRegistry.getItemFor(metal, type), castMap.get(type), MetalRegistry.getFluid(metal), type.fluidAmount());
						}
					}
				}
			}
		}
		//load block recipes
		for (String metal : MetalRegistry.getMetalsFor(MetalType.BLOCK, false)) {
			if (MetalRegistry.getFluid(metal)!=null) {
				//melting
				TinkerRegistry.registerMelting(MetalRegistry.getItemFor(metal, MetalType.BLOCK), MetalRegistry.getFluid(metal), MetalType.BLOCK.fluidAmount());
				//cating
				TinkerRegistry.registerBasinCasting(MetalRegistry.getItemFor(metal, MetalType.BLOCK), ItemStack.EMPTY, MetalRegistry.getFluid(metal), MetalType.BLOCK.fluidAmount());
			}
		}
		//load alloying
		for (AlloyRecipeEntry recipe : AlloyRegistry.getRecipes()) {
			if (isValidFluidRecipe(recipe)) {
				List<FluidStack> inputs = new ArrayList<FluidStack>();
				for (MetalStack input : recipe.getInputs()) {
					inputs.add(new FluidStack(input.getMetal().getFluid(), input.getAmount()));
				}
				TinkerRegistry.registerAlloy(new FluidStack(recipe.getOutput().getMetal().getFluid(), recipe.getOutput().getAmount()), inputs.toArray(new FluidStack[]{}));
			}
		}
		
		//special handling for galvanised steel
		for (MetalType type : MetalRegistry.getTypesFor("Galvanised_Steel")) {
			TinkerRegistry.registerMelting(MetalRegistry.getItemFor("Galvanised_Steel", type), MetalRegistry.getFluid("Steel"), type.fluidAmount());
		}
	}

	private static boolean isValidFluidRecipe(AlloyRecipeEntry recipe) {
		if (!recipe.hasCatalyst() && recipe.getOutput().getMetal().hasFluid()) {
			for (MetalStack input : recipe.getInputs()) {
				if (!input.getMetal().hasFluid()) return false;
			}
			return true;
		}
		return false;
	}
}

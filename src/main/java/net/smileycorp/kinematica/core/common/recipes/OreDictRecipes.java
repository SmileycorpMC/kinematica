package net.smileycorp.kinematica.core.common.recipes;

import java.util.ArrayList;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreIngredient;
import net.smileycorp.kinematica.api.recipes.KilnRecipes;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class OreDictRecipes {
	
	public static void registerRecipes() {
		String[] oredicts = OreDictionary.getOreNames();
		ArrayList<String> ingots = new ArrayList<String>();
		ArrayList<String> dusts = new ArrayList<String>();
		ArrayList<String> ores = new ArrayList<String>();
		for (String ore : oredicts) {
			if(ore.contains("ingot")) {
				ingots.add(ore.replace("ingot", ""));
			} else if(ore.contains("dust")) {
				dusts.add(ore.replace("dust", ""));
			} else if(ore.contains("ore")) {
				ores.add(ore.replace("ore", ""));
			}
		}
		for (String ingot:ingots) {
			for (String oreblock:ores) {
				if (ingot.matches(oreblock)) {
					try {
						ItemStack out = OreDictionary.getOres("ingot"+ingot).get(0).copy();
						KilnRecipes.addRecipe(new OreIngredient("ore"+oreblock), new OreIngredient("sand"), out);
						ItemStack out2 = out.copy();
						out2.setCount(2);
						KilnRecipes.addRecipe(new OreIngredient("ore"+oreblock), new OreIngredient("dustMercury"), out);
						System.out.println("["+ModDefinitions.modid+"] detected matching ores, adding kiln recipe for ore" + oreblock + " to " + out);
					} catch(Exception e) {
						System.out.println("["+ModDefinitions.modid+"] detected matching ores, error adding kiln recipe for ore" + oreblock + " to ingot" + ingot);
					}
				}
			}
			for (String dust:dusts) {
				if (ingot.matches(dust)) {
					try {
						ItemStack out = OreDictionary.getOres("ingot"+ingot).get(0).copy();
						KilnRecipes.addRecipe(new OreIngredient("dust"+dust), new OreIngredient("sand"), out);
						System.out.println("["+ModDefinitions.modid+"] detected matching ores, adding kiln recipe for dust" + dust + " to " + out);
					} catch(Exception e) {
						System.out.println("["+ModDefinitions.modid+"] detected matching ores, error adding kiln recipe for dust" + dust + " to ingot" + ingot);
					}
				}
			}
		}
	}
}

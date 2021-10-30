package net.smileycorp.kinematica.core.common;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraftforge.oredict.OreIngredient;
import net.smileycorp.kinematica.api.metal.AlloyRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.api.util.ElementUtils;
import net.smileycorp.kinematica.core.integration.ModIntegration;

public class APIRegistry {
	
	public static void registerAPI() {
		registerMetals();
		addOtherNames();
		ModIntegration.apiInit();
	}

	private static void registerMetals() {
		
		//Vanilla Metals
		MetalRegistry.registerMetal("Iron", ModDefinitions.modid, new Color(216, 216, 216), true, 1811, 7874);
		MetalRegistry.registerMetalItem("Iron", MetalType.INGOT, Items.IRON_INGOT);
		MetalRegistry.registerMetalItem("Iron", MetalType.NUGGET, Items.IRON_NUGGET);
		MetalRegistry.registerMetalItem("Iron", MetalType.BLOCK, Blocks.IRON_BLOCK);
		MetalRegistry.registerMetal("Gold", ModDefinitions.modid, new Color(255, 222, 61), true, 1337, 17310);
		MetalRegistry.registerMetalItem("Gold", MetalType.INGOT, Items.GOLD_INGOT);
		MetalRegistry.registerMetalItem("Gold", MetalType.NUGGET, Items.GOLD_NUGGET);
		MetalRegistry.registerMetalItem("Gold", MetalType.BLOCK, Blocks.GOLD_BLOCK);
		
		//New Metals
		MetalRegistry.registerMetal("Tin", ModDefinitions.modid, new Color(206, 212, 202), true, 505, 6990);
		MetalRegistry.registerMetal("Copper", ModDefinitions.modid, new Color(185, 121, 26), true, 1357, 7750);
		MetalRegistry.registerMetal("Lead", ModDefinitions.modid, new Color(114, 146, 175), true, 1000, 10678);
		MetalRegistry.registerMetal("Silver", ModDefinitions.modid, new Color(218, 242, 242), true, 1234, 8244);
		MetalRegistry.registerMetal("Zinc", ModDefinitions.modid, new Color(183, 214, 175), false, 693, 7140);
		MetalRegistry.registerMetal("Chromium", ModDefinitions.modid, new Color(188, 242, 239), true, 2180, 6300);
		MetalRegistry.registerMetal("Cobalt", ModDefinitions.modid, new Color(79, 105, 255), false, 1768, 8900);
		MetalRegistry.registerMetal("Nickel", ModDefinitions.modid, new Color(224, 204, 139), true, 1728, 7810);
		MetalRegistry.registerMetal("Palladium", ModDefinitions.modid, new Color(226, 255, 233), true, 1833, 10380);
		MetalRegistry.registerMetal("Platinum", ModDefinitions.modid, new Color(184, 213, 207), true, 2041, 19770);
		MetalRegistry.registerMetal("Osmium", ModDefinitions.modid, new Color(174, 218, 242), false, 3306, 20000);
		MetalRegistry.registerMetal("Iridium", ModDefinitions.modid, new Color(236, 237, 213), true, 2719, 19000);
		MetalRegistry.registerMetal("Magnesium", ModDefinitions.modid, new Color(234, 222, 173), false, 923, 1584);
		MetalRegistry.registerMetal("Bismuth", ModDefinitions.modid, new Color(186, 170, 175), false, 544, 10050);
		MetalRegistry.registerMetal("Tungsten", ModDefinitions.modid, new Color(145, 214, 173), true, 3695, 17600);
		MetalRegistry.registerMetal("Antimony", ModDefinitions.modid, new Color(193, 239, 216), true, 903, 6697);
		MetalRegistry.registerMetal("Aluminium", ModDefinitions.modid, new Color(211, 210, 205), true, 933, 2375);
		MetalRegistry.registerMetal("Titanium", ModDefinitions.modid, new Color(187, 195, 206), true, 1941, 14110);
		
		//Simple Alloys
		MetalRegistry.registerMetal("Bronze", ModDefinitions.modid, new Color(216, 166, 80), true, 1223, 8900);
		MetalRegistry.registerMetal("Brass", ModDefinitions.modid, new Color(213, 172, 53), true, 1203, 8400);
		MetalRegistry.registerMetal("Durallium", ModDefinitions.modid, new Color(215, 179, 123), true, 903, 2780);
		MetalRegistry.registerMetal("Bisbronze", ModDefinitions.modid, new Color(213, 172, 53), true, 1156, 8890);
		MetalRegistry.registerMetal("Constantan", ModDefinitions.modid, new Color(232, 203, 122), true, 1493, 8860);
		MetalRegistry.registerMetal("Invar", ModDefinitions.modid, new Color(239, 227, 208), true, 1710, 8100);
		MetalRegistry.registerMetal("Electrum", ModDefinitions.modid, new Color(255, 242, 118), true, 1285, 8500);
		MetalRegistry.registerMetal("Argentium", ModDefinitions.modid, new Color(238, 238, 232), true, 1172, 10300);
		MetalRegistry.registerMetal("Nichrome", ModDefinitions.modid, new Color(231, 237, 220), true, 16703, 8400);
		MetalRegistry.registerMetal("Iridosmine", ModDefinitions.modid, new Color(223, 230, 196), true, 2905, 19335);
		
		//Complex Alloys
		MetalRegistry.registerMetal("Pewter", ModDefinitions.modid, new Color(172, 224, 205), true, 503, 7473);
		MetalRegistry.registerMetal("Platinaire", ModDefinitions.modid, new Color(207, 235, 231), true, 1418, 12194);
		MetalRegistry.registerMetal("White_Gold", ModDefinitions.modid, new Color(232, 241, 242), true, 1370, 14700);
		MetalRegistry.registerMetal("Rose_Gold", ModDefinitions.modid, new Color(255, 202, 150), true, 1327, 12612);
		
		//Special Alloys
		MetalRegistry.registerMetal("Arsenical_Bronze", ModDefinitions.modid, new Color(235, 255, 242), true, 1357, 7750);
		MetalRegistry.registerMetal("Steel", ModDefinitions.modid, new Color(178, 178, 178), true, 1698, 7750);
		MetalRegistry.registerMetal("Galvanised_Steel", ModDefinitions.modid, new Color(220, 228, 218), true, 1698, 7750);
		MetalRegistry.setFluidEnabled("Galvanised_Steel", false);
		
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Brass", 3), MetalRegistry.createMetalStack("Copper", 2), MetalRegistry.createMetalStack("Zinc", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Durallium", 4), MetalRegistry.createMetalStack("Aluminium", 3), MetalRegistry.createMetalStack("Copper", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Bisbronze", 4), MetalRegistry.createMetalStack("Copper", 3), MetalRegistry.createMetalStack("Bismuth", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Constantan", 1), MetalRegistry.createMetalStack("Copper", 1), MetalRegistry.createMetalStack("Nickel", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Invar", 3), MetalRegistry.createMetalStack("Iron", 2), MetalRegistry.createMetalStack("Nickel", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Electrum", 2), MetalRegistry.createMetalStack("Gold", 1), MetalRegistry.createMetalStack("Silver", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Argentium", 4), MetalRegistry.createMetalStack("Silver", 3), MetalRegistry.createMetalStack("Copper", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Nichrome", 5), MetalRegistry.createMetalStack("Nickel", 4), MetalRegistry.createMetalStack("Chromium", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Iridosmine", 3), MetalRegistry.createMetalStack("Iridium", 2), MetalRegistry.createMetalStack("Osmium", 1));
		
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Pewter", 5), MetalRegistry.createMetalStack("Tin", 3), MetalRegistry.createMetalStack("Antimony", 1), MetalRegistry.createMetalStack("Lead", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Platinaire", 5), MetalRegistry.createMetalStack("Argentium", 4), MetalRegistry.createMetalStack("Platinum", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Platinaire", 5), MetalRegistry.createMetalStack("Silver", 3), MetalRegistry.createMetalStack("Copper", 1), MetalRegistry.createMetalStack("Platinum", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("White_Gold", 5), MetalRegistry.createMetalStack("Gold", 3), MetalRegistry.createMetalStack("Palladium", 1), MetalRegistry.createMetalStack("Copper", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Rose_Gold", 5), MetalRegistry.createMetalStack("Gold", 3), MetalRegistry.createMetalStack("Silver", 1), MetalRegistry.createMetalStack("Copper", 1));
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Rose_Gold", 5), MetalRegistry.createMetalStack("Gold", 2), MetalRegistry.createMetalStack("Electrum", 2), MetalRegistry.createMetalStack("Copper", 1));
		
		AlloyRegistry.registerAlloy(MetalRegistry.createMetalStack("Arsenical_Bronze", 3), new OreIngredient("dustArsenic"), MetalRegistry.createMetalStack("Copper", 3));
	}
	
	private static void addOtherNames() {
		ElementUtils.registerAltOre("Aluminium", "Aluminum");
		ElementUtils.registerAltOre("Chromium", "Chrome");
		ElementUtils.registerAltOre("Tungsten", "Wolfram");
		ElementUtils.registerAltOre("Durallium", "Duralumin", "Alubrass", "Alubronze");
		ElementUtils.registerAltOre("Iridosmine", "Osmiridium");
		ElementUtils.registerAltOre("GalvanisedSteel", "GalvanizedSteel");
		ElementUtils.registerAltOre("Fathonium", "IridiumTitanium", "IridiumTitaniumAlloy", "Irti", "IrTi", "Ir-Ti");
		ElementUtils.registerAltOre("WhiteGold", "Whitegold");
	}
}

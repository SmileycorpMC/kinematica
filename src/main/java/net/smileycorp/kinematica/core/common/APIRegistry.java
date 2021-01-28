package net.smileycorp.kinematica.core.common;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.api.util.ElementUtils;

public class APIRegistry {
	
	public static void registerAPI() {
		registerMetals();
		addOtherNames();
	}

	private static void registerMetals() {
		
		//Vanilla Metals
		MetalRegistry.registerMetal("Iron", ModDefinitions.modid, new Color(216, 216, 216), true);
		MetalRegistry.registerMetalItem("Iron", MetalType.INGOT, Items.IRON_INGOT);
		MetalRegistry.registerMetalItem("Iron", MetalType.NUGGET, Items.IRON_NUGGET);
		MetalRegistry.registerMetalItem("Iron", MetalType.BLOCK, Blocks.IRON_BLOCK);
		MetalRegistry.registerMetal("Gold", ModDefinitions.modid, new Color(255, 222, 61), true);
		MetalRegistry.registerMetalItem("Gold", MetalType.INGOT, Items.GOLD_INGOT);
		MetalRegistry.registerMetalItem("Gold", MetalType.NUGGET, Items.GOLD_NUGGET);
		MetalRegistry.registerMetalItem("Gold", MetalType.BLOCK, Blocks.GOLD_BLOCK);
		
		//New Metals
		MetalRegistry.registerMetal("Tin", ModDefinitions.modid, new Color(206, 212, 202), true);
		MetalRegistry.registerMetal("Copper", ModDefinitions.modid, new Color(185, 121, 26), true);
		MetalRegistry.registerMetal("Lead", ModDefinitions.modid, new Color(114, 146, 175), true);
		MetalRegistry.registerMetal("Silver", ModDefinitions.modid, new Color(222, 230, 230), true);
		MetalRegistry.registerMetal("Zinc", ModDefinitions.modid, new Color(183, 214, 175), false);
		MetalRegistry.registerMetal("Chromium", ModDefinitions.modid, new Color(208, 226, 219), true);
		MetalRegistry.registerMetal("Cobalt", ModDefinitions.modid, new Color(79, 105, 255), false);
		MetalRegistry.registerMetal("Nickel", ModDefinitions.modid, new Color(224, 204, 139), true);
		MetalRegistry.registerMetal("Palladium", ModDefinitions.modid, new Color(226, 255, 233), true);
		MetalRegistry.registerMetal("Platinum", ModDefinitions.modid, new Color(184, 213, 207), true);
		MetalRegistry.registerMetal("Osmium", ModDefinitions.modid, new Color(210, 231, 242), false);
		MetalRegistry.registerMetal("Iridium", ModDefinitions.modid, new Color(226, 215, 165), true);
		MetalRegistry.registerMetal("Magnesium", ModDefinitions.modid, new Color(234, 222, 173), false);
		MetalRegistry.registerMetal("Bismuth", ModDefinitions.modid, new Color(186, 170, 175), false);
		MetalRegistry.registerMetal("Tungsten", ModDefinitions.modid, new Color(145, 214, 173), true);
		MetalRegistry.registerMetal("Antimony", ModDefinitions.modid, new Color(193, 239, 216), true);
		MetalRegistry.registerMetal("Aluminium", ModDefinitions.modid, new Color(211, 210, 205), true);
		MetalRegistry.registerMetal("Titanium", ModDefinitions.modid, new Color(187, 195, 206), true);
		
		//Alloys
		MetalRegistry.registerMetal("Bronze", ModDefinitions.modid, new Color(226, 135, 41), true);
		MetalRegistry.registerMetal("Brass", ModDefinitions.modid, new Color(213, 172, 53), true);
		MetalRegistry.registerMetal("Durallium", ModDefinitions.modid, new Color(215, 179, 123), true);
		MetalRegistry.registerMetal("Constantan", ModDefinitions.modid, new Color(232, 203, 122), true);
		MetalRegistry.registerMetal("Pewter", ModDefinitions.modid, new Color(172, 224, 205), true);
		MetalRegistry.registerMetal("Invar", ModDefinitions.modid, new Color(239, 227, 208), true);
		MetalRegistry.registerMetal("Electrum", ModDefinitions.modid, new Color(255, 242, 118), true);
		MetalRegistry.registerMetal("Argentium", ModDefinitions.modid, new Color(238, 238, 232), true);
		MetalRegistry.registerMetal("Nichrome", ModDefinitions.modid, new Color(231, 237, 220), true);
		MetalRegistry.registerMetal("Platinaire", ModDefinitions.modid, new Color(207, 235, 231), true);
		MetalRegistry.registerMetal("Iridosmine", ModDefinitions.modid, new Color(223, 230, 196), true);
		MetalRegistry.registerMetal("Rose_Gold", ModDefinitions.modid, new Color(255, 202, 150), true);
		MetalRegistry.registerMetal("Fathonium", ModDefinitions.modid, new Color(234, 227, 196), true);
		MetalRegistry.registerMetal("Steel", ModDefinitions.modid, new Color(178, 178, 178), true);
		MetalRegistry.registerMetal("Galvanised_Steel", ModDefinitions.modid, new Color(220, 228, 218), true);
		MetalRegistry.registerMetal("Stellite", ModDefinitions.modid, new Color(223, 238, 255), true);
		MetalRegistry.registerMetal("White_Gold", ModDefinitions.modid, new Color(232, 241, 242), true);
		MetalRegistry.registerMetal("Mithril", ModDefinitions.modid, new Color(235, 255, 242), true);
		MetalRegistry.registerMetal("Hepatizion", ModDefinitions.modid, new Color(179, 87, 204), true);
		MetalRegistry.registerMetal("Orichalcum", ModDefinitions.modid, new Color(177, 178, 118), true);
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

package net.smileycorp.kinematica.core.common;

import java.awt.Color;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
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
		MetalRegistry.registerMetal("Iron", new Color(216, 216, 216), true);
		MetalRegistry.registerMetalItem("Iron", MetalType.INGOT, new ItemStack(Items.IRON_INGOT));
		MetalRegistry.registerMetalItem("Iron", MetalType.NUGGET, new ItemStack(Items.IRON_NUGGET));
		MetalRegistry.registerMetalItem("Iron", MetalType.BLOCK, new ItemStack(Blocks.IRON_BLOCK));
		MetalRegistry.registerMetal("Gold", new Color(255, 222, 61), true);
		MetalRegistry.registerMetalItem("Gold", MetalType.INGOT, new ItemStack(Items.GOLD_INGOT));
		MetalRegistry.registerMetalItem("Gold", MetalType.NUGGET, new ItemStack(Items.GOLD_NUGGET));
		MetalRegistry.registerMetalItem("Gold", MetalType.BLOCK, new ItemStack(Blocks.GOLD_BLOCK));
		
		//New Metals
		MetalRegistry.registerMetal("Tin", new Color(206, 212, 202), true);
		MetalRegistry.registerMetal("Copper", new Color(185, 121, 26), true);
		MetalRegistry.registerMetal("Lead", new Color(114, 146, 175), true);
		MetalRegistry.registerMetal("Silver", new Color(222, 230, 230), true);
		MetalRegistry.registerMetal("Zinc", new Color(183, 214, 175), false);
		MetalRegistry.registerMetal("Chromium", new Color(208, 226, 219), true);
		MetalRegistry.registerMetal("Cobalt", new Color(79, 105, 255), false);
		MetalRegistry.registerMetal("Nickel", new Color(224, 204, 139), true);
		MetalRegistry.registerMetal("Palladium", new Color(226, 255, 233), true);
		MetalRegistry.registerMetal("Platinum", new Color(184, 213, 207), true);
		MetalRegistry.registerMetal("Osmium", new Color(210, 231, 242), false);
		MetalRegistry.registerMetal("Iridium", new Color(226, 215, 165), true);
		MetalRegistry.registerMetal("Magnesium", new Color(234, 222, 173), false);
		MetalRegistry.registerMetal("Bismuth", new Color(186, 170, 175), false);
		MetalRegistry.registerMetal("Tungsten", new Color(145, 214, 173), true);
		MetalRegistry.registerMetal("Antimony", new Color(193, 239, 216), true);
		MetalRegistry.registerMetal("Aluminium", new Color(211, 210, 205), true);
		MetalRegistry.registerMetal("Titanium", new Color(187, 195, 206), true);
		
		//Alloys
		MetalRegistry.registerMetal("Bronze", new Color(226, 135, 41), true);
		MetalRegistry.registerMetal("Brass", new Color(213, 172, 53), true);
		MetalRegistry.registerMetal("Durallium", new Color(215, 179, 123), true);
		MetalRegistry.registerMetal("Constantan", new Color(232, 203, 122), true);
		MetalRegistry.registerMetal("Pewter", new Color(172, 224, 205), true);
		MetalRegistry.registerMetal("Invar", new Color(239, 227, 208), true);
		MetalRegistry.registerMetal("Electrum", new Color(255, 242, 118), true);
		MetalRegistry.registerMetal("Argentium", new Color(238, 238, 232), true);
		MetalRegistry.registerMetal("Nichrome", new Color(231, 237, 220), true);
		MetalRegistry.registerMetal("Platinaire", new Color(207, 235, 231), true);
		MetalRegistry.registerMetal("Iridosmine", new Color(223, 230, 196), true);
		MetalRegistry.registerMetal("Rose_Gold", new Color(255, 202, 150), true);
		MetalRegistry.registerMetal("Fathonium", new Color(234, 227, 196), true);
		MetalRegistry.registerMetal("Steel", new Color(178, 178, 178), true);
		MetalRegistry.registerMetal("Galvanised_Steel", new Color(220, 228, 218), true);
		MetalRegistry.registerMetal("Stellite", new Color(223, 238, 255), true);
		MetalRegistry.registerMetal("White_Gold", new Color(232, 241, 242), true);
		MetalRegistry.registerMetal("Mithril", new Color(235, 255, 242), true);
		MetalRegistry.registerMetal("Hepatizion", new Color(179, 87, 204), true);
		MetalRegistry.registerMetal("Orichalcum", new Color(177, 178, 118), true);
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

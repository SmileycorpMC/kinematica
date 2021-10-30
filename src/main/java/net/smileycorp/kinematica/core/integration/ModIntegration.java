package net.smileycorp.kinematica.core.integration;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.smileycorp.kinematica.core.integration.tcon.TConRecipeLoader;
import net.smileycorp.kinematica.core.integration.thermal.ThermalAPI;
import net.smileycorp.kinematica.core.integration.thermal.ThermalRecipeLoader;

public class ModIntegration {
	
	public static boolean ubInstalled = false;
	
	public static void preInit(FMLPreInitializationEvent event) {
		if (Loader.isModLoaded("undergroundbiomes")) {
			//UBIntegration.setupOres(event);
			ubInstalled = true;
		}
	}
	
	public static void apiInit() {
		if (Loader.isModLoaded("thermalexpansion")) {
			ThermalAPI.initItems();
		}
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
		if (Loader.isModLoaded("tconstruct")) {
			TConRecipeLoader.loadRecipes();
		}
		
		if (Loader.isModLoaded("thermalexpansion")) {
			ThermalRecipeLoader.loadRecipes();
		}
	}
}

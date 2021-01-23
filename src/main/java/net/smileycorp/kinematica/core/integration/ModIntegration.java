package net.smileycorp.kinematica.core.integration;

import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModIntegration {
	
	public static boolean ubInstalled = false;
	
	public static void preInit(FMLPreInitializationEvent event) {
		if (Loader.isModLoaded("undergroundbiomes")) {
			//UBIntegration.setupOres(event);
			ubInstalled = true;
		}
	}
	
	public static void init() {
		
	}
	
	public static void postInit() {
	}
}

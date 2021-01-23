package net.smileycorp.kinematica.core.common;

import net.minecraftforge.common.config.Configuration;

public class KineConfig {
	public static Configuration config;
	
	//general
	public static String tempUnits = "K";
	
	public static void syncConfig(){
		try{
			config.load();
			//general
			tempUnits = config.get(Configuration.CATEGORY_GENERAL, "tempUnits",
					"kelvin", "Which units to use for temperature readings? (C (Celsius), F (Fahrenheit), K (Kelvin) or R (Rankine) (defaults to K (Kelvin))").getString().toUpperCase();
			if (tempUnits!="C"&&tempUnits!="F"&&tempUnits!="R"){
				tempUnits = "K";
			}
		} catch (Exception e) {
		} finally {
    	if (config.hasChanged()) config.save();
		}
	}
}

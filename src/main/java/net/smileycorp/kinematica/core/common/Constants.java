package net.smileycorp.kinematica.core.common;

import net.minecraft.resources.ResourceLocation;

public class Constants {

	public static final String MODID = "kinematica";
	public static final String NAME = "Kinematica";

	public static double ticker = 0;

	public static String name(String name) {
		return name(MODID, name);
	}

	public static String name(String modid, String name) {
		return modid + "." + name.replace("_", "");
	}

	public static ResourceLocation loc(String name) {
		return new ResourceLocation(MODID, name.toLowerCase());
	}

	public static String locStr(String string) {
		return loc(string).toString();
	}

	public static ResourceLocation splitLoc(String resource) {
		if (resource!=null) {
			String[] split = resource.split(":");
			if (split.length>1) {
				return new ResourceLocation(split[0], split[1]);
			}
			return new ResourceLocation(resource);
		} else return new ResourceLocation("stone");
	}

}

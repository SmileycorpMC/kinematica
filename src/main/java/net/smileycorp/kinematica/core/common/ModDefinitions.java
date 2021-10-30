package net.smileycorp.kinematica.core.common;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModDefinitions {

	public static final String modid = "kinematica";
	public static final String name = "Kinematica";
	public static final String version = "alpha 0.1.4";
	public static final String dependencies = "required-after:atlaslib;before:undergroundbiomes;before:tconstruct;before:conarm;after:thermalfoundation";
	public static final String location = "net.smileycorp.kinematica.core.";
	public static final String client = location + "client.ClientProxy";
	public static final String server = location + "common.ServerProxy";
	
	@SideOnly(Side.CLIENT)
	public static double ticker = 0;
	
	public static String getName(String name) {
		return getName(modid, name);
	}
	
	public static String getName(String modid, String name) {
		return modid + "." + name.replace("_", "");
	}
	
	public static ResourceLocation getResource(String name) {
		return new ResourceLocation(modid, name.toLowerCase());
	}

	public static String getResourceName(String string) {
		return getResource(string).toString();
	}

	public static ResourceLocation splitResource(String resource) {
		if (resource!=null) {
			String[] split = resource.split(":");
			if (split.length>1) {
				return new ResourceLocation(split[0], split[1]);
			}
			return new ResourceLocation(resource);
		} else return new ResourceLocation("stone");
	}

}

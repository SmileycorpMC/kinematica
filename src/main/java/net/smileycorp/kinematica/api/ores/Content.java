package net.smileycorp.kinematica.api.ores;

import net.minecraft.creativetab.CreativeTabs;

public class Content {

	static CreativeTabs ORES_TAB;
	static String MOD_ID;

	public static CreativeTabs getCreativeTab() {
		return ORES_TAB;
	}

	public static void setCreativeTab(CreativeTabs creativeTab) {
		ORES_TAB = creativeTab;
	}

	public static String getModid() {
		return MOD_ID;
	}
	
	public static void setModid(String modid) {
		MOD_ID=modid;
	}

}

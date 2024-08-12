package net.smileycorp.kinematica.core.integration.tcon.client;

import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import slimeknights.tconstruct.tools.TinkerTools;

public class TConClientRegistry {

	public static void itemColourHandler(ItemColors registry) {
		System.out.println(":) fuck");
		registry.registerItemColorHandler(new ItemForgeColour(), TinkerTools.toolForge);
	}

	public static void blockColourHandler(BlockColors registry) {
		System.out.println(":) fuck");
		registry.registerBlockColorHandler(new BlockForgeColour(), TinkerTools.toolForge);
	}

}

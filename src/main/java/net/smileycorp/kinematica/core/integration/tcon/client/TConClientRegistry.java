package net.smileycorp.kinematica.core.integration.tcon.client;

import slimeknights.tconstruct.tools.TinkerTools;

import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;

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

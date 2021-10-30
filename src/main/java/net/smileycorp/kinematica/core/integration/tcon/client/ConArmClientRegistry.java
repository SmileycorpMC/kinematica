package net.smileycorp.kinematica.core.integration.tcon.client;

import c4.conarm.common.ConstructsRegistry;

import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;

public class ConArmClientRegistry {

	public static void itemColourHandler(ItemColors registry) {
		System.out.println(":) fuck");
		registry.registerItemColorHandler(new ItemForgeColour(), ConstructsRegistry.armorForge);
	}

	public static void blockColourHandler(BlockColors registry) {
		System.out.println(":) fuck");
		registry.registerBlockColorHandler(new BlockForgeColour(), ConstructsRegistry.armorForge);
	}

}

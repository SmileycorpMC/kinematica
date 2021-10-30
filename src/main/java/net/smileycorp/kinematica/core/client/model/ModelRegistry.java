package net.smileycorp.kinematica.core.client.model;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.smileycorp.kinematica.core.common.world.blocks.BlockOreBase;

public class ModelRegistry {
	public static void registerModels(Block[] blocks) {
		for (Block block : blocks) {
			final ResourceLocation loc = ForgeRegistries.BLOCKS.getKey(block);
			if (block instanceof BlockOreBase) {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "inventory"));
			} else {
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "normal"));
			}
		}
	}
}

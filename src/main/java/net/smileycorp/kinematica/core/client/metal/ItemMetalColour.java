package net.smileycorp.kinematica.core.client.metal;

import java.awt.Color;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.core.common.materials.BlockMetal;
import net.smileycorp.kinematica.core.common.materials.ItemMetal;

public class ItemMetalColour implements IItemColor {

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		Color colour = Color.WHITE;
		if (stack.getItem() instanceof ItemMetal) {
			colour = MetalRegistry.getColour(((ItemMetal)stack.getItem()).metal);
		} else if (stack.getItem() instanceof ItemBlock) {
			Block block = ((ItemBlock) stack.getItem()).getBlock();
			if (block instanceof BlockMetal) {
				colour = MetalRegistry.getColour(((BlockMetal) block).metal);
			}
		} 
		return colour.getRGB();
	}

}

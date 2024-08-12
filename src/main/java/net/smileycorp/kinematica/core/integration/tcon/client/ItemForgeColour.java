package net.smileycorp.kinematica.core.integration.tcon.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.core.common.materials.BlockMetal;
import slimeknights.tconstruct.shared.tileentity.TileTable;

import java.awt.*;

public class ItemForgeColour implements IItemColor {

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		Color colour = Color.WHITE;
		if (stack.getItem() instanceof ItemBlock && tintIndex == 0) {
			 NBTTagCompound nbt = stack.getTagCompound().getCompoundTag(TileTable.FEET_TAG);
			 Block block = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(nbt.getString("id")));
			 if (block instanceof BlockMetal) colour = MetalRegistry.getColour(((BlockMetal)block).metal);
		}
		return colour.getRGB();
	}

}

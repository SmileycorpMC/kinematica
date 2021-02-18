package net.smileycorp.kinematica.core.integration.tcon.client;

import slimeknights.tconstruct.shared.tileentity.TileTable;
import slimeknights.tconstruct.tools.common.block.BlockToolForge;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemForgeColour implements IItemColor {

	@Override
	public int colorMultiplier(ItemStack stack, int tintIndex) {
		if (stack.getItem() instanceof ItemBlock) {
			if (((ItemBlock) stack.getItem()).getBlock() instanceof BlockToolForge)	{
				 NBTTagCompound texture = stack.getTagCompound().getCompoundTag(TileTable.FEET_TAG);
			}
		}
		return 0;
	}

}

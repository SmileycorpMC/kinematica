package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;

import net.smileycorp.kinematica.core.common.KineTabs;

@SuppressWarnings("deprecation")
public class ItemBlockMetal extends ItemBlock {
	
	public ItemBlockMetal(BlockMetal block) {
		super(block);
		setCreativeTab(KineTabs.BLOCKS);
		setUnlocalizedName(block.getUnlocalizedName().substring(4));
		setRegistryName(block.getRegistryName());
	}
	
	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList) {
		if(!isInCreativeTab(tabs)) return;
		itemList.add(new ItemStack(this));
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return getDisplayName(((BlockMetal)block).metal);
	}
	
	private String getDisplayName(String name) {
		String result = I18n.translateToLocal("localisation." + name.replace("_", "")).trim();
		result += " ";
		result += I18n.translateToLocal("localisation.Block".trim());
		return result;
	}

}

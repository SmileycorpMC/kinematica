package net.smileycorp.kinematica.core.common.construction.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;

import net.smileycorp.atlas.api.item.IMetaItem;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

@SuppressWarnings("deprecation")
public class ItemConstructionDusts extends Item implements IMetaItem {
	
	final String[] variants = {"Aggregate", "Limestone", "Dolomite", "Quicklime", "Slaked_Lime", "Cement"};
	
	public ItemConstructionDusts() {
		super();
		String name = "Construction_Dusts";
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		setHasSubtypes(true);
		setCreativeTab(KineTabs.MATERIALS);
	}
	
	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList) {
		if(!isInCreativeTab(tabs)) return;
		for(int counter = 0; counter < variants.length; counter++) {
			itemList.add(new ItemStack(this, 1, counter));
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		int meta = stack.getItemDamage();
		String name = variants[meta].replace("_", "");
		return I18n.translateToLocal("item.kinematica." + name.replace("_", "") + "Dust.name").trim();
	}
	
	@Override
	public String byMeta(int meta) {
		return variants[meta].toLowerCase();
	}
	
	@Override
	public int getMaxMeta() {
		return variants.length-1;
	}

}
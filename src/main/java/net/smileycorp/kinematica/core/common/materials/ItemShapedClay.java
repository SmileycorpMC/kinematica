package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.atlas.api.interfaces.IMetaItem;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

@SuppressWarnings("deprecation")
public class ItemShapedClay extends Item implements IMetaItem {
	
	private String type;
	private String[] variants = {"Gear", "Rod"};
	
	public ItemShapedClay(String type) {
		super();
		String name = "Shaped_" + type;
		setRegistryName(name.toLowerCase());
		setUnlocalizedName(ModDefinitions.getName(name));
		setHasSubtypes(true);
		setCreativeTab(KineTabs.MATERIALS);
		this.type=type;
	}
	
	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList) {
		if(!isInCreativeTab(tabs)) return;
		for(int i = 0; i<variants.length; i++) {
			itemList.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		int meta = stack.getItemDamage();
		return getDisplayName(meta);
	}
	
	private String getDisplayName(int meta) {
		String result = I18n.translateToLocal("localisation." + type).trim();
		result += " ";
		result += I18n.translateToLocal("localisation." + variants[meta]).trim();
		return result;
	}
	
	@Override
	public String byMeta(int meta) {
		return variants[meta].toLowerCase();
	};
	
	@Override
	public int getMaxMeta() {
		return variants.length-1;
	}
}

package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.kinematica.api.metal.NonMetalRegistry;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

@SuppressWarnings("deprecation")
public class ItemMaterialDust extends Item {
	
	public ItemMaterialDust() {
		super();
		String name = "Material_Dust";
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		setHasSubtypes(true);
		setCreativeTab(KineTabs.MATERIALS);
	}
	
	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList) {
		if(!isInCreativeTab(tabs)) return;
		for(int counter = 0; counter < NonMetalRegistry.getMaterials().size(); counter++) {
			itemList.add(new ItemStack(this, 1, counter));
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		int meta = stack.getItemDamage();
		String name = NonMetalRegistry.getMaterials().get(meta);
		return getDisplayName(name);
	}
	
	private String getDisplayName(String name) {
		String result = I18n.translateToLocal("localisation." + name.replace("_", "")).trim();
		result += " ";
		result += I18n.translateToLocal("localisation.dust").trim();
		return result;
	}

}

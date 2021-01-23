package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

@SuppressWarnings("deprecation")
public class ItemBlockMetal extends ItemBlock {
	
	public ItemBlockMetal() {
		super(Materials.BLOCK_METAL);
		setCreativeTab(KineTabs.MATERIALS);
		setUnlocalizedName(ModDefinitions.getName("MetalBlock"));
		setRegistryName(ModDefinitions.getResource("metal_block"));
	}
	
	@Override
	public void getSubItems(CreativeTabs tabs, NonNullList<ItemStack> itemList) {
		if(!isInCreativeTab(tabs)) return;
		for(String name : MetalRegistry.getMetalsFor(MetalType.BLOCK)) {
			ItemStack stack = new ItemStack(this);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("type", name);
			stack.setTagCompound(tag);
			itemList.add(stack);
		}
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		NBTTagCompound tag = stack.getTagCompound();
		if (tag!=null) {
			if (tag.hasKey("type")) {
				return getDisplayName(tag.getString("type"));
			}
		}
		return I18n.translateToLocal("localisation.Block".trim());
	}
	
	private String getDisplayName(String name) {
		String result = I18n.translateToLocal("localisation." + name.replace("_", "")).trim();
		result += " ";
		result += I18n.translateToLocal("localisation.Block".trim());
		return result;
	}

}

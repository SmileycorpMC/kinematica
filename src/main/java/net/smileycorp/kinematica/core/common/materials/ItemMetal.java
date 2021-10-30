package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;

import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.KineTabs;

@SuppressWarnings("deprecation")
public class ItemMetal extends Item {
	
	public final MetalType type;
	public final String metal;
	
	public ItemMetal(String modid, MetalType type, String metal) {
		super();
		String name = metal.toLowerCase()+"_"+type.getName();
		setRegistryName(new ResourceLocation(modid, name));
		setUnlocalizedName(modid + "." + name.replace("_", ""));
		this.type = type;
		this.metal = metal;
		setCreativeTab(KineTabs.MATERIALS);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return getDisplayName(metal);
	}
	
	private String getDisplayName(String name) {
		String result = I18n.translateToLocal("localisation." + name.replace("_", "")).trim();
		result += " ";
		result += I18n.translateToLocal("localisation." + type.getName()).trim();
		return result;
	}

}

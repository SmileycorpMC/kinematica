package net.smileycorp.kinematica.core.common.world.blocks;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.kinematica.core.common.KineTabs;

@SuppressWarnings("deprecation")
public class ItemBlockOreBase extends ItemBlock {

	public ItemBlockOreBase(BlockOreBase block) {
		super(block);
		setCreativeTab(KineTabs.BLOCKS);
		setUnlocalizedName(block.getUnlocalizedName().substring(4));
		setRegistryName(block.getRegistryName());
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return getDisplayName(((BlockOreBase)block).getName().replace("Ore", ""));
	}

	private String getDisplayName(String name) {
		String result = "";
		result += I18n.translateToLocal("localisation." + name.replace("_", "").replace("Nether", "")).trim();
		result += " ";
		if (name.contains("Nether_")) {
			result = I18n.translateToLocal("advancements.nether.root.title").trim() + " " + result;
		}
		result += I18n.translateToLocal("localisation.Ore".trim());
		return result;
	}

}

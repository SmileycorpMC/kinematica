package net.smileycorp.kinematica.api.ores;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.smileycorp.kinematica.api.ores.blocks.IOreComposition;

import javax.annotation.Nullable;
import java.util.List;

public class ItemOre<T extends Block & IOreComposition> extends Item {
	
	final T block;
	final String name;

	public ItemOre(T block) {
		this.block = block;
		String[] localised = ((Block) block).getUnlocalizedName().split("\\.");
		name = localised[localised.length-1]+"_Chunk";
		String modid = block.getRegistryName().getResourceDomain();
		setUnlocalizedName(modid + "." + name.replace("_", ""));
		setRegistryName(new ResourceLocation(modid, name.toLowerCase()));
		setCreativeTab(Content.getCreativeTab());
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return this.block.getLocalizedName() + " " + this.block.localise("Chunk");
	}
	
	public String[] getComposition() {
		return block.getComposition();
	}

	public String getName() {
		return name;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
	    for (String string : getComposition()){
	    	tooltip.add(string);
	    }
	}
	
}
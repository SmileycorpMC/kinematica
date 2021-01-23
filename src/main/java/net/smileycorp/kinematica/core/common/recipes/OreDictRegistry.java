package net.smileycorp.kinematica.core.common.recipes;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.api.util.ElementUtils;
import net.smileycorp.kinematica.core.common.materials.ItemMetal;
import net.smileycorp.kinematica.core.common.materials.Materials;
import net.smileycorp.kinematica.core.common.world.blocks.WorldBlocks;

public class OreDictRegistry {
	
	public static void registerOreDicts() {
		OreDictionary.registerOre("mud", new ItemStack(WorldBlocks.MUD));
		
		/*for (ItemMetal item : Materials.metals) {
			List<String> metals = MetalRegistry.getMetalsFor(item.type);
			for (String metal : metals) {
					ItemStack stack = new ItemStack(item);
					NBTTagCompound tag = new NBTTagCompound();
					tag.setString("type", metal);
					stack.setTagCompound(tag);
				OreDictionary.registerOre(item.type.name().toLowerCase()
						+ metal.replace("_", ""), stack);
				for (String altName : ElementUtils.getOtherNames(metal)) {
					OreDictionary.registerOre(item.type.name().toLowerCase()
							+ altName, stack);
				}
			}
		}	
		for (String metal : MetalRegistry.getMetalsFor(MetalType.BLOCK)) {
			ItemStack stack = new ItemStack(Materials.BLOCK_METAL);
			NBTTagCompound tag = new NBTTagCompound();
			tag.setString("type", metal);
			stack.setTagCompound(tag);
	        OreDictionary.registerOre("block" + metal, stack);
	        for (String altName : ElementUtils.getOtherNames(metal)) {
				OreDictionary.registerOre("block" + altName, stack);
			}
		}*/
    }
}

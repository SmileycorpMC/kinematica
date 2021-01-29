package net.smileycorp.kinematica.core.common.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.smileycorp.kinematica.api.util.ElementUtils;
import net.smileycorp.kinematica.core.common.materials.BlockMetal;
import net.smileycorp.kinematica.core.common.materials.ItemMetal;
import net.smileycorp.kinematica.core.common.materials.Materials;
import net.smileycorp.kinematica.core.common.world.blocks.WorldBlocks;

public class OreDictRegistry {
	
	public static void registerOreDicts() {
		OreDictionary.registerOre("mud", new ItemStack(WorldBlocks.MUD));
		OreDictionary.registerOre("mud", new ItemStack(WorldBlocks.BAUXITE_SOIL));
		
		for (ItemMetal item : Materials.metal_items) {
			OreDictionary.registerOre(item.type.name().toLowerCase()
					+ item.metal.replace("_", ""), item);
			for (String altName : ElementUtils.getOtherNames(item.metal)) {
				OreDictionary.registerOre(item.type.name().toLowerCase()
						+ altName, item);
			}
		}	
		for (BlockMetal block : Materials.metal_blocks) {
			OreDictionary.registerOre("block" + block .metal.replace("_", ""), block);
			for (String altName : ElementUtils.getOtherNames(block.metal)) {
				OreDictionary.registerOre("block" + altName, block);
			}
		}
    }
}

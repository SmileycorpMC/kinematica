package net.smileycorp.kinematica.core.common.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.smileycorp.kinematica.api.util.ElementUtils;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.materials.BlockMetal;
import net.smileycorp.kinematica.core.common.materials.ItemMetal;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;
import net.smileycorp.kinematica.core.common.world.blocks.BlockSimpleOre;

public class OreDictRegistry {
	
	public static void registerOreDicts() {
		OreDictionary.registerOre("mud", KineWorld.MUD);
		OreDictionary.registerOre("stoneLimestone", KineWorld.LIMESTONE);
		OreDictionary.registerOre("stoneLimestone", KineWorld.DOLOMITE);
		OreDictionary.registerOre("stoneDolomite", KineWorld.DOLOMITE);
		OreDictionary.registerOre("logWood", KineWorld.SHARINGA_LOG);
		OreDictionary.registerOre("treeLeaves", KineWorld.SHARINGA_LEAVES);
		OreDictionary.registerOre("treeSapling", KineWorld.SHARINGA_SAPLING);
		OreDictionary.registerOre("plankWood", KineConstruction.SHARINGA_PLANKS.getBase());
		OreDictionary.registerOre("stairWood", KineConstruction.SHARINGA_PLANKS.getStairs());
		OreDictionary.registerOre("slabWood", KineConstruction.SHARINGA_PLANKS.getSlab());
		OreDictionary.registerOre("dustLimestone", new ItemStack(KineConstruction.DUSTS, 1, 1));
		OreDictionary.registerOre("dustCalcite", new ItemStack(KineConstruction.DUSTS, 1, 1));
		OreDictionary.registerOre("dustMercury",  new ItemStack(KineMaterials.MATERIAL_DUST, 1, 4));
		OreDictionary.registerOre("dustCinnabar", new ItemStack(KineMaterials.MATERIAL_DUST, 1, 4));
		
		for (ItemMetal item : KineMaterials.metal_items) {
			OreDictionary.registerOre(item.type.name().toLowerCase()
					+ item.metal.replace("_", ""), item);
			for (String altName : ElementUtils.getOtherNames(item.metal)) {
				OreDictionary.registerOre(item.type.name().toLowerCase()
						+ altName, item);
			}
		}	
		for (BlockMetal block : KineMaterials.metal_blocks) {
			OreDictionary.registerOre("block" + block .metal.replace("_", ""), block);
			for (String altName : ElementUtils.getOtherNames(block.metal)) {
				OreDictionary.registerOre("block" + altName, block);
			}
		}
		for (BlockSimpleOre block : KineWorld.ores) {
			String name = block.getName().replace("Nether", "").replace("_", "");
			OreDictionary.registerOre("ore" + name , block);
			for (String altName : ElementUtils.getOtherNames(name)) {
				OreDictionary.registerOre("ore" + altName, block);
			}
		}	
    }
}

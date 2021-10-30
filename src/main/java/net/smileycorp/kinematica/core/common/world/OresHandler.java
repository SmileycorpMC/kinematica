package net.smileycorp.kinematica.core.common.world;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OresHandler {
	
	public static List<Block> stoneBlocks = new ArrayList<Block>();
	public static List<Block> netherBlocks = new ArrayList<Block>();
	
	public static void setupOres() {
		
		stoneBlocks.add(KineWorld.LIMESTONE);
		stoneBlocks.add(KineWorld.DOLOMITE);
		
		for (ItemStack stack : OreDictionary.getOres("stone")) {
			if (stack.getItem() instanceof ItemBlock) {
				stoneBlocks.add(((ItemBlock) stack.getItem()).getBlock());
			}
		}
		for (ItemStack stack : OreDictionary.getOres("netherrack")) {
			if (stack.getItem() instanceof ItemBlock) {
				netherBlocks.add(((ItemBlock) stack.getItem()).getBlock());
			}
		}
	}
	
	public static void addStoneBlock(Block block) {
		stoneBlocks.add(block);
	}
	
	public static void addNetherBlock(Block block) {
		netherBlocks.add(block);
	}

}

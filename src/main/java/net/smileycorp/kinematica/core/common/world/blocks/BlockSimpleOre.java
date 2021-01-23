package net.smileycorp.kinematica.core.common.world.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.smileycorp.kinematica.core.common.BlockBase;

public class BlockSimpleOre extends BlockBase {

	protected ItemStack drop = null;
	
	public BlockSimpleOre(String name, int harvestLevel) {
		super(name+"_Ore", Material.ROCK, SoundType.STONE, 3.0F, 5.0F, harvestLevel);
	}
	
	public BlockSimpleOre(String name, int harvestLevel, ItemStack drop) {
		this(name, harvestLevel);
		this.drop=drop;
	}
		
}

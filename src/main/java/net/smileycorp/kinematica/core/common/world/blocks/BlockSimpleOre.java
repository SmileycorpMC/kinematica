package net.smileycorp.kinematica.core.common.world.blocks;

import java.util.Random;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.atlas.api.block.BlockUtils;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class BlockSimpleOre extends BlockBase {
	
	final private String name;
	protected ItemStack drop = null;
	int min;
	int max;
	
	public BlockSimpleOre(String name, int harvestLevel) {
		super(name+"_Ore", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 3.0F, 5.0F, harvestLevel, KineTabs.BLOCKS);
		this.name=name;
	}
	
	public BlockSimpleOre(String name, int harvestLevel, ItemStack drop, int min, int max) {
		this(name, harvestLevel);
		this.drop=drop;
		this.min=min;
		this.max=max;
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = new Random();
        if (drop!=null) {
        	drops.clear();
        	ItemStack stack = drop.copy();
        	stack.setCount(BlockUtils.getFortune(fortune, rand.nextInt(max-min)+min, rand));
        	drops.add(stack);
        }
        super.getDrops(drops, world, pos, state, fortune);
    }
	
	@Override
	public int quantityDropped(Random random) {
        return drop==null ? 1:0;
    }
	
	@Override
	public boolean usesCustomItemHandler(){
		return true;
	}
	
	public String getName() {
		return name;
	}
		
}

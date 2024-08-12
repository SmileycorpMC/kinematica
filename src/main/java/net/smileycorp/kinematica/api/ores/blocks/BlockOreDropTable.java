package net.smileycorp.kinematica.api.ores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.smileycorp.atlas.api.block.BlockUtils;
import net.smileycorp.atlas.api.recipe.WeightedOutputs;
import net.smileycorp.kinematica.api.ores.Content;

import java.util.HashMap;
import java.util.Random;

public class BlockOreDropTable extends BlockCompositeOre {
	
	public BlockOreDropTable(String name) {
		this(name, Content.getModid(), 1, Blocks.STONE);
	}
	
	public BlockOreDropTable(String name, String modid) {
		this(name, modid, 1, Blocks.STONE);
	}
	
	public BlockOreDropTable(String name, int harvest) {
		this(name, Content.getModid(), harvest, Blocks.STONE);
	}
	
	public BlockOreDropTable(String name, String modid, int harvest) {
		this(name, modid, harvest, Blocks.STONE);
	}
	
	public BlockOreDropTable(String name, Block base) {
		this(name, Content.getModid(), 1, base);
	}
		
	public BlockOreDropTable(String name, String modid, Block base) {
		this(name, modid, 1, base);
	}

	public BlockOreDropTable(String name, int harvest, Block base) {
		this(name, Content.getModid(), harvest, base);
	}
	
	public BlockOreDropTable(String name, String modid, int harvest, Block base) {
		super(name, modid, harvest, base);
	}
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = new Random();
        System.out.println(drops);
        drops.addAll(getDropTable(rand, fortune).getResults(rand));
        System.out.println(drops);
    }
	
	@Override
	public boolean hasSpecialDrop() {
		return true;
	}
	
	public WeightedOutputs<ItemStack> getDropTable(Random rand, int fortune) {
		return new WeightedOutputs<ItemStack>(BlockUtils.getFortune(fortune, rand), new HashMap<ItemStack, Integer>());
	}
	
}

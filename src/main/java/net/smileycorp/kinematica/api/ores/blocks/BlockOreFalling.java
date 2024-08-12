package net.smileycorp.kinematica.api.ores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.atlas.api.block.BlockUtils;
import net.smileycorp.kinematica.api.ores.OresAPI;
import net.smileycorp.kinematica.core.common.ModDefinitions;

import java.util.Random;

public class BlockOreFalling extends BlockCompositeOre {

	public BlockOreFalling(String name, Block base) {
		this(name, ModDefinitions.modid, 1, base);
	}

	public BlockOreFalling(String name, String modid, Block base) {
		this(name, modid, 1, base);
	}

	public BlockOreFalling(String name, int harvest, Block base) {
		this(name, ModDefinitions.modid,  harvest, base);
	}

	public BlockOreFalling(String name, String modid, int harvest, Block base) {
		super(name, modid, harvest, base);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return OresAPI.getOreItem(this);
    }

	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand) {
        return BlockUtils.getFortune(fortune, rand);
    }

}

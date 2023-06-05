package net.smileycorp.kinematica.core.common.world.block;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BauxiteGrassBlock extends GrassBlock {

	public BauxiteGrassBlock() {
		super(BlockBehaviour.Properties.copy(Blocks.GRASS));
	}

}

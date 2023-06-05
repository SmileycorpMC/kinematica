package net.smileycorp.kinematica.core.common.world.block;

import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class OreBlock extends Block implements EntityBlock {

	private final Supplier<Block> defaultBase;

	public OreBlock(Properties properties, Supplier<Block> defaultBase) {
		super(properties);
		this.defaultBase = defaultBase;
	}

	@Override
	public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new OreBlockEntity(pos, state, defaultBase.get());
	}

}

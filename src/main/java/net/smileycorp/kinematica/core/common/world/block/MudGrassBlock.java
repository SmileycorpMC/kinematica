package net.smileycorp.kinematica.core.common.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

public class MudGrassBlock extends GrassBlock {

	protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 14.0D, 16.0D);

	public MudGrassBlock() {
		super(Properties.copy(Blocks.GRASS_BLOCK));
	}

	@Override
	public VoxelShape getCollisionShape(BlockState p_221561_, BlockGetter p_221562_, BlockPos p_221563_, CollisionContext p_221564_) {
		return SHAPE;
	}

	@Override
	public VoxelShape getBlockSupportShape(BlockState p_221566_, BlockGetter p_221567_, BlockPos p_221568_) {
		return Shapes.block();
	}

	@Override
	public VoxelShape getVisualShape(BlockState p_221556_, BlockGetter p_221557_, BlockPos p_221558_, CollisionContext p_221559_) {
		return Shapes.block();
	}

	@Override
	public float getShadeBrightness(BlockState p_221552_, BlockGetter p_221553_, BlockPos p_221554_) {
		return 0.2F;
	}

}

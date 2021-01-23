package net.smileycorp.kinematica.core.common.world.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class BlockSharingaLog extends BlockLog {

	public BlockSharingaLog() {
		super();
		String name = "Sharinga_Log";
		setCreativeTab(KineTabs.BLOCKS);
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
	}
	
	protected BlockStateContainer createBlockState() {
	        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }

	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		//if (World.getTileEntity(pos) instanceof TileEntityMicrandraLog) {
			//world.removeTileEntity(pos);
		//}
	}
}

package net.smileycorp.kinematica.core.common.world.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityLatexLog;

public class BlockSharingaLog extends BlockLog {

	public BlockSharingaLog() {
		super();
		String name = "Sharinga_Log";
		setCreativeTab(KineTabs.BLOCKS);
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y));
	}
	
	@Override
	protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS});
    }
	
	public IBlockState getStateFromMeta(int meta)	{
        switch (meta) {
        case 0:
            	return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
		case 4:
            	return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
		case 8:
            	return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
		default:
            	return this.getDefaultState().withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }
    }

    public int getMetaFromState(IBlockState state) {
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)) {
    	case Y:
    			return 0;
		case X:
                 return 4;
		case Z:
            	return 8;
		default:
            	return 12;
        }
    }

	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (world.getTileEntity(pos) instanceof TileEntityLatexLog) {
			world.removeTileEntity(pos);
		}
	}
}

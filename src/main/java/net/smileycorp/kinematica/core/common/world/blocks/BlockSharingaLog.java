package net.smileycorp.kinematica.core.common.world.blocks;

import net.minecraft.block.BlockLog;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityLatexLog;

public class BlockSharingaLog extends BlockLog {
	
	public static PropertyBool LEAKING = PropertyBool.create("leaking");
	
	public BlockSharingaLog() {
		super();
		String name = "Sharinga_Log";
		setCreativeTab(KineTabs.BLOCKS);
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		this.setDefaultState(this.blockState.getBaseState().withProperty(LOG_AXIS, BlockLog.EnumAxis.Y).withProperty(LEAKING, false));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {LOG_AXIS, LEAKING});
    }
	
	@Override
	public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return 20;
	}
	
	@Override
	public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		return 5;
	}
	
	@Override
    public int getMetaFromState(IBlockState state) {
		boolean leaking = state.getValue(LEAKING);
        switch ((BlockLog.EnumAxis)state.getValue(LOG_AXIS)) {
    	case Y:
    			return leaking ? 0:1;
		case X:
                 return leaking ? 4:5;
		case Z:
            	return leaking ? 8:9;
		default:
            	return leaking ? 12:13;
        }
    }
    
    @Override
    public IBlockState getStateFromMeta(int meta)	{
    	IBlockState state = this.getDefaultState();
    	if (meta%4==1) {
    		state =  state.withProperty(LEAKING, true);
    		meta--;
    	}
        switch (meta) {
        case 0:
            	return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Y);
		case 4:
            	return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.X);
		case 8:
            	return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.Z);
		default:
            	return state.withProperty(LOG_AXIS, BlockLog.EnumAxis.NONE);
        }
    }
    
    @Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (world.getTileEntity(pos) instanceof TileEntityLatexLog) {
			world.removeTileEntity(pos);
		}
	}
	
    @Override
	public boolean hasTileEntity(IBlockState state) {
        return state.getValue(LEAKING);
    }
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityLatexLog();
	}
}

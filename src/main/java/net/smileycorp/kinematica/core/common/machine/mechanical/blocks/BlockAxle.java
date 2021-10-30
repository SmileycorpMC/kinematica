package net.smileycorp.kinematica.core.common.machine.mechanical.blocks;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class BlockAxle extends BlockBase implements ITileEntityProvider {
	
	PropertyEnum<Axis> AXIS = PropertyEnum.create("axis", Axis.class);
	
	public BlockAxle(String name, Material material, SoundType sound, String tool, int h) {
		super(name, ModDefinitions.modid, material, sound, 0.5F, 0.3f, tool, 0, KineTabs.MACHINES);
		setDefaultState(this.blockState.getBaseState().withProperty(AXIS, Axis.X));
		hasTileEntity=true;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return null;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AXIS});
    }
	
	@Override
    public int getMetaFromState(IBlockState state) {
		return state.getValue(AXIS).ordinal();
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)	{
		return getDefaultState().withProperty(AXIS, Axis.values()[meta]);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

}

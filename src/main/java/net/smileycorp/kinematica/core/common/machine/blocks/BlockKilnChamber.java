package net.smileycorp.kinematica.core.common.machine.blocks;

import java.util.Random;

import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.atlas.api.util.DirectionUtils;
import net.smileycorp.kinematica.core.common.Kinematica;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKiln;

public class BlockKilnChamber extends BlockBase {
	
	public static final PropertyDirection facing = BlockHorizontal.FACING;
		
	public BlockKilnChamber() {
		super("Kiln", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 6f, 0, null);
		setDefaultState(this.blockState.getBaseState().withProperty(facing, EnumFacing.NORTH));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {facing});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)	{
		return this.getDefaultState().withProperty(facing, DirectionUtils.getXZDirection(meta));
    }
	
	@Override
    public int getMetaFromState(IBlockState state) {
    	return DirectionUtils.getXZMeta(state.getValue(facing));
    }
	
	@Override
	public boolean usesCustomItemHandler(){
		return true;
	}
	
	@Override
	public int quantityDropped(Random random) {
        return 1;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return KineConstruction.FIRED_MUDBRICK.getBase().getItemDropped(state, rand, fortune);
    }
	
	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
			BlockPos newpos = pos.down().offset(facing, -1);
			TileEntity tileentity = world.getTileEntity(newpos);
            if (tileentity instanceof TileEntityKiln) {
            	player.openGui(Kinematica.INSTANCE, 0, world, newpos.getX(), newpos.getY(), newpos.getZ());
            	 return true;
        	}
       	}

        return false;
    }
	

}

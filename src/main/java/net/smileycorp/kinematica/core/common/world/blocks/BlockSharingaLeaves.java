package net.smileycorp.kinematica.core.common.world.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Nonnull;

import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlockSharingaLeaves extends BlockLeaves {

	public BlockSharingaLeaves() {
		String name = "Sharinga_Leaves";
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		setCreativeTab(KineTabs.BLOCKS);
		setDefaultState(this.blockState.getBaseState().withProperty(CHECK_DECAY, false).withProperty(DECAYABLE, true));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {CHECK_DECAY, DECAYABLE});
    }
	
	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world,
			BlockPos pos, int fortune) {
		List<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(this));
		return drops;
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
	  public Item getItemDropped(IBlockState state, Random rand, int fortune) {
	    return Item.getItemFromBlock(KineWorld.SHARINGA_SAPLING);
	  }
	
	@Override
	public EnumType getWoodType(int meta) {
		return null;
	}
	
	@Override
	public boolean shouldSideBeRendered(@Nonnull IBlockState blockState, @Nonnull IBlockAccess blockAccess, @Nonnull BlockPos pos, @Nonnull EnumFacing side) {
	    this.leavesFancy = !Blocks.LEAVES.isOpaqueCube(blockState);
	    return super.shouldSideBeRendered(blockState, blockAccess, pos, side);
	}
	
	 @Override
	  public IBlockState getStateFromMeta(int meta) {
	    return this.getDefaultState().withProperty(DECAYABLE, meta!=4).withProperty(CHECK_DECAY, meta==8);
	  }
	
	  @Override
	  public int getMetaFromState(IBlockState state) {
	    if(!state.getValue(DECAYABLE)) {
	      return 4;
	    }
	
	    if(state.getValue(CHECK_DECAY)) {
	      return 8;
	    }
	
	    return 0;
	  }
	  
	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
	    return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
	    return Blocks.LEAVES.isOpaqueCube(state);
	  }
	
	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer() {
	    return Blocks.LEAVES.getBlockLayer();
	}

}

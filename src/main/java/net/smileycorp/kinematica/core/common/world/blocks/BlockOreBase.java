package net.smileycorp.kinematica.core.common.world.blocks;

import java.util.Random;
import java.util.function.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.atlas.api.block.BlockUtils;
import net.smileycorp.atlas.api.block.PropertyOpenString;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKineOre;

public class BlockOreBase extends BlockBase implements ITileEntityProvider {

	public static PropertyOpenString BACKGROUND = new PropertyOpenString("background", new Predicate<String>(){
		@Override
		public boolean test(String type) {
			return true;
		}

	});

	private final Block base;
	protected ItemStack drop = null;
	int min;
	int max;

	public BlockOreBase(String name, int harvestLevel) {
		this(name, ModDefinitions.modid, harvestLevel);
	}

	public BlockOreBase(String name, String modid, int harvestLevel) {
		this(name, modid, harvestLevel, Blocks.STONE);
	}

	public BlockOreBase(String name, int harvestLevel, ItemStack drop, int min, int max) {
		this(name, ModDefinitions.modid, harvestLevel, drop, min, max, Blocks.STONE);
	}

	@SuppressWarnings("deprecation")
	public BlockOreBase(String name, String modid, int harvestLevel, Block base) {
		super(name+"_Ore", modid, base.getMaterial(base.getDefaultState()), base.getSoundType(), 3.0F,
				5.0F, base.getHarvestTool(base.getDefaultState()), harvestLevel, KineTabs.BLOCKS);
		this.base=base;
		this.name=name;
	}

	public BlockOreBase(String name, String modid, int harvestLevel, ItemStack drop, int min, int max, Block base) {
		this(name, modid, harvestLevel, base);
		this.drop=drop;
		this.min=min;
		this.max=max;
	}

	public BlockOreBase(String name, int harvestLevel, ItemStack drop, int min, int max, Block base) {
		this(name, ModDefinitions.modid, harvestLevel, drop, min, max, base);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random rand = new Random();
        if (drop!=null) {
        	drops.clear();
        	ItemStack stack = drop.copy();
        	stack.setCount(BlockUtils.getFortune(fortune, rand.nextInt(max-min)+min, rand));
        	drops.add(stack);
        }
        super.getDrops(drops, world, pos, state, fortune);
    }

	@Override
	public int quantityDropped(Random random) {
        return drop==null ? 1:0;
    }

	@Override
	public boolean usesCustomItemHandler(){
		return true;
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new ExtendedBlockState(this, new IProperty[0], new IUnlistedProperty[]{BACKGROUND});
	}

	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
	    TileEntity te = world.getTileEntity(pos);
	    if(te != null && te instanceof TileEntityKineOre) {
	    	return ((IExtendedBlockState)state).withProperty(BACKGROUND,((TileEntityKineOre) te).getBackgroundBlock());
	    }
	    return super.getExtendedState(state, world, pos);
	 }

	@Override
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.TRANSLUCENT;
    }

	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		world.removeTileEntity(pos);
	}

    @Override
	public boolean hasTileEntity(IBlockState state) {
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityKineOre(base.getRegistryName().toString());
	}

	@Override
	public boolean useInventoryVariant() {
		return true;
	}

}

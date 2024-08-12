package net.smileycorp.kinematica.api.ores.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
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
import net.smileycorp.kinematica.api.ores.Content;
import net.smileycorp.kinematica.api.ores.OresAPI;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKineOre;
import net.smileycorp.kinematica.core.common.world.blocks.BlockOreBase;

import java.util.Random;

public class BlockCompositeOre extends BlockBase implements IOreComposition, ITileEntityProvider {

	private final Block base;

	public BlockCompositeOre(String name) {
		this(name, Content.getModid(), 1, Blocks.STONE);
	}

	public BlockCompositeOre(String name, String modid) {
		this(name, modid, 1, Blocks.STONE);
	}

	public BlockCompositeOre(String name, int harvest) {
		this(name, Content.getModid(), harvest, Blocks.STONE);
	}

	public BlockCompositeOre(String name, String modid, int harvest) {
		this(name, modid, harvest, Blocks.STONE);
	}

	public BlockCompositeOre(String name, Block base) {
		this(name, Content.getModid(), 1, base);
	}

	public BlockCompositeOre(String name, String modid, Block base) {
		this(name, modid, 1, base);
	}

	public BlockCompositeOre(String name, int harvest, Block base) {
		this(name, Content.getModid(), harvest, base);
	}

	@SuppressWarnings("deprecation")
	public BlockCompositeOre(String name, String modid, int harvest, Block base) {
		super(name, modid, base.getMaterial(base.getDefaultState()), base.getSoundType(), 3.0F,
				5.0F, base.getHarvestTool(base.getDefaultState()), harvest, Content.getCreativeTab());
		this.base=base;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return OresAPI.getOreItem(this);
    }

	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand) {
        return BlockUtils.getFortune(fortune, rand);
    }

	@Override
	public BlockStateContainer createBlockState() {
		return new ExtendedBlockState(this, new IProperty[0], new IUnlistedProperty[]{BlockOreBase.BACKGROUND});
	}

	@Override
	public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos) {
	    TileEntity te = world.getTileEntity(pos);
	    if(te != null && te instanceof TileEntityKineOre) {
	    	return ((IExtendedBlockState)state).withProperty(BlockOreBase.BACKGROUND,((TileEntityKineOre) te).getBackgroundBlock());
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
	public Block getBase() {
		return base;
	}

}

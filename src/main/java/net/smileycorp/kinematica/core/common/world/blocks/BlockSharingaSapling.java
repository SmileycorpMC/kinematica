package net.smileycorp.kinematica.core.common.world.blocks;

import java.util.Random;

import net.minecraft.block.BlockSapling;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import net.smileycorp.atlas.api.block.IBlockProperties;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.world.gen.WorldGenSharinga;

public class BlockSharingaSapling extends BlockSapling implements IBlockProperties {
	
	public BlockSharingaSapling() {
		super();
		String name="Sharinga_Sapling";
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		setCreativeTab(KineTabs.BLOCKS);
		setDefaultState(this.blockState.getBaseState().withProperty(STAGE, Integer.valueOf(0)));
		setSoundType(SoundType.PLANT);
	}
	
	@Override
	public void generateTree(World world, BlockPos pos, IBlockState state, Random rand) {
        if (!net.minecraftforge.event.terraingen.TerrainGen.saplingGrowTree(world, rand, pos)) return;
        WorldGenerator worldgenerator = new WorldGenSharinga(false);
        IBlockState iblockstate2 = Blocks.AIR.getDefaultState();
        world.setBlockState(pos, iblockstate2, 4);
        world.setBlockToAir(pos);
        if (!worldgenerator.generate(world, rand, pos)){
        	world.setBlockState(pos, state, 4);
        } 
	}
	
	@Override
	public int damageDropped(IBlockState state) {
        return 0;
    }

    @Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)	{
    	items.add(new ItemStack(this));
    }
    
    @Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(STAGE, meta);
    }

    @Override
	public int getMetaFromState(IBlockState state) {
        return state.getValue(STAGE);
    }
    
    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {TYPE, STAGE});
    }
    
    @Override
    public boolean useInventoryVariant(){
		return true;
	}
}

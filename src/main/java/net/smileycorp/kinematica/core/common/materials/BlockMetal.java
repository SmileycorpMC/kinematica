package net.smileycorp.kinematica.core.common.materials;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.kinematica.core.common.KineTabs;

@SuppressWarnings("unused")
public class BlockMetal extends BlockBase {
	
	public final String metal;
	
	public BlockMetal(String modid, String metal) {
		super(metal+"_Block", modid, Material.IRON, SoundType.METAL, 3.5f, 7f, 0, KineTabs.BLOCKS);
		this.metal=metal;
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
        return 0;
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState();
    }
	
	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
        return true;
    }
	
	/* old code from when block type was nbt (maybe reuse for rusting later?)
	@Override
	public boolean hasTileEntity(IBlockState state) {
        return true;
    }
	
	@Override
	public TileEntity createTileEntity(World world, IBlockState state) {
		return new TileEntityMetalBlock();
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.removeTileEntity(pos);
    }
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		ItemStack stack = new ItemStack(this);
		NBTTagCompound tag = new NBTTagCompound();
		if (world.getTileEntity(pos) instanceof TileEntityMetalBlock) {
			tag.setString("type", ((TileEntityMetalBlock)world.getTileEntity(pos)).getType());
			stack.setTagCompound(tag);
		}
		return stack;
    }
	
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		ItemStack stack = new ItemStack(this);
		NBTTagCompound tag = new NBTTagCompound();
		if (world.getTileEntity(pos) instanceof TileEntityMetalBlock) {
			tag.setString("type", ((TileEntityMetalBlock)world.getTileEntity(pos)).getType());
			stack.setTagCompound(tag);
		}	
		drops.add(stack);
    }
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		NBTTagCompound nbt = stack.getTagCompound();
		if (nbt!=null) {
			if (nbt.hasKey("type")) {
				String type = nbt.getString("type");
				if (world.getTileEntity(pos) instanceof TileEntityMetalBlock) {
					((TileEntityMetalBlock) world.getTileEntity(pos)).setType(type);
				}	
			}
		}
   }
	
	//From BlockFlowerPot, should delay until drops are spawned, before block is broken
	@Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest)
    {
        if (willHarvest) return true; 
        return super.removedByPlayer(state, world, pos, player, willHarvest);
    }
    @Override
    public void harvestBlock(World world, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack tool)
    {
        super.harvestBlock(world, player, pos, state, te, tool);
        world.setBlockToAir(pos);
    }*/
	
}

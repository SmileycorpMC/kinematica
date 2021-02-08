package net.smileycorp.kinematica.core.common.machine.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.kinematica.core.common.Kinematica;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKiln;

public class BlockKilnFire extends Block implements ITileEntityProvider {
	
	public static final PropertyBool burning = PropertyBool.create("burning");
	
	public BlockKilnFire() {
		super(Material.FIRE);
		String name = "Kiln_Fire";
		setRegistryName(ModDefinitions.getResource(name));
		setUnlocalizedName(ModDefinitions.getName(name));
		hasTileEntity=true;
		setHardness(-1);
		setResistance(14f);
		setDefaultState(this.blockState.getBaseState().withProperty(burning, false));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {burning});
    }
	
	@Override
	public IBlockState getStateFromMeta(int meta)	{
		return meta==1 ? this.getDefaultState().withProperty(burning, true):this.getDefaultState().withProperty(burning, false);
    }
	
	@Override
    public int getMetaFromState(IBlockState state) {
		return state.getValue(burning) ? 1:0;
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityKiln();
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)	{
        return false;
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            TileEntity tileentity = world.getTileEntity(pos);
            if (tileentity instanceof TileEntityKiln) {
            	player.openGui(Kinematica.INSTANCE, 1, world, pos.getX(), pos.getY(), pos.getZ());
            }
            return true;
        }
    }
	
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntity tileentity = world.getTileEntity(pos);
        if (tileentity instanceof TileEntityKiln) {
            InventoryHelper.dropInventoryItems(world, pos, (TileEntityKiln)tileentity);
        }
        super.breakBlock(world, pos, state);
    }
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
}

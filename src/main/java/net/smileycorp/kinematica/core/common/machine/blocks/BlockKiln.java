package net.smileycorp.kinematica.core.common.machine.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.atlas.api.interfaces.IBlockProperties;
import net.smileycorp.kinematica.core.common.Kinematica;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityKiln;

public class BlockKiln extends Block implements IBlockProperties {

	public BlockKiln() {
		super(Material.GOURD);
		String name = "Smoldering_Kiln";
		this.setRegistryName(ModDefinitions.getResource(name));
		this.setUnlocalizedName(ModDefinitions.getName(name));
	}
	
	@Override
	public boolean usesCustomItemHandler(){
		return true;
	}
	
	public int quantityDropped(Random random) {
        return 0;
	}
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
        	for (int i = -1; i < 2; i++) {
        		for (int j = -1; j < 2; j++) {
        			for (int k = -1; k < 2; k++) {
        				BlockPos newpos = pos.east(i).up(j).north(k);
        				TileEntity tileentity = world.getTileEntity(newpos);
        	            if (tileentity instanceof TileEntityKiln) {
        	            	player.openGui(Kinematica.INSTANCE, 0, world, newpos.getX(), newpos.getY(), newpos.getZ());
        	            	 return true;
        	            }
                	}
            	}
        	}
        }
        return true;
    }
	

}

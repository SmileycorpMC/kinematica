package net.smileycorp.kinematica.core.common.machine;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityBasin;

public class BlockWoodBasin extends BlockBase implements ITileEntityProvider {

	public BlockWoodBasin() {
		super("Basin_Wood", ModDefinitions.modid, Material.WOOD, SoundType.WOOD, 2.0F, 5.0F, 0, KineTabs.MACHINES);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBasin(1000, 250);
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		if (world.getTileEntity(pos) instanceof TileEntityBasin) {
			world.removeTileEntity(pos);
		}
	}

}

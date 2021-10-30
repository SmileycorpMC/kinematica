package net.smileycorp.kinematica.core.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidTankProperties;
import net.minecraftforge.fluids.capability.TileFluidHandler;

public class TileEntityBasin extends TileFluidHandler {
	
	protected final int maxTemp;
	
	public TileEntityBasin(int capacity, int maxTemp) {
		this.maxTemp = maxTemp;
		tank = new FluidTank(capacity);
		tank.setTileEntity(this);
		tank.setCanFill(true);
		tank.setCanDrain(true);
	}
	
	@Override
	public boolean hasFastRenderer() {
        return true;
    }
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), getUpdateTag());
	}
	
	public int getCapacity() {
		return tank.getCapacity();
	}
	
	public FluidStack getStoredFluid() {
		return tank.getFluid();
	}
	
	public boolean interact(World world, EntityPlayer player, ItemStack stack, EnumHand hand, EnumFacing facing) {
		IFluidHandler stackFluid = FluidUtil.getFluidHandler(stack);
		if (stackFluid.getTankProperties() != null) {
			for  (IFluidTankProperties props : stackFluid.getTankProperties()) {
				
			}
		}
		FluidUtil.interactWithFluidHandler(player, hand, world, pos, facing);
		return false;
	}

}

package net.smileycorp.kinematica.core.common.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

import net.smileycorp.atlas.api.util.DirectionUtils;

public class TileEntityLatexLog extends TileEntity {
	
	Random rand = new Random();
	final int maxCapacity = 3000;
	
	EnumFacing facing;
	int storedLatex = 0;
	
	public TileEntityLatexLog() {
		if (facing==null) {
			facing=DirectionUtils.getXZDirection(rand.nextInt(4));
			System.out.println("set latex tile entity with facing " + facing + " at " +pos);
		}
	}
	
	@Override
	public boolean hasFastRenderer() {
        return true;
    }
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
       super.readFromNBT(tag);
       facing = EnumFacing.getFront(tag.getInteger("facing"));
       storedLatex=tag.getInteger("storedLatex");
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        tag.setInteger("facing", facing.getIndex());
        tag.setInteger("storedLatex", storedLatex);
        return tag;
    }
	
    @Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		tag.setInteger("facing", facing.getIndex());
        tag.setInteger("storedLatex", storedLatex);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		super.handleUpdateTag(tag);
		facing = EnumFacing.getFront(tag.getInteger("facing"));
	    storedLatex=tag.getInteger("storedLatex");
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), getUpdateTag());
	}
	
	public int setNaturalLatex() {
		storedLatex = (rand.nextInt(40)+10)*50;
		return storedLatex;
	}
	
	public int getLatex() {
		return storedLatex;
	}
	
	public EnumFacing getFacing() {
		return facing;
	}

}

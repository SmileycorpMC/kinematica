package net.smileycorp.kinematica.core.common.tileentity;

import java.awt.Color;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.smileycorp.kinematica.api.metal.MetalRegistry;

public class TileEntityMetalBlock extends TileEntity {
	
	private String type;
	
	public TileEntityMetalBlock() {}

	public String getType() {
		if (type==null) {
			return "Null";
		}
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
		this.markDirty();
	}
	
	public Color getColour() {
		return MetalRegistry.getColour(type);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
       super.readFromNBT(compound);
       this.type = compound.getString("type");
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        if (type == null) {
        	type = "null";
        }
        compound.setString("type", type);
        return compound;
    }
	
    @Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		tag.setString("type", type);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(NBTTagCompound compound) {
		super.handleUpdateTag(compound);
		type = compound.getString("type");
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), getUpdateTag());
	}
	
	

}

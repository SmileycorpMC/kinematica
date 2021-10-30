package net.smileycorp.kinematica.core.common.tileentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityKineOre extends TileEntity {
	
	private String background;
	
	public TileEntityKineOre() {
		this("minecraft:stone");
	}
	
	public ResourceLocation getOre() {
		return this.getBlockType().getRegistryName();
	}
	
	public TileEntityKineOre(String background) {
		this.background = background;
	}
	
	public String getBackgroundBlock(){
		return background;
	}
	
	public void setBackgroundBlock(String background){
		this.background=background;
		this.markDirty();
	}
	
	@Override
	public boolean hasFastRenderer() {
        return true;
    }
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
       super.readFromNBT(compound);
       this.background = compound.getString("background");
    }

	@Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setString("background", background);
        return compound;
    }
	
    @Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = super.getUpdateTag();
		tag.setString("background", background);
		return tag;
	}
	
	@Override
	public void handleUpdateTag(NBTTagCompound compound) {
		super.handleUpdateTag(compound);
		background = compound.getString("background");
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), getUpdateTag());
	}
}

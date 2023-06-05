package net.smileycorp.kinematica.core.common.world.block;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class OreBlockEntity extends BlockEntity {

	private ResourceLocation background;

	public OreBlockEntity(BlockPos pos, BlockState state, Block background) {
		super(KineWorld.ORE_BLOCK_ENTITY.get(), pos, state);
		this.background = ForgeRegistries.BLOCKS.getKey(background);
	}

	public ResourceLocation getOre() {
		return ForgeRegistries.BLOCKS.getKey(this.getBlockState().getBlock());
	}

	public ResourceLocation getBackground() {
		return background;
	}

	public void setBackground(Block background) {
		this.background = ForgeRegistries.BLOCKS.getKey(background);
		this.setChanged();
	}

	@Override
	public void load(CompoundTag compound) {
		super.load(compound);
		background = new ResourceLocation(compound.getString("background"));
	}

	@Override
	public void saveAdditional(CompoundTag compound) {
		super.saveAdditional(compound);
		compound.putString("background", background.toString());
	}

	@Override
	public CompoundTag getUpdateTag() {
		CompoundTag tag = super.getUpdateTag();
		tag.putString("background", background.toString());
		return tag;
	}

	@Override
	public void handleUpdateTag(CompoundTag compound) {
		super.handleUpdateTag(compound);
		background = new ResourceLocation(compound.getString("background"));
	}

	@Override
	public ClientboundBlockEntityDataPacket getUpdatePacket(){
		return ClientboundBlockEntityDataPacket.create(this);
	}

	@Override
	public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket pkt){
		CompoundTag compound = pkt.getTag();
		background = new ResourceLocation(compound.getString("background"));
	}

}

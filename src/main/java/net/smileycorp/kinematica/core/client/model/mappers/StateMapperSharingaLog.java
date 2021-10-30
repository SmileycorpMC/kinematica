package net.smileycorp.kinematica.core.client.model.mappers;

import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import net.smileycorp.kinematica.core.common.ModDefinitions;

@SideOnly(Side.CLIENT)
public class StateMapperSharingaLog extends StateMapperBase {
	
	@Override
	protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
		String statename = "axis="+state.getValue(BlockLog.LOG_AXIS).toString();
		return new ModelResourceLocation(ModDefinitions.getResource("sharinga_log"), statename);
	}

}

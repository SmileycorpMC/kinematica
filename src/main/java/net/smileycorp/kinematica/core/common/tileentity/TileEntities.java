package net.smileycorp.kinematica.core.common.tileentity;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class TileEntities {
	public static void register() {
		registerTileEntity(TileEntityKiln.class, "Kiln");
		registerTileEntity(TileEntityMetalBlock.class, "MetalBlock");
	}
	
	public static void registerTileEntity (Class <? extends TileEntity> te, String name) {
		GameRegistry.registerTileEntity(te, ModDefinitions.getResource(name));
	}
}

package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockSphalerite extends BlockCompositeOre {

	public BlockSphalerite() {
		super("Sphalerite", 1);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Zinc"),
				"25% " + localise("Iron"),
				"15% "+ localise("Sulphur")};
	}

}

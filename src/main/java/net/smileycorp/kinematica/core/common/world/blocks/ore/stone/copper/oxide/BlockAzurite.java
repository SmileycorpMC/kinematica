package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockAzurite extends BlockCompositeOre {

	public BlockAzurite() {
		super("Azurite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"57% " + localise("Copper"),
				"29% " + localise("Carbon"),
				"14% " + localise("Osmium")};
	}

}

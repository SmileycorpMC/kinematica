package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockCuprite extends BlockCompositeOre {

	public BlockCuprite() {
		super("Cuprite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"90% "  + localise("Copper"),
				"10% " + localise("Gold")};
	}

}

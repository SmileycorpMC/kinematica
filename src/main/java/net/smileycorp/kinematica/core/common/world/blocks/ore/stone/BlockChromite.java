package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockChromite extends BlockCompositeOre {

	public BlockChromite() {
		super("Chromite", 3);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Chromium"),
				"30% " + localise("Iron"),
				"10% " + localise("Platinum")};
	}

}

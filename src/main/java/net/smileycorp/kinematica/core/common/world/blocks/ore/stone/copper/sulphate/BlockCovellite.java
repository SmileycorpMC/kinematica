package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockCovellite extends BlockCompositeOre {

	public BlockCovellite() {
		super("Covellite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Copper"),
				"25% " + localise("Sulphur"),
				"15% " + localise("Nickel")};
	}

}

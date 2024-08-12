package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockChalcocite extends BlockCompositeOre {

	public BlockChalcocite() {
		super("Chalcocite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"55% " + localise("Copper"),
				"33% " + localise("Sulphur"),
				"12% " + localise("Platinum")};
	}

}

package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockBornite extends BlockCompositeOre {

	public BlockBornite() {
		super("Bornite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"50% " + localise("Copper"),
				"40% " + localise("Sulphur"),
				"10% " + localise("Iron")};
	}

}

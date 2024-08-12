package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockRhodonite extends BlockCompositeOre {

	public BlockRhodonite() {
		super("Rhodonite", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"55% " + localise("Manganese"),
				"30% " + localise("Silicon"),
				"15% " + localise("Magnesium")};
	}

}

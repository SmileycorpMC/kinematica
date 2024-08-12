package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockMaldonite extends BlockCompositeOre {

	public BlockMaldonite() {
		super("Maldonite", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"70% " + localise("Gold"),
				"20% " + localise("Bismuth"),
				"10% " + localise("Palladium")};
	}

}

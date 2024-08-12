package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockOsmian extends BlockCompositeOre {
	
	public BlockOsmian() {
		super("Osmian", 3);
	}

	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Osmium"),
				"30% " + localise("Iridium") ,
				"10% " + localise("Palladium")};
	}
}

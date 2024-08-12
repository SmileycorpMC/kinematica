package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockGalena extends BlockCompositeOre {

	public BlockGalena() {
		super("Galena", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Lead"),
				"25% " + localise("Silver"),
				"15% " + localise("Sulphur")};
	}

}

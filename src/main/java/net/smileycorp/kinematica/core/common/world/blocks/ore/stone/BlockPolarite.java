package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockPolarite extends BlockCompositeOre {

	public BlockPolarite() {
		super("Polarite", 3);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"50% " + localise("Palladium"),
				"25% " + localise("Lead"),
				"25% " + localise("Bismuth")};
	}

}

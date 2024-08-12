package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockErythrite extends BlockCompositeOre {

	public BlockErythrite() {
		super("Erythrite", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Cobalt"),
				"40% " + localise("Arsenic")};
	}

}

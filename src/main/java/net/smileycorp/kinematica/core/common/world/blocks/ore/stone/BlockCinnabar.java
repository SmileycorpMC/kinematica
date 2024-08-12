package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockCinnabar extends BlockCompositeOre {

	public BlockCinnabar() {
		super("Cinnabar", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"70% " + localise("Mercury"),
				"30% " + localise("Sulphur")};
	}

}

package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.platinum;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockVysotskite extends BlockCompositeOre {

	public BlockVysotskite() {
		super("Vysotskite", 3);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"53% " + localise("Palladium"),
				"28% " + localise("Nickel"),
				"19% " + localise("Sulphur")};
	}
	
}

package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockCarrollite extends BlockCompositeOre {

	public BlockCarrollite() {
		super("Carrollite", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"43% " + localise("Cobalt"),
				"33% " + localise("Nickel"),
				"24% " + localise("Sulphur")};
	}

}

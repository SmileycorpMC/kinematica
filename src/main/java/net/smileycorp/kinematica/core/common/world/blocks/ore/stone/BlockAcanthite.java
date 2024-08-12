package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockAcanthite extends BlockCompositeOre {

	public BlockAcanthite() {
		super("Acanthite", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"65% " + localise("Silver"),
				"30% " + localise("Sulphur"),
				"5% " + localise("Gold")};
	}

}

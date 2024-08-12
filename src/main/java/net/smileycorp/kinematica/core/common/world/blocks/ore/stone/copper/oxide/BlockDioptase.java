package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockDioptase extends BlockCompositeOre {

	public BlockDioptase() {
		super("Dioptase", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"76% " + localise("Copper"),
				"24% " + localise("Silicon")};
	}

}

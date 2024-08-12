package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockBismuthinite extends BlockCompositeOre {

	public BlockBismuthinite() {
		super("Bismuthinite", 1);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"70% " + localise("Bismuth"),
				"30% " + localise("Sulphur")};
	}

}

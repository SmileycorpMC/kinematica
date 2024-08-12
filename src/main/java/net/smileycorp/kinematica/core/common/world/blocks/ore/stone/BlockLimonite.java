package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockLimonite extends BlockCompositeOre {

	public BlockLimonite() {
		super("Limonite");
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"60% " + localise("Iron"),
				"30% " + localise("Nickel"),
				"10% " + localise("Platinum")};
	}

}

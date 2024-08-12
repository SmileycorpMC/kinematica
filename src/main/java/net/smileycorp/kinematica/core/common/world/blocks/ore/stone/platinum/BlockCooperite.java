package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.platinum;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockCooperite extends BlockCompositeOre {

	public BlockCooperite() {
		super("Cooperite", 3);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"49% " + localise("Platinum"),
				"35% " + localise("Nickel"),
				"16% " + localise("Sulphur")};
	}
	
}

package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.platinum;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockBraggite extends BlockCompositeOre {

	public BlockBraggite() {
		super("Braggite", 3);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"50% " + localise("Platinum"),
				"21% " + localise("Palladium"),
				"16% " + localise("Sulphur")};
	}
	
}

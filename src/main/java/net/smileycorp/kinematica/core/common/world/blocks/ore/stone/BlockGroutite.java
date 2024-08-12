package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.ModDefinitions;


public class BlockGroutite extends BlockCompositeOre {

	public BlockGroutite() {
		super("Groutite", ModDefinitions.modid, 1);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"74% " + localise("Manganese"),
				"26% " + localise("Iron")};
	}

}

package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.ModDefinitions;


public class BlockHematite extends BlockCompositeOre {

	public BlockHematite() {
		super("Hematite", ModDefinitions.modid, 1);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"65% " + localise("Iron"),
				"28% " + localise("Manganese"),
				"7% " + localise("Titanium")};
	}

}

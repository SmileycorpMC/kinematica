package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockBauxite extends BlockCompositeOre {

	public BlockBauxite() {
		super("Bauxite", 2);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"77% " + localise("Aluminium"),
				"23% " + localise("Iron")};
	}

}

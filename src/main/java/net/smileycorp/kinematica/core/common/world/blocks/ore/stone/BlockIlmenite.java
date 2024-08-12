package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockIlmenite extends BlockCompositeOre {

	public BlockIlmenite() {
		super("Ilmenite", 3);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"70% " + localise("Titanium"),
				"20% " + localise("Iron"),
				"10%" + localise("Aluminium")};
	}

}

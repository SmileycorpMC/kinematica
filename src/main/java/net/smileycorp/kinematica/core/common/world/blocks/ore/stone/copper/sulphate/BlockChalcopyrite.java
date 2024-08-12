package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockChalcopyrite extends BlockCompositeOre {

	public BlockChalcopyrite() {
		super("Chalcopyrite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"44% " + localise("Copper"),
				"31% " + localise("Iron"),
				"25% " + localise("Sulphur")};
	}

}

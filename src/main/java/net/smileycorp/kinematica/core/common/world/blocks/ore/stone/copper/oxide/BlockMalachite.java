package net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockMalachite extends BlockCompositeOre {

	public BlockMalachite() {
		super("Malachite", 0);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"58% " + localise("Copper"),
				"32% " + localise("Carbon"),
				"10% " + localise("Iridium")};
	}

}

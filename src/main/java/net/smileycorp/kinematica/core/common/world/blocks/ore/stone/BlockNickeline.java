package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockNickeline extends BlockCompositeOre {

	public BlockNickeline() {
		super("Nickeline");
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"56% " + localise("Arsenic"),
				"44% " + localise("Nickel")};
	}

}

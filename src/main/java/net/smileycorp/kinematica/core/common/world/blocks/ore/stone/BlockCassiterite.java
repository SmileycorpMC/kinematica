package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockCassiterite extends BlockCompositeOre {

	public BlockCassiterite() {
		super("Cassiterite");
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"80% " + localise("Tin"),
				"15% " + localise("Iron"),
				"5% " + localise("Tungsten")};
	}

}

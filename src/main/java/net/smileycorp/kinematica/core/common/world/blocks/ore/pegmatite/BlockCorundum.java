package net.smileycorp.kinematica.core.common.world.blocks.ore.pegmatite;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlockCorundum extends BlockCompositeOre {

	public BlockCorundum() {
		super("Corundum", 2, KineWorld.PEGMATITE);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"65% " + localise("Aluminium"),
				"20% " + localise("Iron"),
				"15% " + localise("Chromium")};
	}
}

package net.smileycorp.kinematica.core.common.world.blocks.ore.pegmatite;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlockRutile extends BlockCompositeOre {

	public BlockRutile() {
		super("Rutile", 3, KineWorld.PEGMATITE);
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"90% " + localise("Titanium"),
				"10% " + localise("Iron")};
	}

}

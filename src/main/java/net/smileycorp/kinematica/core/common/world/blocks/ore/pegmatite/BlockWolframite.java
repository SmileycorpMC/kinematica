package net.smileycorp.kinematica.core.common.world.blocks.ore.pegmatite;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlockWolframite extends BlockCompositeOre {

	public BlockWolframite() {
		super("Wolframite", 2, KineWorld.PEGMATITE);
	}
	@Override
	public String[] getComposition() {
		return new String[] {"70% " + localise("Tungsten"),
				"18% " + localise("Manganese"),
				"12% " + localise("Iron")};
	}

}

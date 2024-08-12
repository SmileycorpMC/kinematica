package net.smileycorp.kinematica.core.common.world.blocks.ore.surface;

import net.minecraft.init.Blocks;
import net.smileycorp.kinematica.api.ores.blocks.BlockOreFalling;

public class BlockMagnetite extends BlockOreFalling {

	public BlockMagnetite() {
		super("Magnetite", 1, Blocks.SAND);
	}

	@Override
	public String[] getComposition() {
		return new String[] {"65% " + localise("Iron"),
				"25% " + localise("Manganese"),
				"10% " + localise("Titanium")};
	}
}

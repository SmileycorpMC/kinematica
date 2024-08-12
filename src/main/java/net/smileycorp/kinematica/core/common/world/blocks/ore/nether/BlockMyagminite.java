package net.smileycorp.kinematica.core.common.world.blocks.ore.nether;

import net.minecraft.init.Blocks;
import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockMyagminite extends BlockCompositeOre {

	public BlockMyagminite() {
		super("Myagminite", 3, Blocks.NETHERRACK);
		setLightLevel(0.5f);
	}
	@Override
	public String[] getComposition() {
		return new String[] {"50% " + localise("Palladium"),
				"40% " + localise("Osmium"),
				"10% " + localise("Iridosmine")};
	}

}

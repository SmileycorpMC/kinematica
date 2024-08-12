package net.smileycorp.kinematica.core.common.world.blocks.ore.nether;

import net.minecraft.init.Blocks;
import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;

public class BlockAuragmus extends BlockCompositeOre {

	public BlockAuragmus() {
		super("Auragmus", 2, Blocks.NETHERRACK);
		setLightLevel(0.25f);
	}
	@Override
	public String[] getComposition() {
		return new String[] {"70% " + localise("Electrum"),
				"20% " + localise("Gold"),
				"10% " + localise("Silver")};
	}

}

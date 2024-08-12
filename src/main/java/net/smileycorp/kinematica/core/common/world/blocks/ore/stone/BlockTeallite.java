package net.smileycorp.kinematica.core.common.world.blocks.ore.stone;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;


public class BlockTeallite extends BlockCompositeOre {

	public BlockTeallite() {
		super("Teallite");
	}
	
	@Override
	public String[] getComposition() {
		return new String[] {"40% " + localise("Tin"),
				"35% " + localise("Lead") ,
				"25% " + localise("Sulphur")};
	}

}

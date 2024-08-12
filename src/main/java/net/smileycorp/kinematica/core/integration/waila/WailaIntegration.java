package net.smileycorp.kinematica.core.integration.waila;

import mcp.mobius.waila.api.IWailaPlugin;
import mcp.mobius.waila.api.IWailaRegistrar;
import mcp.mobius.waila.api.WailaPlugin;
import net.smileycorp.kinematica.api.ores.blocks.IOreComposition;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.integration.ModIntegration;

@WailaPlugin
public class WailaIntegration implements IWailaPlugin {
	@Override
	public void register(IWailaRegistrar register) {
		register.addConfig(ModDefinitions.modid, ModDefinitions.modid + ":oreCompositions", true);
		OreCompositionDataProvider oreProvider = new OreCompositionDataProvider();
	    register.registerBodyProvider(oreProvider, IOreComposition.class);
	    if (ModIntegration.ubInstalled) {
	    	//UBWaliaIntegration.register(register);
	    }
	}
}

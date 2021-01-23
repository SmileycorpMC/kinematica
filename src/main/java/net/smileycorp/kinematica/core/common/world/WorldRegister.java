package net.smileycorp.kinematica.core.common.world;

import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WorldRegister {
	
	public static void registerGeneration() {
		GameRegistry.registerWorldGenerator(new StoneGenerator(), 0);
		GameRegistry.registerWorldGenerator(new OreGenerator(), 45);
	}
	
	@SubscribeEvent
	public void replaceOreGen(OreGenEvent.GenerateMinable event) {
		//if (!KineConfig.useSimpleOres) {
			if (event.getType()==OreGenEvent.GenerateMinable.EventType.IRON) {
				event.setResult(Result.DENY);
			} else if (event.getType()==OreGenEvent.GenerateMinable.EventType.GOLD) {
				event.setResult(Result.DENY);
			} else if (event.getType()==OreGenEvent.GenerateMinable.EventType.CUSTOM) {
				event.setResult(Result.DENY);
			}
		//}
	}
}

package net.smileycorp.kinematica.core.client;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class EventListener {
	
	@SubscribeEvent
	public void tickEvent(PlayerTickEvent event){
		ModDefinitions.ticker++;
	}
	
}

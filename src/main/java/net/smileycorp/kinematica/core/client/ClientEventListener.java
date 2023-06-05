package net.smileycorp.kinematica.core.client;


import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent.PlayerTickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.smileycorp.kinematica.core.common.Constants;

@EventBusSubscriber(value = Dist.CLIENT, modid = Constants.MODID)
public class ClientEventListener {

	@SubscribeEvent
	public void tickEvent(PlayerTickEvent event){
		Constants.ticker++;
	}

}

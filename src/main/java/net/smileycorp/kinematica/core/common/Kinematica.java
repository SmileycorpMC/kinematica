package net.smileycorp.kinematica.core.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.smileycorp.kinematica.core.client.ClientEventListener;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.tools.KineTools;
import net.smileycorp.kinematica.core.common.world.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;

@Mod(Constants.MODID)
@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Kinematica {

	@SubscribeEvent
	public static void modConstruction(FMLConstructModEvent event) {
		KineConstruction.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineConstruction.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineMaterials.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineTabs.TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineTools.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineWorld.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineWorld.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineWorld.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
		KineWorld.BLOCK_ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	@SubscribeEvent
	public static void loadComplete(FMLLoadCompleteEvent event) {
		KineWorld.loadComplete();
		KineMaterials.loadComplete();
	}

	@SubscribeEvent
	public static void clientSetup(FMLClientSetupEvent event){
		MinecraftForge.EVENT_BUS.register(new ClientEventListener());
	}

}

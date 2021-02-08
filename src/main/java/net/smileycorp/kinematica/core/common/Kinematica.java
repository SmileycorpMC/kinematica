package net.smileycorp.kinematica.core.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.smileycorp.atlas.api.interfaces.ISidedProxy;
import net.smileycorp.kinematica.core.common.inventory.ContainerHandler;
import net.smileycorp.kinematica.core.common.tileentity.TileEntities;
import net.smileycorp.kinematica.core.common.world.WorldRegister;
import net.smileycorp.kinematica.core.integration.ModIntegration;

@Mod(modid = ModDefinitions.modid, name=ModDefinitions.name, version = ModDefinitions.version, dependencies = "before:undergroundbiomes")
public class Kinematica {
	
	@Instance(ModDefinitions.modid)
	public static Kinematica INSTANCE;
	
	@SidedProxy(clientSide = ModDefinitions.client, serverSide = ModDefinitions.server)
	public static ISidedProxy proxy;
	
	public Kinematica() {
		INSTANCE = this;
		APIRegistry.registerAPI();
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		KineConfig.config = new Configuration(event.getSuggestedConfigurationFile());
		KineConfig.syncConfig();
		ModIntegration.preInit(event);
		MinecraftForge.EVENT_BUS.register(new EventListener());
		MinecraftForge.TERRAIN_GEN_BUS.register(new WorldRegister());
		MinecraftForge.ORE_GEN_BUS.register(new WorldRegister());
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new ContainerHandler());
		TileEntities.register();
		WorldRegister.registerGeneration();
		MinecraftForge.EVENT_BUS.register(proxy);
		proxy.preInit(event);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		ModIntegration.init();
		proxy.init(event);
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		ModIntegration.postInit();
		proxy.postInit(event);
		ContentRegistry.registerRecipes();
	}

}

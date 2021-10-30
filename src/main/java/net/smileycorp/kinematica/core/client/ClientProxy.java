package net.smileycorp.kinematica.core.client;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.smileycorp.kinematica.core.client.tesr.TESRLatexLog;
import net.smileycorp.kinematica.core.common.CommonProxy;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.fluids.KineFluids;
import net.smileycorp.kinematica.core.common.machine.BasicMachines;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.tileentity.TileEntityLatexLog;
import net.smileycorp.kinematica.core.common.tools.Tools;
import net.smileycorp.kinematica.core.common.world.KineWorld;

@EventBusSubscriber(value = Side.CLIENT, modid = ModDefinitions.modid)
public class ClientProxy extends CommonProxy  {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new ClientEventListener());
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLatexLog.class, new TESRLatexLog());
		//if (KineConfig.specialOreRenderer) ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKineOre.class, new TESRKineOre());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent
	public static void modelRegister(ModelRegistryEvent event) {
		KineConstruction.registerModels(event);
		BasicMachines.registerModels(event);
		KineMaterials.registerModels(event);
		Tools.registerModels(event);
		KineWorld.registerModels(event);
		KineFluids.registerModels(event);
	}
	
}

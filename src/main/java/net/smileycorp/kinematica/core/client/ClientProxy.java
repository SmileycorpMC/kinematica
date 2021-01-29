package net.smileycorp.kinematica.core.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.smileycorp.atlas.api.client.colour.BlockGrassColour;
import net.smileycorp.atlas.api.client.colour.ItemFoliageColour;
import net.smileycorp.atlas.api.interfaces.ISidedProxy;
import net.smileycorp.kinematica.core.client.metal.BlockMetalColour;
import net.smileycorp.kinematica.core.client.metal.ItemMetalColour;
import net.smileycorp.kinematica.core.client.metal.MetalModelLoader;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;
import net.smileycorp.kinematica.core.common.materials.Materials;
import net.smileycorp.kinematica.core.common.world.blocks.WorldBlocks;

@EventBusSubscriber(value = Side.CLIENT, modid = ModDefinitions.modid)
public class ClientProxy implements ISidedProxy  {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new EventListener());
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public void stitchTextureEvent(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();
		MetalModelLoader.stitchTextures(map);
	}
	
	@SubscribeEvent
	public static void itemColourHandler(ColorHandlerEvent.Item event) {
		ItemColors registry = event.getItemColors();
		//Metals
		registry.registerItemColorHandler(new ItemMetalColour(), Materials.metal_items.toArray(new Item[]{}));
		registry.registerItemColorHandler(new ItemMetalColour(), Materials.metal_blocks.toArray(new Block[]{}));
		//Foliage
		registry.registerItemColorHandler(new ItemFoliageColour(), WorldBlocks.BOG_GRASS);
		registry.registerItemColorHandler(new ItemFoliageColour(), WorldBlocks.BAUXITE_GRASS);
		//registry.registerItemColorHandler(new ItemFoliageColour(), WorldBlocks.SHARINGA_LEAVES);
	}
	
	@SubscribeEvent
	public static void blockColourHandler(ColorHandlerEvent.Block event) {
		BlockColors registry = event.getBlockColors();
		registry.registerBlockColorHandler(new BlockMetalColour(), Materials.metal_blocks.toArray(new Block[]{}));
		//Foliage
		registry.registerBlockColorHandler(new BlockGrassColour(), WorldBlocks.BOG_GRASS);
		registry.registerBlockColorHandler(new BlockGrassColour(), WorldBlocks.BAUXITE_GRASS);
		//registry.registerBlockColorHandler(new BlockFoliageColour(), WorldBlocks.SHARINGA_LEAVES);
	}
	
	@SubscribeEvent
	public static void modelRegister(ModelRegistryEvent event) {
		Materials.registerModels(event);
		WorldBlocks.registerModels(event);
		MachineBlocks.registerModels(event);
	}
	
}

package net.smileycorp.kinematica.core.client;


import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.atlas.api.client.colour.BlockFoliageColour;
import net.smileycorp.atlas.api.client.colour.BlockGrassColour;
import net.smileycorp.atlas.api.client.colour.ItemFoliageColour;
import net.smileycorp.kinematica.core.client.metal.BlockMetalColour;
import net.smileycorp.kinematica.core.client.metal.ItemMetalColour;
import net.smileycorp.kinematica.core.client.metal.MetalModelLoader;
import net.smileycorp.kinematica.core.client.model.BakedModelKineOre;
import net.smileycorp.kinematica.core.common.KineConfig;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;
import net.smileycorp.kinematica.core.integration.tcon.client.ConArmClientRegistry;
import net.smileycorp.kinematica.core.integration.tcon.client.TConClientRegistry;

@EventBusSubscriber(value = Side.CLIENT, modid = ModDefinitions.modid)
public class ClientEventListener {
	
	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void tickEvent(PlayerTickEvent event){
		ModDefinitions.ticker++;
	}
	
	@SubscribeEvent
	public static void onModelBake(ModelBakeEvent event) {
		IRegistry<ModelResourceLocation, IBakedModel> registry = event.getModelRegistry();
		if (KineConfig.specialOreRenderer) {
			for (Block block : KineWorld.ores) {
					RenderingUtils.replaceRegisteredModel(new ModelResourceLocation(block.getRegistryName(), "normal"), registry, BakedModelKineOre.class);
					System.out.println(block.getRegistryName().toString() + " in block" + block);
			}
		}
	}
	
	@SubscribeEvent(priority = EventPriority.LOW)
	public void stitchTextureEvent(TextureStitchEvent.Pre event) {
		TextureMap map = event.getMap();
		
		map.registerSprite(ModDefinitions.getResource("blocks/log_rubber_leaking"));
		
		MetalModelLoader.stitchTextures(map);
		//if (KineConfig.specialOreRenderer) TESRKineOre.stitchTextures(map);
	}
	
	@SubscribeEvent
	public static void itemColourHandler(ColorHandlerEvent.Item event) {
		ItemColors registry = event.getItemColors();
		//Metals
		registry.registerItemColorHandler(new ItemMetalColour(), KineMaterials.metal_items.toArray(new Item[]{}));
		registry.registerItemColorHandler(new ItemMetalColour(), KineMaterials.metal_blocks.toArray(new Block[]{}));
		if (Loader.isModLoaded("tconstruct")) {
			TConClientRegistry.itemColourHandler(registry);
		}
		if (Loader.isModLoaded("conarm")) {
			ConArmClientRegistry.itemColourHandler(registry);
		}
		//Foliage
		registry.registerItemColorHandler(new ItemFoliageColour(), KineWorld.BOG_GRASS);
		registry.registerItemColorHandler(new ItemFoliageColour(), KineWorld.BAUXITE_GRASS);
		registry.registerItemColorHandler(new ItemFoliageColour(), KineWorld.SHARINGA_LEAVES);
	}
	
	@SubscribeEvent
	public static void blockColourHandler(ColorHandlerEvent.Block event) {
		BlockColors registry = event.getBlockColors();
		registry.registerBlockColorHandler(new BlockMetalColour(), KineMaterials.metal_blocks.toArray(new Block[]{}));
		if (Loader.isModLoaded("tconstruct")) {
			TConClientRegistry.blockColourHandler(registry);
		}
		if (Loader.isModLoaded("conarm")) {
			ConArmClientRegistry.blockColourHandler(registry);
		}
		//Foliage
		registry.registerBlockColorHandler(new BlockGrassColour(), KineWorld.BOG_GRASS);
		registry.registerBlockColorHandler(new BlockGrassColour(), KineWorld.BAUXITE_GRASS);
		registry.registerBlockColorHandler(new BlockFoliageColour(), KineWorld.SHARINGA_LEAVES);
	}
	
}

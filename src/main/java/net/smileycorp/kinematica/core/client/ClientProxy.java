package net.smileycorp.kinematica.core.client;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.smileycorp.kinematica.api.ores.ItemOre;
import net.smileycorp.kinematica.api.ores.OresAPI;
import net.smileycorp.kinematica.api.ores.blocks.IOreComposition;
import net.smileycorp.kinematica.core.client.metal.ItemOreModelLoader;
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
import net.smileycorp.kinematica.core.integration.ModIntegration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@EventBusSubscriber(value = Side.CLIENT, modid = ModDefinitions.modid)
public class ClientProxy extends CommonProxy  {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);
		ModelLoaderRegistry.registerLoader(ItemOreModelLoader.INSTANCE);
		MinecraftForge.EVENT_BUS.register(new ClientEventListener());
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
		super.init(event);
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLatexLog.class, new TESRLatexLog());
		//if (KineConfig.specialOreRenderer) ClientRegistry.bindTileEntitySpecialRenderer(TileEntityKineOre.class, new TESRKineOre());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		super.postInit(event);
		FMLClientHandler.instance().refreshResources();
	}
	
	@SubscribeEvent
	public static void modelRegister(ModelRegistryEvent event) {
		KineConstruction.registerModels(event);
		BasicMachines.registerModels(event);
		KineMaterials.registerModels(event);
		Tools.registerModels(event);
		KineWorld.registerModels(event);
		KineFluids.registerModels(event);
		for (ItemOre item : OresAPI.getOreItems()) {
			String name = item.getName().substring(0, item.getName().length() - 6);
			ModelLoader.setCustomModelResourceLocation(item, 0,
					new ModelResourceLocation(new ResourceLocation(item.getRegistryName().getResourceDomain(), "item_ore" + "." + name), "inventory"));
		}
	}
	
	@SubscribeEvent
	public void tooltipEvent(ItemTooltipEvent event) {
		ItemStack stack = event.getItemStack();
		if(stack.getItem() instanceof ItemBlock){
			Block block = ((ItemBlock) stack.getItem()).getBlock();
			List<String> tooltip = new ArrayList<String>(event.getToolTip());
			String name = event.getToolTip().get(0);
			tooltip.remove(0);
			event.getToolTip().clear();
			event.getToolTip().add(name);
			if (block instanceof IOreComposition) {
				event.getToolTip().addAll(Arrays.asList(((IOreComposition) block).getComposition()));
			} else if (ModIntegration.ubInstalled) {
				//event.getToolTip().addAll(Arrays.asList(UBIntegration.getComposition(block)));
			}
			event.getToolTip().addAll(tooltip);
		}
	}
	
}

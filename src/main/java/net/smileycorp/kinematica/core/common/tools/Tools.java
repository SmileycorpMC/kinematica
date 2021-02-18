package net.smileycorp.kinematica.core.common.tools;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.atlas.api.interfaces.IMetaItem;
import net.smileycorp.atlas.api.item.ToolSet;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class Tools {
	public static final Set<Item> ITEMS = new HashSet<Item>();
	public static final Set<Block> BLOCKS = new HashSet<Block>();
	
	public static Item FIRESTARTER = new ItemFireStarter();
	public static ToolSet COPPER = new ToolSet(ModDefinitions.modid, "Copper", EnumHelper.addToolMaterial("Copper", 1, 141, 4.1F, 1.0F, 7)
				.setRepairItem(MetalRegistry.getItemFor("Copper", MetalType.INGOT)), KineTabs.TOOLS);
	public static ToolSet BRONZE = new ToolSet(ModDefinitions.modid, "Bronze", EnumHelper.addToolMaterial("Bronze", 2, 210, 4.5F, 2.0F, 16)
			.setRepairItem(MetalRegistry.getItemFor("Bronze", MetalType.INGOT)), KineTabs.TOOLS);
	
	
	public static Item[] items = {FIRESTARTER};
	public static ToolSet[] tools = {COPPER, BRONZE};


	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Item item : items) {
			registry.register(item);
			ITEMS.add(item);
		}
		for (final ToolSet toolset : tools) {
			toolset.registerItems(registry);
			toolset.registerRecipes();
		}
	}

	public static void registerModels(ModelRegistryEvent event) {
		for (Item item : items) {
			if (item instanceof IMetaItem) {	
				for(int meta = 0; meta<=((IMetaItem)item).getMaxMeta(); meta++) {
					RenderingUtils.setMetaModel(ModDefinitions.modid, item, meta);
				}
			} else {
				ModelLoader.setCustomModelResourceLocation(item, 0,new ModelResourceLocation(item.getRegistryName().toString()));
			}
		}
		for (ToolSet toolset : tools) {
			toolset.registerModels();
		}	
	}
}

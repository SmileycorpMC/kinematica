package net.smileycorp.kinematica.core.common.materials;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.atlas.api.block.CustomStateMapper;
import net.smileycorp.atlas.api.interfaces.IMetaItem;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.client.metal.MetalModelLoader;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class Materials {
	public static final Set<Item> ITEMS = new HashSet<Item>();
	
	static MetalModelLoader LOADER = new MetalModelLoader();
	
	public static Item MATERIAL_DUST = new ItemMaterialDust();
	public static Item SHAPED_CLAY = new ItemShapedClay("Clay");
	public static Item SHAPED_CERAMIC = new ItemShapedClay("Ceramic");

	public static List<ItemMetal> metal_items = new ArrayList<ItemMetal>();	
	public static List<BlockMetal> metal_blocks = new ArrayList<BlockMetal>();	
	
	public static Item[] items = {SHAPED_CLAY, SHAPED_CERAMIC};


	public static void registerItems(IForgeRegistry<Item> registry) {
		for (MetalType type : MetalType.values()) {
			if (type.isItem()) {
				for (String metal : MetalRegistry.getMetalsFor(type)) {
					ItemMetal item = new ItemMetal(MetalRegistry.getMod(metal),type, metal);
					registry.register(item);
					MetalRegistry.registerMetalItem(metal, type, item);
					metal_items.add(item);
					ITEMS.add(item);
				}
			}
		}
		
		for (final Item item : items) {
			registry.register(item);
			ITEMS.add(item);
		}
		for (BlockMetal block : metal_blocks) {
			ItemBlockMetal itemblock = new ItemBlockMetal(block);
			registry.register(itemblock);
			ITEMS.add(itemblock);
		}
	}

	public static void registerModels(ModelRegistryEvent event) {
		ModelLoaderRegistry.registerLoader(LOADER);
		for (ItemMetal item : metal_items) {
			ResourceLocation location = new ResourceLocation(item.getRegistryName().getResourceDomain(), "metal/"+item.type.getName().toLowerCase()+"."+item.metal.toLowerCase());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(location.toString()));
		}
		for (Item item : items) {
			if (item instanceof IMetaItem) {	
				for(int meta = 0; meta<=((IMetaItem)item).getMaxMeta(); meta++) {
					setMetaModel(item, meta);
				}
			} else {
				ModelLoader.setCustomModelResourceLocation(item, 0,new ModelResourceLocation(item.getRegistryName().toString()));
			}
		}
		for (BlockMetal block : metal_blocks) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("kinematica:metal_block", "normal"));
			ModelLoader.setCustomStateMapper(block, new CustomStateMapper(ModDefinitions.modid, "metal_block"));
		}
		
	}
	
	public static void setMetaModel(Item item, int meta) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(ModDefinitions.modid + ":items/"
				+ item.getRegistryName().toString().substring(ModDefinitions.modid.length()+1),
			((IMetaItem)item).byMeta(meta)));
	}

	public static void registerBlocks(IForgeRegistry<Block> registry) {
		for (String metal : MetalRegistry.getMetalsFor(MetalType.BLOCK)) {
			BlockMetal block = new BlockMetal(MetalRegistry.getMod(metal), metal);
			registry.register(block);
			MetalRegistry.registerMetalItem(metal, MetalType.BLOCK, block);
			metal_blocks.add(block);
		}
	}
}

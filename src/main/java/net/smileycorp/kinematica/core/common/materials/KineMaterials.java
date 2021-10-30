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
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.registries.IForgeRegistry;

import net.smileycorp.atlas.api.client.CustomStateMapper;
import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.atlas.api.item.IMetaItem;
import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import net.smileycorp.kinematica.core.client.metal.MetalModelLoader;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.fluids.KineFluids;

public class KineMaterials {
	
	public static final Set<Item> ITEMS = new HashSet<Item>();
	
	static MetalModelLoader ITEM_LOADER = new MetalModelLoader();
	
	public static Item MATERIAL_DUST = new ItemMaterialDust();
	public static Item MATERIALS = new ItemMaterials();
	public static Item MOULD = new ItemClayMould("Clay");
	public static Item FIRED_MOULD = new ItemClayMould("Ceramic");

	public static List<ItemMetal> metal_items = new ArrayList<ItemMetal>();	
	public static List<BlockMetal> metal_blocks = new ArrayList<BlockMetal>();	
	
	public static Item[] items = {MATERIAL_DUST, MATERIALS, MOULD, FIRED_MOULD};


	public static void registerItems(IForgeRegistry<Item> registry) {
		for (MetalType type : MetalType.values()) {
			if (type.isItem()) {
				for (String metal : MetalRegistry.getMetalsFor(type, true)) {
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
		ModelLoaderRegistry.registerLoader(ITEM_LOADER);
		for (ItemMetal item : metal_items) {
			ResourceLocation location = new ResourceLocation(item.getRegistryName().getResourceDomain(), "metal/"+item.type.getName().toLowerCase()+"."+item.metal.toLowerCase());
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(location.toString()));
		}
		for (Item item : items) {
			if (item instanceof IMetaItem) {	
				for(int meta = 0; meta<=((IMetaItem)item).getMaxMeta(); meta++) {
					RenderingUtils.setMetaModel(ModDefinitions.modid, item, meta);
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
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		for (String metal : MetalRegistry.getMetalsFor(MetalType.BLOCK, true)) {
			BlockMetal block = new BlockMetal(MetalRegistry.getMod(metal), metal);
			registry.register(block);
			MetalRegistry.registerMetalItem(metal, MetalType.BLOCK, block);
			metal_blocks.add(block);
		}
		for (String metal : MetalRegistry.getFluidMetals()) {
			if (MetalRegistry.getFluid(metal) == null) {
				FluidMetal fluid = new FluidMetal(metal);
				FluidRegistry.registerFluid(fluid);
				FluidRegistry.addBucketForFluid(fluid);
				MetalRegistry.registerMetalFluid(metal, fluid);
				BlockMetalFluid fluidblock = new BlockMetalFluid(fluid);
				registry.register(fluidblock);
				KineFluids.FLUID_BLOCKS.add(fluidblock);
			}
		}
	}
}

package net.smileycorp.kinematica.core.common.construction;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import net.smileycorp.atlas.api.block.IBlockProperties;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.atlas.api.client.RenderingUtils;
import net.smileycorp.atlas.api.item.IMetaItem;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.construction.items.ItemConstructionDusts;
import net.smileycorp.kinematica.core.common.construction.items.ItemConstructionMaterials;

public class KineConstruction {
	public  static Set<Block> BLOCKS = new HashSet<Block>();
	public  static Set<Item> ITEMS = new HashSet<Item>();
	
	//items
	public static Item DUSTS = new ItemConstructionDusts();
	public static Item MATERIALS = new ItemConstructionMaterials();

	//shaped blocks
	public static ShapedBlock SHARINGA_PLANKS = new ShapedBlock("Sharinga_Planks", ModDefinitions.modid, Material.WOOD, SoundType.WOOD, 1f, 6f, "axe", 0, KineTabs.BLOCKS);
	public static ShapedBlock MUDBRICK = new ShapedBlock("Mudbrick", ModDefinitions.modid, Material.CLAY, SoundType.GROUND, 0.85f, 2f,  "shovel", 0, KineTabs.BLOCKS);
	public static ShapedBlock FIRED_MUDBRICK = new ShapedBlock("Fired_Mudbrick", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1.2f, 6f, 0, KineTabs.BLOCKS);
	public static ShapedBlock ADOBE = new ShapedBlock("Adobe", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 5f, 0, KineTabs.BLOCKS);
	public static ShapedBlock REFRACTORY_BRICK = new ShapedBlock("Refractory_Brick", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 2.2f, 10f, 0, KineTabs.BLOCKS);
	
	//regular blocks
	public static Block SHARINGA_FENCE;
	public static Block SHARINGA_GATE;
	public static Block SHARINGA_DOOR;
	public static Block SHARINGA_TRAPDOOR;
	
	public static Block REINFORCED_CONCRETE_POWDER;
	public static Block REINFORCED_CONCRETE;
	
	public static Block SCAFFOLDING;
	
	public static Block[] blocks = {};
	public static ShapedBlock[] shapedBlocks = {SHARINGA_PLANKS, MUDBRICK, FIRED_MUDBRICK, ADOBE, REFRACTORY_BRICK};
	public static Item[] items = {DUSTS, MATERIALS};
		
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		for (ShapedBlock block:shapedBlocks) {
			block.registerBlocks(registry);
		}
		//registry.registerAll(blocks);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Item item : items) {
			registry.register(item);
			ITEMS.add(item);
		}
		for (ShapedBlock block:shapedBlocks) {
			block.registerItems(registry);
			block.registerRecipes();
		}
		for (final Block block : blocks) {
			Item item = new ItemBlock(block);
			item.setRegistryName(block.getRegistryName());
			item.setUnlocalizedName(block.getUnlocalizedName());
			registry.register(item);
			ITEMS.add(item);
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
		for (ShapedBlock block:shapedBlocks) {
			block.registerModels();
		}
		for (Block block : blocks) {
			final ResourceLocation loc = ForgeRegistries.BLOCKS.getKey(block);
			if (block instanceof IBlockProperties) {
				if(((IBlockProperties) block).useInventoryVariant()) {
					ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "inventory"));
					continue;
				}
			}
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "normal"));
		}
	}
}

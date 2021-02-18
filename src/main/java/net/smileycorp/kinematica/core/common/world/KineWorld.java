package net.smileycorp.kinematica.core.common.world;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.atlas.api.client.CustomStateMapper;
import net.smileycorp.atlas.api.interfaces.IBlockProperties;
import net.smileycorp.kinematica.core.client.model.mappers.StateMapperSharingaLog;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.world.blocks.BlockBauxiteGrass;
import net.smileycorp.kinematica.core.common.world.blocks.BlockBauxiteSoil;
import net.smileycorp.kinematica.core.common.world.blocks.BlockBogGrass;
import net.smileycorp.kinematica.core.common.world.blocks.BlockMud;
import net.smileycorp.kinematica.core.common.world.blocks.BlockSharingaLeaves;
import net.smileycorp.kinematica.core.common.world.blocks.BlockSharingaLog;
import net.smileycorp.kinematica.core.common.world.blocks.BlockSharingaSapling;
import net.smileycorp.kinematica.core.common.world.blocks.BlockSimpleOre;
import net.smileycorp.kinematica.core.common.world.blocks.ItemBlockSimpleOre;

public class KineWorld {
	public  static Set<Block> BLOCKS = new HashSet<Block>();
	public  static Set<Item> ITEMS = new HashSet<Item>();
	
	//main blocks
	public static Block MUD = new BlockMud();
	public static Block BOG_GRASS = new BlockBogGrass();
	public static Block BAUXITE_SOIL = new BlockBauxiteSoil();
	public static Block BAUXITE_GRASS = new BlockBauxiteGrass();
	public static Block LIMESTONE = new BlockBase("Limestone", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.BLOCKS);
	public static Block DOLOMITE = new BlockBase("Dolomite", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.BLOCKS);
	public static Block SHARINGA_LOG = new BlockSharingaLog();
	public static Block SHARINGA_LEAVES = new BlockSharingaLeaves();
	public static Block SHARINGA_SAPLING = new BlockSharingaSapling();
	
	//ores
	public static BlockSimpleOre TIN_ORE = new BlockSimpleOre("Tin", 1);
	public static BlockSimpleOre COPPER_ORE = new BlockSimpleOre("Copper", 0);
	public static BlockSimpleOre LEAD_ORE = new BlockSimpleOre("Lead", 2);
	public static BlockSimpleOre SILVER_ORE = new BlockSimpleOre("Silver", 2);
	public static BlockSimpleOre COBALT_ORE = new BlockSimpleOre("Cobalt", 2);
	public static BlockSimpleOre NICKEL_ORE = new BlockSimpleOre("Nickel", 1);
	public static BlockSimpleOre CHROMIUM_ORE = new BlockSimpleOre("Chromium", 2);
	public static BlockSimpleOre ZINC_ORE = new BlockSimpleOre("Zinc", 1);
	public static BlockSimpleOre MANGANESE_ORE = new BlockSimpleOre("Manganese", 1);
	public static BlockSimpleOre PALLADIUM_ORE = new BlockSimpleOre("Palladium", 3);
	public static BlockSimpleOre PLATINUM_ORE = new BlockSimpleOre("Platinum", 3);
	public static BlockSimpleOre IRIDIUM_ORE = new BlockSimpleOre("Iridium", 3);
	public static BlockSimpleOre OSMIUM_ORE = new BlockSimpleOre("Osmium", 3);
	public static BlockSimpleOre ALUMINIUM_ORE = new BlockSimpleOre("Aluminium", 2);
	public static BlockSimpleOre TUNGSTEN_ORE = new BlockSimpleOre("Tungsten", 2);
	public static BlockSimpleOre BISMUTH_ORE = new BlockSimpleOre("Bismuth", 2);
	public static BlockSimpleOre TITANIUM_ORE = new BlockSimpleOre("Titanium", 3);
	public static BlockSimpleOre CINNABAR_ORE = new BlockSimpleOre("Cinnabar", 1);
	
	public static BlockSimpleOre SULPHUR_ORE = new BlockSimpleOre("Sulphur", 1, new ItemStack(KineMaterials.MATERIAL_DUST), 3, 5);
	public static BlockSimpleOre ARSENIC_ORE = new BlockSimpleOre("Arsenic", 1, new ItemStack(KineMaterials.MATERIAL_DUST, 1, 2), 1, 3);
	
	public static BlockSimpleOre NETHER_GOLD_ORE = new BlockSimpleOre("Nether_Gold", 2, new ItemStack(Items.GOLD_NUGGET), 5, 11);
	public static BlockSimpleOre NETHER_SULPHUR_ORE = new BlockSimpleOre("Nether_Sulphur", 2, new ItemStack(KineMaterials.MATERIAL_DUST), 5, 11);
	
	public static Block[] blocks = {MUD, BOG_GRASS, BAUXITE_SOIL, BAUXITE_GRASS, LIMESTONE, DOLOMITE, SHARINGA_LOG, SHARINGA_LEAVES, SHARINGA_SAPLING};
		
	public static BlockSimpleOre[] ores = {TIN_ORE, COPPER_ORE, LEAD_ORE, SILVER_ORE, COBALT_ORE, NICKEL_ORE,
			CHROMIUM_ORE, ZINC_ORE, MANGANESE_ORE, PALLADIUM_ORE, PLATINUM_ORE, OSMIUM_ORE, IRIDIUM_ORE, ALUMINIUM_ORE, TUNGSTEN_ORE,
			BISMUTH_ORE, TITANIUM_ORE, CINNABAR_ORE, SULPHUR_ORE, ARSENIC_ORE, NETHER_GOLD_ORE, NETHER_SULPHUR_ORE};
		
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		if (!Loader.isModLoaded("kinematicaores")) blocks = ArrayUtils.addAll(blocks, ores);
		registry.registerAll(blocks);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Block block : blocks) {
			if (block instanceof IBlockProperties&&((IBlockProperties) block).usesCustomItemHandler()) continue;
			Item item = new ItemBlock(block);
			item.setRegistryName(block.getRegistryName());
			item.setUnlocalizedName(block.getUnlocalizedName());
			registry.register(item);
			ITEMS.add(item);
		}
		for (final BlockSimpleOre block : ores) {
			Item item = new ItemBlockSimpleOre(block);
			registry.register(item);
			ITEMS.add(item);
		}
	}
	
	public static void customRegistry(Block block, ItemBlock item, IForgeRegistry<Item> registry) {
		item.setRegistryName(block.getRegistryName());
		item.setUnlocalizedName(block.getUnlocalizedName());
		registry.register(item);
		ITEMS.add(item);
	}

	public static void registerModels(ModelRegistryEvent event) {
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
		ModelLoader.setCustomStateMapper(SHARINGA_LOG, new StateMapperSharingaLog());
		ModelLoader.setCustomStateMapper(SHARINGA_LEAVES, new CustomStateMapper(ModDefinitions.modid, "sharinga_leaves", "normal"));
		ModelLoader.setCustomStateMapper(SHARINGA_SAPLING, new CustomStateMapper(ModDefinitions.modid, "sharinga_sapling", "normal"));
	}
}

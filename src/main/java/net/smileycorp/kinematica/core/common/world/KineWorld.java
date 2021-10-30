package net.smileycorp.kinematica.core.common.world;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.atlas.api.block.IBlockProperties;
import net.smileycorp.atlas.api.client.CustomStateMapper;
import net.smileycorp.kinematica.core.client.entity.RenderBlueWitherSkeleton;
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
import net.smileycorp.kinematica.core.common.world.blocks.BlockOreBase;
import net.smileycorp.kinematica.core.common.world.blocks.ItemBlockOreBase;
import net.smileycorp.kinematica.core.common.world.entity.EntityBlueWitherSkeleton;

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
	public static BlockOreBase TIN_ORE = new BlockOreBase("Tin", 1);
	public static BlockOreBase COPPER_ORE = new BlockOreBase("Copper", 0);
	public static BlockOreBase LEAD_ORE = new BlockOreBase("Lead", 2);
	public static BlockOreBase SILVER_ORE = new BlockOreBase("Silver", 2);
	public static BlockOreBase COBALT_ORE = new BlockOreBase("Cobalt", 2);
	public static BlockOreBase NICKEL_ORE = new BlockOreBase("Nickel", 1);
	public static BlockOreBase CHROMIUM_ORE = new BlockOreBase("Chromium", 2);
	public static BlockOreBase ZINC_ORE = new BlockOreBase("Zinc", 1);
	public static BlockOreBase MANGANESE_ORE = new BlockOreBase("Manganese", 1);
	public static BlockOreBase PALLADIUM_ORE = new BlockOreBase("Palladium", 3);
	public static BlockOreBase PLATINUM_ORE = new BlockOreBase("Platinum", 3);
	public static BlockOreBase IRIDIUM_ORE = new BlockOreBase("Iridium", 3);
	public static BlockOreBase OSMIUM_ORE = new BlockOreBase("Osmium", 3);
	public static BlockOreBase ALUMINIUM_ORE = new BlockOreBase("Aluminium", 2);
	public static BlockOreBase TUNGSTEN_ORE = new BlockOreBase("Tungsten", 2);
	public static BlockOreBase ANTIMONY_ORE = new BlockOreBase("Antimony", 1);
	public static BlockOreBase BISMUTH_ORE = new BlockOreBase("Bismuth", 2);
	public static BlockOreBase TITANIUM_ORE = new BlockOreBase("Titanium", 3);
	public static BlockOreBase CINNABAR_ORE = new BlockOreBase("Cinnabar", 1);
	
	public static BlockOreBase ANTHRACITE_ORE = new BlockOreBase("Anthracite", 0, new ItemStack(KineMaterials.MATERIALS, 1, 1), 1, 2);
	public static BlockOreBase SULPHUR_ORE = new BlockOreBase("Sulphur", 1, new ItemStack(KineMaterials.MATERIAL_DUST), 3, 5);
	public static BlockOreBase ARSENIC_ORE = new BlockOreBase("Arsenic", 1, new ItemStack(KineMaterials.MATERIAL_DUST, 1, 2), 1, 3);
	
	public static BlockOreBase NETHER_GOLD_ORE = new BlockOreBase("Nether_Gold", 2, new ItemStack(Items.GOLD_NUGGET), 5, 11, Blocks.NETHERRACK);
	public static BlockOreBase NETHER_SULPHUR_ORE = new BlockOreBase("Nether_Sulphur", 2, new ItemStack(KineMaterials.MATERIAL_DUST), 5, 11, Blocks.NETHERRACK);
	
	public static Block[] blocks = {MUD, BOG_GRASS, BAUXITE_SOIL, BAUXITE_GRASS, LIMESTONE, DOLOMITE, SHARINGA_LOG, SHARINGA_LEAVES, SHARINGA_SAPLING};
		
	public static BlockOreBase[] ores = {TIN_ORE, COPPER_ORE, LEAD_ORE, SILVER_ORE, COBALT_ORE, NICKEL_ORE, CHROMIUM_ORE, 
			ZINC_ORE, MANGANESE_ORE, PALLADIUM_ORE, PLATINUM_ORE, OSMIUM_ORE, IRIDIUM_ORE, ALUMINIUM_ORE, TUNGSTEN_ORE, ANTIMONY_ORE,
			BISMUTH_ORE, TITANIUM_ORE, CINNABAR_ORE, ANTHRACITE_ORE, SULPHUR_ORE, ARSENIC_ORE, NETHER_GOLD_ORE, NETHER_SULPHUR_ORE};
		
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
		for (final BlockOreBase block : ores) {
			Item item = new ItemBlockOreBase(block);
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
	
	public static void registerEntities(IForgeRegistry<EntityEntry> registry) {
		int ID = 201;
		EntityEntry blue_wither_skeleton = EntityEntryBuilder.create().entity(EntityBlueWitherSkeleton.class)
				.id(ModDefinitions.getResource("blue_wither_skeleton"), ID++)
				.name(ModDefinitions.getName("BlueWitherSkeleton"))
				.tracker(80, 3, true).egg(0x00122D, 0x616868).build();
		registry.register(blue_wither_skeleton);
	}
	
	public static void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueWitherSkeleton.class, m-> new RenderBlueWitherSkeleton(m));
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

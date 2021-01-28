package net.smileycorp.kinematica.core.common.world.blocks;

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
import net.smileycorp.kinematica.core.common.BlockBase;

public class WorldBlocks {
	public  static Set<Block> BLOCKS = new HashSet<Block>();
	public  static Set<Item> ITEMS = new HashSet<Item>();
	
	//main blocks
	public static Block MUD = new BlockMud();
	public static Block LIMESTONE = new BlockBase("Limestone", Material.ROCK, SoundType.STONE, 1f, 6f, 0);
	public static Block SHARINGA_LOG = new BlockSharingaLog();
	public static Block SHARINGA_LEAVES;
	public static Block SHARINGA_SAPLING;
	public static Block SHARINGA_PLANKS = new BlockBase("Sharinga_Planks", Material.WOOD, SoundType.WOOD, 1f, 6f, "axe", 0);
	
	//ores
	public static Block TIN_ORE = new BlockSimpleOre("Tin", 1);
	public static Block COPPER_ORE = new BlockSimpleOre("Copper", 0);
	public static Block LEAD_ORE = new BlockSimpleOre("Lead", 2);
	public static Block SILVER_ORE = new BlockSimpleOre("Silver", 2);
	public static Block COBALT_ORE = new BlockSimpleOre("Cobalt", 2);
	public static Block NICKEL_ORE = new BlockSimpleOre("Nickel", 1);
	public static Block CHROMIUM_ORE = new BlockSimpleOre("Chromium", 2);
	public static Block ZINC_ORE = new BlockSimpleOre("Zinc", 1);
	public static Block PALLADIUM_ORE = new BlockSimpleOre("Palladium", 3);
	public static Block PLATINUM_ORE = new BlockSimpleOre("Platinum", 3);
	public static Block IRIDIUM_ORE = new BlockSimpleOre("Iridium", 3);
	public static Block OSMIUM_ORE = new BlockSimpleOre("Osmium", 3);
	public static Block ALUMINIUM_ORE = new BlockSimpleOre("Aluminium", 2);
	public static Block TUNGSTEN_ORE = new BlockSimpleOre("Tungsten", 2);
	public static Block BISMUTH_ORE = new BlockSimpleOre("Bismuth", 2);
	public static Block TITANIUM_ORE = new BlockSimpleOre("Titanium", 3);
	public static Block CINNABAR_ORE = new BlockSimpleOre("Cinnabar", 1);
	//public static Block ARSENIC_ORE = new BlockSimpleOre("Arsenic", 1, new ItemStack(COItems.MATERIAL, 3, 5));
	//public static Block SULPHUR_ORE = new BlockSimpleOre("Sulphur", 1, new ItemStack(COItems.MATERIAL, 3, 7));
	
	public static Block NETHER_GOLD_ORE = new BlockNetherGoldOre();
	//public static Block NETHER_SULPHUR_ORE = new BlockSimpleOre("Nether_Sulphur", 1, new ItemStack(COItems.MATERIAL, 6, 7));
	
	public static Block[] blocks = {MUD, LIMESTONE};
		
	public static Block[] ores = {TIN_ORE, COPPER_ORE, LEAD_ORE, SILVER_ORE, COBALT_ORE, NICKEL_ORE,
			CHROMIUM_ORE, ZINC_ORE, PALLADIUM_ORE, PLATINUM_ORE, OSMIUM_ORE, IRIDIUM_ORE, ALUMINIUM_ORE, TUNGSTEN_ORE,
			BISMUTH_ORE, TITANIUM_ORE, CINNABAR_ORE};
		
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		//blocks = ArrayUtils.addAll(blocks, ores);
		registry.registerAll(blocks);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Block block : blocks) {
			Item item = new ItemBlock(block);
			item.setRegistryName(block.getRegistryName());
			item.setUnlocalizedName(block.getUnlocalizedName());
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
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "normal"));
		}
	}
}

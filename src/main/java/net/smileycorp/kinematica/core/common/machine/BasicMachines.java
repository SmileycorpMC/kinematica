package net.smileycorp.kinematica.core.common.machine;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import net.smileycorp.atlas.api.block.IBlockProperties;
import net.smileycorp.kinematica.core.common.machine.blocks.BlockKilnChamber;
import net.smileycorp.kinematica.core.common.machine.blocks.BlockKilnFire;

public class BasicMachines {
	public static Set<Block> BLOCKS = new HashSet<Block>();
	public static Set<Item> ITEMS = new HashSet<Item>();
	
	//public static Block KILN_BRICK = new BlockBase("Kiln_Brick", Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.MACHINES);
	public static Block KILN_FIRE = new BlockKilnFire();
	public static Block KILN_CHAMBER = new BlockKilnChamber();
	
	public static Block WOODEN_BASIN = new BlockWoodBasin();
	
	public static Block[] blocks = {KILN_FIRE, KILN_CHAMBER};
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		registry.registerAll(blocks);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Block block : blocks) {
			if (block instanceof IBlockProperties) {
				if (!((IBlockProperties)block).usesCustomItemHandler()) {
					register(block, registry);
				}
			} else {
				register(block, registry);
			}
		}
	}
	
	private static void register(Block block, IForgeRegistry<Item> registry) {
		Item item = new ItemBlock(block);
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

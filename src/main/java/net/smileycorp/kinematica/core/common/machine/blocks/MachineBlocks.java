package net.smileycorp.kinematica.core.common.machine.blocks;

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
import net.smileycorp.atlas.api.interfaces.IBlockProperties;
import net.smileycorp.kinematica.core.common.BlockBase;
import net.smileycorp.kinematica.core.common.KineTabs;

public class MachineBlocks {
	public static Set<Block> BLOCKS = new HashSet<Block>();
	public static Set<Item> ITEMS = new HashSet<Item>();
	
	public static Block MUDBRICK = new BlockBase("Mudbrick", Material.CLAY, SoundType.GROUND, 0.75f, 1f,  "shovel", 0);
	public static Block FIRED_MUDBRICK = new BlockBase("Fired_Mudbrick", Material.ROCK, SoundType.STONE, 1f, 6f, 0);
	
	public static Block KILN_BRICK = new BlockBase("Kiln_Brick", Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.MACHINES);
	public static Block KILN_CORE = new BlockKilnCore();
	public static Block KILN = new BlockKiln();
	
	public static Block[] blocks = {MUDBRICK, FIRED_MUDBRICK};
	
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

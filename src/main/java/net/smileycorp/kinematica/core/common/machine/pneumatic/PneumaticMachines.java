package net.smileycorp.kinematica.core.common.machine.pneumatic;

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
import net.smileycorp.atlas.api.interfaces.IBlockProperties;

public class PneumaticMachines {
  	public static Set<Block> BLOCKS = new HashSet<Block>();
	public static Set<Item> ITEMS = new HashSet<Item>();

	public static Block AIR_COMPRESSOR;

	public static Block PRESSURISED_PIPE;
	public static Block PRESSURE_VESSEL;
	public static Block PRESSURE_REDUCING_VALVE;
	public static Block SAFETY_VALVE;
	public static Block BROKEN_SAFETY_VALVE;

	public static Block PNEUMATIC_PRESS;
  
	public static Block[] blocks = {};

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

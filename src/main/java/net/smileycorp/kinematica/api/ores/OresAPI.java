package net.smileycorp.kinematica.api.ores;

import net.minecraft.block.Block;
import net.smileycorp.kinematica.api.ores.blocks.IOreComposition;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class OresAPI {

	private static HashMap<String, Block> registry = new HashMap<String, Block>();
	private static HashMap<Block, Block> baseMap = new HashMap<Block, Block>();
	private static Map<Block, ItemOre> oreItems = new HashMap<Block, ItemOre>();

	public static <T extends Block> void registerOre(T ore) {
		if (!(ore instanceof IOreComposition)) return;
		registry.put(ore.getRegistryName().getResourcePath(), ore);
		baseMap.put(ore, ((IOreComposition)ore).getBase());
	}

	public static Block[] getOres() {
		Block[] array = {};
		return baseMap.keySet().toArray(array);
	}

	public static Block getBlockFor(String name) {
		if (registry.containsKey(name)) {
			return registry.get(name);
		}
		return null;
	}

	public static Block getBaseFor(Block ore) {
		if (baseMap.containsKey(ore)) {
			return baseMap.get(ore);
		}
		return null;
	}

	public static ItemOre getOreItem(Block block) {
		return oreItems.get(block);
	}

	public static void registerOreItem(Block block, ItemOre ore) {
		oreItems.put(block, ore);
	}

	public static Collection<ItemOre> getOreItems() {
		return oreItems.values();
	}

}

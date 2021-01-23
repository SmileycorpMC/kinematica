package net.smileycorp.kinematica.api.metal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fluids.Fluid;

public class MetalRegistry {

	private static Map<String, MetalEntry> metals = Maps.<String, MetalEntry>newHashMap();
	
	public static void registerMetal(String name, Color colour, boolean isShapeable) {
		metals.put(name, new MetalEntry(metals.size(), colour, isShapeable));
	}
	
	public static void registerMetalItem(String name, MetalType type, Item item) {
		registerMetalItem(name, type, new ItemStack(item));
	}
	
	public static void registerMetalItem(String name, MetalType type, Block block) {
		registerMetalItem(name, type, new ItemStack(block));
	}
	
	public static void registerMetalItem(String name, MetalType type, ItemStack stack) {
		metals.get(name).setMetalItem(type, stack);
	}
	
	
	public static void registerMetalFluid(String name, Fluid fluid) {
		metals.get(name).setFluid(fluid);
	}
	
	private static int getIndex(String name) {
		return metals.get(name).index;
	}
	
	public static Color getColour(String name) {
		if (metals.containsKey(name)) {
			return metals.get(name).colour;
		}
		return Color.WHITE;
	}
	
	public static boolean isShapeable(String name) {
		return metals.get(name).isShapeable;
	}
	
	public static List<String> getMetals() {
		List<String> result = new ArrayList<String>();
		Set<Entry<String, MetalEntry>> entries = metals.entrySet();
		for (Entry<String, MetalEntry> entry : entries) {
			result.add(entry.getKey());
		}
		return sortByIndex(result);
	}

	public static List<String> getMetalsFor(MetalType type) {
		List<String> result = new ArrayList<String>();
		Set<Entry<String, MetalEntry>> entries = metals.entrySet();
		for (Entry<String, MetalEntry> entry : entries) {
			MetalEntry metal = entry.getValue();
			if (!metal.hasItem(type)) {
				if (!isMachineShape(type)||metal.isShapeable) {
					result.add(entry.getKey());
				}
			}
		}
		return sortByIndex(result);
	}
	
	public static boolean isMachineShape(MetalType type) {
		return type==MetalType.GEAR || type==MetalType.PLATE || type==MetalType.ROD;
	}
	
	private static List<String> sortByIndex(List<String> result) {
		for (int i =  0; i<result.size(); i++) {
			boolean pass = true;
			for (int j =  0; j<result.size()-i-1;j++) {
				if (getIndex(result.get(j))>getIndex(result.get(j+1))) {
					Collections.swap(result, j, j+1);
					pass = false;
				}
			}
			if (pass) {
				break;
			}
		}
		return result;
	}
	
	public static ItemStack getItemFor(String name, MetalType type) {
		return getItemFor(name, type, 1);
	}
	
	public static ItemStack getItemFor(String name, MetalType type, int amount) {
		if (metals.containsKey(name)) {
			MetalEntry metal = metals.get(name);
			ItemStack stack;
			if (metal.hasItem(type)) {
				stack = metal.getItem(type).copy();
			} else {
				stack = new ItemStack(Blocks.AIR);
			}
			stack.setCount(amount);
			System.out.println("[MetalAPI] tried to get item " + stack + " from {" + name + ", "+type + ", " + amount +"}");
			return stack;
		}
		return null;
	}
	
	public enum MetalType {
		INGOT("Ingot", true),
		NUGGET("Nugget", true),
		DUST("Dust", true),
		GEAR("Gear", true),
		PLATE("Plate", true),
		ROD("Rod", true),
		BLOCK("Block", false),
		FLUID("Block", false);
		
		private final String name;
		private final Boolean isItem;
		
		MetalType(String name, Boolean isItem) {
			this.name = name;
			this.isItem = isItem;
		}
		
		public String getName() {
			return name;
		}

		public boolean isItem() {
			return isItem;
		}
	}

}

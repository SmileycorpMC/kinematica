package net.smileycorp.kinematica.api.metal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import net.minecraft.item.ItemStack;

public class NonMetalRegistry {
	static LinkedHashMap<String, Color> materials = new LinkedHashMap<String, Color>();
	static Map<String, ItemStack> linkedmaterials = new HashMap<String, ItemStack>();
	
	public static void addMaterial(String name, Color colour) {
		materials.put(name, colour);
	}
	
	public static void addMaterial(String name, ItemStack linkedItem) {
		linkedmaterials.put(name, linkedItem);
	}
	
	public static List<String> getMaterials() {
		List<String> result = new ArrayList<String>();
		Set<Entry<String, Color>> entries = materials.entrySet();
		for (Entry<String, Color> entry : entries) {
			result.add(entry.getKey());
		}
		return result;
	}
	
	public static boolean hasLinkedItem(String name) {
		return false;
	}
	
	public static ItemStack getLinkedItem(String name) {
		return ItemStack.EMPTY;
	}
	
}

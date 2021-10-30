package net.smileycorp.kinematica.api.metal;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.Loader;

import net.smileycorp.atlas.api.item.DummyItemBlock;
import net.smileycorp.kinematica.core.common.ModDefinitions;

public class MetalRegistry {
	

	static Map<String, MetalEntry> metals = Maps.<String, MetalEntry>newHashMap();
	
	private static boolean fixedDummys;
	private static boolean mekInstalled = Loader.isModLoaded("mekanism");
	private static boolean thermalInstalled = Loader.isModLoaded("thermalfoundation");
	
	public static void registerMetal(String name, String modid, Color colour, boolean isShapeable, int meltingTemp, int density) {
		metals.put(name, new MetalEntry(metals.size(), modid, name, colour, isShapeable, meltingTemp, density));
	}
	
	//register an item as the default itemstack for a given metal and shape
	public static void registerMetalItem(String name, MetalType type, Item item) {
		registerMetalItem(name, type, new ItemStack(item));
	}
	
	//register a block as the default itemstack for a given metal and shape
	public static void registerMetalItem(String name, MetalType type, Block block) {
		registerMetalItem(name, type, new ItemStack(new DummyItemBlock(block)));
		fixedDummys = false;
	}
	
	/*register an itemstack as the default itemstack for a given metal and shape
	do not use this to register blocks, if you need to register an itemblock with metadata or nbt use DummyItemBlock instead of the block or itemblock*/
	public static void registerMetalItem(String name, MetalType type, ItemStack stack) {
		if (stack.getItem() instanceof DummyItemBlock) fixedDummys = false;
		metals.get(name).setMetalItem(type, stack);
	}
	
	public static void registerMetalFluid(String name, Fluid fluid) {
		metals.get(name).setFluid(fluid);
	}
	
	public static void setFluidEnabled(String name, boolean enableFluid) {
		metals.get(name).setFluidEnabled(false);
	}
	
	private static int getIndex(String name) {
		return metals.get(name).index;
	}
	
	public static String getMod(String name) {
		if (metals.containsKey(name)) {
			MetalEntry metal = metals.get(name);
			return metal.modid;
		}
		return ModDefinitions.modid;
	}
	
	public static Color getColour(String name) {
		if (metals.containsKey(name)) {
			return metals.get(name).colour;
		}
		return Color.WHITE;
	}
	
	public static int getMeltingTemp(String name) {
		if (metals.containsKey(name)) {
			return metals.get(name).getMeltingTemp();
		}
		return 0;
	}
	
	public static int getDensity(String name) {
		if (metals.containsKey(name)) {
			return metals.get(name).getDensity();
		}
		return 0;
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
	
	public static List<String> getFluidMetals() {
		List<String> result = new ArrayList<String>();
		for (String metal : getMetals()) {
			if (!(metals.get(metal).hasFluid())&&metals.get(metal).shouldHaveFluid()) {
				result.add(metal);
			}
		}
		return result;
	}
	
	public static List<String> getMetalsFor(MetalType type) {
		return getMetalsFor(type, false);
	}

	public static List<String> getMetalsFor(MetalType type, boolean ignoreExisting) {
		List<String> result = new ArrayList<String>();
		Set<Entry<String, MetalEntry>> entries = metals.entrySet();
		for (Entry<String, MetalEntry> entry : entries) {
			MetalEntry metal = entry.getValue();
			if (!isMachineShape(type)||metal.isShapeable) {
				if(!(ignoreExisting&&metal.getItem(type)!=null))	{
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
	
	public static MetalType[] getTypesFor(String name) {
		List<MetalType> result = new ArrayList<MetalType>();
		for (MetalType type : MetalType.values()) {
			if (getItemFor(name, type)!=null) result.add(type);
		}
		return result.toArray(new MetalType[]{});
	}
	
	public static ItemStack getItemFor(String name, MetalType type) {
		return getItemFor(name, type, 1);
	}
	
	public static ItemStack getItemFor(String name, MetalType type, int amount) {
		if (!fixedDummys) fixDummys();
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
		System.out.println("[MetalAPI] failed to get any item from {" + name + ", "+type + ", " + amount +"}");
		return null;
	}
	
	public static Fluid getFluid(String name) {
		if (metals.containsKey(name)) {
			return metals.get(name).getFluid();
		}
		return null;
	}
	
	public static MetalStack createMetalStack(String name, int amount) {
		return new MetalStack(metals.get(name), amount);
	}
	
	private static void fixDummys() {
		for (MetalEntry entry : metals.values()) {
			for (MetalType type : MetalType.values()) {
				ItemStack stack0 = entry.getItem(type);
				if (stack0 != null) {
					Item item = entry.getItem(type).getItem();
					if (item instanceof DummyItemBlock) {
						ItemStack stack1 = new ItemStack(Item.getItemFromBlock(((DummyItemBlock)item).block), 1, stack0.getItemDamage());
						stack1.setTagCompound(stack0.getTagCompound());
						entry.setMetalItem(type, stack1);
					}
				}
			}
		}
		fixedDummys = true;
	}
	
	public static class MetalStack {
		final MetalEntry metal;
		final int amount;
		
		MetalStack(MetalEntry metal, int amount) {
			this.metal=metal;
			this.amount=amount;
		}
			
		public int getAmount() {
			return amount;
		}
		
		public MetalEntry getMetal() {
			return metal;
		}
		
	}

	public enum MetalType {
		INGOT("Ingot", true, 144),
		NUGGET("Nugget", true, 16),
		DUST("Dust", true, 144),
		GEAR("Gear", true, 576),
		PLATE("Plate", true, 144),
		ROD("Rod", true, 144),
		BLOCK("Block", false, 1296),
		DIRTY_DUST("Dirty_Dust", mekInstalled, 0),
		CLUMP("Clump", mekInstalled, 0),
		SHARD("Shard", mekInstalled, 0),
		CRYSTAL("Crystal", mekInstalled, 0),
		COIN("Coin", thermalInstalled, 0);
		
		private final String name;
		private final Boolean isItem;
		private final int fluidAmount;
		
		MetalType(String name, Boolean isItem, int fluidAmount) {
			this.name = name;
			this.isItem = isItem;
			this.fluidAmount=fluidAmount;
		}
		
		public String getName() {
			return name;
		}

		public boolean isItem() {
			return isItem;
		}
		
		public int fluidAmount() {
			return fluidAmount;
		}
	}

}

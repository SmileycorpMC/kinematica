package net.smileycorp.kinematica.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementUtils {
	protected static Map<String, List<String>> knownOres = new HashMap<String, List<String>>();
	protected static Map<String, String> atomicSymbols = new HashMap<String, String>();
	protected static Map<String, Integer> atomicNumbers = new HashMap<String, Integer>();
	
	public static List<String> getOtherNames(String name) {
		if (knownOres.containsKey(name.replace("_", ""))) {
			return knownOres.get(name.replace("_", ""));
		} else {
			return new ArrayList<String>();
		}
	}
	
	public static String getSymbol(String name) {
		if (atomicSymbols.containsKey(name)) {
			return atomicSymbols.get(name);
		} else return null;
	}
	
	public static int getNumber(String name) {
		if (atomicNumbers.containsKey(name)) {
			return atomicNumbers.get(name);
		} else return 0;
	}
	
	public static void registerAltOre(String oredict, String... altOredicts) {
		if (knownOres.containsKey(oredict)) {
			knownOres.get(oredict).addAll(Arrays.asList(altOredicts));
		} else {
			List<String> altOreList = new ArrayList<String>();
			altOreList.addAll(Arrays.asList(altOredicts));
			knownOres.put(oredict, altOreList);
		}
	}
	public static void registerElement(String name, String symbol, int number) {
		atomicSymbols.put(name, symbol);
		atomicNumbers.put(name, number);
	}
	
}

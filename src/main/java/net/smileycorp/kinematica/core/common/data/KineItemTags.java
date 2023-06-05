package net.smileycorp.kinematica.core.common.data;

import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.smileycorp.kinematica.core.common.Constants;

public class KineItemTags {

	public static final TagKey<Item> TIN_INGOT = registerForge("ingots/tin");
	public static final TagKey<Item> BRONZE_INGOT = registerForge("ingots/bronze");
	public static final TagKey<Item> CALCITE = registerForge("calcite");

	private static TagKey<Item> register(String name) {
		return ItemTags.create(Constants.loc(name));
	}

	private static TagKey<Item> registerForge(String name) {
		return ItemTags.create(Constants.loc(name));
	}

}

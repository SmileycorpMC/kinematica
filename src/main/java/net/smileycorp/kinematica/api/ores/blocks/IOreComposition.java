package net.smileycorp.kinematica.api.ores.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public interface IOreComposition {

	public default String[] getComposition() {
		return null;
	}

	default String localise(String string) {
		return I18n.translateToLocal("localisation." + string);
	}

	public Block getBase();

	public default boolean hasSpecialDrop() {
		return false;
	}

	public default boolean hasSpecialItem() {
		return false;
	}
}

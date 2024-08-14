package net.smileycorp.kinematica.api.ores.blocks;

import net.minecraft.block.Block;
import net.minecraft.util.text.translation.I18n;

@SuppressWarnings("deprecation")
public interface IOreComposition {

	default String[] getComposition() {
		return null;
	}

	default String localise(String string) {
		return I18n.translateToLocal("localisation." + string);
	}

	Block getBase();

	default boolean hasSpecialDrop() {
		return false;
	}

	default boolean hasSpecialItem() {
		return false;
	}
}

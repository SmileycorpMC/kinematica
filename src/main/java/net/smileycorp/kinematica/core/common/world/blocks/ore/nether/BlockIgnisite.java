package net.smileycorp.kinematica.core.common.world.blocks.ore.nether;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.smileycorp.atlas.api.block.BlockUtils;
import net.smileycorp.atlas.api.recipe.WeightedOutputs;
import net.smileycorp.kinematica.api.ores.blocks.BlockOreDropTable;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BlockIgnisite extends BlockOreDropTable {

	public BlockIgnisite() {
		super("Ignisite", 1, Blocks.NETHERRACK);
		setLightLevel(0.75f);
	}
	@Override
	public String[] getComposition() {
		return new String[] {"50% " + localise("Sulphur"),
				"30% " + localise("Blaze"),
				"20% " + localise("Phosphorus")};
	}

	@Override
	public WeightedOutputs<ItemStack> getDropTable(Random rand, int fortune) {
		Map<ItemStack, Integer> map = new HashMap<ItemStack, Integer>();
		map.put(new ItemStack(Items.GUNPOWDER), 5);
		map.put(new ItemStack(KineMaterials.MATERIAL_DUST), 3);
		map.put(new ItemStack(KineMaterials.MATERIAL_DUST, 1, 1), 2);
		return new WeightedOutputs<ItemStack>(BlockUtils.getFortune(fortune, 8, rand), map);
	}

}

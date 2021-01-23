package net.smileycorp.kinematica.core.common.recipes;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;

public class FurnaceRecipes {

	public static void registerRecipes() {
		GameRegistry.addSmelting(MachineBlocks.MUDBRICK, new ItemStack(MachineBlocks.FIRED_MUDBRICK), 0.5f);
		
	}

}

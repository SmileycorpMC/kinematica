package net.smileycorp.kinematica.core.common.recipes;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.smileycorp.atlas.api.block.FuelHandler;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class SmeltingRecipes {

	public static void registerRecipes() {
		GameRegistry.addSmelting(KineConstruction.MUDBRICK.getBase(), new ItemStack(KineConstruction.FIRED_MUDBRICK.getBase()), 0.5f);
		GameRegistry.addSmelting(KineConstruction.MUDBRICK.getStairs(), new ItemStack(KineConstruction.FIRED_MUDBRICK.getStairs()), 0.5f);
		GameRegistry.addSmelting(KineConstruction.MUDBRICK.getSlab(), new ItemStack(KineConstruction.FIRED_MUDBRICK.getSlab()), 0.5f);
		GameRegistry.addSmelting(KineWorld.MUD, new ItemStack(KineConstruction.ADOBE.getBase()), 0.5f);
		GameRegistry.addSmelting(new ItemStack(KineConstruction.DUSTS, 1, 1), new ItemStack(KineConstruction.DUSTS, 1, 3), 0.5f);
		GameRegistry.addSmelting(new ItemStack(KineMaterials.MATERIAL_DUST, 1, 7), new ItemStack(Items.BREAD), 0.5f);
	}

	public static void registerFuel() {
		FuelHandler fuel = FuelHandler.getInstance();
		fuel.registerFuel(new ItemStack(KineMaterials.MATERIALS, 1, 1), 2400);
		fuel.registerFuel(new ItemStack(KineMaterials.MATERIALS, 1, 2), 3200);
		fuel.registerFuel(KineWorld.SHARINGA_SAPLING, 100);
	}

}

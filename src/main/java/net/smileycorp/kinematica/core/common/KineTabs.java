package net.smileycorp.kinematica.core.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.tools.KineTools;
import net.smileycorp.kinematica.core.common.world.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class KineTabs {

	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

	public static final RegistryObject<CreativeModeTab> MATERIALS = TABS.register("materials", () -> CreativeModeTab.builder()
			.title(Component.translatable("creativetab." + Constants.MODID + ".materials"))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS).icon(() -> new ItemStack(KineMaterials.WOODEN_GEAR.get()))
			.displayItems(KineMaterials::fillMaterialsTab).build());

	public static final RegistryObject<CreativeModeTab> WORLD = TABS.register("world", () -> CreativeModeTab.builder()
			.title(Component.translatable("creativetab." + Constants.MODID + ".world"))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS).icon(() -> new ItemStack(KineWorld.LIMESTONE.getBase()))
			.displayItems(KineWorld::fillWorldTab).build());

	public static final RegistryObject<CreativeModeTab> TOOLS = TABS.register("tools", () -> CreativeModeTab.builder()
			.title(Component.translatable("creativetab." + Constants.MODID + ".tools"))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS).icon(() -> new ItemStack(KineTools.FIRESTARTER.get()))
			.displayItems(KineTools::fillToolsTab).build());

	public static final RegistryObject<CreativeModeTab> CONSTRUCTION = TABS.register("construction", () -> CreativeModeTab.builder()
			.title(Component.translatable("creativetab." + Constants.MODID + ".construction"))
			.withTabsBefore(CreativeModeTabs.SPAWN_EGGS).icon(() -> new ItemStack(KineConstruction.REFRACTORY_BRICKS.getBase()))
			.displayItems(KineConstruction::fillConstructionTab).build());


}

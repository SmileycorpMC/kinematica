package net.smileycorp.kinematica.core.common;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.item.ToolSet.ToolType;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.tools.KineTools;
import net.smileycorp.kinematica.core.common.world.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class KineTabs {

	public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Constants.MODID);

	public static final RegistryObject<CreativeModeTab> MATERIALS;

	public static final RegistryObject<CreativeModeTab> WORLD;

	public static final RegistryObject<CreativeModeTab> TOOLS;

	public static final RegistryObject<CreativeModeTab> CONSTRUCTION;


}

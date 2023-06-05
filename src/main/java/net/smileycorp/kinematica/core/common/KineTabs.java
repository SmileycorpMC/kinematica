package net.smileycorp.kinematica.core.common;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.item.ToolSet.ToolType;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.tools.KineTools;
import net.smileycorp.kinematica.core.common.world.KineMaterials;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class KineTabs {

	public static CreativeModeTab MATERIALS;
	public static CreativeModeTab WORLD;
	public static CreativeModeTab TOOLS;
	public static CreativeModeTab CONSTRUCTION;

	@SubscribeEvent
	public void registerTabs(CreativeModeTabEvent.Register event) {
		MATERIALS = event.registerCreativeModeTab(Constants.loc("materials"), builder -> builder.m_257941_(Component.translatable("itemGroup.kinematica.Materials"))
				.m_257737_(()->new ItemStack(KineMaterials.WOODEN_GEAR.get())).m_257501_((params, outputs) -> {
					for (RegistryObject<Item> reg: KineMaterials.ITEMS.getEntries()) {
						outputs.m_246326_(reg.get());
					}}));

		WORLD = event.registerCreativeModeTab(Constants.loc("world"), builder -> builder.m_257941_(Component.translatable("itemGroup.kinematica.World"))
				.m_257737_(()->new ItemStack(KineWorld.LIMESTONE.get())).m_257501_((params, outputs) -> {
					for (RegistryObject<Item> reg: KineWorld.ITEMS.getEntries()) {
						outputs.m_246326_(reg.get());
					}}));

		TOOLS = event.registerCreativeModeTab(Constants.loc("tools"), builder -> builder.m_257941_(Component.translatable("itemGroup.kinematica.Tools"))
				.m_257737_(()->new ItemStack(KineTools.COPPER.getItem(ToolType.PICKAXE))).m_257501_((params, outputs) -> {
					for (RegistryObject<Item> reg: KineTools.ITEMS.getEntries()) {
						outputs.m_246326_(reg.get());
					}
				}));

		CONSTRUCTION = event.registerCreativeModeTab(Constants.loc("construction"), builder -> builder.m_257941_(Component.translatable("itemGroup.kinematica.Construction"))
				.m_257737_(()->new ItemStack(KineConstruction.REFRACTORY_BRICKS.getBase())).m_257501_((params, outputs) -> {
					for (RegistryObject<Item> reg: KineConstruction.ITEMS.getEntries()) {
						outputs.m_246326_(reg.get());
					}
				}));
	}

}

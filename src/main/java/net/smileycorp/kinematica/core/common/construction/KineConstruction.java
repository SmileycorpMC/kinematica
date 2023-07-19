package net.smileycorp.kinematica.core.common.construction;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.construction.block.ShapedMudBlock;

import java.util.function.Supplier;

public class KineConstruction {

	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

	public static ShapedMudBlock BAUXITE = new ShapedMudBlock("bauxite", KineTabs.CONSTRUCTION, p->p.mapColor(MapColor.COLOR_ORANGE), ITEMS, BLOCKS);

	public static ShapedMudBlock PEAT = new ShapedMudBlock("peat", KineTabs.CONSTRUCTION, p->p.mapColor(MapColor.TERRACOTTA_BLACK), ITEMS, BLOCKS);

	public static ShapedBlock REFRACTORY_BRICKS = new ShapedBlock("refractory_bricks", KineTabs.CONSTRUCTION, Block.Properties.of().mapColor(MapColor.DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS).strength(2.2f, 10f),
			ITEMS, BLOCKS, true);

	private static RegistryObject<Block> registerBlock(String name, Block.Properties properties) {
		return registerBlock(name, ()-> new Block(properties));
	}

	private static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
		RegistryObject<Block> block = BLOCKS.register(name, supplier);
		ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}

	public static void fillConstructionTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {

	}
}

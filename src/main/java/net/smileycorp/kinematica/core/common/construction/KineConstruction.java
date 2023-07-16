package net.smileycorp.kinematica.core.common.construction;

import net.minecraft.client.resources.model.Material;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.Constants;

import java.util.function.Supplier;

public class KineConstruction {

	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

	//items
	//public static Item DUSTS = new ItemConstructionDusts();
	//public static Item MATERIALS = new ItemConstructionMaterials();

	public static RegistryObject<Block> POLISHED_LIMESTONE = registerBlock("polished_limestone", Block.Properties.of().mapColor(MapColor.SAND)
			.sound(SoundType.STONE).strength(1f, 6f).requiresCorrectToolForDrops());
	public static RegistryObject<Block> POLISHED_DOLOMITE = registerBlock("polished_dolomite", Block.Properties.of().mapColor(MapColor.SNOW)
			.sound(SoundType.STONE).strength(1f, 6f).requiresCorrectToolForDrops());

	public static RegistryObject<Block> POLISHED_PEGMATITE = registerBlock("polished_pegmatite", Block.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());
	public static ShapedBlock REFRACTORY_BRICKS = new ShapedBlock("refractory_bricks", BuiltInRegistries.CREATIVE_MODE_TAB.get(CreativeModeTabs.BUILDING_BLOCKS), Block.Properties.of().mapColor(MapColor.DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS).strength(2.2f, 10f),
			ITEMS, BLOCKS, false);

	private static RegistryObject<Block> registerBlock(String name, Block.Properties properties) {
		return registerBlock(name, ()-> new Block(properties));
	}

	private static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
		RegistryObject<Block> block = BLOCKS.register(name, supplier);
		ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}
}

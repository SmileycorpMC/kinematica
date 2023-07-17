package net.smileycorp.kinematica.core.common.world;

import net.minecraft.Util;
import net.minecraft.util.datafix.fixes.References;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.MudBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntityType.BlockEntitySupplier;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.WoodBlock;
import net.smileycorp.atlas.api.block.WoodBlockBuilder;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.world.block.BauxiteGrassBlock;
import net.smileycorp.kinematica.core.common.world.block.OreBlockEntity;
import net.smileycorp.kinematica.core.common.world.block.PeatGrassBlock;
import net.smileycorp.kinematica.core.common.world.entity.BlueWitherSkeleton;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KineWorld {

	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);
	public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Constants.MODID);
	public static DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Constants.MODID);

	public static RegistryObject<Block> BAUXITE_SOIL = registerBlock("bauxite_soil",() ->  new Block(BlockBehaviour.Properties.copy(Blocks.DIRT).mapColor(MapColor.COLOR_ORANGE)));
	public static RegistryObject<Block> BAUXITE_GRASS = registerBlock("bauxite_grass",() ->  new BauxiteGrassBlock());
	public static RegistryObject<Block> PEAT = registerBlock("peat",() ->  new MudBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).mapColor(MapColor.COLOR_ORANGE)));
	public static RegistryObject<Block> PEAT_GRASS = registerBlock("peat_grass", () ->  new PeatGrassBlock());
	public static RegistryObject<Block> LIMESTONE = registerBlock("limestone", Block.Properties.of().mapColor(MapColor.SAND)
			.sound(SoundType.STONE).strength(1f, 6f).requiresCorrectToolForDrops());
	public static RegistryObject<Block> DOLOMITE = registerBlock("dolomite", Block.Properties.of().mapColor(MapColor.SNOW)
			.sound(SoundType.STONE).strength(1f, 6f).requiresCorrectToolForDrops());

	public static RegistryObject<Block> PEGMATITE = registerBlock("pegmatite", Block.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());
	public static WoodBlock SHARINGA_WOOD = WoodBlockBuilder.of("sharinga", Constants.MODID, KineTabs.WORLD, ITEMS, BLOCKS)
			.barkColour(MapColor.TERRACOTTA_BROWN).plankColour(MapColor.TERRACOTTA_WHITE).decorationsTab(KineTabs.CONSTRUCTION).enableBoat().build();

	//ores
	public static RegistryObject<Block> TIN_ORE = registerBlock("tin_ore", Block.Properties.of().mapColor(MapColor.STONE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());
	public static RegistryObject<Block> ZINC_ORE = registerBlock("zinc_ore", Block.Properties.of().mapColor(MapColor.STONE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());

	public static RegistryObject<Block> CINNABAR_ORE = registerBlock("cinnabar_ore", Block.Properties.of().mapColor(MapColor.STONE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());
	public static RegistryObject<Block> SULPHUR_ORE = registerBlock("sulphur_ore", Block.Properties.of().mapColor(MapColor.STONE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());
	public static RegistryObject<Block> ANTHRACITE_ORE = registerBlock("anthracite_ore", Block.Properties.of().mapColor(MapColor.STONE)
			.sound(SoundType.STONE).strength(1.5f, 9f).requiresCorrectToolForDrops());

	public static RegistryObject<BlockEntityType<OreBlockEntity>> ORE_BLOCK_ENTITY = register("ore_block", (pos, state)-> new OreBlockEntity(pos, state, Blocks.STONE),
			TIN_ORE, ZINC_ORE, CINNABAR_ORE, SULPHUR_ORE, ANTHRACITE_ORE);

	public static final RegistryObject<EntityType<BlueWitherSkeleton>> BLUE_WITHER_SKELETON = ENTITIES.register("blue_wither_skeleton", () ->
	EntityType.Builder.<BlueWitherSkeleton>of(BlueWitherSkeleton::new, MobCategory.MONSTER).sized(0.7F, 2.5F).clientTrackingRange(8).build("blue_wither_skeleton"));

	private static RegistryObject<Block> registerBlock(String name, Block.Properties properties) {
		return registerBlock(name, ()-> new Block(properties));
	}

	private static RegistryObject<Block> registerBlock(String name, Supplier<Block> supplier) {
		RegistryObject<Block> block = BLOCKS.register(name, supplier);
		ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
		return block;
	}

	@SafeVarargs
	private static <T extends BlockEntity> RegistryObject<BlockEntityType<T>> register(String name, BlockEntitySupplier<T> supplier, RegistryObject<Block>... blocks) {
		return BLOCK_ENTITIES.register(name, () ->
		BlockEntityType.Builder.of(supplier, Stream.of(blocks).map((block)->block.get()).collect(Collectors.toList()).toArray(new Block[] {}))
		.build(Util.fetchChoiceType(References.BLOCK_ENTITY, Constants.locStr(name))));
	}

	public static void loadComplete() {
		SHARINGA_WOOD.registerStandardFuelValues();
	}

    public static void fillWorldTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
		output.accept(BAUXITE_SOIL.get());
		output.accept(BAUXITE_GRASS.get());
		output.accept(PEAT.get());
		output.accept(PEAT_GRASS.get());
		output.accept(LIMESTONE.get());
		output.accept(DOLOMITE.get());
		output.accept(PEGMATITE.get());
		output.accept(TIN_ORE.get());
		output.accept(ZINC_ORE.get());
		output.accept(CINNABAR_ORE.get());
		output.accept(SULPHUR_ORE.get());
		output.accept(ANTHRACITE_ORE.get());
    }
}

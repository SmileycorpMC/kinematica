package net.smileycorp.kinematica.core.common.world;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.atlas.api.block.BlockBase;
import net.smileycorp.atlas.api.block.IBlockProperties;
import net.smileycorp.atlas.api.client.CustomStateMapper;
import net.smileycorp.kinematica.api.ores.ItemOre;
import net.smileycorp.kinematica.api.ores.OresAPI;
import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.api.ores.blocks.BlockOreFalling;
import net.smileycorp.kinematica.api.ores.blocks.IOreComposition;
import net.smileycorp.kinematica.core.client.entity.RenderBlueWitherSkeleton;
import net.smileycorp.kinematica.core.client.model.mappers.StateMapperSharingaLog;
import net.smileycorp.kinematica.core.common.KineTabs;
import net.smileycorp.kinematica.core.common.ModDefinitions;
import net.smileycorp.kinematica.core.common.materials.KineMaterials;
import net.smileycorp.kinematica.core.common.world.blocks.*;
import net.smileycorp.kinematica.core.common.world.blocks.ore.nether.BlockAuragmus;
import net.smileycorp.kinematica.core.common.world.blocks.ore.nether.BlockIgnisite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.nether.BlockMyagminite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.pegmatite.BlockCorundum;
import net.smileycorp.kinematica.core.common.world.blocks.ore.pegmatite.BlockRutile;
import net.smileycorp.kinematica.core.common.world.blocks.ore.pegmatite.BlockWolframite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.*;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide.BlockAzurite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide.BlockCuprite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide.BlockDioptase;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.oxide.BlockMalachite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate.BlockBornite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate.BlockChalcocite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate.BlockChalcopyrite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.copper.sulphate.BlockCovellite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.platinum.BlockBraggite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.platinum.BlockCooperite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.stone.platinum.BlockVysotskite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.surface.BlockGoethite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.surface.BlockMagnetite;
import net.smileycorp.kinematica.core.common.world.blocks.ore.surface.BlockPyrolusite;
import net.smileycorp.kinematica.core.common.world.entity.EntityBlueWitherSkeleton;

import java.lang.reflect.Field;
import java.util.List;

public class KineWorld {
	public  static List<Block> BLOCKS = Lists.newArrayList();
	public  static List<Item> ITEMS = Lists.newArrayList();
	
	//main blocks
	public static Block MUD = new BlockMud();
	public static Block BOG_GRASS = new BlockBogGrass();
	public static Block BAUXITE_SOIL = new BlockBauxiteSoil();
	public static Block BAUXITE_GRASS = new BlockBauxiteGrass();
	public static Block LIMESTONE = new BlockBase("Limestone", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.BLOCKS);
	public static Block DOLOMITE = new BlockBase("Dolomite", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.BLOCKS);
	public static Block PEGMATITE = new BlockBase("Pegmatite", ModDefinitions.modid, Material.ROCK, SoundType.STONE, 1f, 6f, 0, KineTabs.BLOCKS);
	public static Block SHARINGA_LOG = new BlockSharingaLog();
	public static Block SHARINGA_LEAVES = new BlockSharingaLeaves();
	public static Block SHARINGA_SAPLING = new BlockSharingaSapling();
	
	//ores
	public static BlockCompositeOre ACANTHITE = new BlockAcanthite();
	public static BlockCompositeOre BAUXITE = new BlockBauxite();
	public static BlockCompositeOre BISMUTHINITE = new BlockBismuthinite();
	public static BlockCompositeOre CARROLLITE = new BlockCarrollite();
	public static BlockCompositeOre CASSITERITE = new BlockCassiterite();
	public static BlockCompositeOre CHROMITE = new BlockChromite();
	public static BlockCompositeOre CINNABAR = new BlockCinnabar();
	public static BlockCompositeOre ERYTHRITE = new BlockErythrite();
	public static BlockCompositeOre GALENA = new BlockGalena();
	public static BlockCompositeOre ILMENITE = new BlockIlmenite();
	public static BlockCompositeOre LIMONITE = new BlockLimonite();
	public static BlockCompositeOre MALDONITE = new BlockMaldonite();
	public static BlockCompositeOre NICKELINE = new BlockNickeline();
	public static BlockCompositeOre OSMIAN = new BlockOsmian();
	public static BlockCompositeOre POLARITE = new BlockPolarite();
	public static BlockCompositeOre SPHALERITE = new BlockSphalerite();
	public static BlockCompositeOre TEALLITE = new BlockTeallite();
	public static BlockCompositeOre GROUTITE = new BlockGroutite();
	public static BlockCompositeOre HEMATITE = new BlockHematite();
	public static BlockCompositeOre RHODONITE = new BlockRhodonite();;
	
	//copper oxides
	public static BlockCompositeOre AZURITE = new BlockAzurite();
	public static BlockCompositeOre CUPRITE = new BlockCuprite();
	public static BlockCompositeOre DIOPTASE = new BlockDioptase();
	public static BlockCompositeOre MALACHITE = new BlockMalachite();
	
	//copper sulphates
	public static BlockCompositeOre BORNITE = new BlockBornite();
	public static BlockCompositeOre CHALCOCITE = new BlockChalcocite();
	public static BlockCompositeOre CHALCOPYRITE = new BlockChalcopyrite();
	public static BlockCompositeOre COVELLITE = new BlockCovellite();
	
	//platinum sulphates
	public static BlockCompositeOre BRAGGITE = new BlockBraggite();
	public static BlockCompositeOre COOPERITE = new BlockCooperite();
	public static BlockCompositeOre VYSOTSKITE = new BlockVysotskite();
	
	//surface ores
	public static BlockCompositeOre GOETHITE = new BlockGoethite();
	public static BlockOreFalling MAGNETITE = new BlockMagnetite();
	public static BlockCompositeOre PYROLUSITE = new BlockPyrolusite();
	
	//pegmatite ores
	public static BlockCompositeOre CORUNDUM = new BlockCorundum();
	public static BlockCompositeOre RUTILE = new BlockRutile();
	public static BlockCompositeOre WOLFRAMITE = new BlockWolframite();
	
	//nether ores
	public static BlockCompositeOre IGNISITE = new BlockIgnisite();
	public static BlockCompositeOre AURAGMUS = new BlockAuragmus();
	public static BlockCompositeOre MYAGMINITE = new BlockMyagminite();
	
	public static BlockOreBase ANTHRACITE_ORE = new BlockOreBase("Anthracite", 0, new ItemStack(KineMaterials.MATERIALS, 1, 1), 1, 2);
	
	public static BlockOreBase NETHER_GOLD_ORE = new BlockOreBase("Nether_Gold", 2, new ItemStack(Items.GOLD_NUGGET), 5, 11, Blocks.NETHERRACK);
	public static BlockOreBase NETHER_SULPHUR_ORE = new BlockOreBase("Nether_Sulphur", 2, new ItemStack(KineMaterials.MATERIAL_DUST), 5, 11, Blocks.NETHERRACK);
	
	public static BlockCompositeOre[] stoneOres = {ACANTHITE, AZURITE, BAUXITE, BISMUTHINITE, BORNITE, BRAGGITE, CARROLLITE, CASSITERITE, CHALCOCITE, CHALCOPYRITE,
			CHROMITE, CINNABAR, COOPERITE, COVELLITE, CUPRITE, DIOPTASE, ERYTHRITE, GALENA, ILMENITE, LIMONITE, MALACHITE,
			MALDONITE, NICKELINE, OSMIAN, POLARITE, SPHALERITE, TEALLITE, VYSOTSKITE, GROUTITE, HEMATITE, RHODONITE};
	
	public static void registerBlocks(IForgeRegistry<Block> registry) {
		for (Field field : KineWorld.class.getDeclaredFields()) {
			try {
				Object object = field.get(null);
				if (!(object instanceof Block) || object == null) continue;
				register(registry, (Block) object);
				if (object instanceof IOreComposition) OresAPI.registerOre((Block)object);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static <T extends Block> void register(IForgeRegistry<Block> registry, T block) {
		registry.register(block);
		BLOCKS.add(block);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Block block : BLOCKS) {
			if (block instanceof IBlockProperties && ((IBlockProperties) block).usesCustomItemHandler()) continue;
			Item item = newItemBlock(block);
			item.setRegistryName(block.getRegistryName());
			item.setUnlocalizedName(block.getUnlocalizedName());
			registry.register(item);
			ITEMS.add(item);
			if (block instanceof IOreComposition) if (!((IOreComposition)block).hasSpecialDrop()) {
				ItemOre ore = new ItemOre(block);
				OresAPI.registerOreItem(block, ore);
				registry.register(ore);
			}
		}
	}
	
	private static Item newItemBlock(Block block) {
		if (block instanceof BlockOreBase) return new ItemBlockOreBase((BlockOreBase) block);
		return new ItemBlock(block);
	}
	
	public static void customRegistry(Block block, ItemBlock item, IForgeRegistry<Item> registry) {
		item.setRegistryName(block.getRegistryName());
		item.setUnlocalizedName(block.getUnlocalizedName());
		registry.register(item);
		ITEMS.add(item);
	}
	
	public static void registerEntities(IForgeRegistry<EntityEntry> registry) {
		int ID = 201;
		EntityEntry blue_wither_skeleton = EntityEntryBuilder.create().entity(EntityBlueWitherSkeleton.class)
				.id(ModDefinitions.getResource("blue_wither_skeleton"), ID++)
				.name(ModDefinitions.getName("BlueWitherSkeleton"))
				.tracker(80, 3, true).egg(0x00122D, 0x616868).build();
		registry.register(blue_wither_skeleton);
	}
	
	public static void registerModels(ModelRegistryEvent event) {
		RenderingRegistry.registerEntityRenderingHandler(EntityBlueWitherSkeleton.class, m-> new RenderBlueWitherSkeleton(m));
		for (Block block : BLOCKS) {
			final ResourceLocation loc = ForgeRegistries.BLOCKS.getKey(block);
			if (block instanceof IBlockProperties) {
				if(((IBlockProperties) block).useInventoryVariant()) {
					ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "inventory"));
					continue;
				}
			}
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "normal"));
		}
		ModelLoader.setCustomStateMapper(SHARINGA_LOG, new StateMapperSharingaLog());
		ModelLoader.setCustomStateMapper(SHARINGA_LEAVES, new CustomStateMapper(ModDefinitions.modid, "sharinga_leaves", "normal"));
		ModelLoader.setCustomStateMapper(SHARINGA_SAPLING, new CustomStateMapper(ModDefinitions.modid, "sharinga_sapling", "normal"));
	}
}

package net.smileycorp.kinematica.core.common.construction;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.Constants;

public class KineConstruction {

	public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Constants.MODID);
	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

	//items
	//public static Item DUSTS = new ItemConstructionDusts();
	//public static Item MATERIALS = new ItemConstructionMaterials();

	//shaped blocks
	/*public static ShapedBlock MUDBRICK = new ShapedBlock("mudbrick", CreativeModeTabs.f_256837_, Block.Properties.of(Material.CLAY, MaterialColor.DIRT).sound(SoundType.GRAVEL).strength(0.85f, 2f),
			ITEMS, BLOCKS, false);
	public static ShapedBlock FIRED_MUDBRICK = new ShapedBlock("fired_mudbrick", CreativeModeTabs.f_256837_, Block.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).strength(1.2f, 6f),
			ITEMS, BLOCKS, false);
	public static ShapedBlock ADOBE = new ShapedBlock("adobe", CreativeModeTabs.f_256837_, Block.Properties.of(Material.STONE, MaterialColor.DIRT).sound(SoundType.STONE).strength(1f, 5f),
			ITEMS, BLOCKS, false);*/
	public static ShapedBlock REFRACTORY_BRICKS = new ShapedBlock("refractory_bricks", CreativeModeTabs.f_256837_, Block.Properties.of(Material.STONE, MaterialColor.DEEPSLATE).sound(SoundType.DEEPSLATE_BRICKS).strength(2.2f, 10f),
			ITEMS, BLOCKS, false);

	/*public static Block REINFORCED_CONCRETE_POWDER;
	public static Block REINFORCED_CONCRETE;

	public static Block SCAFFOLDING;*/

	/*public static Block[] blocks = {};
	public static ShapedBlock[] shapedBlocks = {SHARINGA_PLANKS, MUDBRICK, FIRED_MUDBRICK, ADOBE, REFRACTORY_BRICK};
	//public static Item[] items = {DUSTS, MATERIALS};

	/*public static void registerBlocks(IForgeRegistry<Block> registry) {
		for (ShapedBlock block:shapedBlocks) {
			block.registerBlocks(registry);
		}
		//registry.registerAll(blocks);
	}

	public static void registerItems(IForgeRegistry<Item> registry) {
		for (final Item item : items) {
			registry.register(item);
			ITEMS.add(item);
		}
		for (ShapedBlock block:shapedBlocks) {
			block.registerItems(registry);
			block.registerRecipes();
		}
		for (final Block block : blocks) {
			Item item = new ItemBlock(block);
			item.setRegistryName(block.getRegistryName());
			item.setUnlocalizedName(block.getUnlocalizedName());
			registry.register(item);
			ITEMS.add(item);
		}
	}

	public static void registerModels(ModelRegistryEvent event) {
		for (Item item : items) {
			if (item instanceof IMetaItem) {
				for(int meta = 0; meta<=((IMetaItem)item).getMaxMeta(); meta++) {
					RenderingUtils.setMetaModel(ModDefinitions.modid, item, meta);
				}
			} else {
				ModelLoader.setCustomModelResourceLocation(item, 0,new ModelResourceLocation(item.getRegistryName().toString()));
			}
		}
		for (ShapedBlock block:shapedBlocks) {
			block.registerModels();
		}
		for (Block block : blocks) {
			final ResourceLocation loc = ForgeRegistries.BLOCKS.getKey(block);
			if (block instanceof IBlockProperties) {
				if(((IBlockProperties) block).useInventoryVariant()) {
					ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "inventory"));
					continue;
				}
			}
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "normal"));
		}
	}*/
}

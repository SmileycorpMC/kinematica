package net.smileycorp.kinematica.core.common.machine.mechanical;

import java.util.HashSet;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.smileycorp.atlas.api.interfaces.IBlockProperties;

public class MechanicalMachines {

    public static Set<Block> BLOCKS = new HashSet<Block>();
	  public static Set<Item> ITEMS = new HashSet<Item>();
    
    //Power Transfer
	public static Block WOODEN_AXEL;
    public static Block STONE_AXEL;
	public static Block MECHANICAL_AXEL;
    public static Block WOODEN_GEARBOX;
    public static Block STONE_GEARBOX;
    public static Block MECHANICAL_GEARBOX;
    
    //Machines
    public static Block GRINDING_MILL;
    public static Block HEAVY_MILL;
    public static Block BELT_DRIVE;
    public static Block MECHANICAL_PUMP;
    public static Block MECHANICAL_FAN;
    public static Block MECHANICAL_PISTON;
    
    //Basic Generators
    public static Block HANDCRANK;
    public static Block WOODEN_WIND_TURBINE;
    public static Block WOODEN_WATER_TURBINE;
    public static Block BASIC_TREADMILL;
    
    //Advanced Generators
    public static Block WIND_TURBINE;
    public static Block WATER_TURBINE;
    public static Block STEAM_TURBINE;
    public static Block TREADMILL;
    
    //Electric
    public static Block ACYCLIC_GENERATOR;
    public static Block MOTOR;
    
    //Transfer
    public static Block MECHANICAL_BELT;
    public static Block MECHANICAL_PIPE;
    public static Block MECHANICAL_DUCT;
    
    public static Block[] blocks = {};

    public static void registerBlocks(IForgeRegistry<Block> registry) {
      registry.registerAll(blocks);
    }

    public static void registerItems(IForgeRegistry<Item> registry) {
      for (final Block block : blocks) {
        if (block instanceof IBlockProperties) {
          if (!((IBlockProperties)block).usesCustomItemHandler()) {
            register(block, registry);
          }
        } else {
          register(block, registry);
        }
      }
    }

    private static void register(Block block, IForgeRegistry<Item> registry) {
      Item item = new ItemBlock(block);
      item.setRegistryName(block.getRegistryName());
      item.setUnlocalizedName(block.getUnlocalizedName());
      registry.register(item);
      ITEMS.add(item);
    }

    public static void registerModels(ModelRegistryEvent event) {
      for (Block block : blocks) {
        final ResourceLocation loc = ForgeRegistries.BLOCKS.getKey(block);
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(loc, "normal"));
      }
    }
}

package net.smileycorp.kinematica.core.common;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.ResourceLocation;
import net.smileycorp.atlas.api.interfaces.IBlockProperties;

public class BlockBase extends Block implements IBlockProperties {
	
	public BlockBase(String name, String modid, Material material, SoundType sound, float h, float r, String tool, int level,
			CreativeTabs tab) {
			super(material);
			setResistance(r);
			setHardness(h);
			setHarvestLevel(tool, level);
			setUnlocalizedName(modid + "." + name.replace("_", ""));
			setRegistryName(new ResourceLocation(modid, name.toLowerCase()));
			setCreativeTab(tab);
			setSoundType(sound);
		}
	
	public BlockBase(String name, Material material, SoundType sound, float h, float r, String tool, int level,
		CreativeTabs tab) {
		this(name, ModDefinitions.modid, material, sound, h, r, tool, level, tab);
	}
	
	public BlockBase(String name, Material material, SoundType sound, float h, float r, String tool, int level) {
		this(name, ModDefinitions.modid, material, sound, h, r, tool, level, KineTabs.BLOCKS);
	}
	
    public BlockBase(String name, Material material, SoundType sound, float h, float r, int level) {
		this(name, ModDefinitions.modid, material, sound, h, r, "pickaxe", level, KineTabs.BLOCKS);
	}

	public BlockBase(String name, Material material, SoundType sound, float h, float r, int level, CreativeTabs tab) {
		this(name, ModDefinitions.modid, material, sound, h, r, "pickaxe", level, tab); 
	}
		
	public BlockBase(String name, String modid, Material material, SoundType sound, float h, float r, String tool, int level) {
		this(name, modid, material, sound, h, r, tool, level, KineTabs.BLOCKS);
	}
	
    public BlockBase(String name, String modid, Material material, SoundType sound, float h, float r, int level) {
		this(name, modid, material, sound, h, r, "pickaxe", level, KineTabs.BLOCKS);
	}

	public BlockBase(String name, String modid, Material material, SoundType sound, float h, float r, int level, CreativeTabs tab) {
		this(name, modid, material, sound, h, r, "pickaxe", level, tab); 
	}

}

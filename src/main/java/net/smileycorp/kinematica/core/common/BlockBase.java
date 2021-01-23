package net.smileycorp.kinematica.core.common;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.smileycorp.atlas.api.interfaces.IBlockProperties;

public class BlockBase extends Block implements IBlockProperties {
	
	public BlockBase(String name, Material material, SoundType sound, float h, float r, String tool, int level,
		CreativeTabs tab) {
		super(material);
		setResistance(r);
		setHardness(h);
		setHarvestLevel(tool, level);
		setUnlocalizedName(ModDefinitions.getName(name));
		setRegistryName(ModDefinitions.getResource(name));
		setCreativeTab(tab);
		setSoundType(sound);
	}
	
	public BlockBase(String name, Material material, SoundType sound, float h, float r, String tool, int level) {
		this(name, material, sound, h, r, tool, level, KineTabs.BLOCKS);
	}
	
    public BlockBase(String name, Material material, SoundType sound, float h, float r, int level) {
		this(name, material, sound, h, r, "pickaxe", level);
	}

	public BlockBase(String name, Material material, SoundType sound, float h, float r, int level, CreativeTabs tab) {
		this(name, material, sound, h, r, "pickaxe", level, tab); 
	}

}

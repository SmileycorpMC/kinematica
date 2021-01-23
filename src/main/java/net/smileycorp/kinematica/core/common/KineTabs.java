package net.smileycorp.kinematica.core.common;

import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.kinematica.core.common.machine.blocks.MachineBlocks;
import net.smileycorp.kinematica.core.common.world.blocks.WorldBlocks;

public class KineTabs {
	
	static Random rand = new Random();
	
	private static ItemStack chooseItem(CreativeTabs tab) {
		NonNullList<ItemStack> stacks = NonNullList.<ItemStack>create();
		tab.displayAllRelevantItems(stacks);
		return stacks.get(rand.nextInt(stacks.size()));
	}
	
	public static CreativeTabs MATERIALS = new CreativeTabs(ModDefinitions.getName("Materials")){
		ItemStack iconItemStack;
		
		
		
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack(){
			
			if (iconItemStack == null) {
				iconItemStack = chooseItem(this);
			} else if (ModDefinitions.ticker%35==0) {
				if (rand.nextInt(12)==0) {
					iconItemStack = chooseItem(this);		
				}
			}
			return this.iconItemStack;
		 }
		
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return getIconItemStack();
		}
	};
	 
	 public static CreativeTabs BLOCKS = new CreativeTabs(ModDefinitions.getName("Blocks")){
		 
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(WorldBlocks.LIMESTONE);
		}
	 };

	public static CreativeTabs MACHINES = new CreativeTabs(ModDefinitions.getName("Machines")){
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem(){
			return new ItemStack(MachineBlocks.FIRED_MUDBRICK);
		 }
	 };
}

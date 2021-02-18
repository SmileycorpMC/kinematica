package net.smileycorp.kinematica.core.common;

import java.util.Collection;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.smileycorp.kinematica.core.common.machine.BasicMachines;
import net.smileycorp.kinematica.core.common.tools.Tools;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class KineTabs {
	
	static Random rand = new Random();
	
	private static ItemStack chooseItem(CreativeTabs tab) {
		NonNullList<ItemStack> stacks = NonNullList.<ItemStack>create();
		tab.displayAllRelevantItems(stacks);
		return stacks.get(rand.nextInt(stacks.size()));
	}
	
	private static ItemStack chooseItem(Collection<Item> items) {
		return new ItemStack((Item) items.toArray()[rand.nextInt(items.size())]);
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
	
	public static CreativeTabs TOOLS = new CreativeTabs(ModDefinitions.getName("Tools")){
		 
		ItemStack iconItemStack;
		
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack(){
			
			if (iconItemStack == null) {
				iconItemStack = chooseItem(this);
			} else if (ModDefinitions.ticker%35==0) {
				if (rand.nextInt(12)==0) {
					iconItemStack = chooseItem(Tools.COPPER.getItems());		
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
			return new ItemStack(KineWorld.LIMESTONE);
		}
	 };

	public static CreativeTabs MACHINES = new CreativeTabs(ModDefinitions.getName("Machines")){
		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem(){
			return new ItemStack(BasicMachines.KILN_FIRE);
		 }
	 };
}

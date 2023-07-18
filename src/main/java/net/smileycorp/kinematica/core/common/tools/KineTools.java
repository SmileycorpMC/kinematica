package net.smileycorp.kinematica.core.common.tools;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.item.CustomTier;
import net.smileycorp.atlas.api.item.ToolSet;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.KineTabs;

public class KineTools {

	public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

	public static RegistryObject<Item> FIRESTARTER = ITEMS.register("firestarter", ()-> new ItemFireStarter(false));
	public static RegistryObject<Item> TINDERBOX = ITEMS.register("tinderbox", ()-> new ItemFireStarter(true));
	public static ToolSet COPPER = new ToolSet("copper", new CustomTier(141, 6.0F, 4.0F, 1, 7, ()->Ingredient.of(Tags.Items.INGOTS_COPPER)), KineTabs.TOOLS, ITEMS);

    //public static ToolSet BRONZE = new ToolSet("bronze", new CustomTier(210, 6.0F, 5F, 2, 16, ()->Ingredient.m_204132_(KineItemTags.BRONZE_INGOT)), KineTabs.TOOLS, ITEMS);

	public static void fillToolsTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output output) {
		output.accept(FIRESTARTER.get());
		output.accept(TINDERBOX.get());
	}

}

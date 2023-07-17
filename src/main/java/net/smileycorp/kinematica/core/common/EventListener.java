package net.smileycorp.kinematica.core.common;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.client.event.RecipesUpdatedEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.smileycorp.atlas.common.AtlasLib;
import net.smileycorp.kinematica.core.common.world.KineWorld;
import net.smileycorp.kinematica.core.common.world.entity.BlueWitherSkeleton;

@EventBusSubscriber(modid = Constants.MODID)
public class EventListener {

	@SubscribeEvent
	public static void recipeLoad(RecipesUpdatedEvent event) {
		RecipeManager manager = event.getRecipeManager();
		ItemStack coal = new ItemStack(Items.COAL, 64);
		for (Recipe<?> recipe : manager.getAllRecipesFor(RecipeType.CRAFTING)) {
			for (Ingredient ingredient : recipe.getIngredients()) {
				if (ingredient.test(coal)) {

				}
			}
		}
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(KineWorld.BLUE_WITHER_SKELETON.get(), BlueWitherSkeleton.createAttributes().build());
	}

}

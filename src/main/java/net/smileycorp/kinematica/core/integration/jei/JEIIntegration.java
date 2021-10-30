package net.smileycorp.kinematica.core.integration.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.IRecipeCategoryRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;

import net.minecraft.item.ItemStack;

import net.smileycorp.kinematica.core.common.machine.BasicMachines;
import net.smileycorp.kinematica.core.integration.jei.kiln.KilnRecipeCategory;
import net.smileycorp.kinematica.core.integration.jei.kiln.KilnRecipeHandler;
import net.smileycorp.kinematica.core.integration.jei.kiln.KilnRecipeLoader;
import net.smileycorp.kinematica.core.integration.jei.kiln.KilnRecipeWrapper;

@JEIPlugin
public class JEIIntegration implements IModPlugin {
	public static IJeiHelpers jeiHelpers;
	
	@Override
	public void register(@Nonnull IModRegistry registry) {
		jeiHelpers = registry.getJeiHelpers();
		
		registry.handleRecipes(KilnRecipeWrapper.class, new KilnRecipeHandler(),KilnRecipeCategory.ID);
		
		registry.addRecipeCatalyst(new ItemStack(BasicMachines.KILN_FIRE), VanillaRecipeCategoryUid.FUEL);
		registry.addRecipeCatalyst(new ItemStack(BasicMachines.KILN_FIRE), KilnRecipeCategory.ID);
		
		registry.addRecipes(KilnRecipeLoader.getRecipes(jeiHelpers), KilnRecipeCategory.ID);
	}
	
	@Override
	public void registerCategories(IRecipeCategoryRegistration registry) {
		jeiHelpers = registry.getJeiHelpers();
		IGuiHelper guiHelper = jeiHelpers.getGuiHelper();
		registry.addRecipeCategories(new KilnRecipeCategory(guiHelper));
	}
}

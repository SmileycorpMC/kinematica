package net.smileycorp.kinematica.core.integration.jei.kiln;

import javax.annotation.Nonnull;

import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IDrawableAnimated;
import mezz.jei.api.gui.IDrawableStatic;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.translation.I18n;
import net.smileycorp.kinematica.core.common.ModDefinitions;

@SuppressWarnings("deprecation")
public class KilnRecipeCategory implements IRecipeCategory<KilnRecipeWrapper> {

	public static final String ID = ModDefinitions.getName("kiln");
	
	private final IDrawable background;
	protected final IDrawableAnimated arrow;
	
	public static ResourceLocation LOCATION = ModDefinitions.getResource("textures/gui/jei/kiln.png");
	
	public KilnRecipeCategory(IGuiHelper guiHelper) {
		this.background = guiHelper.createDrawable(LOCATION, 0, 0, 106, 50);
		IDrawableStatic arrowDrawable = guiHelper.createDrawable(LOCATION, 106, 0, 24, 17);
		this.arrow = guiHelper.createAnimatedDrawable(arrowDrawable, 160, IDrawableAnimated.StartDirection.LEFT, false);
	}
	
	@Override
	public IDrawable getBackground() {
		return background;
	}

	@Override
	public String getModName() {
		return ModDefinitions.modid;
	}
	
	@Override
	  public void drawExtras(@Nonnull Minecraft minecraft) {
	    arrow.draw(minecraft, 47, 7);
	}

	@Override
	public String getTitle() {
		return I18n.translateToLocal("jei.category.kinematica.Kiln").trim();
	}

	@Override
	public String getUid() {
		return ID;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, KilnRecipeWrapper recipeWrapper, IIngredients ingredients) {
		IGuiItemStackGroup items = recipeLayout.getItemStacks();
		items.init(0, true, 2, 7);
		items.init(1, true, 20, 7);
		items.init(2, false, 82, 7);
		
		recipeLayout.getItemStacks().set(0, ingredients.getInputs(ItemStack.class).get(0));
		if (ingredients.getInputs(ItemStack.class).size()>1) {
			recipeLayout.getItemStacks().set(1, ingredients.getInputs(ItemStack.class).get(1));
		}
	    recipeLayout.getItemStacks().set(2, ingredients.getOutputs(ItemStack.class).get(0));
	}

}

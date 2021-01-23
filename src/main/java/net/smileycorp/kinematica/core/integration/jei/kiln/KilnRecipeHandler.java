package net.smileycorp.kinematica.core.integration.jei.kiln;

import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;

public class KilnRecipeHandler implements IRecipeWrapperFactory<KilnRecipeWrapper> {

	@Override
	public IRecipeWrapper getRecipeWrapper(KilnRecipeWrapper recipe) {
		return recipe;
	}

}

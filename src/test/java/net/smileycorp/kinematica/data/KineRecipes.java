package net.smileycorp.kinematica.data;

import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.construction.block.ShapedMudBlock;
import net.smileycorp.kinematica.core.common.construction.block.ShapedStoneBlock;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.function.Consumer;

public class KineRecipes extends RecipeProvider {

	public KineRecipes(PackOutput gen) {
		super(gen);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> writer) {
		stoneBlock(KineWorld.LIMESTONE, writer);
		stoneBlock(KineWorld.DOLOMITE, writer);
		stoneBlock(KineWorld.PEGMATITE, writer);
		registerMudBlock(KineConstruction.BAUXITE, writer);
		registerMudBlock(KineConstruction.PEAT, writer);
		shapedBlock("refractory_bricks", KineConstruction.REFRACTORY_BRICKS, writer);
	}

	public void shapedBlock(String name, ShapedBlock block, Consumer<FinishedRecipe> writer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getSlab(), 6)
				.pattern("bbb")
				.define('b', block.getBase())
				.unlockedBy("has_"+name, inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
				.save(writer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getStairs(), 4)
				.pattern("b  ").pattern("bb ").pattern("bbb")
				.define('b', block.getBase())
				.unlockedBy("has_"+name, inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
				.save(writer);
		if (block.getWall() != null) {
			ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getWall(), 6)
					.pattern("bbb").pattern("bbb")
					.define('b', block.getBase())
					.unlockedBy("has_"+name, inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
					.save(writer);
		}
	}

	public void stoneBlock(ShapedStoneBlock block, Consumer<FinishedRecipe> writer) {
		shapedBlock(block.getName(), block, writer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getChiseled(), 1)
				.pattern("s").pattern("s")
				.define('s', block.getSlab())
				.unlockedBy("has_"+block.getName()+"_slab", inventoryTrigger(ItemPredicate.Builder.item().of(block.getSlab()).build()))
				.save(writer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getPillar(), 2)
				.pattern("b").pattern("b")
				.define('b', block.getBase())
				.unlockedBy("has_"+block.getName(), inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
				.save(writer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.get(ShapedStoneBlock.StoneShape.BRICK).getBase(), 4)
				.pattern("bb").pattern("bb")
				.define('b', block.getBase())
				.unlockedBy("has_"+block.getName(), inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
				.save(writer);
		ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, block.getButton(), 1)
				.requires(block.getBase())
				.unlockedBy("has_"+block.getName(), inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
				.save(writer);
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getPressurePlate(), 1)
				.pattern("bb")
				.define('b', block.getBase())
				.unlockedBy("has_"+block.getName(), inventoryTrigger(ItemPredicate.Builder.item().of(block.getBase()).build()))
				.save(writer);
		for (ShapedStoneBlock.StoneShape shape : ShapedStoneBlock.StoneShape.values()) {
			shapedBlock(shape.getName(block.getName()), block.get(shape), writer);
		}
	}

	public void registerMudBlock(ShapedMudBlock block, Consumer<FinishedRecipe> writer) {
		ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block.getBase(), 4)
				.pattern("pp").pattern("pp")
				.define('p', block.getPackedBlock())
				.unlockedBy("has_packed_"+block.getName(), inventoryTrigger(ItemPredicate.Builder.item().of(block.getPackedBlock()).build()))
				.save(writer);
		shapedBlock(block.getName()+"_bricks", block, writer);
	}

}

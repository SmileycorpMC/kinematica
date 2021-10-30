package net.smileycorp.kinematica.api.recipes;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import net.minecraft.item.ItemStack;
import net.smileycorp.atlas.api.util.RecipeUtils;

public class CrushingRecipes {
	
	public static CrushingRecipes INSTANCE = new CrushingRecipes();

	private final Map<ItemStack, Object> crushingResults = new HashMap<ItemStack, Object>();

	/*
	 * adds a recipe, guaranteed to give one item input - the item stack of the
	 * item(or block) used as input output - the ItemStack received as an output
	 */
	/*public void addRecipe(ItemStack input, ItemStack... outputs) {
		if (isInputValid(input)) {
			crushingResults.put(input.copy(), outputs);
		}
	}

	/*
	 * adds a recipe for every item of the ore dictionary entry, guaranteed to
	 * give one item oreDictionaryInput - the string with which the ore
	 * dictionaries were registered outputs - a list of ItemStacks received as
	 * an output
	 */
	/*public void addRecipe(String oreDictionaryInput, ItemStack... outputs) {
		NonNullList<ItemStack> ores = OreDictionary.getOres(oreDictionaryInput);
		for (ItemStack input : ores) {
			addRecipe(input, outputs);
		}
	}

	/*
	 * adds a recipe, giving one of a number of items input - the item stack of
	 * the item(or block) used as input outputs - a list of possible outputs in
	 * the format of (ItemStack, chance), a higher chance being, more likely to
	 * show up
	 */
	/*public void addRecipe(ItemStack input, WeightedStack... weightedOutputs) {
		addRecipe(input, 1, weightedOutputs);
	}

	/*
	 * adds a recipe giving many of a number of items input - the item stack of
	 * the item(or block) used as input amount - the amount of items created
	 * from the process outputs - a list of possible outputs in the format of
	 * (ItemStack, chance), a higher chance being, more likely to show up
	 */
	/*public void addRecipe(ItemStack input, int amount,
			WeightedStack... weightedOutputs) {
		if (isInputValid(input)) {
			WeightedOutputs results = new WeightedOutputs(amount,
					weightedOutputs);
			crushingResults.put(input.copy(), results);
		}
	}

	/*
	 * adds a recipe for every item of the ore dictionary entry, giving one of a
	 * number of items oreDictionaryInput - the string with which the ore
	 * dictionaries were registered outputs - a list of possible outputs in the
	 * format of (ItemStack, chance), a higher chance being, more likely to show
	 * up
	 */
	/*public void addRecipe(String oreDictionaryInput,
			WeightedStack... weightedOutputs) {
		addRecipe(oreDictionaryInput, 1, weightedOutputs);
	}

	/*
	 * adds a recipe for every item of the ore dictionary entry, giving one of a
	 * number of items oreDictionaryInput - the string with which the ore
	 * dictionaries were registered amount - the amount of items created from
	 * the process outputs - a list of possible outputs in the format of
	 * (ItemStack, chance), a higher chance being, more likely to show up
	 */
	/*public void addRecipe(String oreDictionaryInput, int amount,
			WeightedStack... weightedOutputs) {
		NonNullList<ItemStack> ores = OreDictionary.getOres(oreDictionaryInput);
		for (ItemStack input : ores) {
			addRecipe(input.copy(), amount, weightedOutputs);
		}
	}

	public ItemStack[] getCrushingResults(ItemStack stack) {
		Object result = this.getMapResult(stack);
		if (result instanceof ItemStack[]) {
			ItemStack[] outputs = (ItemStack[]) result;
			return outputs;
		} else if (result instanceof WeightedOutputs) {
			WeightedOutputs output = (WeightedOutputs) result;
			return getWeightedResults(output.getTable(), output.getAmount());
		}
		System.out.println("tocrush null wft, how did you do this"
				+ crushingResults.get(stack));
		return null;
	}

	public Boolean canCrush(ItemStack input, List<ItemStack> slots) {
		Object result = this.getMapResult(input);
		if (result != null) {
			List<ItemStack> outputList = new ArrayList<ItemStack>();
			int amount = 0;
			if (result instanceof ItemStack[]) {
				ItemStack[] resultList = (ItemStack[]) result;
				amount = resultList.length;
				for(ItemStack stack : resultList) {
					outputList.add(stack);
				}
			} else if (result instanceof WeightedOutputs) {
				WeightedOutputs outputTable = (WeightedOutputs) result;
				amount = outputTable.getAmount();
				for(WeightedStack wstack :outputTable.getTable()) {
					outputList.add(wstack.getStack());
				}
				
			}
			if (RecipeUtils.canResultsFitInSlots(outputList, slots, amount)) {
				return true;
			}
		}
		return false;
	}

	private boolean isInputValid(ItemStack input) {
		if (getMapResult(input) == null) {
			return true;
		} else {
			System.out.println("[" + ModDefinitions.modid
					+ "] ERROR adding recipe for " + input
					+ ": recipe already exists.");
			return false;
		}
	}

	protected ItemStack[] getWeightedResults(WeightedStack[] outputTable,
			int amount) {
		Random rand = new Random();
		ItemStack[] output = new ItemStack[amount];
		int maxChance = -1;
		Integer[] weightMappings = new Integer[outputTable.length];
		ItemStack[] outputMappings = new ItemStack[outputTable.length];
		for (int w = 0; w < outputTable.length; w++) {
			maxChance += outputTable[w].getWeight();
			weightMappings[w] = outputTable[w].getWeight();
			outputMappings[w] = outputTable[w].getStack();
		}
		for (int i = 0; i < amount; i++) {
			ItemStack stack = null;
			while(stack==null) {
				int randint = rand.nextInt(maxChance);
				for (int j = 0; j < weightMappings.length; j++) {
					if (j == 0) {
						if (randint <= weightMappings[0]) {
							stack = outputMappings[0];
						}
					} else {
						if (randint <= weightMappings[j]) {
							stack = outputMappings[j];
						}
					}
				}
			}
			output[i] = stack;
		}
		return output;
	}*/

	public Object getMapResult(ItemStack stack) {
		Set<Entry<ItemStack, Object>> entries = crushingResults.entrySet();
		for (Entry<ItemStack, Object> entry : entries) {
			if (RecipeUtils.compareItemStacks(stack, entry.getKey(), false)) {
				return entry.getValue();
			}
		}
		return null;
	}

	public Map<ItemStack, Object> getCrushingMap() {
		return crushingResults;
	}
}

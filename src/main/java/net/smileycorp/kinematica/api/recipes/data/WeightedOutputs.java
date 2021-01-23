package net.smileycorp.kinematica.api.recipes.data;

public class WeightedOutputs {

	private final WeightedStack[] wstacks;
	private final int tries;

	public WeightedOutputs(int tries, WeightedStack[] wstacks) {
		this.tries = tries;
		this.wstacks = wstacks;
	}

	public int getAmount() {
		return tries;
	}

	public WeightedStack[] getTable() {
		return wstacks;
	}
}

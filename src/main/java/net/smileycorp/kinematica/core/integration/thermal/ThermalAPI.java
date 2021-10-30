package net.smileycorp.kinematica.core.integration.thermal;

import net.smileycorp.kinematica.api.metal.MetalRegistry;
import net.smileycorp.kinematica.api.metal.MetalRegistry.MetalType;
import cofh.thermalfoundation.item.ItemCoin;

public class ThermalAPI {

	public static void initItems() {
		MetalRegistry.registerMetalItem("Aluminium", MetalType.COIN, ItemCoin.coinAluminum);
		MetalRegistry.registerMetalItem("Bronze", MetalType.COIN, ItemCoin.coinBronze);
		MetalRegistry.registerMetalItem("Constantan", MetalType.COIN, ItemCoin.coinConstantan);
		MetalRegistry.registerMetalItem("Copper", MetalType.COIN, ItemCoin.coinCopper);
		MetalRegistry.registerMetalItem("Electrum", MetalType.COIN, ItemCoin.coinElectrum);
		MetalRegistry.registerMetalItem("Gold", MetalType.COIN, ItemCoin.coinGold);
		MetalRegistry.registerMetalItem("Invar", MetalType.COIN, ItemCoin.coinInvar);
		MetalRegistry.registerMetalItem("Iridium", MetalType.COIN, ItemCoin.coinIridium);
		MetalRegistry.registerMetalItem("Iron", MetalType.COIN, ItemCoin.coinIron);
		MetalRegistry.registerMetalItem("Lead", MetalType.COIN, ItemCoin.coinLead);
		MetalRegistry.registerMetalItem("Nickel", MetalType.COIN, ItemCoin.coinNickel);
		MetalRegistry.registerMetalItem("Platinum", MetalType.COIN, ItemCoin.coinPlatinum);
		MetalRegistry.registerMetalItem("Silver", MetalType.COIN, ItemCoin.coinSilver);
		MetalRegistry.registerMetalItem("Steel", MetalType.COIN, ItemCoin.coinSteel);
		MetalRegistry.registerMetalItem("Tin", MetalType.COIN, ItemCoin.coinTin);
	}

}

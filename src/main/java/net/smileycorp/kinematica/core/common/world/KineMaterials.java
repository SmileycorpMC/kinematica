package net.smileycorp.kinematica.core.common.world;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.FuelHandler;
import net.smileycorp.kinematica.core.common.Constants;

public class KineMaterials {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MODID);

	public static final RegistryObject<Item> ANTHRACTITE = registerItem("anthracite");
	public static final RegistryObject<Item> COKE = registerItem("coke");
	public static final RegistryObject<Item> SULPHUR = registerItem("sulphur");
	public static final RegistryObject<Item> PHOSPHORUS = registerItem("phosphorus");
	public static final RegistryObject<Item> NITER = registerItem("niter");
	public static final RegistryObject<Item> ARSENIC = registerItem("arsenic");
	public static final RegistryObject<Item> CINNABAR = registerItem("cinnabar");
	public static final RegistryObject<Item> COAL_DUST = registerItem("coal_dust");
	public static final RegistryObject<Item> ANTHRACITE_DUST = registerItem("anthracite_dust");
	public static final RegistryObject<Item> COKE_DUST = registerItem("coke_dust");
	public static final RegistryObject<Item> FLOUR = registerItem("flour");
	public static final RegistryObject<Item> SILICA = registerItem("silica");
	public static final RegistryObject<Item> CRUSHED_CALCITE = registerItem("crushed_calcite");
	public static final RegistryObject<Item> CRUSHED_LIMESTONE = registerItem("crushed_limestone");
	public static final RegistryObject<Item> CRUSHED_DOLOMITE = registerItem("crushed_dolomite");
	public static final RegistryObject<Item> QUICKLIME = registerItem("quicklime");
	public static final RegistryObject<Item> SLAKED_LIME = registerItem("slaked_lime");
	public static final RegistryObject<Item> CEMENT = registerItem("cement");
	public static final RegistryObject<Item> REFRACTORY_BRICK = registerItem("refractory_brick");
	public static final RegistryObject<Item> WOODEN_GEAR = registerItem("wooden_gear");
	//public static final RegistryObject<Item> FLOUR = registerItem("grass_");

	private static RegistryObject<Item> registerItem(String name) {
		return ITEMS.register(name,  ()-> new Item(new Item.Properties()));
	}

	public static void loadComplete() {
		FuelHandler.INSTANCE.registerFuel(ANTHRACTITE.get(), 2400);
		FuelHandler.INSTANCE.registerFuel(COKE.get(), 3200);
	}

}

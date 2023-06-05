package net.smileycorp.kinematica.data;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.smileycorp.kinematica.core.common.Constants;

@EventBusSubscriber(modid = Constants.MODID, bus = Bus.MOD)
public class DataGenerators {

	/*@SubscribeEvent
	public static void generateData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			//event.addProvider(new LootTableProvider());
		}
		if (event.includeClient()) {
			generator.addProvider(new KineBlockstates(generator, event.getExistingFileHelper()));
		}
	}*/

}

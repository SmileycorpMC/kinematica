package net.smileycorp.kinematica.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.smileycorp.kinematica.core.common.Constants;

@EventBusSubscriber(modid = Constants.MODID, bus = Bus.MOD)
public class DataGenerators {

	@SubscribeEvent
	public static void generateData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		if (event.includeServer()) {
			//event.addProvider(new LootTableProvider());
		}
		if (event.includeClient()) {
			generator.addProvider(true, new KineBlockstates(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));
		}
	}

}

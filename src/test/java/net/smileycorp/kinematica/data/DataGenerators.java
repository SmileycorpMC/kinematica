package net.smileycorp.kinematica.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
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
			generator.addProvider(true, new KineRecipes(event.getGenerator().getPackOutput()));
			generator.addProvider(true, new LootTableProvider(event.getGenerator().getPackOutput(), Sets.newHashSet(),
					Lists.newArrayList(new LootTableProvider.SubProviderEntry(KineBlockLootTables::new, LootContextParamSets.BLOCK))));
		}
		if (event.includeClient()) {
			generator.addProvider(true, new KineBlockstates(event.getGenerator().getPackOutput(), event.getExistingFileHelper()));
		}
	}

}

package net.smileycorp.kinematica.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class KineBlockstates extends BlockStateProvider {

	public KineBlockstates(PackOutput gen, ExistingFileHelper exFileHelper) {
		super(gen, Constants.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		simpleBlock(KineWorld.DOLOMITE.get());
		simpleBlock(KineWorld.LIMESTONE.get());
	}

}

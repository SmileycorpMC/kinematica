package net.smileycorp.kinematica.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.construction.block.ShapedStoneBlock;

public class KineBlockstates extends BlockStateProvider {

	public KineBlockstates(PackOutput gen, ExistingFileHelper exFileHelper) {
		super(gen, Constants.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		//registerStoneBlock(KineConstruction.LIMESTONE);
		//registerStoneBlock(KineConstruction.DOLOMITE);
		//registerStoneBlock(KineConstruction.PEGMATITE);
	}

	public void registerStoneBlock(ShapedStoneBlock stone) {
		logBlock((RotatedPillarBlock) stone.getPillar());
		for (ShapedStoneBlock.StoneShape shape : ShapedStoneBlock.StoneShape.values()) {
			ShapedBlock block = stone.get(shape);
			simpleBlock(block.getBase());
			ResourceLocation loc = Constants.loc("block/"+shape.getName(stone.getName()));
			slabBlock(block.getSlab(), loc, loc);
			stairsBlock(block.getStairs(), loc);
		}
	}

}

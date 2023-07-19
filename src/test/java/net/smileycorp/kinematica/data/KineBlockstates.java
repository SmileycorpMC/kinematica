package net.smileycorp.kinematica.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.construction.block.ShapedMudBlock;
import net.smileycorp.kinematica.core.common.construction.block.ShapedStoneBlock;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class KineBlockstates extends BlockStateProvider {

	public KineBlockstates(PackOutput gen, ExistingFileHelper exFileHelper) {
		super(gen, Constants.MODID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels() {
		stoneBlock(KineWorld.LIMESTONE);
		stoneBlock(KineWorld.DOLOMITE);
		stoneBlock(KineWorld.PEGMATITE);
		mudBlock(KineConstruction.BAUXITE);
		mudBlock(KineConstruction.PEAT);
		shapedBlock(Constants.loc("block/refractory_bricks"), KineConstruction.REFRACTORY_BRICKS);
	}

	public void shapedBlock(ResourceLocation loc, ShapedBlock block) {
		simpleBlock(block.getBase());
		simpleBlockItem(block.getBase(), new ModelFile.UncheckedModelFile(loc));
		slabBlock(block.getSlab(), loc, loc);
		simpleBlockItem(block.getSlab(), new ModelFile.UncheckedModelFile(loc+"_slab"));
		stairsBlock(block.getStairs(), loc);
		simpleBlockItem(block.getStairs(), new ModelFile.UncheckedModelFile(loc +"_stairs"));
		if (block.getWall() != null) {
			wallBlock(block.getWall(), loc);
			itemModels().wallInventory(loc +"_wall_inventory", loc);
			simpleBlockItem(block.getWall(), new ModelFile.UncheckedModelFile(loc +"_wall_inventory"));
		}
	}

	public void stoneBlock(ShapedStoneBlock block) {
		ResourceLocation loc = Constants.loc("block/" + block.getName());
		shapedBlock(loc, block);
		simpleBlock(block.getChiseled());
		simpleBlockItem(block.getChiseled(), new ModelFile.UncheckedModelFile("kinematica:block/chiseled_"+block.getName()));
		logBlock(block.getPillar());
		simpleBlockItem(block.getPillar(), new ModelFile.UncheckedModelFile("kinematica:block/"+block.getName()+"_pillar"));
		buttonBlock(block.getButton(), loc);
		itemModels().buttonInventory(loc +"_button_inventory", loc);
		simpleBlockItem(block.getButton(), new ModelFile.UncheckedModelFile(loc +"_button_inventory"));
		pressurePlateBlock(block.getPressurePlate(), loc);
		simpleBlockItem(block.getPressurePlate(), new ModelFile.UncheckedModelFile(loc +"_pressure_plate"));
		for (ShapedStoneBlock.StoneShape shape : ShapedStoneBlock.StoneShape.values()) {
			shapedBlock(Constants.loc("block/"+shape.getName(block.getName())), block.get(shape));
		}
	}

	public void mudBlock(ShapedMudBlock block) {
		shapedBlock(Constants.loc("block/"+block.getName()+"_bricks"), block);
		simpleBlock(block.getPackedBlock());
		simpleBlockItem(block.getPackedBlock(), new ModelFile.UncheckedModelFile("kinematica:block/packed_"+block.getName()));
	}

}

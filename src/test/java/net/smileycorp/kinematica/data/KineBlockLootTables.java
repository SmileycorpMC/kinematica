package net.smileycorp.kinematica.data;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.atlas.common.AtlasLib;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.construction.block.ShapedMudBlock;
import net.smileycorp.kinematica.core.common.construction.block.ShapedStoneBlock;
import net.smileycorp.kinematica.core.common.world.KineWorld;

import java.util.List;
import java.util.stream.Collectors;

public class KineBlockLootTables extends BlockLootSubProvider {

    protected KineBlockLootTables() {
        super(Sets.newHashSet(), FeatureFlagSet.of());
    }

    @Override
    public void generate() {
        dropSelf(KineWorld.BAUXITE_SOIL.get());
        dropSelf(KineWorld.PEAT.get());
        stoneBlock(KineWorld.LIMESTONE);
        stoneBlock(KineWorld.DOLOMITE);
        stoneBlock(KineWorld.PEGMATITE);
        registerMudBlock(KineConstruction.BAUXITE);
        registerMudBlock(KineConstruction.PEAT);
        shapedBlock(KineConstruction.REFRACTORY_BRICKS);
    }

    public void shapedBlock(ShapedBlock block) {
        dropSelf(block.getBase());
        createSlabItemTable(block.getSlab());
        dropSelf(block.getStairs());
        if (block.getWall() != null) dropSelf(block.getWall());
    }

    public void stoneBlock(ShapedStoneBlock block) {
        shapedBlock(block);
        dropSelf(block.getChiseled());
        dropSelf(block.getPillar());
        dropSelf(block.getButton());
        dropSelf(block.getPressurePlate());
        for (ShapedStoneBlock.StoneShape shape : ShapedStoneBlock.StoneShape.values()) {
            shapedBlock(block.get(shape));
        }
    }

    public void registerMudBlock(ShapedMudBlock block) {
        shapedBlock(block);
        dropSelf(block.getPackedBlock());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        List<Block> blocks = Lists.newArrayList();
        blocks.addAll(KineConstruction.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList()));
        blocks.addAll(KineWorld.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList()));
        AtlasLib.logInfo(blocks);
        return blocks;
    }

}

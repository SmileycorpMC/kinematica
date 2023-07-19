package net.smileycorp.kinematica.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.smileycorp.atlas.api.block.ShapedBlock;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.construction.KineConstruction;
import net.smileycorp.kinematica.core.common.construction.block.ShapedMudBlock;
import net.smileycorp.kinematica.core.common.construction.block.ShapedStoneBlock;
import net.smileycorp.kinematica.core.common.world.KineWorld;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class KineBlockTags extends BlockTagsProvider {
    public KineBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Constants.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        IntrinsicTagAppender<Block> walls_tag = tag(BlockTags.WALLS);
        IntrinsicTagAppender<Block> stairs_tag = tag(BlockTags.STAIRS);
        IntrinsicTagAppender<Block> pickaxe_tag = tag(BlockTags.MINEABLE_WITH_PICKAXE);
        IntrinsicTagAppender<Block> shovel_tag = tag(BlockTags.MINEABLE_WITH_SHOVEL);
        stoneBlock(KineWorld.LIMESTONE, walls_tag, stairs_tag, pickaxe_tag);
        stoneBlock(KineWorld.DOLOMITE, walls_tag, stairs_tag, pickaxe_tag);
        stoneBlock(KineWorld.PEGMATITE, walls_tag, stairs_tag, pickaxe_tag);
        registerMudBlock(KineConstruction.BAUXITE, walls_tag, stairs_tag, pickaxe_tag, shovel_tag);
        registerMudBlock(KineConstruction.PEAT, walls_tag, stairs_tag, pickaxe_tag, shovel_tag);
        shapedBlock(KineConstruction.REFRACTORY_BRICKS, walls_tag, stairs_tag, pickaxe_tag);
    }

    private void shapedBlock(ShapedBlock block, IntrinsicTagAppender<Block> walls_tag, IntrinsicTagAppender<Block> stairs_tag, IntrinsicTagAppender<Block> pickaxe_tag) {
        stairs_tag.add(block.getStairs());
        if (block.getWall() != null) walls_tag.add(block.getWall());
        for (ShapedBlock.BlockShape shape : ShapedBlock.BlockShape.values()) {
            Block block1 = block.get(shape);
            if (block1 != null) pickaxe_tag.add(block1);
        }
    }

    private void stoneBlock(ShapedStoneBlock block, IntrinsicTagAppender<Block> walls_tag, IntrinsicTagAppender<Block> stairs_tag, IntrinsicTagAppender<Block> pickaxe_tag) {
        shapedBlock(block, walls_tag, stairs_tag, pickaxe_tag);
        pickaxe_tag.add(block.getChiseled());
        pickaxe_tag.add(block.getPillar());
        pickaxe_tag.add(block.getButton());
        pickaxe_tag.add(block.getPressurePlate());
        for (ShapedStoneBlock.StoneShape shape : ShapedStoneBlock.StoneShape.values()) {
            shapedBlock(block.get(shape), walls_tag, stairs_tag, pickaxe_tag);
        }
    }

    private void registerMudBlock(ShapedMudBlock block, IntrinsicTagAppender<Block> walls_tag, IntrinsicTagAppender<Block> stairs_tag, IntrinsicTagAppender<Block> pickaxe_tag, IntrinsicTagAppender<Block> shovel_tag) {
        shovel_tag.add(block.getPackedBlock());
        shapedBlock(block, walls_tag, stairs_tag, pickaxe_tag);
    }

}

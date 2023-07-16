package net.smileycorp.kinematica.core.common.world.block;

import com.google.common.collect.Maps;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.ShapedBlock;

import java.util.Map;

public class StoneBlock {

    private final CreativeModeTab tab;
    public final RegistryObject<Block> pillar;
    private final Map<StoneShape, ShapedBlock> blocks = Maps.newHashMap();

    public StoneBlock(String name, CreativeModeTab tab, BlockBehaviour.Properties props, DeferredRegister<Item> itemRegister, DeferredRegister<Block> blockRegister) {
        this.tab = tab;
        for (StoneShape shape : StoneShape.values()) {
            blocks.put(shape, new ShapedBlock(shape.getName(name), tab, props, itemRegister, blockRegister, false));
        }
        pillar = blockRegister.register(name + "_pillar", () -> new RotatedPillarBlock(props));
        itemRegister.register(name + "_pillar", ()->new BlockItem(pillar.get(), new Item.Properties()));
        MinecraftForge.EVENT_BUS.register(this);
    }

    public Block getPillar() {
        return pillar.get();
    }

    public ShapedBlock get(StoneShape shape) {
        return blocks.get(shape);
    }

    @SubscribeEvent
    public void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == this.tab) {
            event.m_246326_(getPillar().asItem());
        }
    }

    public enum StoneShape implements StringRepresentable {
        POLISHED("polished", true),
        CHISELED("chiseled", true),
        BRICK("bricks", false);

        private final String name;
        private final boolean isPrefix;

        StoneShape(String name, boolean isPrefix) {
            this.name = name;
            this.isPrefix = isPrefix;
        }

        @Override
        public String getSerializedName() {
            return name;
        }

        public String getName(String name) {
            return isPrefix ? this.name + "_" + name : name + "_" + this.name;
        }
    }

}

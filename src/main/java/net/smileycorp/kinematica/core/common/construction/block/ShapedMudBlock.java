package net.smileycorp.kinematica.core.common.construction.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.ShapedBlock;

import java.util.function.Function;
import java.util.function.Supplier;

public class ShapedMudBlock extends ShapedBlock {

    private final String name;
    private final RegistryObject<Block> packed_block;

    public ShapedMudBlock(String name, Supplier<CreativeModeTab> tab, Function<BlockBehaviour.Properties, BlockBehaviour.Properties> properties, DeferredRegister<Item> items, DeferredRegister<Block> blocks) {
        super(name + "_bricks", tab, properties.apply(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS)), items, blocks, true);
        packed_block = blocks.register("packed_" + name,() -> {
            return new Block(properties.apply(BlockBehaviour.Properties.copy(Blocks.PACKED_MUD)));
        });
        items.register("packed_" + name, () -> {
            return new BlockItem(packed_block.get(), new Item.Properties());
        });
        this.name = name;
    }

    public Block getPackedBlock() {
        return packed_block.get();
    }

    @Override
    @SubscribeEvent
    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == this.tab.get()) {
            event.accept(packed_block);
        }
        super.addCreative(event);
    }

    public String getName() {
        return name;
    }
}

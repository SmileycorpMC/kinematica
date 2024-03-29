package net.smileycorp.kinematica.core.common.construction.block;

import com.google.common.collect.Maps;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.smileycorp.atlas.api.block.ShapedBlock;

import java.util.Map;
import java.util.function.Supplier;

public class ShapedStoneBlock extends ShapedBlock {

    private final String name;
    protected final BlockSetType type;
    private final Supplier<CreativeModeTab> decorationsTab;
    private final Map<StoneShape, ShapedBlock> blocks = Maps.newHashMap();
    public final RegistryObject<Block> chiseled;
    public final RegistryObject<Block> pillar;

    public final RegistryObject<Block> button;

    public final RegistryObject<Block> pressure_plate;

    public ShapedStoneBlock(String name, Supplier<CreativeModeTab> tab, Supplier<CreativeModeTab> decorationsTab, BlockBehaviour.Properties props, DeferredRegister<Item> itemRegister, DeferredRegister<Block> blockRegister) {
        super(name, tab, props, itemRegister, blockRegister, false);
        type = new BlockSetType(name);
        this.decorationsTab = decorationsTab;
        for (StoneShape shape : StoneShape.values()) {
            blocks.put(shape, new ShapedBlock(shape.getName(name), decorationsTab, props, itemRegister, blockRegister, true));
        }
        chiseled = register("chiseled_" + name, () -> new Block(props), itemRegister, blockRegister);
        pillar = register(name + "_pillar", () -> new RotatedPillarBlock(props), itemRegister, blockRegister);
        button = register(name + "_button", () -> new ButtonBlock(props.strength(0.5F).pushReaction(PushReaction.DESTROY).noCollission(), BlockSetType.STONE, 20, false), itemRegister, blockRegister);
        pressure_plate = register(name + "_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, props.strength(0.5F).pushReaction(PushReaction.DESTROY).noCollission(), this.type), itemRegister, blockRegister);
        this.name = name;
    }

    protected RegistryObject<Block> register(String name, Supplier<Block> supplier, DeferredRegister<Item> items, DeferredRegister<Block> blocks) {
        RegistryObject<Block> block = blocks.register(name, supplier);
        items.register(name, () -> {
            return new BlockItem((Block)block.get(), new Item.Properties());
        });
        return block;
    }

    public Block getChiseled() {
        return chiseled.get();
    }

    public RotatedPillarBlock getPillar() {
        return (RotatedPillarBlock) pillar.get();
    }

    public ButtonBlock getButton() {
        return (ButtonBlock) button.get();
    }

    public PressurePlateBlock getPressurePlate() {
        return (PressurePlateBlock) pressure_plate.get();
    }

    public ShapedBlock get(StoneShape shape) {
        return blocks.get(shape);
    }

    @SubscribeEvent
    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == decorationsTab.get()) {
            event.accept(chiseled);
            event.accept(pillar);
        }
        super.addCreative(event);
    }

    public String getName() {
        return name;
    }

    public enum StoneShape implements StringRepresentable {
        POLISHED("polished", true),
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

package net.smileycorp.kinematica.core.common.world.block;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class StoneBlock {

    public final RegistryObject<Block> pillar;
    public final Map<>


    public static enum StoneShape implements StringRepresentable {
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

        public boolean isPrefix() {
            return isPrefix;
        }
    }

}

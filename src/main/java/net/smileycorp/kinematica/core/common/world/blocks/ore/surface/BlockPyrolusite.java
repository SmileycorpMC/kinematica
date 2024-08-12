package net.smileycorp.kinematica.core.common.world.blocks.ore.surface;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlockPyrolusite extends BlockCompositeOre {

      public BlockPyrolusite() {
        super("Pyrolusite", 1, KineWorld.MUD);
      }

      @Override
      public String[] getComposition() {
        return new String[] {"67% " + localise("Manganese"),
            "23% " + localise("Iron"),
            "10% " + localise("Silicon")};
      }

}

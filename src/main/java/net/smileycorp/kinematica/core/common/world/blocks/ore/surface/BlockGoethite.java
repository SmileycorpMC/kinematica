package net.smileycorp.kinematica.core.common.world.blocks.ore.surface;

import net.smileycorp.kinematica.api.ores.blocks.BlockCompositeOre;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlockGoethite extends BlockCompositeOre {

      public BlockGoethite() {
        super("Goethite", 1, KineWorld.MUD);
      }

      @Override
      public String[] getComposition() {
        return new String[] {"70% " + localise("Iron"),
            "25% " + localise("Aluminium"),
            "5% " + localise("Silicon")};
      }

}

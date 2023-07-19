package net.smileycorp.kinematica.core.client.colour;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;

import java.awt.*;

public class MudBlockGrassColour implements BlockColor {

    @Override
    public int getColor(BlockState state, BlockAndTintGetter reader, BlockPos pos, int tintIndex) {
        Color base = new Color(reader.getBlockTint(pos, BiomeColors.GRASS_COLOR_RESOLVER));
        return new Color(darken(base.getRed()), darken(base.getGreen()), darken(base.getBlue())).getRGB();
    }

    private int darken(int i) {
        return (int) Math.floor(i*0.8);
    }
}

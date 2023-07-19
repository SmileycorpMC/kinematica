package net.smileycorp.kinematica.core.client;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.smileycorp.kinematica.core.client.colour.MudBlockGrassColour;
import net.smileycorp.kinematica.core.common.Constants;
import net.smileycorp.kinematica.core.common.world.KineWorld;

@Mod.EventBusSubscriber(modid = Constants.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientRegistry {

    @SubscribeEvent
    public static void clientRegistry(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(KineWorld.MUD_GRASS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(KineWorld.PEAT_GRASS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(KineWorld.BAUXITE_GRASS.get(), RenderType.cutoutMipped());
        //KineWorld.SHARINGA_WOOD.registerClient();
    }

    @SubscribeEvent
    public static void itemColourRegistry(RegisterColorHandlersEvent.Item event) {
        ItemColors colors = event.getItemColors();
        colors.register((stack, index) -> index == 0 ? 0x5C8E50 : 0xFFFFFF,
                KineWorld.MUD_GRASS.get(), KineWorld.PEAT_GRASS.get(), KineWorld.BAUXITE_GRASS.get());
        colors.register((stack, index) -> index == 0 ? 0x2A3D11: 0xFFFFFF, KineWorld.SHARINGA_WOOD.getLeaves());
    }

    @SubscribeEvent
    public static void blockColourRegistry(RegisterColorHandlersEvent.Block event) {
        BlockColors colors = event.getBlockColors();
        colors.register(new MudBlockGrassColour(), KineWorld.MUD_GRASS.get());
        colors.register(new MudBlockGrassColour(), KineWorld.PEAT_GRASS.get());
        colors.register(new MudBlockGrassColour(), KineWorld.BAUXITE_GRASS.get());
        colors.register((state, reader, pos, index) -> index == 0 ? reader.getBlockTint(pos, BiomeColors.FOLIAGE_COLOR_RESOLVER) : 0xFFFFFF,
                KineWorld.SHARINGA_WOOD.getLeaves());
    }

}

package net.smileycorp.kinematica.core.client.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSkeleton;
import net.minecraft.entity.monster.AbstractSkeleton;
import net.minecraft.util.ResourceLocation;

import net.smileycorp.kinematica.core.common.ModDefinitions;

public class RenderBlueWitherSkeleton extends RenderSkeleton {

    public RenderBlueWitherSkeleton(RenderManager rendermanager) {
        super(rendermanager);
    }
    
    @Override
	protected ResourceLocation getEntityTexture(AbstractSkeleton entity) {
        return ModDefinitions.getResource("textures/entity/blue_wither_skeleton.png");
    }
    
    @Override
	protected void preRenderCallback(AbstractSkeleton entity, float partialTickTime) {
        GlStateManager.scale(1.3F, 1.3F, 1.3F);
    }
}

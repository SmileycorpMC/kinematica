package net.smileycorp.kinematica.core.common.world.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import net.smileycorp.kinematica.core.common.ModDefinitions;

public class EntityBlueWitherSkeleton extends EntityWitherSkeleton {

	public EntityBlueWitherSkeleton(World world) {
		super(world);
		this.setSize(0.7F, 2.5F);
	}
	
	@Override
    protected void applyEntityAttributes() {
		super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8f);
	}
	
	@Override
	@Nullable
    protected ResourceLocation getLootTable() {
        return ModDefinitions.getResource("entities/blue_wither_skeleton");
    }
	
	@Override
	public float getEyeHeight() {
        return 2.3F;
    }

}

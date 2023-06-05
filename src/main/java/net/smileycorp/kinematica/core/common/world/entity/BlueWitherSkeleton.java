package net.smileycorp.kinematica.core.common.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.level.Level;
import net.smileycorp.kinematica.core.common.world.KineWorld;

public class BlueWitherSkeleton extends WitherSkeleton {

	public BlueWitherSkeleton(Level level) {
		this(KineWorld.BLUE_WITHER_SKELETON.get(), level);
	}

	public BlueWitherSkeleton(EntityType<BlueWitherSkeleton> type, Level level) {
		super(type, level);
		//setBoundingBox(new AABB(-0.35, 0, -0.35, 0.35, 2.5, 0.35));
	}

	public static AttributeSupplier.Builder createAttributes() {
		return WitherSkeleton.createAttributes().add(Attributes.MOVEMENT_SPEED, 0.4d).add(Attributes.MAX_HEALTH, 35).add(Attributes.KNOCKBACK_RESISTANCE, 0.8f);
	}


	/*@Override
	public float getEyeHeight() {
		return 2.3F;
	}*/

}

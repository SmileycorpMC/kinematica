package net.smileycorp.kinematica.core.common.machine.mechanical.tile;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

import net.smileycorp.kinematica.api.IMechanicalPower;

public class TileMechanicalMachineBase extends TileEntity implements ITickable, IMechanicalPower {
	
	private float torque;
	private float velocity;

	@Override
	public float getTorque() {
		return torque;
	}

	@Override
	public float getVelocity() {
		return velocity;
	}

	@Override
	public void updateTorque(float torque) {
		this.torque=torque;
	}

	@Override
	public void updateVelocity(float velocity) {
		this.velocity=velocity;
	}

	@Override
	public float getMaxWork() {
		return 0;
	}

	@Override
	public void update() {
		
	}

	@Override
	public float getWork() {
		return 0;
	}

}

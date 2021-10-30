package net.smileycorp.kinematica.core.common.machine.mechanical.tile;

import net.minecraft.util.EnumFacing;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;

public class TileAcyclicGenerator extends TileMechanicalMachineBase implements ICapabilityProvider  {
    
    protected int energy = 0;

    @Override
	  public void update() {
        super.update();
        int work = (int) this.getWork();
        if (work>0) {
          this.energy = work;
        }
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) {
          return true;
        }
    return super.hasCapability(capability, facing);
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) {
            return capability.getDefaultInstance();
        }
        return super.getCapability(capability, facing);
    }
    
}

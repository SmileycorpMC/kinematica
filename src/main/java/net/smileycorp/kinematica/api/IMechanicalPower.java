package net.smileycorp.kinematica.api;

public interface IMechanicalPower {
    
    float getTorque();
    
    float getVelocity();
    
    void updateTorque(float torque);
    
    void updateVelocity(float velocity);
    
    float getMaxWork();
    
    float getWork();
    
}

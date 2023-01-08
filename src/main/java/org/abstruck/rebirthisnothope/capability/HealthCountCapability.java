package org.abstruck.rebirthisnothope.capability;

import net.minecraft.nbt.CompoundNBT;

/**
 * @author Goulixiaoji
 */
public class HealthCountCapability implements IModHealthCapability{

    private int healthCount;
    public static final String HEALTH_COUNT = "healthCount";

    public HealthCountCapability(){
        healthCount = 20;
    }
    @Override
    public int getHealthCount() {
        return healthCount;
    }

    @Override
    public void setHealthCount(int value) {
        this.healthCount = value;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt(HEALTH_COUNT, healthCount);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        healthCount = nbt.getInt(HEALTH_COUNT);
    }
}

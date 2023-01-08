package org.abstruck.rebirthisnothope.capability;

import net.minecraft.nbt.CompoundNBT;

/**
 *  @Author Biggest_Xuan
 */

public class DeathCountCapability implements IModDeathCapability {
    private int deathCount;

    public DeathCountCapability(){
        deathCount = 0;
    }

    @Override
    public int getDeathCount() {
        return deathCount;
    }

    @Override
    public void setDeathCount(int count) {
        this.deathCount = count;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("death_count", deathCount);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        deathCount = nbt.getInt("death_count");
    }
}

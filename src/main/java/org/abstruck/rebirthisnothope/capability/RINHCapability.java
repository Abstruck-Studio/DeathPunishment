package org.abstruck.rebirthisnothope.capability;

import net.minecraft.nbt.CompoundNBT;

/**
 *  @Author Biggest_Xuan
 */

public class RINHCapability implements IModCapability {
    private int deathCount;
    private float health;
    private String effectId;

    public RINHCapability(){
        deathCount = 0;
        health = 20;
        effectId = "";
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
    public float getHealth() {
        return health;
    }

    @Override
    public void setHealth(float value) {
        health = value;
    }

    @Override
    public String getEffectId() {
        return effectId;
    }

    @Override
    public void setEffectId(String id) {
        effectId = id;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT tag = new CompoundNBT();
        tag.putInt("death_count", deathCount);
        tag.putFloat("health",health);
        tag.putString("effectId", effectId);
        return tag;
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        deathCount = nbt.getInt("death_count");
        health = nbt.getFloat("health");
        effectId = nbt.getString("effectId");
    }
}

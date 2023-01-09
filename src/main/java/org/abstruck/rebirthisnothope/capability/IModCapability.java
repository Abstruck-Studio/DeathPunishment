package org.abstruck.rebirthisnothope.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.common.util.INBTSerializable;

/**
 *  @Author Biggest_Xuan
 */

public interface IModCapability extends INBTSerializable<CompoundNBT> {
    int getDeathCount();

    void setDeathCount(int count);

    float getHealth();

    void setHealth(float value);

    String getEffectId();

    void setEffectId(String id);

}

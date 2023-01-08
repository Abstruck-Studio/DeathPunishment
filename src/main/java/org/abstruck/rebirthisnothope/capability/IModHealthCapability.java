package org.abstruck.rebirthisnothope.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * @author Goulixiaoji
 */
public interface IModHealthCapability extends INBTSerializable<CompoundNBT> {

    int getHealthCount();

    void setHealthCount(int value);
}

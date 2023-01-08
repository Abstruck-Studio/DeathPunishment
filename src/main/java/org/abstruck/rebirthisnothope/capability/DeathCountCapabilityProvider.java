package org.abstruck.rebirthisnothope.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *  @Author Biggest_Xuan
 */

public class DeathCountCapabilityProvider implements ICapabilityProvider, INBTSerializable<CompoundNBT> {
    private IModDeathCapability capability;

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return cap == ModDeathCapability.DEATH_COUNT ? LazyOptional.of(this::get).cast() : LazyOptional.empty();
    }

    @Nonnull
    public IModDeathCapability get(){
        if(capability == null){
            capability = new DeathCountCapability();
        }
        return capability;
    }

    @Override
    public CompoundNBT serializeNBT() {
        return get().serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt) {
        get().deserializeNBT(nbt);
    }
}

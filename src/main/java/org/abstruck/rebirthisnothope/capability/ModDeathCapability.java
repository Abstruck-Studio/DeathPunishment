package org.abstruck.rebirthisnothope.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 *  @Author Biggest_Xuan
 */

public class ModDeathCapability {
    @CapabilityInject(IModDeathCapability.class)
    public static Capability<IModDeathCapability> DEATH_COUNT;
}

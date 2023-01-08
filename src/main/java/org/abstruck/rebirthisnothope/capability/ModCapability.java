package org.abstruck.rebirthisnothope.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 *  @Author Biggest_Xuan
 */

public class ModCapability {
    @CapabilityInject(IModCapability.class)
    public static Capability<IModCapability> CAP;
}

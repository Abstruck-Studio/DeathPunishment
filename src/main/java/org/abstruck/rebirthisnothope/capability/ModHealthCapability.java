package org.abstruck.rebirthisnothope.capability;

import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;

/**
 * @author Goulixiaoji
 */
public class ModHealthCapability {
    @CapabilityInject(IModHealthCapability.class)
    public static Capability<IModHealthCapability> HEALTH_COUNT;
}

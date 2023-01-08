package org.abstruck.rebirthisnothope.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.abstruck.rebirthisnothope.RebirthIsNotHope;
import org.abstruck.rebirthisnothope.capability.*;

/**
 *  @Author Biggest_Xuan
 */

@Mod.EventBusSubscriber
public class CapabilityEvent {
    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event){
        if(event.getObject() instanceof PlayerEntity){
            event.addCapability(new ResourceLocation(RebirthIsNotHope.MOD_ID,"mod_cap"),new RINHCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void playerCloned(PlayerEvent.Clone event){
        LazyOptional<IModCapability> oldSpeedCap = event.getOriginal().getCapability(ModCapability.CAP);
        LazyOptional<IModCapability> newSpeedCap = event.getPlayer().getCapability(ModCapability.CAP);
        if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
            newSpeedCap.ifPresent((newCap) -> oldSpeedCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
        }
    }
}

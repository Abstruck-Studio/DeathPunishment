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
            event.addCapability(new ResourceLocation(RebirthIsNotHope.MOD_ID,"count"),new DeathCountCapabilityProvider());
            event.addCapability(new ResourceLocation(RebirthIsNotHope.MOD_ID, "health"), new HealthCountCapabilityProvider());
        }
    }

    @SubscribeEvent
    public static void playerCloned(PlayerEvent.Clone event){
        LazyOptional<IModDeathCapability> oldSpeedCap = event.getOriginal().getCapability(ModDeathCapability.DEATH_COUNT);
        LazyOptional<IModDeathCapability> newSpeedCap = event.getPlayer().getCapability(ModDeathCapability.DEATH_COUNT);
        LazyOptional<IModHealthCapability> oldHealthSpeedCap = event.getOriginal().getCapability(ModHealthCapability.HEALTH_COUNT);
        LazyOptional<IModHealthCapability> newHealthSpeedCap = event.getPlayer().getCapability(ModHealthCapability.HEALTH_COUNT);
        if (oldSpeedCap.isPresent() && newSpeedCap.isPresent()) {
            newSpeedCap.ifPresent((newCap) -> oldSpeedCap.ifPresent((oldCap) -> newCap.deserializeNBT(oldCap.serializeNBT())));
        }
        if (oldHealthSpeedCap.isPresent() && newHealthSpeedCap.isPresent()){
            newHealthSpeedCap.ifPresent((newCap) ->
                    oldHealthSpeedCap.ifPresent((oldCap) ->
                            newCap.deserializeNBT(oldCap.serializeNBT())));
        }
    }
}

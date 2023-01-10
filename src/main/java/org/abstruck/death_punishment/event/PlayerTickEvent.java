package org.abstruck.death_punishment.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.abstruck.death_punishment.capability.ModCapability;
import org.abstruck.death_punishment.common.config.Config;
import org.abstruck.death_punishment.util.Utils;


/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber
public class PlayerTickEvent {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        PlayerEntity player = event.player;
        player.getCapability(ModCapability.CAP).ifPresent((cap) -> {
            int count = cap.getDeathCount();
            if (count >= Config.PUNISHMENT_LEVEL.get()){
                String EffectId = cap.getEffectId();
                if (!EffectId.isEmpty()){
                    Utils.setEntityEffectByCommand(player, "effect give @s " + EffectId + " 5 1");
                }
            }
        });
    }
}

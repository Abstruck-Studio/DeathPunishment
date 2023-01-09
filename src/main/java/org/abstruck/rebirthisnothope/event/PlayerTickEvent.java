package org.abstruck.rebirthisnothope.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.abstruck.rebirthisnothope.capability.ModCapability;
import org.abstruck.rebirthisnothope.common.config.Config;
import org.abstruck.rebirthisnothope.util.Utils;


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

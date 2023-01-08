package org.abstruck.rebirthisnothope.event;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.abstruck.rebirthisnothope.capability.ModCapability;

import java.util.Random;

/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber
public class PlayerTickEvent {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event){
        PlayerEntity player = event.player;
        player.getCapability(ModCapability.CAP).ifPresent((cap)->{
            int count = cap.getDeathCount();
            Random random = new Random();
            if (count > 5) {
                int rand = random.nextInt(10000);
                if (rand == count) {
                    player.addEffect(new EffectInstance(Effects.WEAKNESS, count));
                } else if (rand % 100 == count % 10) {
                    player.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 2));
                } else if ((rand | count) == 114) {
                    player.addEffect(new EffectInstance(Effects.WITHER, count % 4));
                }
            }
        });

    }
}

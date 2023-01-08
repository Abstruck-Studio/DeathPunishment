package org.abstruck.rebirthisnothope.event;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.abstruck.rebirthisnothope.capability.ModDeathCapability;
import org.abstruck.rebirthisnothope.capability.ModHealthCapability;
import org.abstruck.rebirthisnothope.common.config.Config;
import org.abstruck.rebirthisnothope.util.Utils;


/**
 * @author Goulixiaoji
 */
@Mod.EventBusSubscriber
public class OnPlayerDiedEvent {

    @SubscribeEvent
    public static void playerDied(LivingDeathEvent event) {
        LivingEntity entity = event.getEntityLiving();
        if(entity.level.isClientSide) {
            return;
        }
        if(entity instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) entity;
            player.getCapability(ModDeathCapability.DEATH_COUNT).ifPresent((cap)->{
                int count = cap.getDeathCount();
                cap.setDeathCount(++count);
            });
        }
    }

    @SubscribeEvent
    public static void playerRebirth(PlayerEvent.PlayerRespawnEvent event) {
        PlayerEntity player = event.getPlayer();
        if(player.level.isClientSide || event.isEndConquered()) {
            return;
        }
        player.getCapability(ModDeathCapability.DEATH_COUNT).ifPresent((cap)->{
            int count = cap.getDeathCount();
            player.getCapability(ModHealthCapability.HEALTH_COUNT).ifPresent((cap1) -> {
                int health = cap1.getHealthCount();
                if (health - 2 >= Config.MIN_HEALTH.get()){
                    health -= 2;
                }
                Utils.setPlayerAttribute(player, Attributes.MAX_HEALTH, Utils.RINH_MODIFY_HEALTH_ID, Utils.RINH_MODIFY_HEALTH_NAME, health - player.getMaxHealth());
                cap1.setHealthCount(health);
            });

            player.sendMessage(new TranslationTextComponent("text.deathLevel.tip", count), player.getUUID());
        });
    }

}

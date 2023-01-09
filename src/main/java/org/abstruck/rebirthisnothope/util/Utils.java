package org.abstruck.rebirthisnothope.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;

import java.util.UUID;

/**
 * @author Goulixiaoji
 */
public class Utils {
    public static final UUID RINH_MODIFY_HEALTH_ID = UUID.fromString("9135185d-54fd-4b9b-b271-9e6d4cd3c47e");
    public static final String RINH_MODIFY_HEALTH_NAME = "RINH.HealthModifier";
    public static void setPlayerAttribute(PlayerEntity player, Attribute attribute, UUID attributeId, String attributeName, double value){
        ModifiableAttributeInstance valueInstance = player.getAttribute(attribute);
        if (valueInstance != null){
            AttributeModifier modifier = valueInstance.getModifier(attributeId);
            if (modifier != null){
                valueInstance.removeModifier(attributeId);
            }
            valueInstance.addPermanentModifier(new AttributeModifier(attributeId, attributeName, value, AttributeModifier.Operation.ADDITION));
        }
    }

    public static void setEntityEffectByCommand(Entity entity, String command) {
        if (!entity.level.isClientSide && entity.getServer() != null){
            entity.getServer().getCommands().performCommand(
                    entity.createCommandSourceStack().withSuppressedOutput().withPermission(4),
                    command
            );
        }
    }
}

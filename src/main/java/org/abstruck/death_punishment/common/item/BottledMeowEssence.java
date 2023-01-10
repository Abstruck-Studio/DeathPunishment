package org.abstruck.death_punishment.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.abstruck.death_punishment.DeathPunishment;
import org.abstruck.death_punishment.capability.ModCapability;
import org.abstruck.death_punishment.util.Utils;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Goulixiaoji
 */
public class BottledMeowEssence extends Item {
    private static final Food FOOD = new Food.Builder().alwaysEat().nutrition(0).saturationMod(0.0F).build();
    public BottledMeowEssence() {
        super(new Properties().stacksTo(1).tab(ItemGroup.TAB_FOOD).food(FOOD));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity consumer) {
        super.finishUsingItem(stack, worldIn, consumer);
        ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
        if (consumer instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) consumer;
            player.getCapability(ModCapability.CAP).ifPresent((cap) -> {
                float health = cap.getHealth();
                health += 2;
                Utils.setPlayerAttribute(player, Attributes.MAX_HEALTH, Utils.RINH_MODIFY_HEALTH_ID, Utils.RINH_MODIFY_HEALTH_NAME, health - 20);
                cap.setHealth(health);
                DeathPunishment.LOGGER.debug(health);
            });
            if (stack.isEmpty()){
                return itemStack;
            }

            if (!player.isCreative()){
                if (!player.inventory.add(itemStack)){
                    player.drop(itemStack, false);
                }
            }
        }

        return stack;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }

    @Override
    public UseAction getUseAnimation(ItemStack stack) {
        return UseAction.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> textComponents, ITooltipFlag flag) {
        super.appendHoverText(stack, world, textComponents, flag);
        textComponents.add(new TranslationTextComponent("item.rebirth_is_not_hope.bottled_meow_essence.tip"));
    }

}

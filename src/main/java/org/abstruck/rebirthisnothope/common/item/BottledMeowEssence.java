package org.abstruck.rebirthisnothope.common.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.world.World;
import org.abstruck.rebirthisnothope.capability.ModHealthCapability;
import org.abstruck.rebirthisnothope.util.Utils;

/**
 * @author Goulixiaoji
 */
public class BottledMeowEssence extends Item {
    private static final Food FOOD = new Food.Builder().nutrition(0).saturationMod(0).build();
    public BottledMeowEssence() {
        super(new Properties().stacksTo(1).tab(ItemGroup.TAB_MISC).food(FOOD));
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World worldIn, LivingEntity consumer) {
        super.finishUsingItem(stack, worldIn, consumer);
        ItemStack itemStack = new ItemStack(Items.GLASS_BOTTLE);
        if (stack.isEmpty()){
            return itemStack;
        }

        if (consumer instanceof PlayerEntity){
            PlayerEntity player = (PlayerEntity) consumer;
            if (!player.isCreative()){
                if (!player.inventory.add(itemStack)){
                    player.drop(itemStack, false);
                }
            }
            player.getCapability(ModHealthCapability.HEALTH_COUNT).ifPresent((cap) -> {
                int health = cap.getHealthCount();
                Utils.setPlayerAttribute(player, Attributes.MAX_HEALTH, Utils.RINH_MODIFY_HEALTH_ID, Utils.RINH_MODIFY_HEALTH_NAME, 1);
                cap.setHealthCount(++health);
            });
        }

        return stack;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        return new ItemStack(Items.GLASS_BOTTLE);
    }

    @Override
    public UseAction getUseAnimation(ItemStack p_77661_1_) {
        return UseAction.DRINK;
    }

}

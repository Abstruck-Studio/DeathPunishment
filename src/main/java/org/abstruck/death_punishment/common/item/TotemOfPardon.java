package org.abstruck.death_punishment.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.item.SimpleFoiledItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import org.abstruck.death_punishment.capability.ModCapability;

import javax.annotation.Nullable;
import java.util.List;

/**
 * @author Goulixiaoji
 */
public class TotemOfPardon extends SimpleFoiledItem {
    public static final String PARDON_LEVEL = "pardonLevel";
    private final int VALUE;
    public TotemOfPardon(int value) {
        super(new Properties().rarity(Rarity.UNCOMMON).stacksTo(1).durability(value).tab(ItemGroup.TAB_COMBAT));
        VALUE = value;
    }

    @Override
    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand handIn) {
        ItemStack stack = player.getItemInHand(handIn);

        player.getCapability(ModCapability.CAP).ifPresent((cap)->{
            int count = cap.getDeathCount();

            if (count > 0){
                cap.setDeathCount(--count);
                player.sendMessage(new TranslationTextComponent("text.deathLevel.tip", count), player.getUUID());
                stack.hurtAndBreak(1, player, (entity)->{
                    entity.broadcastBreakEvent(EquipmentSlotType.MAINHAND);
                });
            }

        });
        return ActionResult.success(stack);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.appendHoverText(stack, world, list, flag);
        list.add(new TranslationTextComponent("item.rebirth_is_not_hope.totem_of_pardon.tip", VALUE - stack.getDamageValue()));
    }
}

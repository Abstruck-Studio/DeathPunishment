package org.abstruck.death_punishment.init;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.abstruck.death_punishment.DeathPunishment;
import org.abstruck.death_punishment.common.item.BottledMeowEssence;
import org.abstruck.death_punishment.common.item.TotemOfPardon;

/**
 * @author Goulixiaoji
 */
public class ItemInit {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, DeathPunishment.MOD_ID);

    public static final RegistryObject<Item> MEOW_ESSENCE = REGISTER.register("bottled_meow_essence", BottledMeowEssence::new);
    public static final RegistryObject<Item> TOTEM_OF_PARDON = REGISTER.register("totem_of_pardon", ()-> new TotemOfPardon(1));
    public static final RegistryObject<Item> IRON_TOTEM_OF_PARDON = REGISTER.register("iron_totem_of_pardon", ()-> new TotemOfPardon(2));
    public static final RegistryObject<Item> GOLD_TOTEM_OF_PARDON = REGISTER.register("gold_totem_of_pardon", ()-> new TotemOfPardon(4));
    public static final RegistryObject<Item> DIAMOND_TOTEM_OF_PARDON = REGISTER.register("diamond_totem_of_pardon", ()-> new TotemOfPardon(8));
    public static final RegistryObject<Item> EMERALD_TOTEM_OF_PARDON = REGISTER.register("emerald_totem_of_pardon", ()-> new TotemOfPardon(10));
    public static final RegistryObject<Item> NETHERITE_TOTEM_OF_PARDON = REGISTER.register("netherite_totem_of_pardon", ()-> new TotemOfPardon(15));
}

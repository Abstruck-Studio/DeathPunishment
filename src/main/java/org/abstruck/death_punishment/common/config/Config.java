package org.abstruck.death_punishment.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * @author goulixiaoji
 */
public class Config {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.IntValue MIN_HEALTH;
    public static ForgeConfigSpec.IntValue PUNISHMENT_LEVEL;
    //public static ForgeConfigSpec.ConfigValue<List<? extends String>> EFFECT_LIST;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        MIN_HEALTH = COMMON_BUILDER.comment("min health").defineInRange("minHealth", 10, 1, 20);
        PUNISHMENT_LEVEL = COMMON_BUILDER.comment("punishment level").defineInRange("punishmentLevel", 5, 1, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }

}

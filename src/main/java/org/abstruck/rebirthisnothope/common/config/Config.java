package org.abstruck.rebirthisnothope.common.config;

import net.minecraftforge.common.ForgeConfigSpec;

/**
 * @author goulixiaoji
 */
public class Config {
    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec.IntValue MIN_HEALTH;

    static {
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();
        COMMON_BUILDER.comment("General settings").push("general");
        MIN_HEALTH = COMMON_BUILDER.comment("min health").defineInRange("minHealth", 10, 1, 20);
        COMMON_BUILDER.pop();
        COMMON_CONFIG = COMMON_BUILDER.build();
    }
}

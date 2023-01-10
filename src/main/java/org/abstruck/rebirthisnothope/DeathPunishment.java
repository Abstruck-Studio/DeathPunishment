package org.abstruck.rebirthisnothope;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.abstruck.rebirthisnothope.init.ItemInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Goulixiaoji
 */
@Mod(DeathPunishment.MOD_ID)
public class DeathPunishment {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "death_punishment";
    public static final List<String> EFFECTS = new ArrayList<>();

    public DeathPunishment() {
        initEffects();
        register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void register(IEventBus bus){
        ItemInit.REGISTER.register(bus);
    }

    private void initEffects(){
        EFFECTS.add("minecraft:slowness");
        EFFECTS.add("minecraft:mining_fatigue");
        EFFECTS.add("minecraft:nausea");
        EFFECTS.add("minecraft:blindness");
        EFFECTS.add("minecraft:hunger");
        EFFECTS.add("minecraft:weakness");
    }
}

package org.abstruck.rebirthisnothope;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.abstruck.rebirthisnothope.init.ItemInit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * @author Goulixiaoji
 * 我是重生大大的苟！ ！ ！！！！ ！！！！！ ！ ！！！！
 */
@Mod(RebirthIsNotHope.MOD_ID)
public class RebirthIsNotHope {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "rebirth_is_not_hope";

    public RebirthIsNotHope() {
        register(FMLJavaModLoadingContext.get().getModEventBus());
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void register(IEventBus bus){
        ItemInit.REGISTER.register(bus);
    }
}

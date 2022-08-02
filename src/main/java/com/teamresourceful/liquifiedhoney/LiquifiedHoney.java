package com.teamresourceful.liquifiedhoney;

import com.teamresourceful.liquifiedhoney.client.event.ClientEventHandlers;
import com.teamresourceful.liquifiedhoney.common.compat.ModCompat;
import com.teamresourceful.liquifiedhoney.common.registry.RegistryHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LiquifiedHoney.MOD_ID)
public class LiquifiedHoney {

    public static final String MOD_ID = "liquifiedhoney";
    public static final Logger LOGGER = LogManager.getLogger();

    public LiquifiedHoney() {
        RegistryHandler.init();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(EventPriority.LOW, this::setup);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientEventHandlers::clientStuff);
    }

    private void setup(FMLCommonSetupEvent event) {
        ModCompat.setupCompatibilities();
    }
}

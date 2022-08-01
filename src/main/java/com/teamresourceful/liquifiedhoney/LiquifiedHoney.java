package com.teamresourceful.liquifiedhoney;

import com.teamresourceful.liquifiedhoney.client.event.ClientEventHandlers;
import com.teamresourceful.liquifiedhoney.common.registry.RegistryHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LiquifiedHoney.MOD_ID)
public class LiquifiedHoney {

    public static final String MOD_ID = "liquifiedhoney";
    public static final Logger LOGGER = LogManager.getLogger();

    public LiquifiedHoney() {
        RegistryHandler.init();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientEventHandlers::clientStuff);
    }
}

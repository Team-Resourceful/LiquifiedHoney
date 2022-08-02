package com.teamresourceful.liquifiedhoney.client.event;

import com.teamresourceful.liquifiedhoney.client.render.fluid.FluidRender;
import com.teamresourceful.liquifiedhoney.common.lib.constants.ModConstants;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public final class ClientEventHandlers {

    private ClientEventHandlers() {
        throw new IllegalStateException(ModConstants.UTILITY_CLASS);
    }

    public static void clientStuff() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientEventHandlers::clientSetup);
    }

    public static void clientSetup(final FMLClientSetupEvent event) {
        event.enqueueWork(FluidRender::setHoneyRenderType);
    }

}

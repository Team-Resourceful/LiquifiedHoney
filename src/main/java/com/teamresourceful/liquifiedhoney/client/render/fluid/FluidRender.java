package com.teamresourceful.liquifiedhoney.client.render.fluid;

import com.teamresourceful.liquifiedhoney.common.lib.constants.ModConstants;
import com.teamresourceful.liquifiedhoney.common.registry.RegistryHandler;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public final class FluidRender {

    private FluidRender() {
        throw new IllegalStateException(ModConstants.UTILITY_CLASS);
    }

    public static void setHoneyRenderType() {
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.HONEY_STILL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(RegistryHandler.HONEY_FLOWING.get(), RenderType.translucent());
    }
}

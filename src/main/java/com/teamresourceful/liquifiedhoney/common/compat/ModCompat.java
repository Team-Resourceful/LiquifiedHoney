package com.teamresourceful.liquifiedhoney.common.compat;

import com.teamresourceful.liquifiedhoney.common.lib.constants.ModConstants;
import com.teamresourceful.liquifiedhoney.common.registry.RegistryHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ModCompat {

    private ModCompat() {
        throw new IllegalStateException(ModConstants.UTILITY_CLASS);
    }

    private static final Set<ResourceLocation> IGNORED_DIMENSIONS = new HashSet<>();
    private static final List<String> HONEY_FLUID_BLOCKS = List.of(
            "resourcefulbees:honey_fluid_block",
            "productivebees:honey",
            "the_bumblezone:honey_fluid_block"
    );

    private static Block conversionFluid = RegistryHandler.HONEY_FLUID_BLOCK.get();

    public static void setupCompatibilities() {
        if (ModList.get().isLoaded("the_bumblezone")) {
            IGNORED_DIMENSIONS.add(BumblezoneCompat.getBumbleZoneDimensionID());
        }

        for (String honey : HONEY_FLUID_BLOCKS) {
            Block honeyBlock = ForgeRegistries.BLOCKS.getValue(ResourceLocation.tryParse(honey));
            if (honeyBlock != Blocks.AIR) {
                conversionFluid = honeyBlock;
                break;
            }
        }
    }

    public static Block getConversionFluid() {
        return conversionFluid;
    }

    public static Set<ResourceLocation> getIgnoredDimensions() {
        return Collections.unmodifiableSet(IGNORED_DIMENSIONS);
    }
}

package com.teamresourceful.liquifiedhoney.common.lib.constants;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.versions.forge.ForgeVersion;

public final class ModTags {

    private ModTags() {
        throw new IllegalAccessError(ModConstants.UTILITY_CLASS);
    }

    public static final class Items {
        public static final TagKey<Item> HEAT_SOURCES = createItemTag(ForgeVersion.MOD_ID, "heat_sources");

        private static TagKey<Item> createItemTag(String mod, String path) {
            return ItemTags.create(new ResourceLocation(mod, path));
        }
    }

    public static final class Blocks {
        public static final TagKey<Block> HEAT_SOURCES = createBlockTag(ForgeVersion.MOD_ID, "heat_sources");

        private static TagKey<Block> createBlockTag(String mod, String path) {
            return BlockTags.create(new ResourceLocation(mod, path));
        }
    }

    public static final class Fluids {
        public static final TagKey<Fluid> HONEY = FluidTags.create(new ResourceLocation(ForgeVersion.MOD_ID, "honey"));
    }
}

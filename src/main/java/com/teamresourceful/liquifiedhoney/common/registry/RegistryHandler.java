package com.teamresourceful.liquifiedhoney.common.registry;

import com.teamresourceful.liquifiedhoney.LiquifiedHoney;
import com.teamresourceful.liquifiedhoney.common.fluids.NormalHoneyFluidType;
import com.teamresourceful.liquifiedhoney.common.lib.constants.ModConstants;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public final class RegistryHandler {

    private RegistryHandler() {
        throw new IllegalStateException(ModConstants.UTILITY_CLASS);
    }

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, LiquifiedHoney.MOD_ID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, LiquifiedHoney.MOD_ID);
    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, LiquifiedHoney.MOD_ID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, LiquifiedHoney.MOD_ID);

    public static void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        FLUIDS.register(bus);
        FLUID_TYPES.register(bus);
    }

    public static final CreativeModeTab LIQUIFIED_HONEY = new CreativeModeTab(LiquifiedHoney.MOD_ID) {

        @Override
        @NotNull
        @OnlyIn(Dist.CLIENT)
        public ItemStack makeIcon() {
            return new ItemStack(Items.HONEY_BOTTLE);
        }
    };

    public static final RegistryObject<FlowingFluid> HONEY_STILL = FLUIDS.register("honey", () ->
            new ForgeFlowingFluid.Source(makeProperties())
    );
    public static final RegistryObject<FlowingFluid> HONEY_FLOWING = FLUIDS.register("honey_flowing", () ->
            new ForgeFlowingFluid.Flowing(makeProperties())
    );

    public static final RegistryObject<FluidType> HONEY = FLUID_TYPES.register("honey", NormalHoneyFluidType::of);
    public static final RegistryObject<LiquidBlock> HONEY_FLUID_BLOCK = BLOCKS.register("honey_fluid_block", () -> new LiquidBlock(HONEY_STILL, BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100.0F).noLootTable()));

    public static final RegistryObject<Item> HONEY_FLUID_BUCKET = ITEMS.register("honey_fluid_bucket", () -> new BucketItem(HONEY_STILL, getItemProperties().craftRemainder(Items.BUCKET).stacksTo(1)));



    private static Item.Properties getItemProperties() {
        return new Item.Properties().tab(LIQUIFIED_HONEY);
    }
    private static ForgeFlowingFluid.Properties makeProperties() {
        return new ForgeFlowingFluid.Properties(HONEY, HONEY_STILL, HONEY_FLOWING)
                .bucket(HONEY_FLUID_BUCKET)
                .block(HONEY_FLUID_BLOCK)
                .tickRate(20);
    }

}

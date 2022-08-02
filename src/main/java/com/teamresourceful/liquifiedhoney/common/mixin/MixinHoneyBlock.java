package com.teamresourceful.liquifiedhoney.common.mixin;

import com.teamresourceful.liquifiedhoney.common.compat.ModCompat;
import com.teamresourceful.liquifiedhoney.common.lib.constants.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HoneyBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;

import java.util.function.Predicate;

@Mixin(HoneyBlock.class)
public abstract class MixinHoneyBlock extends Block {
    public MixinHoneyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource source) {
        AABB aabb = new AABB(pos).inflate(1);
        if (BlockPos.betweenClosedStream(aabb).anyMatch(liquifiedhoney$heatSourcePredicate(level))) {
            this.liquifiedhoney$melt(level, pos);
        }
    }

    @Override
    public boolean isRandomlyTicking(@NotNull BlockState state) {
        return true;
    }

    @NotNull
    private static Predicate<BlockPos> liquifiedhoney$heatSourcePredicate(@NotNull ServerLevel level) {
        return pos -> liquifiedhoney$blockInDirectionIsHeatSource(level, pos);
    }

    private static boolean liquifiedhoney$blockInDirectionIsHeatSource(@NotNull ServerLevel level, @NotNull BlockPos pos) {
        return level.getBlockState(pos).is(ModTags.Blocks.HEAT_SOURCES);
    }

    private void liquifiedhoney$melt(Level level, BlockPos pos) {
        if (!ModCompat.getIgnoredDimensions().contains(level.dimension().location())) {
            level.setBlockAndUpdate(pos, ModCompat.getConversionFluid().defaultBlockState());
            level.neighborChanged(pos, ModCompat.getConversionFluid(), pos);
        }
    }
}

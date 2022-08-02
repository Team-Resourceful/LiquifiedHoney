package com.teamresourceful.liquifiedhoney.common.compat;

import com.teamresourceful.liquifiedhoney.common.lib.constants.ModConstants;
import com.telepathicgrunt.the_bumblezone.Bumblezone;
import net.minecraft.resources.ResourceLocation;

public class BumblezoneCompat {

    private BumblezoneCompat() {
        throw new IllegalStateException(ModConstants.UTILITY_CLASS);
    }

    public static ResourceLocation getBumbleZoneDimensionID() {
        return Bumblezone.MOD_DIMENSION_ID;
    }
}

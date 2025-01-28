package com.fuyuaki.morethanadventure.game.worldgen.biomes;

import com.fuyuaki.morethanadventure.core.mod.MTAConfigs;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaTerrablender {
    public static void registerBiomes(){
        Regions.register(new MtaOverworldRegions(ResourceLocation.fromNamespaceAndPath(MODID,"overworld"), MTAConfigs.Common.COMMON_REGION_WEIGHT.get()));

    }
}

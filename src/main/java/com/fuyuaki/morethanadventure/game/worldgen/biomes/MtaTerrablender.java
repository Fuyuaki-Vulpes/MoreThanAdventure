package com.fuyuaki.morethanadventure.game.worldgen.biomes;

import com.fuyuaki.morethanadventure.core.mod.MTAConfigs;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.region.MTAAlternateOverworldRegions;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.region.MTARareOverworldRegions;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.region.MtaOverworldRegions;
import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaTerrablender {
    public static void registerBiomes(){
        Regions.register(new MtaOverworldRegions(ResourceLocation.fromNamespaceAndPath(MODID,"overworld"), MTAConfigs.Common.COMMON_REGION_WEIGHT.get()));
        Regions.register(new MTAAlternateOverworldRegions(ResourceLocation.fromNamespaceAndPath(MODID,"overworld_alternate"), MTAConfigs.Common.ALTERNATE_REGION_WEIGHT.get()));
        Regions.register(new MTARareOverworldRegions(ResourceLocation.fromNamespaceAndPath(MODID,"overworld_rare"), MTAConfigs.Common.RARE_REGION_WEIGHT.get()));

    }
}

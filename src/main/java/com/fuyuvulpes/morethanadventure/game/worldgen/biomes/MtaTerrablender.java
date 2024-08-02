package com.fuyuvulpes.morethanadventure.game.worldgen.biomes;

import net.minecraft.resources.ResourceLocation;
import terrablender.api.Regions;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaTerrablender {
    public static void registerBiomes(){
        Regions.register(new MtaOverworldRegions(ResourceLocation.fromNamespaceAndPath(MODID,"overworld"), 3));
    }
}

package com.fuyuaki.morethanadventure.game.worldgen.biomes.region;

import com.fuyuaki.morethanadventure.game.worldgen.biomes.builder.MtaRareOverworldBiomeBuilder;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class MTARareOverworldRegions extends Region {
    public MTARareOverworldRegions(ResourceLocation name, int weight) {
        super(name, RegionType.OVERWORLD, weight);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        new MtaRareOverworldBiomeBuilder().addBiomes(registry, mapper);
    }
}

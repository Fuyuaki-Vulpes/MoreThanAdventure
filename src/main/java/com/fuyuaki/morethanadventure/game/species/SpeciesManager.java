package com.fuyuaki.morethanadventure.game.species;

import com.mojang.serialization.Codec;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.util.Map;

public class SpeciesManager extends SimpleJsonResourceReloadListener<SpeciesHolder> {
    protected SpeciesManager(HolderLookup.Provider provider, Codec<SpeciesHolder> codec, ResourceKey<? extends Registry<SpeciesHolder>> registryKey) {
        super(provider, codec, registryKey);
    }

    @Override
    protected void apply(Map<ResourceLocation, SpeciesHolder> object, ResourceManager resourceManager, ProfilerFiller profiler) {

    }
}

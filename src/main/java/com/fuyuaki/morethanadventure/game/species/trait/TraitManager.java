package com.fuyuaki.morethanadventure.game.species.trait;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import com.fuyuaki.morethanadventure.game.species.SpeciesTree;
import com.google.common.collect.ImmutableMap;
import com.mojang.logging.LogUtils;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.ProblemReporter;
import net.minecraft.util.profiling.ProfilerFiller;
import org.slf4j.Logger;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.Map;

public class TraitManager extends SimpleJsonResourceReloadListener<Trait> {
    private static final Logger LOGGER = LogUtils.getLogger();
    private Map<ResourceLocation, TraitHolder> traits = Map.of();
    private TraitsTree tree = new TraitsTree();
    private final HolderLookup.Provider registries;


    public TraitManager(HolderLookup.Provider provider) {
        super(provider, Trait.CODEC, MTARegistries.Keys.TRAITS);
        this.registries = provider;

    }

    @Override
    protected void apply(Map<ResourceLocation, Trait> object, ResourceManager resourceManager, ProfilerFiller profiler) {
        ImmutableMap.Builder<ResourceLocation, TraitHolder> builder = ImmutableMap.builder();

        object.forEach((location, trait) -> {
            this.validate(location, trait);
            builder.put(location, new TraitHolder(trait,location));

        });
        this.traits = builder.buildOrThrow();
        TraitsTree traitsTree = new TraitsTree();
        traitsTree.addAll(this.traits.values());

        this.tree = traitsTree;

    }

    private void validate(ResourceLocation location, Trait advancement) {
        ProblemReporter.Collector problemreporter$collector = new ProblemReporter.Collector();
        advancement.validate(problemreporter$collector, this.registries);
        problemreporter$collector.getReport().ifPresent(p_344260_ -> LOGGER.warn("Found validation problems in trait {}: \n{}", location, p_344260_));
    }

    @Nullable
    public TraitHolder get(ResourceLocation location) {
        return this.traits.get(location);
    }

    public TraitsTree tree() {
        return this.tree;
    }

    public Collection<TraitHolder> getAllSpecies() {
        return this.traits.values();
    }




}

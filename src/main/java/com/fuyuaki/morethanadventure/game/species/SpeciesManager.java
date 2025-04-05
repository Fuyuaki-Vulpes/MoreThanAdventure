package com.fuyuaki.morethanadventure.game.species;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.trait.TraitHolder;
import com.fuyuaki.morethanadventure.game.species.trait.TraitsTree;
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

public class SpeciesManager extends SimpleJsonResourceReloadListener<Species> {
    private static final Logger LOGGER = LogUtils.getLogger();
    private Map<ResourceLocation, SpeciesHolder> species = Map.of();
    private SpeciesTree tree = new SpeciesTree();
    private Map<ResourceLocation, TraitHolder> trait = Map.of();
    private TraitsTree traitsTree = new TraitsTree();
    private final HolderLookup.Provider registries;


    public SpeciesManager(HolderLookup.Provider provider) {
        super(provider, Species.CODEC, MTARegistries.Keys.SPECIES);
        this.registries = provider;

    }

    @Override
    protected void apply(Map<ResourceLocation, Species> object, ResourceManager resourceManager, ProfilerFiller profiler) {
        ImmutableMap.Builder<ResourceLocation, SpeciesHolder> builder = ImmutableMap.builder();

        object.forEach((location, species1) -> {
            this.validate(location, species1);
            builder.put(location, new SpeciesHolder(species1,location));

        });
        this.species = builder.buildOrThrow();
        SpeciesTree speciesTree = new SpeciesTree();
        speciesTree.addAll(this.species.values());

        this.tree = speciesTree;

    }

    private void validate(ResourceLocation location, Species advancement) {
        ProblemReporter.Collector problemreporter$collector = new ProblemReporter.Collector();
        advancement.validate(problemreporter$collector, this.registries);
        problemreporter$collector.getReport().ifPresent(p_344260_ -> LOGGER.warn("Found validation problems in species {}: \n{}", location, p_344260_));
    }

    @Nullable
    public SpeciesHolder get(ResourceLocation location) {
        return this.species.get(location);
    }

    public SpeciesTree tree() {
        return this.tree;
    }

    public Collection<SpeciesHolder> getAllSpecies() {
        return this.species.values();
    }
}

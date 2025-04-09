package com.fuyuaki.morethanadventure.game.species.data;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class SpeciesProvider implements DataProvider {
    private final PackOutput.PathProvider pathProvider;
    private final List<SpeciesSubProvider> subProviders;
    private final CompletableFuture<HolderLookup.Provider> registries;

    public SpeciesProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, List<SpeciesSubProvider> subProviders) {
        this.pathProvider = output.createRegistryElementsPathProvider(MTARegistries.Keys.SPECIES);
        this.subProviders = subProviders;
        this.registries = registries;
    }

    @Override
    public CompletableFuture<?> run(CachedOutput p_254268_) {
        return this.registries.thenCompose(p_323115_ -> {
            Set<ResourceLocation> set = new HashSet<>();
            List<CompletableFuture<?>> list = new ArrayList<>();
            Consumer<SpeciesHolder> consumer = speciesHolder -> {
                if (!set.add(speciesHolder.id())) {
                    throw new IllegalStateException("Duplicate species " + speciesHolder.id());
                } else {
                    Path path = this.pathProvider.json(speciesHolder.id());
                    list.add(DataProvider.saveStable(p_254268_, p_323115_, Species.CODEC, speciesHolder.value(), path));
                }
            };

            for (SpeciesSubProvider speciesSubProvider : this.subProviders) {
                speciesSubProvider.generate(p_323115_, consumer);
            }

            return CompletableFuture.allOf(list.toArray(CompletableFuture[]::new));
        });
    }

    @Override
    public final String getName() {
        return "Species";
    }
}

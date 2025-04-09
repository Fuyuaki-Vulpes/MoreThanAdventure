package com.fuyuaki.morethanadventure.core.datagen.species;

import com.fuyuaki.morethanadventure.core.datagen.species.packs.MTADefaultSpecies;
import com.fuyuaki.morethanadventure.game.species.data.SpeciesProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GenSpecies extends SpeciesProvider {
    public GenSpecies(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                List.of(
                new MTADefaultSpecies()
        )
        );
    }
}

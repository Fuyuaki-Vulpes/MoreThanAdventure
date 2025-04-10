package com.fuyuaki.morethanadventure.core.datagen.species;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import com.fuyuaki.morethanadventure.game.species.data.SpeciesProvider;
import com.fuyuaki.morethanadventure.game.species.data.SpeciesSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class GenSpecies extends SpeciesProvider {
    public GenSpecies(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                List.of(
                new MTADefaultSpecies()
        )
        );
    }


    static class MTADefaultSpecies implements SpeciesSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<SpeciesHolder> writer) {

            Species.Builder.species().human(writer);
        }
    }
}

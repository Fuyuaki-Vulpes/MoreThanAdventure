package com.fuyuaki.morethanadventure.core.datagen.species.packs;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import com.fuyuaki.morethanadventure.game.species.data.SpeciesSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.function.Consumer;

public class MTADefaultSpecies implements SpeciesSubProvider {
    @Override
    public void generate(HolderLookup.Provider registries, Consumer<SpeciesHolder> writer) {

        Species.Builder.species().human(writer);
    }
}

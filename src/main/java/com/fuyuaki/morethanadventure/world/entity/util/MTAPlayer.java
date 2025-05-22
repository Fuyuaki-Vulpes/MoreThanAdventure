package com.fuyuaki.morethanadventure.world.entity.util;

import com.fuyuaki.morethanadventure.game.species.Species;
import net.minecraft.resources.ResourceKey;

public interface MTAPlayer {


    ResourceKey<Species> getSpeciesKey();
    Species getSpecies();

    void setSpeciesKey(ResourceKey<Species> key);
}

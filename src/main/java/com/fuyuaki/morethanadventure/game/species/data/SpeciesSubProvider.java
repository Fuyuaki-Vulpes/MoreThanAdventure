package com.fuyuaki.morethanadventure.game.species.data;

import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Consumer;

public interface SpeciesSubProvider {
    void generate(HolderLookup.Provider registries, Consumer<SpeciesHolder> writer);

    static AdvancementHolder createPlaceholder(String location) {
        return Advancement.Builder.advancement().build(ResourceLocation.parse(location));
    }
}

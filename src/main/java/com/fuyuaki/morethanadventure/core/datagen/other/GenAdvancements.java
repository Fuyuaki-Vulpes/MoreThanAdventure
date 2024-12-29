package com.fuyuaki.morethanadventure.core.datagen.other;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class GenAdvancements extends AdvancementProvider {

    public GenAdvancements(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                List.of(
                        new MTARootAdvancements()
                )
        );
    }


}

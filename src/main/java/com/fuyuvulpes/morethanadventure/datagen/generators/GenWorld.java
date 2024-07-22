package com.fuyuvulpes.morethanadventure.datagen.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenWorld extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            //.add(Registries.DIMENSION_TYPE, ModDimensions::bootstrapType)
            //.add(Registries.CONFIGURED_FEATURE, ModConfigFeatures::bootstrap)
            //.add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            //.add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
            //.add(Registries.BIOME, ModBiomes::boostrap)
            //.add(Registries.LEVEL_STEM, ModDimensions::bootstrapStem)
            ;


    public GenWorld(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MODID));
    }
}

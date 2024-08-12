package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomeModifiers;
import com.fuyuaki.morethanadventure.game.worldgen.MtaConfigFeatures;
import com.fuyuaki.morethanadventure.game.worldgen.MtaPlacedFeatures;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenWorld extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, MtaConfigFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, MtaPlacedFeatures::bootstrap)
            .add(Registries.BIOME, MtaBiomes::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, MtaBiomeModifiers::bootstrap)
            ;


    public GenWorld(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(MODID));
    }
}

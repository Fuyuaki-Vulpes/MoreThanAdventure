package com.fuyuvulpes.morethanadventure.game.worldgen.biomes;

import com.fuyuvulpes.morethanadventure.game.worldgen.MtaPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaBiomeModifiers {


    public static final ResourceKey<BiomeModifier> ADD_DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<BiomeModifier> ADD_DEBRIS_CLUSTER = registerKey("debris_cluster");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {

        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_DIAMOND_CLUSTER,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.DIAMOND_CLUSTER)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_DEBRIS_CLUSTER,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.DEBRIS_CLUSTER)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }
}

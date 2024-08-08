package com.fuyuvulpes.morethanadventure.game.worldgen.biomes;

import com.fuyuvulpes.morethanadventure.core.registry.MtaTags;
import com.fuyuvulpes.morethanadventure.game.worldgen.MtaPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaBiomeModifiers {


    public static final ResourceKey<BiomeModifier> ADD_DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<BiomeModifier> ADD_DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<BiomeModifier> ADD_MOSSY_ROCKS = registerKey("mossy_rocks");
    public static final ResourceKey<BiomeModifier> ADD_STONY_ROCKS = registerKey("stony_rocks");
    public static final ResourceKey<BiomeModifier> ADD_GEYSER_OVERWORLD = registerKey("geyser_overworld");
    public static final ResourceKey<BiomeModifier> ADD_GEYSER_NETHER = registerKey("geyser_nether");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_IRON = registerKey("nether_iron");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_DIAMOND = registerKey("nether_diamond");
    public static final ResourceKey<BiomeModifier> ADD_END_LAPIS = registerKey("nether_lapis");
    public static final ResourceKey<BiomeModifier> ADD_END_EMERALD = registerKey("nether_emerald");
    public static final ResourceKey<BiomeModifier> ADD_CLEAR_QUARTZ = registerKey("clear_quartz");

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

        context.register(ADD_STONY_ROCKS,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_STONY_SHORES),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.STONY_ROCK)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_GEYSER_OVERWORLD,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.OVERWORLD_GEYSERS),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.GEYSER_OVERWORLD)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_GEYSER_NETHER,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.NETHER_GEYSERS),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.GEYSER_NETHER)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_NETHER_IRON,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.NETHER_IRON)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_NETHER_DIAMOND,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.NETHER_DIAMOND)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_END_LAPIS,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.END_LAPIS)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_END_EMERALD,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_END),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.END_EMERALD)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_CLEAR_QUARTZ,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.CLEAR_QUARTZ_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));



    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }
}

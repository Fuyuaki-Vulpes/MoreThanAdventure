package com.fuyuaki.morethanadventure.game.worldgen.biomes;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.game.worldgen.MtaPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaBiomeModifiers {

    public  static final ResourceKey<BiomeModifier> ADD_PALM_TREE = registerKey(("palm_tree"));
    public static final ResourceKey<BiomeModifier> ADD_DIAMOND_CLUSTER = registerKey("diamond_cluster");
    public static final ResourceKey<BiomeModifier> ADD_DEBRIS_CLUSTER = registerKey("debris_cluster");
    public static final ResourceKey<BiomeModifier> ADD_MOSSY_ROCKS = registerKey("mossy_rocks");
    public static final ResourceKey<BiomeModifier> ADD_STONY_ROCKS = registerKey("stony_rocks");
    public static final ResourceKey<BiomeModifier> ADD_STONY_ROCKS_MOUNTAIN = registerKey("stony_rocks_mountain");
    public static final ResourceKey<BiomeModifier> ADD_GEYSER_OVERWORLD = registerKey("geyser_overworld");
    public static final ResourceKey<BiomeModifier> ADD_GEYSER_NETHER = registerKey("geyser_nether");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_IRON = registerKey("nether_iron");
    public static final ResourceKey<BiomeModifier> ADD_NETHER_DIAMOND = registerKey("nether_diamond");
    public static final ResourceKey<BiomeModifier> ADD_END_LAPIS = registerKey("nether_lapis");
    public static final ResourceKey<BiomeModifier> ADD_END_EMERALD = registerKey("nether_emerald");
    public static final ResourceKey<BiomeModifier> ADD_CLEAR_QUARTZ = registerKey("clear_quartz");
    public static final ResourceKey<BiomeModifier> ADD_NETHERITIC_CRYSTAL_ORE = registerKey("netheritic_crystal_ore");
    public static final ResourceKey<BiomeModifier> ADD_AGATE_ORE = registerKey("agate_ore");
    public static final ResourceKey<BiomeModifier> ADD_ALEXANDRITE_ORE = registerKey("alexandrite_ore");
    public static final ResourceKey<BiomeModifier> ADD_AQUAMARINE_ORE = registerKey("aquamarine_ore");
    public static final ResourceKey<BiomeModifier> ADD_CELESTITE_ORE = registerKey("celestite_ore");
    public static final ResourceKey<BiomeModifier> ADD_GARNET_ORE = registerKey("garnet_ore");
    public static final ResourceKey<BiomeModifier> ADD_MOONSTONE_ORE = registerKey("moonstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_SWEET_BERRY_LEAVES = registerKey("sweet_berry_leaves");

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {

        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_PALM_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BEACH)),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.PALM_TREE_RARE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

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
                GenerationStep.Decoration.UNDERGROUND_DECORATION
        ));

        context.register(ADD_STONY_ROCKS_MOUNTAIN,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_MOUNTAIN_PEAK),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.STONY_ROCK)),
                GenerationStep.Decoration.UNDERGROUND_DECORATION
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

        context.register(ADD_NETHERITIC_CRYSTAL_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.NETHERITIC_CRYSTAL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_AGATE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_BADLANDS),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AGATE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_ALEXANDRITE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.ALEXANDRITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_AQUAMARINE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OCEAN),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AQUAMARINE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_CELESTITE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.CELESTITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_GARNET_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DESERT),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.GARNET_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_MOONSTONE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.MOONSTONE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_MOSSY_ROCKS,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.MOSSY_ROCKS)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_SWEET_BERRY_LEAVES,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_TAIGA),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.SWEET_BERRY_LEAVES)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }
}

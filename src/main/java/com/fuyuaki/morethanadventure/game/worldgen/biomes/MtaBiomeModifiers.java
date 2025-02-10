package com.fuyuaki.morethanadventure.game.worldgen.biomes;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.game.worldgen.MtaPlacedFeatures;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaBiomeModifiers {

    public  static final ResourceKey<BiomeModifier> ADD_AVOCADO_TREE = registerKey(("avocado_tree"));
    public  static final ResourceKey<BiomeModifier> ADD_PINK_IPE_TREE = registerKey(("pink_ipe_tree"));
    public  static final ResourceKey<BiomeModifier> ADD_PURPLE_IPE_TREE = registerKey(("purple_ipe_tree"));
    public  static final ResourceKey<BiomeModifier> ADD_WHITE_IPE_TREE = registerKey(("white_ipe_tree"));
    public  static final ResourceKey<BiomeModifier> ADD_YELLOW_IPE_TREE = registerKey(("yellow_ipe_tree"));
    public  static final ResourceKey<BiomeModifier> ADD_MANGO_TREE = registerKey(("mango_tree"));
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
    public static final ResourceKey<BiomeModifier> ADD_BLOODSTONE_ORE = registerKey("bloodstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_CELESTITE_ORE = registerKey("celestite_ore");
    public static final ResourceKey<BiomeModifier> ADD_CRYOLITE_ORE = registerKey("cryolite_ore");
    public static final ResourceKey<BiomeModifier> ADD_GARNET_ORE = registerKey("garnet_ore");
    public static final ResourceKey<BiomeModifier> ADD_MOONSTONE_ORE = registerKey("moonstone_ore");
    public static final ResourceKey<BiomeModifier> ADD_GRASSY_DIRT_PATCHES = registerKey("grassy_dirt_patches");
    public static final ResourceKey<BiomeModifier> ADD_SCATTERED_LEAVES = registerKey("scattered_leaves");
    public static final ResourceKey<BiomeModifier> ADD_SHALLOW_GRASS = registerKey("shallow_grass");


    public static final ResourceKey<BiomeModifier> SPAWNS_BEARDED_DRAGON = registerKey("add_spawns_bearded_dragon");
    public static final ResourceKey<BiomeModifier> SPAWNS_BUTTERFLY = registerKey("add_spawns_butterfly");
    public static final ResourceKey<BiomeModifier> SPAWNS_CAPYBARA = registerKey("add_spawns_capybara");
    public static final ResourceKey<BiomeModifier> SPAWNS_DUCK = registerKey("add_spawns_duck");
    public static final ResourceKey<BiomeModifier> SPAWNS_FERRET = registerKey("add_spawns_ferret");
    public static final ResourceKey<BiomeModifier> SPAWNS_GREAT_WHITE_SHARK = registerKey("add_spawns_great_white_shark");
    public static final ResourceKey<BiomeModifier> SPAWNS_HORSESHOE_CRAB = registerKey("add_spawns_horseshoe_crab");
    public static final ResourceKey<BiomeModifier> SPAWNS_JELLYFISH = registerKey("add_spawns_jellyfish");
    public static final ResourceKey<BiomeModifier> SPAWNS_OCTOPUS = registerKey("add_spawns_octopus");
    public static final ResourceKey<BiomeModifier> SPAWNS_DEER = registerKey("add_spawns_deer");
    public static final ResourceKey<BiomeModifier> SPAWNS_TURKEY = registerKey("add_spawns_turkey");
    public static final ResourceKey<BiomeModifier> SPAWNS_OWL = registerKey("add_spawns_owl");
    public static final ResourceKey<BiomeModifier> SPAWNS_PENGUIN = registerKey("add_spawns_penguin");
    public static final ResourceKey<BiomeModifier> SPAWNS_RACCOON = registerKey("add_spawns_raccoon");
    public static final ResourceKey<BiomeModifier> SPAWNS_SHRIMP = registerKey("add_spawns_shrimp");
    public static final ResourceKey<BiomeModifier> SPAWNS_TOUCAN = registerKey("add_spawns_toucan");
    public static final ResourceKey<BiomeModifier> SPAWNS_WISPFLY = registerKey("add_spawns_wispfly");
    public static final ResourceKey<BiomeModifier> SPAWNS_WISPFLY_RARE = registerKey("add_spawns_wispfly_rare");

    public static final ResourceKey<BiomeModifier> SPAWNS_ICICLE_CREEPER = registerKey("add_spawns_icicle_creeper");
    public static final ResourceKey<BiomeModifier> SPAWNS_ARMORED_SKELETON = registerKey("add_spawns_armored_skeleton");
    public static final ResourceKey<BiomeModifier> SPAWNS_BLACK_WIDOW = registerKey("add_spawns_black_widow");
    public static final ResourceKey<BiomeModifier> SPAWNS_FALLEN_SAMURAI = registerKey("add_spawns_fallen_samurai");
    public static final ResourceKey<BiomeModifier> SPAWNS_YUKI_ONNA = registerKey("add_spawns_yuki_onna");
    public static final ResourceKey<BiomeModifier> SPAWNS_CHARRED_SKELETON = registerKey("add_spawns_charred_skeleton");
    public static final ResourceKey<BiomeModifier> SPAWNS_CORROSIVE_CUBE = registerKey("add_spawns_corrosive_cube");
    public static final ResourceKey<BiomeModifier> SPAWNS_FROSTED_SLIME = registerKey("add_spawns_frosted_slime");
    public static final ResourceKey<BiomeModifier> SPAWNS_GLOW_SPIDER = registerKey("add_spawns_glow_spider");
    public static final ResourceKey<BiomeModifier> SPAWNS_HOST = registerKey("add_spawns_host");
    public static final ResourceKey<BiomeModifier> SPAWNS_MOSSY_ZOMBIE = registerKey("add_spawns_mossy_zombie");
    public static final ResourceKey<BiomeModifier> SPAWNS_SKELETON_FIGHTER = registerKey("add_spawns_skeleton_fighter");
    public static final ResourceKey<BiomeModifier> SPAWNS_TOXIC_ZOMBIE = registerKey("add_spawns_toxic_zombie");
    public static final ResourceKey<BiomeModifier> SPAWNS_WITHER_SOLDIER = registerKey("add_spawns_wither_soldier");
    public static final ResourceKey<BiomeModifier> SPAWNS_ZOMBIFIED_MINER = registerKey("add_spawns_zombified_miner");
    public static final ResourceKey<BiomeModifier> SPAWNS_SIREN = registerKey("add_spawns_siren");

    public static final ResourceKey<BiomeModifier> ADD_CATTAIL = registerKey("cattail");




    public static void bootstrap(BootstrapContext<BiomeModifier> context) {

        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_CATTAIL,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_CATTAIL),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.CATTAIL_VEGETATION)),
                GenerationStep.Decoration.VEGETAL_DECORATION

        ));

        context.register(ADD_AVOCADO_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AVOCADO_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));


        context.register(ADD_PINK_IPE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AVOCADO_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(ADD_PURPLE_IPE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AVOCADO_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(ADD_WHITE_IPE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AVOCADO_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));
        context.register(ADD_YELLOW_IPE_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AVOCADO_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_MANGO_TREE, new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FOREST)),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.MANGO_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

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
                biomes.getOrThrow(MtaTags.Biomes.AGATE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AGATE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_ALEXANDRITE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.ALEXANDRITE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.ALEXANDRITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_AQUAMARINE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.AQUAMARINE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.AQUAMARINE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_CELESTITE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.CELESTITE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.CELESTITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_BLOODSTONE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.BLOODSTONE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.BLOODSTONE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_CRYOLITE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.CRYOLITE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.CRYOLITE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_GARNET_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.GARNET),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.GARNET_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_MOONSTONE_ORE,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.MOONSTONE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.MOONSTONE_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));

        context.register(ADD_MOSSY_ROCKS,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.MOSSY_ROCKS)),
                GenerationStep.Decoration.UNDERGROUND_ORES
        ));
        context.register(ADD_GRASSY_DIRT_PATCHES,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.GRASSY_DIRT_SHOULD_GENERATE),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.GRASSY_DIRT_PATCH)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_SCATTERED_LEAVES,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_FOREST),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.SCATTERED_LEAVES)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));

        context.register(ADD_SHALLOW_GRASS,new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
                HolderSet.direct(placedFeatures.getOrThrow(MtaPlacedFeatures.SHALLOW_GRASS_SPARSE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));


        //MOB SPAWNS
        context.register(SPAWNS_BEARDED_DRAGON,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_BEARDED_DRAGON),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.BEARDED_DRAGON.get(),10,1,2))
        ));
        context.register(SPAWNS_BUTTERFLY,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_BUTTERFLY),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.BUTTERFLY.get(),8,2,9))
        ));
        context.register(SPAWNS_CAPYBARA,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_CAPYBARA),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.CAPIBARA.get(),10,1,7))
        ));
        context.register(SPAWNS_DUCK,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_DUCK),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.DUCK.get(),8,2,7))
        ));
        context.register(SPAWNS_FERRET,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_FERRET),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.FERRET.get(),10,2,4))
        ));
        context.register(SPAWNS_GREAT_WHITE_SHARK,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_GREAT_WHITE_SHARK),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.GREAT_WHITE_SHARK.get(),5,1,1))
        ));
        context.register(SPAWNS_HORSESHOE_CRAB,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_HORSESHOE_CRAB),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.HORSESHOE_CRAB.get(),15,1,5))
        ));
        context.register(SPAWNS_JELLYFISH,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_JELLYFISH),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.JELLYFISH.get(),20,1,5))
        ));
        context.register(SPAWNS_OCTOPUS,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_OCTOPUS),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.OCTOPUS.get(),15,1,2))
        ));
        context.register(SPAWNS_DEER,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_DEER),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.DEER.get(),15,1,2))
        ));
        context.register(SPAWNS_TURKEY,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_TURKEY),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.TURKEY.get(),15,1,2))
        ));
        context.register(SPAWNS_OWL,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_OWL),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.OWL.get(),8,1,3))
        ));
        context.register(SPAWNS_PENGUIN,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_PENGUIN),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.PENGUIN.get(),20,2,6))
        ));
        context.register(SPAWNS_RACCOON,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_RACCOON),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.RACCOON.get(),12,1,5))
        ));
        context.register(SPAWNS_SHRIMP,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_SHRIMP),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.SHRIMP.get(),14,1,5))
        ));
        context.register(SPAWNS_TOUCAN,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_TOUCAN),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.TOUCAN.get(),40,1,5))
        ));
        context.register(SPAWNS_WISPFLY_RARE,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_WISP_RARE),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.WISPFLY.get(),8,1,3))
        ));

        context.register(SPAWNS_WISPFLY,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_WISP),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.WISPFLY.get(),25,1,6))
        ));


        context.register(SPAWNS_ICICLE_CREEPER,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_COLD_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.ICICLE_CREEPER.get(),35,1,1))
        ));

        context.register(SPAWNS_ARMORED_SKELETON,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.ARMORED_SKELETON.get(),30,1,2))
        ));

        context.register(SPAWNS_BLACK_WIDOW,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_BLACK_WIDOW),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.BLACK_WIDOW.get(),18,1,1))
        ));

        context.register(SPAWNS_FALLEN_SAMURAI,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.FALLEN_SAMURAI.get(),30,1,4))
        ));
        context.register(SPAWNS_YUKI_ONNA,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_YUKI_ONNA),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.YUKI_ONNA.get(),20,1,2))
        ));

        context.register(SPAWNS_CHARRED_SKELETON,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_CHARRED_SKELETON),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.CHARRED_SKELETON.get(),30,1,3))
        ));

        context.register(SPAWNS_CORROSIVE_CUBE,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.CORROSIVE_CUBE.get(),5,1,3))
        ));

        context.register(SPAWNS_FROSTED_SLIME,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SNOWY),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.FROSTED_SLIME.get(),5,1,4))
        ));

        context.register(SPAWNS_GLOW_SPIDER,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_GLOW_SPIDER),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.GLOW_SPIDER.get(),40,1,3))
        ));

        context.register(SPAWNS_HOST,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_HOST),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.HOST.get(),6,1,7))
        ));

        context.register(SPAWNS_MOSSY_ZOMBIE,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_JUNGLE),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.MOSSY_ZOMBIE.get(),60,1,2))
        ));

        context.register(SPAWNS_SKELETON_FIGHTER,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_DRY_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.SKELETON_FIGHTER.get(),45,1,2))
        ));

        context.register(SPAWNS_TOXIC_ZOMBIE,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_SWAMP),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.TOXIC_ZOMBIE.get(),25,1,1))
        ));

        context.register(SPAWNS_WITHER_SOLDIER,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.WITHER_SOLDIER.get(),60,2,8))
        ));

        context.register(SPAWNS_ZOMBIFIED_MINER,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(Tags.Biomes.IS_OVERWORLD),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.ZOMBIFIED_MINER.get(),80,1,3))
        ));

        context.register(SPAWNS_SIREN,new BiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(MtaTags.Biomes.HAS_SIREN),
                List.of(new MobSpawnSettings.SpawnerData(MtaEntityTypes.SIREN.get(),10,1,4))
        ));



    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MODID, name));
    }
}

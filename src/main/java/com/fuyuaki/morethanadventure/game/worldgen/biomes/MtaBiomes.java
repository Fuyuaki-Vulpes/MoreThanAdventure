package com.fuyuaki.morethanadventure.game.worldgen.biomes;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.game.worldgen.MtaPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BiomeDefaultFeatures;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.biome.OverworldBiomes;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.data.worldgen.placement.AquaticPlacements;
import net.minecraft.data.worldgen.placement.MiscOverworldPlacements;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.Musics;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.npc.VillagerType;
import net.minecraft.world.level.biome.*;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaBiomes {

    //MUSIC
    @Nullable
    private static final Music NORMAL_MUSIC = null;
    private static final Music FOREST_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_FOREST);
    private static final Music SWAMP_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SWAMP);
    private static final Music JUNGLE_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JUNGLE);
    private static final Music CAVE_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DRIPSTONE_CAVES);
    private static final Music CAVE_LUSH_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_LUSH_CAVES);
    private static final Music MOUNTAIN_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_JAGGED_PEAKS);
    private static final Music DESERT_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_DESERT);
    private static final Music SNOWY_SLOPES_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_SNOWY_SLOPES);
    private static final Music MAGICAL_MUSIC = Musics.createGameMusic(SoundEvents.MUSIC_BIOME_CHERRY_GROVE);

    //OVERWORLD

    public static final ResourceKey<Biome> ALPINE_TUNDRA = createBiome("alpine_tundra");
    public static final ResourceKey<Biome> BOG = createBiome("bog");
    public static final ResourceKey<Biome> GRAVELLY_RIVER = createBiome("gravelly_river");
    public static final ResourceKey<Biome> LUSH_MEADOW = createBiome("lush_meadow");
    public static final ResourceKey<Biome> LUSH_RIVER = createBiome("lush_river");
    public static final ResourceKey<Biome> MAPLE_FOREST = createBiome("maple_forest");
    public static final ResourceKey<Biome> OASIS = createBiome("oasis");
    public static final ResourceKey<Biome> CAATINGA = createBiome("caatinga");
    public static final ResourceKey<Biome> SPARSE_CHERRY_GROVE = createBiome("sparse_cherry_grove");
    public static final ResourceKey<Biome> SPARSE_TAIGA = createBiome("sparse_taiga");
    public static final ResourceKey<Biome> TUNDRA = createBiome("tundra");
    public static final ResourceKey<Biome> UNDERWATER_FOREST = createBiome("underwater_forest");
    public static final ResourceKey<Biome> POLAR_DESERT = createBiome("polar_desert");
    public static final ResourceKey<Biome> CERRADO = createBiome("cerrado");
    public static final ResourceKey<Biome> DENSE_SAVANNA = createBiome("dense_savanna");

    //CAVE

    public static final ResourceKey<Biome> CRYSTALLINE_GROTTO = createBiome("crystalline_grotto");

    public static final List<ResourceKey<Biome>> BIOMES = new ArrayList<>();

    public static ResourceKey<Biome> createBiome(String name){
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(MODID,name));
    }

    public static void addBiomes() {
        registerVillagerTypes();
    }

    public static void bootstrap(BootstrapContext<Biome> context){

        HolderGetter<PlacedFeature> placedFeatureHolder = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<ConfiguredWorldCarver<?>> configuredCarverHolder = context.lookup(Registries.CONFIGURED_CARVER);

        register(context,LUSH_RIVER, lushRiver(placedFeatureHolder,configuredCarverHolder));
        register(context,SPARSE_CHERRY_GROVE, sparseCherryGrove(placedFeatureHolder,configuredCarverHolder));
        register(context,SPARSE_TAIGA, sparseTaiga(placedFeatureHolder,configuredCarverHolder));
        register(context,OASIS, oasis(placedFeatureHolder,configuredCarverHolder));
        register(context,TUNDRA, tundra(placedFeatureHolder,configuredCarverHolder));
        register(context,GRAVELLY_RIVER, gravelRiver(placedFeatureHolder,configuredCarverHolder));
        register(context,LUSH_MEADOW, lushMeadow(placedFeatureHolder,configuredCarverHolder));
        register(context,CRYSTALLINE_GROTTO, crystallineGrotto(placedFeatureHolder,configuredCarverHolder));
        register(context,UNDERWATER_FOREST, underwaterForest(placedFeatureHolder,configuredCarverHolder));
        register(context,MAPLE_FOREST, mapleForest(placedFeatureHolder,configuredCarverHolder));
        register(context,ALPINE_TUNDRA, alpineTundra(placedFeatureHolder,configuredCarverHolder));
        register(context,BOG, bog(placedFeatureHolder,configuredCarverHolder));
        register(context,POLAR_DESERT, polarDesert(placedFeatureHolder,configuredCarverHolder));
        register(context,CERRADO, cerrado(placedFeatureHolder,configuredCarverHolder));
        register(context,CAATINGA, caatinga(placedFeatureHolder,configuredCarverHolder));
        register(context,DENSE_SAVANNA, dense_savanna(placedFeatureHolder,configuredCarverHolder));
    }



    public static void globalOverworldGeneration(BiomeGenerationSettings.Builder builder) {
        BiomeDefaultFeatures.addDefaultCarversAndLakes(builder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(builder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(builder);
        BiomeDefaultFeatures.addDefaultUndergroundVariety(builder);
        BiomeDefaultFeatures.addDefaultSprings(builder);
        BiomeDefaultFeatures.addSurfaceFreezing(builder);
    }


    private static Biome dense_savanna(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.HORSE, 1, 2, 6))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 1))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ARMADILLO, 10, 2, 3));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);

        globalOverworldGeneration(biomeBuilder);


        BiomeDefaultFeatures.addSavannaGrass(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.DENSE_SAVANNA_TREES);
        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SHALLOW_GRASS_SPARSE);



        return biome(true,
                2.0F,
                0.2F,
                4159204,
                329011,
                0xbfb755,
                0xAEA42A,
                spawnBuilder,
                biomeBuilder,
                FOREST_MUSIC
        );
    }

private static Biome caatinga(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.desertSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.ARMADILLO, 6, 1, 2));
        spawnBuilder.creatureGenerationProbability(0.2F);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);


        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addExtraGold(biomeBuilder);

        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SPARSE_OAK_TREE);

        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);

        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.STONY_ROCK);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PRICKLY_PEAR);

        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SAND_GRASS_SPARSE);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SHALLOW_GRASS_SPARSE);


        return biome(true,
                2.0F,
                0.0F,
                4159204,
                329011,
                0xabbd82,
                0xc6cc97,
                spawnBuilder,
                biomeBuilder,
                DESERT_MUSIC
        );
    }

    private static Biome cerrado(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 12, 4, 8))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 10, 2, 5))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PARROT, 20, 1, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.OCELOT, 5, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.DEER.get(), 8, 1, 3))
        ;
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);
        BiomeDefaultFeatures.farmAnimals(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);


        globalOverworldGeneration(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_TALL_GRASS);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_LARGE_FERN);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addSavannaTrees(biomeBuilder);

        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
        BiomeDefaultFeatures.addSavannaExtraGrass(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_DEAD_BUSH);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PRICKLY_PEAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SAND_GRASS_SPARSE);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.ACACIA_BUSH);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SHALLOW_GRASS_SPARSE);


        return biome(true,1.8F,0.1F,
                4159204,
                329011,
                0xd4a531,
                0xe3c622,
                spawnBuilder,
                biomeBuilder,
                DESERT_MUSIC
                );
    }

    private static Biome alpineTundra(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 2, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.DEER.get(), 15, 2, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.GOAT, 15, 2, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 15, 2, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 15, 2, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 15, 2, 4))

                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.YUKI_ONNA.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.FROSTED_SLIME.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.ICICLE_CREEPER.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.STRAY, 15, 2, 4));

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PATCH_TUNDRA_GRASS);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.STONY_ROCK);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.ALPINE_TREE);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);


        return biome(true, -1.0F, 0.8F,
                4159204,
                329011,
                0xeac466,
                0xa5bc6c,
                spawnBuilder, biomeBuilder, SNOWY_SLOPES_MUSIC);
    }

    public static Biome polarDesert(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder();
        BiomeDefaultFeatures.snowySpawns(mobspawnsettings$builder);
        mobspawnsettings$builder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 8, 4, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 12, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.YUKI_ONNA.get(), 40, 1, 3))
        ;
        mobspawnsettings$builder.creatureGenerationProbability(0.05F);
        BiomeGenerationSettings.Builder biomeBuilder = new BiomeGenerationSettings.Builder(placedFeatures, worldCarvers);
        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PERMAFROST_ROCK);
        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);
        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(-1.0F)
                .downfall(0.0F)
                .specialEffects(new BiomeSpecialEffects.Builder()
                        .waterColor(4159204)
                        .waterFogColor(329011)
                        .fogColor(12638463)
                        .skyColor(calculateSkyColor(-1.0F))
                        .ambientParticle(new AmbientParticleSettings(ParticleTypes.SNOWFLAKE, 0.00125F))
                        .ambientAdditionsSound(new AmbientAdditionsSettings(MtaSounds.AMBIENT_POLAR_WIND, 0.005))
                        .backgroundMusic(SNOWY_SLOPES_MUSIC)
                        .build())
                .mobSpawnSettings(mobspawnsettings$builder.build())
                .generationSettings(biomeBuilder.build())
                .build();

    }


    private static Biome bog(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FROG, 4, 1, 3))


                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.WITCH, 5, 1, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.BOGGED, 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.ARMORED_SKELETON.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.FALLEN_SAMURAI.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.BLACK_WIDOW.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.HOST.get(), 15, 1, 1))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.SKELETON_FIGHTER.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.CORROSIVE_CUBE.get(), 15, 2, 4))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.TOXIC_ZOMBIE.get(), 15, 2, 4));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addBadlandGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_GRAVEL);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.BOGGED_OAK_TREE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.STONY_ROCK);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addBadlandExtraVegetation(biomeBuilder);

        BiomeSpecialEffects.Builder effects = new BiomeSpecialEffects.Builder()
                .waterColor(0x9eacb5)
                .waterFogColor(0xc0c8cc)
                .grassColorOverride(0x899aa3)
                .foliageColorOverride(0x899aa3)
                .fogColor(0xe1e4e6)
                .skyColor(0xd3dfe6)
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(SWAMP_MUSIC);

        return new Biome.BiomeBuilder()
                .hasPrecipitation(false)
                .temperature(0.7F)
                .downfall(0.2F)
                .specialEffects(effects.build())
                .mobSpawnSettings(spawnBuilder.build())
                .generationSettings(biomeBuilder.build())
                .build();
    }



    private static Biome lushRiver(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 6, 1, 5))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.COD, 5, 1, 5))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.TROPICAL_FISH, 2, 3, 8));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 40, 1, 1));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, MtaPlacedFeatures.MOSSY_ROCKS);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SPARSE_MANGROVE);


        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_SAND);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MiscOverworldPlacements.DISK_CLAY);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.DISK_MOSS);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.FREQUENT_CLAY);
        BiomeDefaultFeatures.addWaterTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_WATERLILY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_JUNGLE);
        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_SWAMP)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.KELP_WARM)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_BERRY_COMMON);






        return biome(true,0.6F,0.3F, 4566514, 267827, null, null,spawnBuilder,biomeBuilder,null);

    }

    private static Biome sparseCherryGrove(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers){
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.PIG, 1, 1, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 2, 2, 6))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.FREQUENT_CLAY);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.PATCH_GRASS_PLAIN);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_CHERRY);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SPARSE_CHERRY_TREE);

        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);

        return biome(true,
                0.5F,
                0.8F,
                6141935,
                6141935,
                11983713,
                11983713,
                spawnBuilder,
                biomeBuilder,
                MAGICAL_MUSIC);
    }

    private static Biome sparseTaiga(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.farmAnimals(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 2, 4))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 6, 2, 5))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 5, 1, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addPlainGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SPARSE_SPRUCE_TREE);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addTaigaGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addCommonBerryBushes(biomeBuilder);
        return biome(
                true,
                0.2F,
                0.6F,
                4159204,
                329011,
                null,
                null,
                spawnBuilder,
                biomeBuilder,
                NORMAL_MUSIC);
    }

    private static Biome oasis(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        BiomeDefaultFeatures.desertSpawns(spawnBuilder);
        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.CAMEL, 4, 1, 3));


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);


        BiomeDefaultFeatures.addFossilDecoration(biomeBuilder);
        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PALM_TREE);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PRICKLY_PEAR);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SAND_GRASS);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SANDSTONE_ROCK);

        BiomeDefaultFeatures.addDesertVegetation(biomeBuilder);

        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);

        BiomeDefaultFeatures.addDesertExtraVegetation(biomeBuilder);
        BiomeDefaultFeatures.addDesertExtraDecoration(biomeBuilder);


        return biome(
                false,
                2.0F,
                0.4F,
                0x32A598,
                0x32A598,
                0xBFB755,
                0xBFB755,
                spawnBuilder,
                biomeBuilder,
                DESERT_MUSIC);
    }

    private static Biome gravelRiver(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();


        spawnBuilder.addSpawn(MobCategory.WATER_CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SQUID, 2, 1, 4))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.SALMON, 6, 1, 5));
        spawnBuilder.addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(EntityType.DROWNED, 40, 1, 1));

        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addForestFlowers(biomeBuilder);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);



        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);

        BiomeDefaultFeatures.addWaterTrees(biomeBuilder);
        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addDefaultGrass(biomeBuilder);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.STONY_ROCK);



        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_RIVER);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.VINES);


        return biome(true,0.3F,0.1F, 0x7C8CC4, 0x171A2A, null, null,spawnBuilder,biomeBuilder,null);

    }

    private static Biome lushMeadow(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers){
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.DONKEY, 1, 1, 2))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.RABBIT, 4, 2, 6))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.BUTTERFLY.get(), 3, 2, 5))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.SHEEP, 2, 2, 4));
        BiomeDefaultFeatures.commonSpawns(spawnBuilder);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_FOREST_FLOWERS);


        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, VegetationPlacements.FLOWER_FLOWER_FOREST);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.DISK_MOSS_RARE);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.LUSH_VEGETATION);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreePlacements.FANCY_OAK_BEES_002);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreePlacements.OAK_BEES_002);
        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, TreePlacements.BIRCH_BEES_002);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_DECORATION, MtaPlacedFeatures.MOSSY_ROCKS);

        BiomeDefaultFeatures.addMeadowVegetation(biomeBuilder);
        BiomeDefaultFeatures.addWarmFlowers(biomeBuilder);
        BiomeDefaultFeatures.addJungleGrass(biomeBuilder);


        BiomeDefaultFeatures.addExtraEmeralds(biomeBuilder);
        BiomeDefaultFeatures.addInfestedStone(biomeBuilder);

        return biome(true,
                0.3F,
                0.8F,
                6141935,
                6141935,
                11983713,
                11983713,
                spawnBuilder,
                biomeBuilder,
                MOUNTAIN_MUSIC);
    }


    private static Biome crystallineGrotto(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers){
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();



        BiomeDefaultFeatures.caveSpawns(spawnBuilder);
        BiomeDefaultFeatures.monsters(spawnBuilder, 40, 6, 40, false);

        spawnBuilder.addSpawn(MobCategory.MONSTER,
                new MobSpawnSettings.SpawnerData(EntityType.SILVERFISH, 20, 2, 8));


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.CALCITE_BLOBS);

        BiomeDefaultFeatures.addDefaultCarversAndLakes(biomeBuilder);
        BiomeDefaultFeatures.addDefaultCrystalFormations(biomeBuilder);
        BiomeDefaultFeatures.addDefaultMonsterRoom(biomeBuilder);

        BiomeDefaultFeatures.addDefaultSprings(biomeBuilder);
        BiomeDefaultFeatures.addSurfaceFreezing(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder, true);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.LARGE_CLEAR_QUARTZ_VEIN);
        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.CLEAR_QUARTZ_SHARD);





        return biome(true, 0.0F, 0.4F, spawnBuilder, biomeBuilder, CAVE_LUSH_MUSIC);
    }


    private static Biome tundra(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder();

        spawnBuilder.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.WOLF, 4, 2, 4));


        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);
        BiomeDefaultFeatures.snowySpawns(spawnBuilder);

        globalOverworldGeneration(biomeBuilder);

        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);


        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.PATCH_TUNDRA_GRASS);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.STONY_ROCK);


        BiomeDefaultFeatures.addDefaultMushrooms(biomeBuilder);


        return biome(false, -1.0F, 0.5F,
                4159204,
                329011,
                0xeac466,
                0xa5bc6c,
                spawnBuilder, biomeBuilder, MOUNTAIN_MUSIC);
    }





    public static Biome underwaterForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder mobspawnsettings$builder = new MobSpawnSettings.Builder()
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.PUFFERFISH, 15, 1, 3))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.AXOLOTL, 4, 1, 2))
                .addSpawn(MobCategory.WATER_AMBIENT, new MobSpawnSettings.SpawnerData(EntityType.GLOW_SQUID, 10, 2, 5));
        BiomeDefaultFeatures.warmOceanSpawns(mobspawnsettings$builder, 20, 2);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);



        biomeBuilder
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.WARM_OCEAN_VEGETATION)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEAGRASS_WARM)
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, AquaticPlacements.SEA_PICKLE);

        biomeBuilder.addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.SEAWOOD_TREE);

        biomeBuilder.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, MtaPlacedFeatures.FREQUENT_CLAY);


        return baseOcean(mobspawnsettings$builder, 4445678, 270131, biomeBuilder);
    }



    public static Biome mapleForest(HolderGetter<PlacedFeature> placedFeatures, HolderGetter<ConfiguredWorldCarver<?>> worldCarvers) {
        MobSpawnSettings.Builder spawnBuilder = new MobSpawnSettings.Builder()
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.BUTTERFLY.get(), 15, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.DEER.get(), 15, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.OWL.get(), 15, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.RACCOON.get(), 15, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.TURKEY.get(), 15, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(MtaEntityTypes.WISPFLY.get(), 15, 1, 3))
                .addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(EntityType.FOX, 15, 1, 3))

                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.FALLEN_SAMURAI.get(), 15, 1, 3))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.GLOW_SPIDER.get(), 15, 1, 3))
                .addSpawn(MobCategory.MONSTER, new MobSpawnSettings.SpawnerData(MtaEntityTypes.SKELETON_FIGHTER.get(), 15, 1, 3));


        BiomeDefaultFeatures.commonSpawns(spawnBuilder, 20);

        BiomeGenerationSettings.Builder biomeBuilder =
                new BiomeGenerationSettings.Builder(placedFeatures,worldCarvers);

        globalOverworldGeneration(biomeBuilder);
        BiomeDefaultFeatures.addOtherBirchTrees(biomeBuilder);

        BiomeDefaultFeatures.addDefaultFlowers(biomeBuilder);
        BiomeDefaultFeatures.addForestGrass(biomeBuilder);
        BiomeDefaultFeatures.addDefaultOres(biomeBuilder);
        BiomeDefaultFeatures.addDefaultSoftDisks(biomeBuilder);



        biomeBuilder
                .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, MtaPlacedFeatures.MAPLE_TREE);


        return biome(true, 0.2F, 0.8F,
                0x79a6ff,
                0xc0d8ff,
                0x79c05a,
                0xdbb435,
                spawnBuilder, biomeBuilder, FOREST_MUSIC);
    }


    private static void registerVillagerTypes() {
        registerVillagers(LUSH_MEADOW, VillagerType.PLAINS);
        registerVillagers(LUSH_RIVER, VillagerType.PLAINS);
        registerVillagers(GRAVELLY_RIVER, VillagerType.PLAINS);
        registerVillagers(SPARSE_TAIGA, VillagerType.TAIGA);
        registerVillagers(SPARSE_CHERRY_GROVE, VillagerType.PLAINS);
        registerVillagers(OASIS, VillagerType.DESERT);
        registerVillagers(TUNDRA, VillagerType.SNOW);
        registerVillagers(MAPLE_FOREST, VillagerType.PLAINS);
        registerVillagers(ALPINE_TUNDRA, VillagerType.SNOW);
        registerVillagers(BOG, VillagerType.SWAMP);



    }
    private static void register(BootstrapContext<Biome> context, ResourceKey<Biome> key, Biome biome) {
        context.register(key, biome);
        if (!BIOMES.contains(key)){
            BIOMES.add(key);
        }
    }

    private static void registerVillagers(ResourceKey<Biome> key, VillagerType type) {
        VillagerType.BY_BIOME.put(key, type);
    }


    protected static int calculateSkyColor(float pTemperature) {
        float $$1 = pTemperature / 3.0F;
        $$1 = Mth.clamp($$1, -1.0F, 1.0F);
        return Mth.hsvToRgb(0.62222224F - $$1 * 0.05F, 0.5F + $$1 * 0.1F, 1.0F);
    }

    private static Biome biome(
            boolean pHasPercipitation,
            float pTemperature,
            float pDownfall,
            MobSpawnSettings.Builder pMobSpawnSettings,
            BiomeGenerationSettings.Builder pGenerationSettings,
            @Nullable Music pBackgroundMusic
    ) {
        return biome(pHasPercipitation, pTemperature, pDownfall, 4159204, 329011, null, null, pMobSpawnSettings, pGenerationSettings, pBackgroundMusic);
    }

    private static Biome biome(
            boolean pHasPrecipitation,
            float pTemperature,
            float pDownfall,
            int pWaterColor,
            int pWaterFogColor,
            @Nullable Integer pGrassColorOverride,
            @Nullable Integer pFoliageColorOverride,
            MobSpawnSettings.Builder pMobSpawnSettings,
            BiomeGenerationSettings.Builder pGenerationSettings,
            @Nullable Music pBackgroundMusic
    ) {
        BiomeSpecialEffects.Builder biomespecialeffects$builder = new BiomeSpecialEffects.Builder()
                .waterColor(pWaterColor)
                .waterFogColor(pWaterFogColor)
                .fogColor(12638463)
                .skyColor(calculateSkyColor(pTemperature))
                .ambientMoodSound(AmbientMoodSettings.LEGACY_CAVE_SETTINGS)
                .backgroundMusic(pBackgroundMusic);
        if (pGrassColorOverride != null) {
            biomespecialeffects$builder.grassColorOverride(pGrassColorOverride);
        }

        if (pFoliageColorOverride != null) {
            biomespecialeffects$builder.foliageColorOverride(pFoliageColorOverride);
        }

        return new Biome.BiomeBuilder()
                .hasPrecipitation(pHasPrecipitation)
                .temperature(pTemperature)
                .downfall(pDownfall)
                .specialEffects(biomespecialeffects$builder.build())
                .mobSpawnSettings(pMobSpawnSettings.build())
                .generationSettings(pGenerationSettings.build())
                .build();
    }


    private static Biome baseOcean(MobSpawnSettings.Builder mobSpawnSettings, int waterColor, int waterFogColor, BiomeGenerationSettings.Builder generationSettings) {
        return biome(true, 0.5F, 0.5F, waterColor, waterFogColor, null, null, mobSpawnSettings, generationSettings, NORMAL_MUSIC);
    }



    private static BiomeGenerationSettings.Builder baseOceanGeneration(BiomeGenerationSettings.Builder builder) {
        globalOverworldGeneration(builder);
        BiomeDefaultFeatures.addDefaultOres(builder);
        BiomeDefaultFeatures.addDefaultSoftDisks(builder);
        BiomeDefaultFeatures.addWaterTrees(builder);
        BiomeDefaultFeatures.addDefaultFlowers(builder);
        BiomeDefaultFeatures.addDefaultGrass(builder);
        BiomeDefaultFeatures.addDefaultMushrooms(builder);
        BiomeDefaultFeatures.addDefaultExtraVegetation(builder);
        return builder;
    }

}



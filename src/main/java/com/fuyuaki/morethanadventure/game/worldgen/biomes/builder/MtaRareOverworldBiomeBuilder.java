package com.fuyuaki.morethanadventure.game.worldgen.biomes.builder;

import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import com.fuyuaki.morethanadventure.world.level.biome.MtaBiomeList;
import com.fuyuaki.morethanadventure.world.level.biome.MtaRareBiomeList;
import com.fuyuaki.morethanadventure.world.level.biome.VanillaBiomeList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;

import java.util.function.Consumer;

public class MtaRareOverworldBiomeBuilder {
    private static final float VALLEY_SIZE = 0.05F;
    private static final float LOW_START = 0.26666668F;
    public static final float HIGH_START = 0.4F;
    private static final float HIGH_END = 0.93333334F;
    private static final float PEAK_SIZE = 0.1F;
    public static final float PEAK_START = 0.56666666F;
    private static final float PEAK_END = 0.7666667F;
    public static final float NEAR_INLAND_START = -0.11F;
    public static final float MID_INLAND_START = 0.03F;
    public static final float FAR_INLAND_START = 0.3F;
    public static final float EROSION_INDEX_1_START = -0.78F;
    public static final float EROSION_INDEX_2_START = -0.375F;

    protected final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    protected final Climate.Parameter[] temperatures = new Climate.Parameter[]{
            Climate.Parameter.span(-1.0F, -0.45F),
            Climate.Parameter.span(-0.45F, -0.15F),
            Climate.Parameter.span(-0.15F, 0.2F),
            Climate.Parameter.span(0.2F, 0.55F),
            Climate.Parameter.span(0.55F, 1.0F)
    };

    protected final Climate.Parameter[] humidities = new Climate.Parameter[]{
            Climate.Parameter.span(-1.0F, -0.35F),
            Climate.Parameter.span(-0.35F, -0.1F),
            Climate.Parameter.span(-0.1F, 0.1F),
            Climate.Parameter.span(0.1F, 0.3F),
            Climate.Parameter.span(0.3F, 1.0F)
    };

    protected final Climate.Parameter[] erosions = new Climate.Parameter[]{
            Climate.Parameter.span(-1.0F, -0.78F),
            Climate.Parameter.span(-0.78F, -0.375F),
            Climate.Parameter.span(-0.375F, -0.2225F),
            Climate.Parameter.span(-0.2225F, 0.05F),
            Climate.Parameter.span(0.05F, 0.45F),
            Climate.Parameter.span(0.45F, 0.55F),
            Climate.Parameter.span(0.55F, 1.0F)
    };

    protected static final Climate.Parameter COMMON_RARENESS_RANGE = Climate.Parameter.span(-1.0F, 0.35F);
    protected static final Climate.Parameter RARE_RARENESS_RANGE = Climate.Parameter.span(0.35F, 1.0F);

    protected final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
    protected final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
    protected final Climate.Parameter islandContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    protected final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
    protected final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
    protected final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
    protected final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    protected final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
    protected final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    protected final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);


    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addOffCoastBiomes(mapper);
        this.addInlandBiomes(mapper);
        this.addUndergroundBiomes(mapper);


    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> islandBiomeMTA = this.pickIslandBiomeMTA(i, j);

                this.addSurfaceBiome(mapper, temperature, humidity, this.islandContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, islandBiomeMTA);
            }

            this.addSurfaceBiome(mapper, temperature, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, pickOceanBiomes(0,i));
            this.addSurfaceBiome(mapper, temperature, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, pickOceanBiomes(1,i));
        }
    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        /*
            Weirdness ranges map to specific slices in a repeating triangle wave fashion.
                   PEAKS                           PEAKS
               HIGH     HIGH                   HIGH     HIGH
            MID             MID             MID             MID
                               LOW       LOW
                                  VALLEYS
         */

        // First cycle
        this.addMidSlice(mapper, Climate.Parameter.span(-1.0F, -0.93333334F));
        this.addHighSlice(mapper, Climate.Parameter.span(-0.93333334F, -0.7666667F));
        this.addPeaks(mapper, Climate.Parameter.span(-0.7666667F, -0.56666666F));
        this.addHighSlice(mapper, Climate.Parameter.span(-0.56666666F, -0.4F));
        this.addMidSlice(mapper, Climate.Parameter.span(-0.4F, -0.26666668F));
        this.addLowSlice(mapper, Climate.Parameter.span(-0.26666668F, -0.05F));
        this.addValleys(mapper, Climate.Parameter.span(-0.05F, 0.05F));
        this.addLowSlice(mapper, Climate.Parameter.span(0.05F, 0.26666668F));
        this.addMidSlice(mapper, Climate.Parameter.span(0.26666668F, 0.4F));

        // Second cycle is truncated
        this.addHighSlice(mapper, Climate.Parameter.span(0.4F, 0.56666666F));
        this.addPeaks(mapper, Climate.Parameter.span(0.56666666F, 0.7666667F));
        this.addHighSlice(mapper, Climate.Parameter.span(0.7666667F, 0.93333334F));
        this.addMidSlice(mapper, Climate.Parameter.span(0.93333334F, 1.0F));
    }


    protected void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, Climate.Parameter weirdness) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];

                ResourceKey<Biome> middleBiomeMTA = this.pickMiddleBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> middleBadlandsOrSlopeBiomeMTA = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfColdMTA(i, j, weirdness);

                ResourceKey<Biome> plateauBiomeMTA = this.pickPlateauBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> extremeHillsBiome = this.pickExtremeHillsBiomeVanilla(i, j, weirdness);
                ResourceKey<Biome> extremeHillsBiomeMTA = this.pickExtremeHillsBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> shatteredBiome = this.maybePickShatteredBiome(i, j, weirdness, extremeHillsBiome);
                ResourceKey<Biome> peakBiomeMTA = this.pickPeakBiomeMTA(i, j, weirdness);

                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, peakBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], weirdness, 0.0F, middleBadlandsOrSlopeBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, peakBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, plateauBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, plateauBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, shatteredBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, extremeHillsBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, middleBiomeMTA);
            }
        }

    }

    protected void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, Climate.Parameter weirdness) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];

                ResourceKey<Biome> middleBiomeVanilla = this.pickMiddleBiomeVanilla(i, j, weirdness);
                ResourceKey<Biome> middleBiomeMTA = this.pickMiddleBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> middleBadlandsOrSlopeBiomeMTA = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfColdMTA(i, j, weirdness);

                ResourceKey<Biome> plateauBiomeMTA = this.pickPlateauBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> extremeHillsBiomeMTA = this.pickExtremeHillsBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> shatteredBiome = this.maybePickShatteredBiome(i, j, weirdness, middleBiomeVanilla);
                ResourceKey<Biome> slopeBiomeMTA = this.pickSlopeBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> peakBiomeMTA = this.pickPeakBiomeMTA(i, j, weirdness);

                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, this.erosions[0], weirdness, 0.0F, slopeBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, peakBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, this.erosions[1], weirdness, 0.0F, middleBadlandsOrSlopeBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], weirdness, 0.0F, slopeBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], weirdness, 0.0F, plateauBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.midInlandContinentalness, this.erosions[3], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.farInlandContinentalness, this.erosions[3], weirdness, 0.0F, plateauBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], weirdness, 0.0F, shatteredBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, extremeHillsBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, middleBiomeMTA);
            }
        }

    }

    protected void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, Climate.Parameter weirdness) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];

                ResourceKey<Biome> middleBiomeVanilla = this.pickMiddleBiomeVanilla(i, j, weirdness);
                ResourceKey<Biome> middleBiomeMTA = this.pickMiddleBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> middleBadlandsOrSlopeBiomeMTA = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfColdMTA(i, j, weirdness);

                ResourceKey<Biome> extremeHillsBiomeMTA = this.pickExtremeHillsBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> plateauBiomeMTA = this.pickPlateauBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> beachBiomeMTA = this.pickBeachBiomeMTA(i, j);
                ResourceKey<Biome> stonyShoresBiomeMTA = this.pickStonyShoresBiomeMTA(i, j);
                ResourceKey<Biome> shatteredBiome = this.maybePickShatteredBiome(i, j, weirdness, middleBiomeVanilla);
                ResourceKey<Biome> shatteredCoastBiome = this.pickShatteredCoastBiome(i, j, weirdness);
                ResourceKey<Biome> slopeBiomeMTA = this.pickSlopeBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> swampBiomeMTA = this.pickSwampBiomeMTA(i, j, weirdness);

                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, stonyShoresBiomeMTA);

                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], weirdness, 0.0F, slopeBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], weirdness, 0.0F, middleBadlandsOrSlopeBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.farInlandContinentalness, this.erosions[1], weirdness, 0.0F, i == 0 ? slopeBiomeMTA : plateauBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, this.erosions[2], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.midInlandContinentalness, this.erosions[2], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.farInlandContinentalness, this.erosions[2], weirdness, 0.0F, plateauBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], weirdness, 0.0F, middleBiomeMTA);

                if (weirdness.max() < 0L) {
                    this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[4], weirdness, 0.0F, beachBiomeMTA);
                    this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiomeMTA);
                } else {
                    this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiomeMTA);
                }

                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, shatteredCoastBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, shatteredBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, extremeHillsBiomeMTA);
                if (weirdness.max() < 0L) {
                    this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, beachBiomeMTA);
                } else {
                    this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, middleBiomeMTA);
                }

                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, swampBiomeMTA);
            }
        }

    }

    protected void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, Climate.Parameter weirdness) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];

                ResourceKey<Biome> middleBiomeVanilla = this.pickMiddleBiomeVanilla(i, j, weirdness);
                ResourceKey<Biome> middleBiomeMTA = this.pickMiddleBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> middleBadlandsOrSlopeBiomeMTA = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfColdMTA(i, j, weirdness);

                ResourceKey<Biome> beachBiome = this.pickBeachBiomeMTA(i, j);
                ResourceKey<Biome> stonyShoresBiomeMTA = this.pickStonyShoresBiomeMTA(i, j);
                ResourceKey<Biome> shatteredBiome = this.maybePickShatteredBiome(i, j, weirdness, middleBiomeVanilla);
                ResourceKey<Biome> shatteredCoastBiome = this.pickShatteredCoastBiome(i, j, weirdness);

                ResourceKey<Biome> swampBiomeMTA = this.pickSwampBiomeMTA(i, j, weirdness);

                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), weirdness, 0.0F, stonyShoresBiomeMTA);

                // Lowest to low erosion
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBadlandsOrSlopeBiomeMTA);

                // Reduced to moderate erosion
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), weirdness, 0.0F, middleBiomeMTA);

                // Moderate to increased erosion
                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), weirdness, 0.0F, beachBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], weirdness, 0.0F, middleBiomeMTA);

                // High erosion
                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[5], weirdness, 0.0F, shatteredCoastBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], weirdness, 0.0F, shatteredBiome);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], weirdness, 0.0F, middleBiomeMTA);

                // Highest erosion
                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, beachBiome);

                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, swampBiomeMTA);
            }
        }

    }

    protected void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper, Climate.Parameter weirdness) {
        // MTA River biomes
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> riverBiomeMTA = this.pickRiverBiomeMTA(i, j);
                ResourceKey<Biome> stonyShoresBiomeMTA = this.pickStonyShoresBiomeMTA(i, j);

                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, weirdness.max() < 0L ? stonyShoresBiomeMTA : riverBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, riverBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), weirdness, 0.0F, riverBiomeMTA);
                this.addSurfaceBiome(mapper, temperature, humidity, this.coastContinentalness, this.erosions[6], weirdness, 0.0F, riverBiomeMTA);
            }
        }

        // MTA Swamp biomes
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];

            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> middleBiomeMTA = this.pickMiddleBiomeMTA(i, j, weirdness);
                ResourceKey<Biome> swampBiomeMTA = this.pickSwampBiomeMTA(i, j, weirdness);

                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), weirdness, 0.0F, middleBiomeMTA);

                this.addSurfaceBiome(mapper, temperature, humidity, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], weirdness, 0.0F, swampBiomeMTA);
            }
        }
    }


    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, point(0.0F), weirdness, offset), biome));
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, point(1.0F), weirdness, offset), biome));
    }

    private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.24F, 0.9F), weirdness, offset), biome));
    }

    private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> builder, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
        builder.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.1F), weirdness, offset), biome));
    }

    private Climate.Parameter point(float point) {
        return Climate.Parameter.point(point);
    }

    private Climate.Parameter span(float min, float max) {
        return Climate.Parameter.span(min, max);
    }

    private Climate.Parameter span(Climate.Parameter min, Climate.Parameter max) {
        return Climate.Parameter.span(min, max);
    }


    @SafeVarargs
    public static ResourceKey<Biome> biomeOrFallback(ResourceKey<Biome>... biomes) {
        for (ResourceKey<Biome> key : biomes) {
            if (key == null)
                continue;


            return key;
        }

        throw new RuntimeException("Failed to find fallback for biome!");
    }


    protected void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addUndergroundBiome(
                mapper, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES
        );
        this.addUndergroundBiome(
                mapper, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.LUSH_CAVES
        );
        this.addBottomBiome(
                mapper,
                this.FULL_RANGE,
                this.FULL_RANGE,
                this.FULL_RANGE,
                Climate.Parameter.span(this.erosions[0], this.erosions[1]),
                this.FULL_RANGE,
                0.0F,
                Biomes.DEEP_DARK
        );

        this.addUndergroundBiome(
                mapper,
                temperatures[2],
                this.FULL_RANGE,
                span(coastContinentalness,farInlandContinentalness),
                span(erosions[1],erosions[4]),
                this.FULL_RANGE,
                0.0F,
                MtaBiomes.CRYSTALLINE_GROTTO

                );

    }

    protected ResourceKey<Biome> pickMiddleBiomeVanilla(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        if (weirdness.max() < 0L) {
            return VanillaBiomeList.MIDDLE_BIOMES[temperatureIndex][humidityIndex];
        } else {
            ResourceKey<Biome> variantBiome = VanillaBiomeList.MIDDLE_BIOMES_VARIANT[temperatureIndex][humidityIndex];
            return variantBiome == null ? VanillaBiomeList.MIDDLE_BIOMES[temperatureIndex][humidityIndex] : variantBiome;
        }
    }

    protected ResourceKey<Biome> pickMiddleBiomeMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        ResourceKey<Biome> middleBiome = biomeOrFallback(MtaRareBiomeList.MTA_MIDDLE_BIOMES[temperatureIndex][humidityIndex],MtaBiomeList.MTA_MIDDLE_BIOMES[temperatureIndex][humidityIndex], VanillaBiomeList.MIDDLE_BIOMES[temperatureIndex][humidityIndex]);

        if (weirdness.max() < 0) return middleBiome;
        else {
            return biomeOrFallback(MtaRareBiomeList.MTA_MIDDLE_BIOMES_VARIANT[temperatureIndex][humidityIndex],MtaBiomeList.MTA_MIDDLE_BIOMES_VARIANT[temperatureIndex][humidityIndex], middleBiome);
        }
    }

    protected ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfColdMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        return temperatureIndex == 0 ? this.pickSlopeBiomeMTA(temperatureIndex, humidityIndex, weirdness) : this.pickMiddleBiomeMTA(temperatureIndex, humidityIndex, weirdness);
    }

    protected ResourceKey<Biome> maybePickShatteredBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness, ResourceKey<Biome> extremeHillsBiome) {
        return temperatureIndex > 1 && humidityIndex < 4 && weirdness.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : extremeHillsBiome;
    }

    protected ResourceKey<Biome> pickShatteredCoastBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        ResourceKey<Biome> resourcekey = weirdness.max() >= 0L ? this.pickMiddleBiomeVanilla(temperatureIndex, humidityIndex, weirdness) : this.pickBeachBiomeMTA(temperatureIndex, humidityIndex);
        return this.maybePickShatteredBiome(temperatureIndex, humidityIndex, weirdness, resourcekey);
    }

    protected ResourceKey<Biome> pickSwampBiomeVanilla(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        ResourceKey<Biome> resourcekey = VanillaBiomeList.SWAMP_BIOMES[temperatureIndex][humidityIndex];
        return resourcekey == null ? this.pickMiddleBiomeVanilla(temperatureIndex, humidityIndex, weirdness) : resourcekey;
    }

    protected ResourceKey<Biome> pickSwampBiomeMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        return biomeOrFallback(MtaRareBiomeList.MTA_SWAMP_BIOMES[temperatureIndex][humidityIndex],MtaBiomeList.MTA_SWAMP_BIOMES[temperatureIndex][humidityIndex], this.pickSwampBiomeVanilla(temperatureIndex, humidityIndex, weirdness));
    }

    protected ResourceKey<Biome> pickRiverBiomeMTA(int temperatureIndex, int humidityIndex) {
        return biomeOrFallback(MtaRareBiomeList.MTA_RIVER_BIOMES[temperatureIndex][humidityIndex], MtaBiomeList.MTA_RIVER_BIOMES[temperatureIndex][humidityIndex], temperatureIndex == 0 ? Biomes.FROZEN_RIVER : Biomes.RIVER);
    }

    protected ResourceKey<Biome> pickBeachBiomeMTA(int temperatureIndex, int humidityIndex) {
        return biomeOrFallback(MtaRareBiomeList.MTA_BEACH_BIOMES[temperatureIndex][humidityIndex],MtaBiomeList.MTA_BEACH_BIOMES[temperatureIndex][humidityIndex], VanillaBiomeList.BEACH_BIOMES[temperatureIndex][humidityIndex]);
    }

    protected ResourceKey<Biome> pickStonyShoresBiomeMTA(int temperatureIndex, int humidityIndex) {
        return biomeOrFallback(MtaRareBiomeList.MTA_STONY_SHORES_BIOMES[temperatureIndex][humidityIndex],MtaBiomeList.MTA_STONY_SHORES_BIOMES[temperatureIndex][humidityIndex], Biomes.STONY_SHORE);
    }

    protected ResourceKey<Biome> pickIslandBiomeMTA(int temperatureIndex, int humidityIndex) {
        return biomeOrFallback(MtaRareBiomeList.MTA_ISLAND_BIOMES[temperatureIndex][humidityIndex],MtaBiomeList.MTA_ISLAND_BIOMES[temperatureIndex][humidityIndex], Biomes.MUSHROOM_FIELDS);
    }

    protected ResourceKey<Biome> pickBadlandsBiome(int humidityIndex, Climate.Parameter weirdness) {
        if (humidityIndex < 2) {
            return weirdness.max() < 0L ? Biomes.ERODED_BADLANDS : Biomes.BADLANDS;
        } else {
            return humidityIndex < 3 ? Biomes.BADLANDS : Biomes.WOODED_BADLANDS;
        }
    }

    protected ResourceKey<Biome> pickPlateauBiomeMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        if (weirdness.max() < 0L)
            return biomeOrFallback(MtaRareBiomeList.MTA_PLATEAU_BIOMES[temperatureIndex][humidityIndex], MtaBiomeList.MTA_PLATEAU_BIOMES[temperatureIndex][humidityIndex], VanillaBiomeList.PLATEAU_BIOMES[temperatureIndex][humidityIndex]);
        else
            return biomeOrFallback(MtaRareBiomeList.MTA_PLATEAU_BIOMES_VARIANT[temperatureIndex][humidityIndex], MtaBiomeList.MTA_PLATEAU_BIOMES_VARIANT[temperatureIndex][humidityIndex], MtaBiomeList.MTA_PLATEAU_BIOMES[temperatureIndex][humidityIndex], VanillaBiomeList.PLATEAU_BIOMES_VARIANT[temperatureIndex][humidityIndex], VanillaBiomeList.PLATEAU_BIOMES[temperatureIndex][humidityIndex]);
    }

    protected ResourceKey<Biome> pickPeakBiome(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        if (temperatureIndex <= 2) {
            return weirdness.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
        } else {
            return temperatureIndex == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(humidityIndex, weirdness);
        }
    }

    protected ResourceKey<Biome> pickPeakBiomeMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        return biomeOrFallback(MtaRareBiomeList.MTA_PEAK_BIOMES[temperatureIndex][humidityIndex], MtaBiomeList.MTA_PEAK_BIOMES[temperatureIndex][humidityIndex], this.pickPeakBiome(temperatureIndex, humidityIndex, weirdness));
    }

    protected ResourceKey<Biome> pickSlopeBiomeMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        return biomeOrFallback(MtaRareBiomeList.MTA_SLOPE_BIOMES[temperatureIndex][humidityIndex], MtaBiomeList.MTA_SLOPE_BIOMES[temperatureIndex][humidityIndex], this.pickPlateauBiomeMTA(temperatureIndex, humidityIndex, weirdness));
    }

    protected ResourceKey<Biome> pickExtremeHillsBiomeVanilla(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        ResourceKey<Biome> resourcekey = VanillaBiomeList.EXTREME_HILLS_BIOMES[temperatureIndex][humidityIndex];
        return resourcekey == null ? this.pickMiddleBiomeVanilla(temperatureIndex, humidityIndex, weirdness) : resourcekey;
    }

    protected ResourceKey<Biome> pickExtremeHillsBiomeMTA(int temperatureIndex, int humidityIndex, Climate.Parameter weirdness) {
        return biomeOrFallback(MtaRareBiomeList.MTA_EXTREME_HILLS_BIOMES[temperatureIndex][humidityIndex], MtaBiomeList.MTA_EXTREME_HILLS_BIOMES[temperatureIndex][humidityIndex], this.pickExtremeHillsBiomeVanilla(temperatureIndex, humidityIndex, weirdness), VanillaBiomeList.PLATEAU_BIOMES[temperatureIndex][humidityIndex]);
    }

    protected ResourceKey<Biome> pickOceanBiomes(int temperatureIndex, int humidityIndex) {

        return biomeOrFallback(MtaRareBiomeList.MTA_OCEANS[temperatureIndex][humidityIndex],MtaBiomeList.MTA_OCEANS[temperatureIndex][humidityIndex],VanillaBiomeList.OCEANS[temperatureIndex][humidityIndex]);

    }
}

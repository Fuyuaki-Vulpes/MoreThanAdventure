package com.fuyuaki.morethanadventure.world.level.biome;

import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class MtaRareBiomeList {
    /*
    BIOME LIST GOES:
    ResourceKey[temperature][humidity]

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






     */


    public static final ResourceKey<Biome>[][] MTA_MIDDLE_BIOMES = new ResourceKey[][]{
            {MtaBiomes.POLAR_DESERT, MtaBiomes.POLAR_DESERT, MtaBiomes.POLAR_DESERT, MtaBiomes.POLAR_DESERT, MtaBiomes.POLAR_DESERT},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_PLATEAU_BIOMES = new ResourceKey[][]{
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {MtaBiomes.CAATINGA,            MtaBiomes.CAATINGA,            null,                          null,         null}
    };

    public static final ResourceKey<Biome>[][] MTA_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null}
    };

    public static final ResourceKey<Biome>[][] MTA_SLOPE_BIOMES = new ResourceKey[][]{
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {MtaBiomes.CAATINGA,            null,                          null,                          null,         null}
    };

    public static final ResourceKey<Biome>[][] MTA_PEAK_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_EXTREME_HILLS_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {MtaBiomes.CAATINGA, MtaBiomes.CAATINGA, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_SWAMP_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_RIVER_BIOMES = new ResourceKey[][]{
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null}
    };

    public static final ResourceKey<Biome>[][] MTA_BEACH_BIOMES = new ResourceKey[][]{
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null}
    };

    public static final ResourceKey<Biome>[][] MTA_STONY_SHORES_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_ISLAND_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_OCEANS = new ResourceKey[][]{
            {null,                          null,                          null,                          null,         null},
            {null,                          null,                          null,                          null,         null}
    };




}

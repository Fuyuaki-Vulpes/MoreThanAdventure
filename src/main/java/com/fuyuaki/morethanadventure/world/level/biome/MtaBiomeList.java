package com.fuyuaki.morethanadventure.world.level.biome;

import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class MtaBiomeList {
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
            {MtaBiomes.TUNDRA, MtaBiomes.TUNDRA, null, null, MtaBiomes.SPARSE_TAIGA},
            {null, null, MtaBiomes.MAPLE_FOREST, MtaBiomes.SPARSE_TAIGA, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, MtaBiomes.OASIS}
    };

    public static final ResourceKey<Biome>[][] MTA_MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, MtaBiomes.MAPLE_FOREST, MtaBiomes.SPARSE_TAIGA, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, MtaBiomes.OASIS, MtaBiomes.OASIS, null}
    };

    public static final ResourceKey<Biome>[][] MTA_PLATEAU_BIOMES = new ResourceKey[][]{
            {MtaBiomes.TUNDRA, null, null, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.ALPINE_TUNDRA},
            {null, null, MtaBiomes.LUSH_MEADOW, null, null},
            {null, null, null, MtaBiomes.LUSH_MEADOW, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {null,                          null,        MtaBiomes.MAPLE_FOREST,                          null,         null},
            {null, MtaBiomes.SPARSE_CHERRY_GROVE, MtaBiomes.SPARSE_CHERRY_GROVE,        MtaBiomes.SPARSE_TAIGA,         null},
            {null,                          null,         MtaBiomes.LUSH_MEADOW, MtaBiomes.SPARSE_CHERRY_GROVE,         null},
            {null,                          null,                          null,         MtaBiomes.LUSH_MEADOW,         null},
            {null,                          null,                          null,                          null,         null}
    };

    public static final ResourceKey<Biome>[][] MTA_SLOPE_BIOMES = new ResourceKey[][]{
            {null, null, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.ALPINE_TUNDRA},
            {null, null, null, MtaBiomes.ALPINE_TUNDRA, MtaBiomes.ALPINE_TUNDRA},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null}
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
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_SWAMP_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, MtaBiomes.BOG, null, null, null},
            {null, null, null, null, null}
    };

    public static final ResourceKey<Biome>[][] MTA_RIVER_BIOMES = new ResourceKey[][]{
            {null, null, MtaBiomes.GRAVELLY_RIVER, null, null},
            {MtaBiomes.GRAVELLY_RIVER, null, null, null, null},
            {MtaBiomes.GRAVELLY_RIVER,null, null, null, null},
            {null, null, null, null, MtaBiomes.LUSH_RIVER},
            {null, null, null, null, MtaBiomes.LUSH_RIVER}
    };

    public static final ResourceKey<Biome>[][] MTA_BEACH_BIOMES = new ResourceKey[][]{
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, null, null},
            {null, null, null, MtaBiomes.OASIS, MtaBiomes.OASIS}
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
            {null, null ,null, null, MtaBiomes.UNDERWATER_FOREST},
            {null, null, null, null, null}
    };




}

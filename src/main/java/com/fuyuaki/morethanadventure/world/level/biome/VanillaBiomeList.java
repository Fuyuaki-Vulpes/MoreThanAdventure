package com.fuyuaki.morethanadventure.world.level.biome;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

public class VanillaBiomeList {

    public static final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{
            {Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN},
            {Biomes.FROZEN_OCEAN,      Biomes.COLD_OCEAN,      Biomes.OCEAN,      Biomes.LUKEWARM_OCEAN,      Biomes.WARM_OCEAN}
    };

    public static final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS,  Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA,  Biomes.TAIGA},
            {Biomes.PLAINS,        Biomes.PLAINS,       Biomes.FOREST,       Biomes.TAIGA,        Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.FLOWER_FOREST, Biomes.PLAINS,       Biomes.FOREST,       Biomes.BIRCH_FOREST, Biomes.DARK_FOREST},
            {Biomes.SAVANNA,       Biomes.SAVANNA,      Biomes.FOREST,       Biomes.JUNGLE,       Biomes.JUNGLE},
            {Biomes.DESERT,        Biomes.DESERT,       Biomes.DESERT,       Biomes.DESERT,       Biomes.DESERT}
    };

    public static final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES,       null, Biomes.SNOWY_TAIGA, null,                           null},
            {null,                    null, null,               null,                           Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.SUNFLOWER_PLAINS, null, null,               Biomes.OLD_GROWTH_BIRCH_FOREST, null},
            {null,                    null, Biomes.PLAINS,      Biomes.SPARSE_JUNGLE,           Biomes.BAMBOO_JUNGLE},
            {null,                    null, null,               null,                           null}
    };

    public static final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_PLAINS,    Biomes.SNOWY_PLAINS,    Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA,     Biomes.SNOWY_TAIGA},
            {Biomes.MEADOW,          Biomes.MEADOW,          Biomes.FOREST,       Biomes.TAIGA,           Biomes.OLD_GROWTH_SPRUCE_TAIGA},
            {Biomes.MEADOW,          Biomes.MEADOW,          Biomes.MEADOW,       Biomes.MEADOW,          Biomes.DARK_FOREST},
            {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST,       Biomes.FOREST,          Biomes.JUNGLE},
            {Biomes.BADLANDS,        Biomes.BADLANDS,        Biomes.BADLANDS,     Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}
    };

    public static final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{
            {Biomes.ICE_SPIKES,      null,                   null,          null,                null},
            {Biomes.CHERRY_GROVE,    null,                   Biomes.MEADOW, Biomes.MEADOW,       Biomes.OLD_GROWTH_PINE_TAIGA},
            {Biomes.CHERRY_GROVE,    Biomes.CHERRY_GROVE,    Biomes.FOREST, Biomes.BIRCH_FOREST, null},
            {null,                   null,                   null,          null,                null},
            {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, null,          null,                null}
    };

    public static final ResourceKey<Biome>[][] EXTREME_HILLS_BIOMES = new ResourceKey[][]{
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {Biomes.WINDSWEPT_HILLS,          Biomes.WINDSWEPT_HILLS,          Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST},
            {null,                            null,                            null,                   null,                    null},
            {null,                            null,                            null,                   null,                    null}
    };

    public static final ResourceKey<Biome>[][] SWAMP_BIOMES = new ResourceKey[][]{
            {Biomes.FROZEN_RIVER,   Biomes.FROZEN_RIVER,   Biomes.FROZEN_RIVER,   Biomes.FROZEN_RIVER,   Biomes.FROZEN_RIVER},
            {Biomes.SWAMP,          Biomes.SWAMP,          Biomes.SWAMP,          Biomes.SWAMP,          Biomes.SWAMP},
            {Biomes.SWAMP,          Biomes.SWAMP,          Biomes.SWAMP,          Biomes.SWAMP,          Biomes.SWAMP},
            {Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP},
            {Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP, Biomes.MANGROVE_SWAMP}
    };

    public static final ResourceKey<Biome>[][] BEACH_BIOMES = new ResourceKey[][]{
            {Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH, Biomes.SNOWY_BEACH},
            {Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH},
            {Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH},
            {Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH,       Biomes.BEACH},
            {Biomes.DESERT,      Biomes.DESERT,      Biomes.DESERT,      Biomes.DESERT,      Biomes.DESERT}
    };


}

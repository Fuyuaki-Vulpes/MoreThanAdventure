package com.fuyuvulpes.morethanadventure.world.level.feature.feature;

import com.fuyuvulpes.morethanadventure.world.level.feature.configuration.OreVeinConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;

public class OreVeinFeature extends Feature<OreVeinConfiguration> {
    public OreVeinFeature(Codec<OreVeinConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreVeinConfiguration> pContext) {
        RandomSource randomsource = pContext.random();
        BlockPos blockpos = pContext.origin();
        WorldGenLevel worldgenlevel = pContext.level();
        OreVeinConfiguration config = pContext.config();
        return false;
    }
}

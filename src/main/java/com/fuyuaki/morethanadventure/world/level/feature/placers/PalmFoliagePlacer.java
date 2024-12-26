package com.fuyuaki.morethanadventure.world.level.feature.placers;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAPlacers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            p_68380_ -> foliagePlacerParts(p_68380_).apply(p_68380_, PalmFoliagePlacer::new)
    );
    private float hangingLeavesChance = 0.4F;
    private float hangingLeavesExtensionChance = 0.85F;

    public PalmFoliagePlacer(IntProvider pRadius, IntProvider pOffset) {
        super(pRadius, pOffset);
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return MTAPlacers.PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        boolean flag = pAttachment.doubleTrunk();
        BlockPos blockpos = pAttachment.pos().above(pOffset);
        int i = pFoliageRadius + pAttachment.radiusOffset() - 1;


        this.placeLeavesRowWithHangingLeavesBelow(
                pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, -1 - pFoliageHeight, flag, this.hangingLeavesChance, this.hangingLeavesExtensionChance
        );
        this.placeLeavesRowWithHangingLeavesBelow(
                pLevel, pBlockSetter, pRandom, pConfig, blockpos, i -1, -1 - pFoliageHeight, flag, this.hangingLeavesChance, this.hangingLeavesExtensionChance
        );
        this.placeLeavesRowWithHangingLeavesBelow(
                pLevel, pBlockSetter, pRandom, pConfig, blockpos, i -2, -1 - pFoliageHeight, flag, this.hangingLeavesChance, this.hangingLeavesExtensionChance
        );

        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, pFoliageRadius - 2, -1 - pFoliageHeight, flag);
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, blockpos, i, - pFoliageHeight, flag);
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return 0;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return pLocalY == 0
                ? (pLocalX > 1 || pLocalZ > 1) && pLocalX != 0 && pLocalZ != 0
                : pLocalX == pRange && pLocalZ == pRange && pRange > 0;    }
}

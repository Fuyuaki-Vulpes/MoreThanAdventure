package com.fuyuaki.morethanadventure.world.level.feature.placers;

import com.fuyuaki.morethanadventure.core.registry.MTAPlacers;
import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.function.BiConsumer;

public class PalmTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<PalmTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            p_70261_ -> trunkPlacerParts(p_70261_).apply(p_70261_, PalmTrunkPlacer::new)
    );
    public PalmTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return MTAPlacers.PALM_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter, RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        if (!pLevel.isStateAtPosition(pPos.below(), state -> state.is(Tags.Blocks.SANDS))){
            setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);
        }

        BlockPos placedPos = pPos;
        for (int i = 0; i < pFreeTreeHeight; i++) {
            this.placeLog(pLevel, pBlockSetter, pRandom, placedPos.above(i), pConfig);
            if (pRandom.nextFloat() > (float) pFreeTreeHeight / 700 && pRandom.nextBoolean()){
                Direction direction = Direction.getRandom(pRandom);

                while (!direction.getAxis().isHorizontal()){
                    direction = Direction.getRandom(pRandom);
                }

                placedPos = placedPos.relative(direction);
                this.placeLog(pLevel, pBlockSetter, pRandom, placedPos.above(i), pConfig);

            }
        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(placedPos.above(pFreeTreeHeight), 0, false));
    }
}

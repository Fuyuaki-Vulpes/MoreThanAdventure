package com.fuyuaki.morethanadventure.world.level.feature.feature;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAPlacers;
import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.neoforged.neoforge.common.Tags;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class GentleForkingTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<GentleForkingTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
        p_70261_ -> trunkPlacerParts(p_70261_).apply(p_70261_, GentleForkingTrunkPlacer::new)
);
    public GentleForkingTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return MTAPlacers.GENTLE_FORKING_TRUNK_PLACER.get();
    }


    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        if (!level.isStateAtPosition(pos.below(), state -> state.is(Tags.Blocks.SANDS))){
            setDirtAt(level, blockSetter, random, pos.below(), config);
        }

        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        int offset = freeTreeHeight / 2;
        int offsetB = offset / random.nextInt(1,4);

        for (int h = 0; h <= freeTreeHeight- offsetB; h++){
            if (h >= freeTreeHeight - offsetB - 1){
                list.add(
                        this.generateBranch(level,
                                blockSetter,
                                random,
                                config,
                                freeTreeHeight - offsetB + random.nextIntBetweenInclusive(-2,2),
                                direction,
                                pos.above(h))
                );
                direction = direction.getOpposite();
            }
            this.placeLog(level, blockSetter, random, pos.above(h), config);
        }


        return list;
    }

    private FoliagePlacer.FoliageAttachment generateBranch(LevelSimulatedReader level,
                                BiConsumer<BlockPos, BlockState> blockSetter,
                                RandomSource random,
                                TreeConfiguration config,
                                int branchHeight,
                                Direction direction,
                                BlockPos blockPos
    ) {
        BlockPos pos = blockPos.relative(direction);
        Function<BlockState, BlockState> function = state -> state.trySetValue(RotatedPillarBlock.AXIS, direction.getAxis());
        this.placeLog(level,blockSetter,random,pos,config,function);
        pos = pos.relative(direction);
        this.placeLog(level,blockSetter,random,pos,config,function);

        for (int b = 0; b < branchHeight; b++){
            this.placeLog(level,blockSetter,random,pos.above(b),config);
        }
        return new FoliagePlacer.FoliageAttachment(pos.above(branchHeight), 0, false);

    }
}

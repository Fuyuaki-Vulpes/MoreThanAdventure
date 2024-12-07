package com.fuyuaki.morethanadventure.world.level.feature.placers;

import com.fuyuaki.morethanadventure.core.registry.MTAPlacers;
import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class SeawoodTrunkPlacer extends TrunkPlacer {

    public static final MapCodec<SeawoodTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            p_70261_ -> trunkPlacerParts(p_70261_).apply(p_70261_, SeawoodTrunkPlacer::new)
    );
    public SeawoodTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return MTAPlacers.SEAWOOD_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader level, BiConsumer<BlockPos, BlockState> blockSetter, RandomSource random, int freeTreeHeight, BlockPos pos, TreeConfiguration config) {
        List<FoliagePlacer.FoliageAttachment> list = Lists.newArrayList();
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        int i = freeTreeHeight - random.nextInt(4);
        int j = 2 - random.nextInt(3);
        int k = pos.getX();
        int l = pos.getY();
        int i1 = pos.getZ();
        int j1 = k;
        int k1 = i1;
        int l1 = l + freeTreeHeight - 1;

        for (int i2 = 0; i2 < freeTreeHeight; i2++) {
            if (i2 >= i && j > 0) {
                j1 += direction.getStepX();
                k1 += direction.getStepZ();
                j--;
            }
            int j2 = l + i2;
            BlockPos blockpos1 = new BlockPos(j1, j2, k1);

            if (random.nextFloat() < 0.12){
                if (random.nextBoolean()){
                    if (random.nextFloat() < 0.5){
                        list.add(new FoliagePlacer.FoliageAttachment(blockpos1.east(), -2, false));

                    }else {
                        list.add(new FoliagePlacer.FoliageAttachment(blockpos1.east().south(), -2, false));

                    }
                }else {
                    if (random.nextFloat() < 0.5){
                        list.add(new FoliagePlacer.FoliageAttachment(blockpos1, -2, false));

                    }else {
                        list.add(new FoliagePlacer.FoliageAttachment(blockpos1.south(), -2, false));

                    }
                }
            }
            if (isValidPlacementForLog(level, blockpos1)) {
                this.placeLog(level, blockSetter, random, blockpos1, config);
                this.placeLog(level, blockSetter, random, blockpos1.east(), config);
                this.placeLog(level, blockSetter, random, blockpos1.south(), config);
                this.placeLog(level, blockSetter, random, blockpos1.east().south(), config);
            }
        }

        list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(j1, l1, k1), 0, true));

        for (int l2 = -1; l2 <= 2; l2++) {
            for (int i3 = -1; i3 <= 2; i3++) {
                if ((l2 < 0 || l2 > 1 || i3 < 0 || i3 > 1) && random.nextInt(3) <= 0) {
                    int j3 = random.nextInt(3) + 2;

                    for (int k2 = 0; k2 < j3; k2++) {
                        this.placeLog(level, blockSetter, random, new BlockPos(k + l2, l1 - k2 - 1, i1 + i3), config);
                    }

                    list.add(new FoliagePlacer.FoliageAttachment(new BlockPos(j1 + l2, l1, k1 + i3), 0, false));
                }
            }
        }

        return list;
    }

    public static boolean isValidPlacementForLog(LevelSimulatedReader level, BlockPos pos) {
        return level.isStateAtPosition(pos, state -> state.isAir() || state.is(BlockTags.LEAVES) || state.is(Blocks.WATER) ||state.canBeReplaced());
    }

}

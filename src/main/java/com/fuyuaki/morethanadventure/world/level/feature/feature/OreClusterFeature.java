package com.fuyuaki.morethanadventure.world.level.feature.feature;

import com.fuyuaki.morethanadventure.world.level.feature.configuration.OreClusterConfiguration;
import com.mojang.serialization.Codec;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;

public class OreClusterFeature extends Feature<OreClusterConfiguration> {
    public OreClusterFeature(Codec<OreClusterConfiguration> pCodec) {
        super(pCodec);
    }

    @Override
    public boolean place(FeaturePlaceContext<OreClusterConfiguration> pContext) {
        int i = 0;
        RandomSource random = pContext.random();
        BlockPos blockpos = pContext.origin();
        WorldGenLevel level = pContext.level();
        OreClusterConfiguration config = pContext.config();
        int size = config.thickness;

        int branches = random.nextInt(config.minBranches,config.maxBranches);

        for (int a = 0; a < branches; a++){

            float multiplier = random.nextFloat();
            int maxLength = (int) (config.maxLenght * (multiplier > 0.8 ? multiplier : 0.8));
            int x = random.nextInt(1) * (random.nextBoolean() ? 1: -1);
            int y = random.nextInt(1) * (random.nextBoolean() ? 1: -1);
            int z = random.nextInt(1) * (random.nextBoolean() ? 1: -1);


            BlockPos pos = blockpos;

            int length = 0;

            while (length < maxLength) {

                BlockPos pos1 = new BlockPos(pos.getX() + size,pos.getY() + size,pos.getZ() + size);

                for (BlockPos pos3 : BlockPos.betweenClosed(pos1, pos)) {
                    if(config.targetStates.test(level.getBlockState(pos),random)){
                        level.setBlock(pos3, random.nextFloat() < config.oreChance ? config.oreBlock : config.veinBlock, 2);
                    }
                }


                if (random.nextBoolean()){
                    pos = pos.relative(Direction.getRandom(random)).relative(Direction.getRandom(random)).relative(Direction.getRandom(random));
                }
                else{
                    if (random.nextBoolean()){
                        pos = pos.relative(Direction.Axis.X,
                                x);
                    }
                    if (random.nextBoolean()){
                        pos = pos.relative(Direction.Axis.Y,
                                y);
                    }
                    if (random.nextBoolean()){
                        pos = pos.relative(Direction.Axis.Z,
                                z);
                    }
                }

                i++;

                length++;
            }


        }

        return i > 0;
    }




}

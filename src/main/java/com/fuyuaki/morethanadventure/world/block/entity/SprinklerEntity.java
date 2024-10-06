package com.fuyuaki.morethanadventure.world.block.entity;

import com.fuyuaki.morethanadventure.core.MTACommonConfig;
import com.fuyuaki.morethanadventure.core.registry.MtaBlockEntities;
import com.fuyuaki.morethanadventure.core.registry.MtaParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.Tags;

public class SprinklerEntity extends BlockEntity {

    public SprinklerEntity( BlockPos pPos, BlockState pBlockState) {
        super(MtaBlockEntities.SPRINKLER.get(), pPos, pBlockState);
    }





    public static void particleTick(Level level, BlockPos blockPos, BlockState blockState, SprinklerEntity sprinklerEntity) {
        for (int p = 0; p < 4; p++){
            level.addParticle(MtaParticles.SPRINKLER.get(), blockPos.getX() + 0.5,blockPos.above().above().getY(),blockPos.getZ() + 0.5,0,0,0);
        }
        for (int k = 0; k < 10; k++ ) {
            float cRange = (float) ((MTACommonConfig.sprinklerRange / 10) * k) / 25;
            float xRange = cRange * level.random.nextIntBetweenInclusive(-20,20) / 20;
            float zRange = cRange * level.random.nextIntBetweenInclusive(-20,20) / 20;
            if (level.getBlockState(blockPos.below()).is(Tags.Blocks.VILLAGER_FARMLANDS)) {
                level.addParticle(ParticleTypes.FALLING_WATER, blockPos.getCenter().x + xRange,
                        blockPos.getCenter().y + 0.5,
                        blockPos.getCenter().z + zRange
                        , 0, 0, 0);
            }
        }
    }

    public static void growthTick(Level level, BlockPos blockPos, BlockState blockState, SprinklerEntity sprinklerEntity) {
        int range = MTACommonConfig.sprinklerRange;
        if (level.random.nextFloat() < 0.005) {
            for (BlockPos pos : BlockPos.betweenClosed(blockPos.east(range).above(2).south(range), blockPos.west(range).below().north(range))) {
                BlockState state = level.getBlockState(pos);

                if (level.random.nextFloat() < 0.001) {
                    if (state.is(BlockTags.CROPS)) {
                        for (int a = 0; a < level.random.nextInt(5); a++) {
                            state.randomTick((ServerLevel) level, pos, level.random);
                        }
                        level.playSound(null,pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS,0.5F,1.0F);
                    }
                }

            }
        }
    }
}

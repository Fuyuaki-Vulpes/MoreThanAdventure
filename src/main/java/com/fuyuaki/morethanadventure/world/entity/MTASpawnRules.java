package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.LevelAccessor;

public class MTASpawnRules {

    public static boolean checkSeaAnimalSpawnRules(
            EntityType<? extends WaterAnimal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        int i = pLevel.getSeaLevel();
        int j = i - 13;
        return pPos.getY() >= j
                && pPos.getY() <= i
                && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER)
                && pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.SEA_ANIMAL_SPAWNABLE_ON);
    }

    public static boolean checkWaterAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        int i = pLevel.getSeaLevel();
        int j = i - 13;
        return pPos.getY() >= j
                && pPos.getY() <= i
                && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER)
                && pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.SEA_ANIMAL_SPAWNABLE_ON);
    }

    public static boolean checkDesertAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        boolean flag = MobSpawnType.ignoresLightRequirements(pSpawnType) || isBrightEnoughToSpawn(pLevel, pPos);
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.DESERT_ANIMAL_SPAWNABLE_ON) && flag;
    }

    public static boolean checkLandSwimmerSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.LAND_SWIMMER_SPAWNABLE_ON);
    }

    public static boolean checkSnowAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        boolean flag = MobSpawnType.ignoresLightRequirements(pSpawnType) || isBrightEnoughToSpawn(pLevel, pPos);
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.SNOW_ANIMAL_SPAWNABLE_ON) && flag;
    }

    protected static boolean isBrightEnoughToSpawn(BlockAndTintGetter pLevel, BlockPos pPos) {
        return pLevel.getRawBrightness(pPos, 0) > 8;
    }


}

package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.animal.AgeableWaterCreature;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;

public class MTASpawnRules {



    public static boolean checkSeaCreatureSpawnRules(
            EntityType<? extends AgeableWaterCreature> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        int i = 63;
        return pPos.getY() <= i
                && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER)
                && pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }

    public static boolean checkWaterCreatureSpawnRules(
            EntityType<? extends AgeableWaterCreature> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {

        return  pLevel.getFluidState(pPos.below()).is(FluidTags.WATER) ||   pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }
    public static boolean checkSeaAnimalSpawnRules(
            EntityType<? extends WaterAnimal> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        int i = 63;
        return pPos.getY() <= i
                && pLevel.getFluidState(pPos.below()).is(FluidTags.WATER)
                && pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }

    public static boolean checkWaterAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {

        return  pLevel.getFluidState(pPos.below()).is(FluidTags.WATER) ||   pLevel.getBlockState(pPos.above()).is(Blocks.WATER);
    }
    public static boolean checkDesertAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        boolean flag = EntitySpawnReason.ignoresLightRequirements(pSpawnType) || isBrightEnoughToSpawn(pLevel, pPos);
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.DESERT_ANIMAL_SPAWNABLE_ON) && flag;
    }

    public static boolean checkLandSwimmerSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.LAND_SWIMMER_SPAWNABLE_ON) ||  pLevel.getFluidState(pPos.below()).is(FluidTags.WATER);
    }
    public static boolean checkBirdSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.BIRD_SPAWNABLE_ON);
    }

    public static boolean checkSnowAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, EntitySpawnReason pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        boolean flag = EntitySpawnReason.ignoresLightRequirements(pSpawnType) || isBrightEnoughToSpawn(pLevel, pPos);
        return pLevel.getBlockState(pPos.below()).is(MtaTags.Blocks.SNOW_ANIMAL_SPAWNABLE_ON) && flag;
    }

    protected static boolean isBrightEnoughToSpawn(BlockAndTintGetter pLevel, BlockPos pPos) {
        return pLevel.getRawBrightness(pPos, 0) > 8;
    }


}

package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

import javax.annotation.Nullable;

public interface MTAPlacementTypes extends SpawnPlacementTypes {
    SpawnPlacementType VALID_GROUND = new SpawnPlacementType() {
        @Override
        public boolean isSpawnPositionOk(LevelReader levelReader, BlockPos pos, @Nullable EntityType<?> entityType) {
            if (entityType != null && levelReader.getWorldBorder().isWithinBounds(pos)) {
                BlockPos blockpos = pos.above();
                BlockPos below = pos.below();
                BlockState blockstate = levelReader.getBlockState(below);
                if (blockstate.isValidSpawn(levelReader, below, entityType)){
                    return this.isValidEmptySpawnBlock(levelReader, pos, entityType)
                            && this.isValidEmptySpawnBlock(levelReader, blockpos, entityType);
                }
                return levelReader.getFluidState(pos).is(FluidTags.WATER)
                        && !levelReader.getBlockState(blockpos).isRedstoneConductor(levelReader, blockpos) && !levelReader.getBlockState(below.below(2)).isAir();
            } else {
                return false;
            }
        }

        private boolean isValidEmptySpawnBlock(LevelReader reader, BlockPos pos, EntityType<?> type) {
            BlockState blockstate = reader.getBlockState(pos);
            return NaturalSpawner.isValidEmptySpawnBlock(reader, pos, blockstate, blockstate.getFluidState(), type);
        }

    };


    SpawnPlacementType GROUND_OR_AIR =  new SpawnPlacementType() {
        @Override
        public boolean isSpawnPositionOk(LevelReader levelReader, BlockPos pos, @Nullable EntityType<?> entityType) {
            if (entityType != null && levelReader.getWorldBorder().isWithinBounds(pos)) {
                BlockPos blockpos = pos.above();
                BlockPos belowPos = pos.below();
                BlockState blockstate = levelReader.getBlockState(belowPos);
                if (blockstate.isValidSpawn(levelReader, belowPos, entityType)) {
                    return this.isValidEmptySpawnBlock(levelReader, pos, entityType) && this.isValidEmptySpawnBlock(levelReader, blockpos, entityType);
                }
                return levelReader.getBlockState(pos).isAir() && !levelReader.getBlockState(belowPos.below(2)).isAir();
            }
            else {
                return false;
            }
        }

        private boolean isValidEmptySpawnBlock(LevelReader reader, BlockPos pos, EntityType<?> type) {
            BlockState blockstate = reader.getBlockState(pos);
            return NaturalSpawner.isValidEmptySpawnBlock(reader, pos, blockstate, blockstate.getFluidState(), type);
        }
    };


    SpawnPlacementType GROUND_OR_WATER = new SpawnPlacementType() {
        @Override
        public boolean isSpawnPositionOk(LevelReader levelReader, BlockPos pos, @Nullable EntityType<?> entityType) {
            if (entityType != null && levelReader.getWorldBorder().isWithinBounds(pos)) {
                BlockPos blockpos = pos.above();
                BlockPos blockpos1 = pos.below();
                BlockState blockstate = levelReader.getBlockState(blockpos1);
                return !blockstate.isValidSpawn(levelReader, blockpos1, entityType)
                        ? levelReader.getFluidState(pos).is(FluidTags.WATER) && !levelReader.getBlockState(blockpos).isRedstoneConductor(levelReader, blockpos)
                        : (this.isValidEmptySpawnBlock(levelReader, pos, entityType)  || levelReader.getFluidState(pos).is(FluidTags.WATER)) && this.isValidEmptySpawnBlock(levelReader, blockpos, entityType);
            } else {
                return false;
            }
        }

        private boolean isValidEmptySpawnBlock(LevelReader reader, BlockPos pos, EntityType<?> type) {
            BlockState blockstate = reader.getBlockState(pos);
            return NaturalSpawner.isValidEmptySpawnBlock(reader, pos, blockstate, blockstate.getFluidState(), type);
        }
    };
}

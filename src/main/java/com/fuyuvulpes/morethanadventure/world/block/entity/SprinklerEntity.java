package com.fuyuvulpes.morethanadventure.world.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Objects;

public class SprinklerEntity extends BlockEntity implements GeoBlockEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final RawAnimation RUN = RawAnimation.begin().thenLoop("spin");


    public SprinklerEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, state -> {
            if (state.getAnimatable().shouldRun(Objects.requireNonNull(state.getAnimatable().level),state.getAnimatable().worldPosition))
                return state.setAndContinue(RUN);

            return state.setAndContinue(DefaultAnimations.IDLE);
        }));
    }

    private boolean shouldRun(Level level, BlockPos position) {
        BlockState state = level.getBlockState(position);
        if (!state.getValue(RedstoneTorchBlock.LIT)){
            return true;
        }
        return false;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }
}

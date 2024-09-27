package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

public class IcicleCreeper extends AbstractCreeperVariant {

    protected static final RawAnimation WALK = RawAnimation.begin().thenPlayAndHold("animation.creeper.walk");
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public IcicleCreeper(EntityType<? extends AbstractCreeperVariant> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }



    @Override
    protected void doParticles(Vec3 pos) {

    }
    public static AttributeSupplier.Builder createAttributes() {
        return AbstractCreeperVariant.createMonsterAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.30)
                .add(Attributes.MAX_HEALTH,15);
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, 5, (state) -> {
                   if (state.isMoving()) {
                        return state.setAndContinue(WALK);
                    }
                    return state.setAndContinue(DefaultAnimations.IDLE);
                })
        );
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public void setTicksFrozen(int pTicksFrozen) {

    }

    @Override
    public int getTicksFrozen() {
        return 0;
    }

    @Override
    public boolean addEffect(MobEffectInstance pEffectInstance, @Nullable Entity pEntity) {
        if (pEffectInstance.is(MtaEffects.FREEZING)){
            return false;
        }
        return super.addEffect(pEffectInstance, pEntity);
    }

    @Override
    protected void explodeCreeper() {
        super.explodeCreeper();
        Level level = this.level();
        BlockPos blockpos = this.getOnPos().above();
        for (BlockPos pos : BlockPos.betweenClosed(blockpos.offset(-6, -1, -6), blockpos.offset(6, 5, 6))){
            if (this.random.nextFloat() < 0.3F && !level.getBlockState(pos.below()).isAir() && level.getFluidState(pos.below()).isEmpty()){
                level.addParticle(ParticleTypes.SNOWFLAKE,pos.getX(),pos.getY(),pos.getZ(),0,0,0);
            }
            if (!level.getBlockState(pos.below()).isAir() && level.getFluidState(pos.below()).isEmpty()){
                if (level.getBlockState(pos).isAir()) {
                    level.setBlockAndUpdate(pos,Blocks.SNOW.defaultBlockState());
                }else if (level.getBlockState(pos).is(Blocks.SNOW)) {
                    int layer = level.getBlockState(pos).hasProperty(SnowLayerBlock.LAYERS) ? level.getBlockState(pos).getValue(SnowLayerBlock.LAYERS) : 0;
                    level.setBlockAndUpdate(pos,Blocks.SNOW.defaultBlockState().setValue(SnowLayerBlock.LAYERS, layer + 1));
                }
            }
            if (level.getFluidState(pos).is(Fluids.WATER)){
                level.setBlockAndUpdate(pos, Blocks.ICE.defaultBlockState());
            }
            else if (level.getFluidState(pos).is(Fluids.LAVA)){
                level.setBlockAndUpdate(pos, Blocks.MAGMA_BLOCK.defaultBlockState());
            }
        }

        level.getEntitiesOfClass(LivingEntity.class,this.getBoundingBox().inflate(4,2,4)).forEach(
                living -> {
                    if (!living.isDeadOrDying()){
                        living.addEffect(new MobEffectInstance(MtaEffects.FREEZING,120,2));
                    }
                }
        );

    }

}

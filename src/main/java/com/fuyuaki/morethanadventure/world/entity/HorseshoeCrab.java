package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaItems;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.util.GeckoLibUtil;

public class HorseshoeCrab extends MTATameableAnimal implements GeoEntity {
    protected static final RawAnimation WALK = RawAnimation.begin().thenLoop("walk");


    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public HorseshoeCrab(EntityType<? extends MTATameableAnimal> pEntityType, Level pLevel) {
        super(40.0F,pEntityType, pLevel);
        this.setPathfindingMalus(PathType.WATER, 0.0F);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(5, new FollowMobGoal(this, 1.0, 1.0F, 7.0F));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25, stack -> stack.is(MtaItems.SHRIMP), false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4.0F)
                .add(Attributes.FOLLOW_RANGE, 12.0)
                .add(Attributes.MOVEMENT_SPEED, 0.02F);
    }

    @Override
    public int getMaxAirSupply() {
        return 148000;
    }

    @Override
    protected int decreaseAirSupply(int pCurrentAir) {
        return pCurrentAir;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(MtaItems.SHRIMP);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        HorseshoeCrab horseshoeCrab = MtaEntityTypes.HORSESHOE_CRAB.get().create(pLevel);
        return horseshoeCrab;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, 10, (state) -> {
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
}

package com.fuyuvulpes.morethanadventure.world.entity;

import com.fuyuvulpes.morethanadventure.core.registry.MtaEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;

public class Toucan extends Animal implements FlyingAnimal, GeoEntity {
    protected static final RawAnimation WALK = RawAnimation.begin().thenLoop("walk");


    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);


    public Toucan(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0, 1.0F, 7.0F));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25, p_335831_ -> p_335831_.is(ItemTags.PARROT_FOOD), false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.25));
    }



    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 4.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.FLYING_SPEED,0.5)
                .add(Attributes.MOVEMENT_SPEED, 0.1F);
    }


    @Override
    public boolean isFood(ItemStack pStack) {
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        Toucan toucan = MtaEntityTypes.TOUCAN.get().create(pLevel);
        return toucan;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public boolean isFlying() {
        return false;
    }
}

package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.Nullable;

public class Turkey extends Animal {
    public Turkey(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 2.0F));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(3, new TemptGoal(this, 1, stack -> stack.is(Tags.Items.SEEDS), false));
        this.goalSelector.addGoal(3, new FollowMobGoal(this, 1.0, 1.0F, 7.0F));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 9.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.TURKEY_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.TURKEY_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.TURKEY_DEATH.get();
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Tags.Items.SEEDS);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        Turkey turkey = MtaEntityTypes.TURKEY.get().create(level);
        return turkey;
    }
}

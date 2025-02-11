package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

public class Penguin extends MTATameableAnimal {


    public Penguin(EntityType<? extends MTATameableAnimal> pEntityType, Level pLevel) {
        super(60.0F,pEntityType, pLevel);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.addGoal(9, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(6, new FollowParentGoal(this, 1.0F));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1, stack -> stack.is(ItemTags.FISHES), false));
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(8, new RandomStrollGoal(this, 1));
        this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 1.0, 20));

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createAnimalAttributes()
                .add(Attributes.MAX_HEALTH, 8.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.WATER_MOVEMENT_EFFICIENCY, 2.0)
                .add(Attributes.MOVEMENT_SPEED, 0.15F);
    }

    @Override
    public int getMaxAirSupply() {
        return 4800;
    }

    @Override
    protected int increaseAirSupply(int pCurrentAir) {
        return this.getMaxAirSupply();
    }


    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.FISHES);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        Penguin penguin = MtaEntityTypes.PENGUIN.get().create(pLevel, EntitySpawnReason.BREEDING);
        return penguin;
    }
}

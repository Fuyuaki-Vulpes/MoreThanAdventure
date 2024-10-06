package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import org.jetbrains.annotations.Nullable;

public class Capybara extends MTATameableAnimal {


    public Capybara(EntityType<? extends MTATameableAnimal> pEntityType, Level pLevel) {
        super(50.0F,pEntityType, pLevel);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new TamableAnimal.TamableAnimalPanicGoal(1.5, DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(4, new TemptGoal(this, 1.25, stack -> stack.is(ItemTags.COW_FOOD), false));
        this.goalSelector.addGoal(4, new BreedGoal(this, 1.25));
        this.goalSelector.addGoal(4, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.addGoal(4, new FollowParentGoal(this, 1.25));
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(7, new RandomSwimmingGoal(this, 1.0, 20));



    }



    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 12.0F)
                .add(Attributes.FOLLOW_RANGE, 7.0)
                .add(Attributes.ATTACK_DAMAGE, 6.0)
                .add(Attributes.OXYGEN_BONUS, 32.0)
                .add(Attributes.MOVEMENT_SPEED, 0.2F);
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.CAPYBARA_HURT.get();
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ItemTags.COW_FOOD);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        Capybara capybara = MtaEntityTypes.CAPIBARA.get().create(pLevel);
        return capybara;
    }


    public static boolean checkAnimalSpawnRules(
            EntityType<? extends Animal> pAnimal, LevelAccessor pLevel, MobSpawnType pSpawnType, BlockPos pPos, RandomSource pRandom
    ) {
        boolean flag = MobSpawnType.ignoresLightRequirements(pSpawnType) || isBrightEnoughToSpawn(pLevel, pPos);
        return Animal.checkAnimalSpawnRules(pAnimal,pLevel,pSpawnType,pPos,pRandom) || pLevel.getBlockState(pPos.below()).is(BlockTags.AXOLOTLS_SPAWNABLE_ON) && flag ;
    }
}

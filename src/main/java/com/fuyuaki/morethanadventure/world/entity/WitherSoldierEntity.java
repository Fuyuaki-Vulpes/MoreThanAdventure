package com.fuyuaki.morethanadventure.world.entity;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FleeSunGoal;
import net.minecraft.world.entity.ai.goal.RangedCrossbowAttackGoal;
import net.minecraft.world.entity.ai.goal.UseItemGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.SnowGolem;
import net.minecraft.world.entity.monster.AbstractIllager;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.monster.CrossbowAttackMob;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class WitherSoldierEntity extends AbstractSkeleton implements CrossbowAttackMob {
    public WitherSoldierEntity(EntityType<? extends AbstractSkeleton> p_32133_, Level p_32134_) {
        super(p_32133_, p_32134_);
        this.xpReward = 10;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MOVEMENT_SPEED, 0.35F)
                .add(Attributes.ARMOR, 3.0F)
                .add(Attributes.MAX_HEALTH, 30.0)
                .add(Attributes.FOLLOW_RANGE, 24.0)
                .add(Attributes.ATTACK_DAMAGE, 2.0);
    }



    @Override
    protected void registerGoals() {

        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, SnowGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, Villager.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractIllager.class, true));

        super.registerGoals();
    }

    @Override
    protected void populateDefaultEquipmentSlots(RandomSource randomSource, DifficultyInstance difficultyInstance) {
        this.pickWeapon(randomSource.nextBoolean(), randomSource);

//        if (randomSource.nextFloat() < 0.2F * difficultyInstance.getEffectiveDifficulty()){
//            this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.SHIELD));
//
//        }

        if (random.nextFloat() < 0.5F) {
            int i = random.nextInt(4);

            float helmetChance = 0.12F;
            float chestChance = 0.4F;
            float legChance = 0.32F;
            float bootsChance = 0.27F;
            if (randomSource.nextFloat() < helmetChance){
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.HEAD);

                if (itemstack.isEmpty()) {
                    Item item = getEquipmentForSlot(EquipmentSlot.HEAD, i);
                    if (item != null) {
                        this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(item));
                    }
                }
            }
            i = random.nextInt(4);

            if (randomSource.nextFloat() < chestChance){
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.CHEST);

                if (itemstack.isEmpty()) {
                    Item item = getEquipmentForSlot(EquipmentSlot.CHEST, i);
                    if (item != null) {
                        this.setItemSlot(EquipmentSlot.CHEST, new ItemStack(item));
                    }
                }
            }
            i = random.nextInt(4);

            if (randomSource.nextFloat() < legChance){
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.LEGS);

                if (itemstack.isEmpty()) {
                    Item item = getEquipmentForSlot(EquipmentSlot.LEGS, i);
                    if (item != null) {
                        this.setItemSlot(EquipmentSlot.LEGS, new ItemStack(item));
                    }
                }
            }
            i = random.nextInt(4);

            if (randomSource.nextFloat() < bootsChance){
                ItemStack itemstack = this.getItemBySlot(EquipmentSlot.FEET);

                if (itemstack.isEmpty()) {
                    Item item = getEquipmentForSlot(EquipmentSlot.FEET, i);
                    if (item != null) {
                        this.setItemSlot(EquipmentSlot.FEET, new ItemStack(item));
                    }
                }
            }
        }

    }

    private void pickWeapon(boolean ranged, RandomSource source) {
        if (ranged){
            if (source.nextBoolean()) {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.BOW));
            }
            else {
                this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.TWIN_BOW.get()));

            }
        }else{
            int w = source.nextInt(0,7);
            int t = source.nextInt(0,4);
            if (w == 0){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.WOODEN_SWORD));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
                }
            }if (w == 1){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_HALBERD.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_HALBERD.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_HALBERD.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_HALBERD.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_HALBERD.get()));
                }

            }if (w == 2){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_RAPIER.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_RAPIER.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_RAPIER.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_RAPIER.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_RAPIER.get()));
                }
            }if (w == 3){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_CUTLASS.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_CUTLASS.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_CUTLASS.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_CUTLASS.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_CUTLASS.get()));
                }
            }if (w == 4){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_SPEAR.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_SPEAR.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_SPEAR.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_SPEAR.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_SPEAR.get()));
                }
            }if (w == 5){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_SICKLE.get()));
                    this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MtaItems.WOOD_SICKLE.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_SICKLE.get()));
                    this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MtaItems.STONE_SICKLE.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_SICKLE.get()));
                    this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MtaItems.IRON_SICKLE.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_SICKLE.get()));
                    this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MtaItems.GOLD_SICKLE.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_SICKLE.get()));
                    this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(MtaItems.DIAMOND_SICKLE.get()));
                }
            }if (w == 6){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_GLAIVE.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_GLAIVE.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_GLAIVE.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_GLAIVE.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_GLAIVE.get()));
                }
            }if (w == 7){
                if (t == 0){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.WOOD_KATANA.get()));
                }if (t == 1){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.STONE_KATANA.get()));
                }if (t == 2){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.IRON_KATANA.get()));
                }if (t == 3){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.GOLD_KATANA.get()));
                }if (t == 4){
                    this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(MtaItems.DIAMOND_KATANA.get()));
                }
            }
        }

    }

    @Override
    protected boolean isSunBurnTick() {
        return false;
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return MtaSounds.ARMORED_SKELETON_AMBIENT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return MtaSounds.ARMORED_SKELETON_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return MtaSounds.ARMORED_SKELETON_DEATH.get();
    }

    @Override
    protected SoundEvent getStepSound() {
        return MtaSounds.ARMORED_SKELETON_STEP.get();
    }

    @Override
    public void setChargingCrossbow(boolean chargingCrossbow) {

    }

    @Override
    public void onCrossbowAttackPerformed() {

    }
}

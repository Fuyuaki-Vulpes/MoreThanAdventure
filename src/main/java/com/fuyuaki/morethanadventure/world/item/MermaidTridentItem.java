package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.world.entity.ThrownMysticMermaidsTrident;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Position;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class MermaidTridentItem extends TridentItem implements ProjectileItem {

    private int beamActiveTicks;
    private boolean wasCharging;
    private int startedUsingTick;
    private int timer;

    public MermaidTridentItem(Properties pProperties) {
        super(pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
    }

    @Override
    public InteractionResult use(Level level, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (player.isCrouching() && !player.getCooldowns().isOnCooldown(itemstack)) {
            player.startUsingItem(hand);
            this.wasCharging = true;
            return InteractionResult.CONSUME;
        }
        return super.use(level, player, hand);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!isSelected){
            this.wasCharging = false;
        }
        super.inventoryTick(stack, level, entity, slotId, isSelected);
    }

    @Override
    public void onUseTick(Level level, LivingEntity livingEntity, ItemStack stack, int remainingDuration) {
        if (livingEntity instanceof Player player && player.isCrouching()) {
            Vec3 vec3 = player.position().add(0,player.getEyeHeight() * 0.75,0);
            Vec3 vec31 = player.getViewVector(1.0F);
            Vec3 vec32 = vec3.add(vec31.x * 16.0, vec31.y * 16.0, vec31.z * 16.0);
            EntityHitResult entityhitresult = ProjectileUtil.getEntityHitResult(
                    player.level(), player, vec3, vec32, new AABB(vec3, vec32).inflate(1.0), p_156765_ -> !p_156765_.isSpectator(), 0.0F
            );

            if (!(entityhitresult == null || entityhitresult.getType() != HitResult.Type.ENTITY)
            ) {

                Entity entity = entityhitresult.getEntity();
                if (entity instanceof LivingEntity living && player.hasLineOfSight(living)) {

                    if (!this.wasCharging && timer > 30) {
                        this.wasCharging = true;

                        this.startedUsingTick = player.getTicksUsingItem();
                        this.timer = 0;
                    }
                    int t = (int) Math.min(((this.getUseDuration(stack, player) - (remainingDuration + this.startedUsingTick)) * 1.5),100);
                    if(t > 0 && t <= 100) player.displayClientMessage(Component.literal(t + "%").withStyle(ChatFormatting.AQUA,ChatFormatting.BOLD,ChatFormatting.ITALIC),true);

                    if (t >= 100) {

                        player.playNotifySound(SoundEvents.CONDUIT_ATTACK_TARGET, SoundSource.PLAYERS, 5.0F, 0.2F);
                        for (int n = 0; n < 100; n++) {
                            level.addParticle(MtaParticles.UNPOPPABLE_BUBBLE.get(), living.getRandomX(0.8F), living.getY() + 0.5F, living.getRandomZ(0.8), 0, 0.5, 0);
                        }
                        living.hurt(player.damageSources().magic(), Math.min(Math.max(living.getMaxHealth() / 5, 15), 80));
                        player.getCooldowns().addCooldown(stack,200);
                        player.stopUsingItem();

                    }else {
                        Vec3 lPos = new Vec3(living.getX(), living.getY(0.5), living.getZ());

                        float p = t % 20;

                        if (t % 25 == 0) {
                            player.playNotifySound(SoundEvents.CONDUIT_ATTACK_TARGET, SoundSource.PLAYERS, 0.5F, 1.0F);
                            for (int a = 0; a < 20; a++) {
                                Vec3 pos = vec3.lerp(lPos, ((double) a) / 20);
                                level.addParticle(ParticleTypes.NAUTILUS, pos.x, pos.y, pos.z, 0, 0, 0);
                            }
                        } else {
                            Vec3 pos = vec3.lerp(lPos, p / 20);
                            level.addParticle(MtaParticles.UNPOPPABLE_BUBBLE.get(), pos.x, pos.y, pos.z, 0, 0.2, 0);
                        }
                    }
                }

            }else{
                if (this.timer > 30) {
                    this.startedUsingTick = player.getTicksUsingItem();
                    player.stopUsingItem();
                    this.wasCharging = false;

                }
                else timer++;
            }


        }
        super.onUseTick(level, livingEntity, stack, remainingDuration);
    }

    public static ItemAttributeModifiers createAttributes() {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, 12.0, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -2.9F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        double d0 = (double) (-Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double) Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0));
        if (pAttacker.level() instanceof ServerLevel) {
            ((ServerLevel) pAttacker.level()).sendParticles(ParticleTypes.SONIC_BOOM, pAttacker.getX() + d0, pAttacker.getY(0.5), pAttacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }


    @Override
    public boolean isPrimaryItemFor(ItemStack stack, Holder<Enchantment> enchantment) {
        return stack.getItem() == MtaItems.MYSTIC_MERMAIDS_TRIDENT.get() && (
                enchantment.is(Enchantments.CHANNELING) ||
                        enchantment.is(Enchantments.SMITE) ||
                        enchantment.is(Enchantments.BANE_OF_ARTHROPODS) ||
                        enchantment.is(Enchantments.UNBREAKING) ||
                        enchantment.is(Enchantments.LOYALTY) ||
                        enchantment.is(Enchantments.IMPALING) ||
                        enchantment.is(Enchantments.RIPTIDE)
        );
    }


    @Override
    public void onStopUsing(ItemStack stack, LivingEntity entity, int count) {
        this.wasCharging = false;
        this.startedUsingTick = 0;
        super.onStopUsing(stack, entity, count);
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (this.wasCharging) {
            this.startedUsingTick = 0;
            this.wasCharging = false;
            return false;
        }

        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack, pEntityLiving) - pTimeLeft;
            if (i >= 10) {
                float f = EnchantmentHelper.getTridentSpinAttackStrength(pStack, player);
                if (!(f > 0.0F) || player.isInWaterOrRain()) {
                    if (!isTooDamagedToUse(pStack)) {
                        Holder<SoundEvent> holder = EnchantmentHelper.pickHighestLevel(pStack, EnchantmentEffectComponents.TRIDENT_SOUND)
                                .orElse(SoundEvents.TRIDENT_THROW);
                        if (!pLevel.isClientSide) {
                            pStack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(pEntityLiving.getUsedItemHand()));
                            if (f == 0.0F) {
                                ThrownMysticMermaidsTrident throwntrident = new ThrownMysticMermaidsTrident(pLevel, player, pStack);
                                throwntrident.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 2.5F, 1.0F);
                                if (player.hasInfiniteMaterials()) {
                                    throwntrident.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
                                }

                                pLevel.addFreshEntity(throwntrident);
                                pLevel.playSound(null, throwntrident, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                                if (!player.hasInfiniteMaterials()) {
                                    player.getInventory().removeItem(pStack);
                                }
                            }
                        }

                        player.awardStat(Stats.ITEM_USED.get(this));
                        if (f > 0.0F) {
                            float f7 = player.getYRot();
                            float f1 = player.getXRot();
                            float f2 = -Mth.sin(f7 * (float) (Math.PI / 180.0)) * Mth.cos(f1 * (float) (Math.PI / 180.0));
                            float f3 = -Mth.sin(f1 * (float) (Math.PI / 180.0));
                            float f4 = Mth.cos(f7 * (float) (Math.PI / 180.0)) * Mth.cos(f1 * (float) (Math.PI / 180.0));
                            float f5 = Mth.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
                            f2 *= f / f5;
                            f3 *= f / f5;
                            f4 *= f / f5;
                            player.push((double) f2, (double) f3, (double) f4);
                            player.startAutoSpinAttack(20, 40.0F, pStack);
                            if (player.onGround()) {
                                float f6 = 1.1999999F;
                                player.move(MoverType.SELF, new Vec3(0.0, 1.1999999F, 0.0));
                            }

                            pLevel.playSound(null, player, holder.value(), SoundSource.PLAYERS, 1.0F, 1.0F);
                        }
                    }
                }
            }
        }
        return true;
    }

    private static boolean isTooDamagedToUse(ItemStack pStack) {
        return pStack.getDamageValue() >= pStack.getMaxDamage() - 1;
    }

    @Override
    public Projectile asProjectile(Level pLevel, Position pPos, ItemStack pStack, Direction pDirection) {
        ThrownMysticMermaidsTrident throwntrident = new ThrownMysticMermaidsTrident(pLevel, pPos.x(), pPos.y(), pPos.z(), pStack.copyWithCount(1));
        throwntrident.pickup = AbstractArrow.Pickup.ALLOWED;
        return throwntrident;
    }

}
package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaItems;
import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.MaceItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;

public class SentinelsWarHammerItem extends MaceItem {

    private static final int DEFAULT_ATTACK_DAMAGE = 10;
    private static final float DEFAULT_ATTACK_SPEED = -3.4F;
    public static final float SMASH_ATTACK_FALL_THRESHOLD = 1.5F;
    private static final float SMASH_ATTACK_HEAVY_THRESHOLD = 5.0F;
    public static final float SMASH_ATTACK_KNOCKBACK_RADIUS = 3.5F;
    private static final float SMASH_ATTACK_KNOCKBACK_POWER = 0.7F;
    private final Supplier<ItemAttributeModifiers> attributeModifiers;


    public SentinelsWarHammerItem(Properties pProperties) {
        super(pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    ResourceLocation location = ResourceLocation.withDefaultNamespace("warhammer");

                    return createAttributeModifiers(builder).build();
                }
        );
    }



    @Override
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.playSound(SoundEvents.ANVIL_HIT);
        player.playSound(SoundEvents.GENERIC_EXPLODE.value());
        player.getCooldowns().addCooldown(itemstack,1000);

        List<LivingEntity> list = level.getEntitiesOfClass(LivingEntity.class,player.getBoundingBox().inflate(10.0));
        list.removeIf(player::isAlliedTo);
        list.removeIf(living -> living.is(player));
        list.forEach(entity -> {
            entity.push(entity.getEyePosition().subtract(player.position()).add(0,0.5F,0));
            entity.hurt(player.damageSources().magic(),10F);
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,200,1));

        });
        return InteractionResult.SUCCESS;
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        double d0 = (double)(-Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double)Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0));
        if (pAttacker.level() instanceof ServerLevel) {
            ((ServerLevel)pAttacker.level()).sendParticles(ParticleTypes.GUST, pAttacker.getX() + d0, pAttacker.getY(0.5), pAttacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    protected ItemAttributeModifiers.Builder createAttributeModifiers(ItemAttributeModifiers.Builder builder){
        ResourceLocation location = ResourceLocation.withDefaultNamespace("warhammer");


        builder.add(
                Attributes.ATTACK_DAMAGE,
                new AttributeModifier(location, 6, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_SPEED,
                new AttributeModifier(location, -3.3, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        builder.add(
                Attributes.ATTACK_KNOCKBACK,
                new AttributeModifier(location, 3F, AttributeModifier.Operation.ADD_VALUE),
                EquipmentSlotGroup.MAINHAND
        );
        return builder;
    }

    @Override
    public boolean isPrimaryItemFor(ItemStack stack, Holder<Enchantment> enchantment) {
        return stack.getItem() == MtaItems.GREAT_SENTINELS_WAR_HAMMER.get() && enchantment.is(Enchantments.FIRE_ASPECT) ||
                enchantment.is(Enchantments.SMITE) ||
                enchantment.is(Enchantments.DENSITY) ||
                enchantment.is(Enchantments.BANE_OF_ARTHROPODS) ||
                enchantment.is(Enchantments.BREACH) ||
                enchantment.is(Enchantments.UNBREAKING);
    }

    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.attributeModifiers.get();
    }

}
package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaEffects;
import com.fuyuaki.morethanadventure.world.item.weaponry.DoubleAxeItem;
import com.google.common.base.Suppliers;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class BerserkerBattleAxeItem extends DoubleAxeItem {


    public BerserkerBattleAxeItem(Tier pTier, Properties pProperties) {
        super(pTier, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));

    }


    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        if (pAttacker.hasEffect(MtaEffects.BERSERK)){
            int a = pAttacker.getEffect(MtaEffects.BERSERK).getAmplifier();
            int t = pAttacker.getEffect(MtaEffects.BERSERK).getDuration();
            pAttacker.addEffect(new MobEffectInstance(MtaEffects.BERSERK,t + 20,a + 1));
        }

        double d0 = (double)(-Mth.sin(pAttacker.getYRot() * (float) (Math.PI / 180.0)));
        double d1 = (double)Mth.cos(pAttacker.getYRot() * (float) (Math.PI / 180.0));
        if (pAttacker.level() instanceof ServerLevel) {
            ((ServerLevel)pAttacker.level()).sendParticles(ParticleTypes.GUST, pAttacker.getX() + d0, pAttacker.getY(0.5), pAttacker.getZ() + d1, 0, d0, 0.0, d1, 0.0);
        }
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.getCooldowns().addCooldown(itemstack.getItem(),5000);
        player.playSound(SoundEvents.RAVAGER_ROAR,2.0F,0.5F);
        player.addEffect(new MobEffectInstance(MtaEffects.BERSERK,200,2));
        return InteractionResultHolder.success(itemstack);
    }

    public static ItemAttributeModifiers createAttributes(Tier p_330371_) {
        return createAttributes(p_330371_, 8.0F, -2.6F, 3.7F);
    }





    @Override
    public int getEnchantmentValue() {
        return 17;

    }
}

package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import com.fuyuaki.morethanadventure.world.item.weaponry.DoubleAxeItem;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

public class BerserkerBattleAxeItem extends DoubleAxeItem {


    public BerserkerBattleAxeItem(ToolMaterial pTier, Properties pProperties) {
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
    public InteractionResult use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemstack = player.getItemInHand(usedHand);
        player.getCooldowns().addCooldown(itemstack,5000);
        player.playSound(SoundEvents.RAVAGER_ROAR,2.0F,0.5F);
        player.addEffect(new MobEffectInstance(MtaEffects.BERSERK,200,2));
        return InteractionResult.SUCCESS;
    }




}

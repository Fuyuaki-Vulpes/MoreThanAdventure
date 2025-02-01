package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.world.entity.arrows.MTAArrowEntity;
import com.fuyuaki.morethanadventure.world.item.weaponry.ArcheryItem;
import com.google.common.base.Suppliers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AngelBowItem extends ArcheryItem {
    public static final int MAX_DRAW_DURATION = 20;
    public static final int DEFAULT_RANGE = 60;


    public AngelBowItem(Properties pProperties) {
        super(pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC),2.0F,true,10.0F,0.0F,SoundEvents.ARROW_SHOOT);

    }

    @Override
    public ItemUseAnimation getUseAnimation(ItemStack pStack) {
        return ItemUseAnimation.BOW;
    }


    @Override
    public int getDefaultProjectileRange() {
        return 60;
    }

    @Override
    protected Projectile createProjectile(Level pLevel, LivingEntity pShooter, ItemStack pWeapon, ItemStack pAmmo, boolean pIsCrit) {
        AbstractArrow abstractarrow = new MTAArrowEntity(pShooter,pLevel,10,0.7F,pWeapon);
        if (pIsCrit) {
            abstractarrow.setCritArrow(true);
        }

        return customArrow(abstractarrow, pAmmo, pWeapon);
    }



    @Override
    protected void shootProjectile(
            LivingEntity pShooter, Projectile pProjectile, int pIndex, float pVelocity, float pInaccuracy, float pAngle, @Nullable LivingEntity pTarget
    ) {
        pProjectile.shootFromRotation(pShooter, pShooter.getXRot(), pShooter.getYRot() + pAngle, 0.0F, pVelocity, pInaccuracy);
    }

    @Override
    public InteractionResult use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);

        InteractionResult ret = net.neoforged.neoforge.event.EventHooks.onArrowNock(itemstack, pLevel, pPlayer, pHand, true);
        if (ret != null) return ret;

        pPlayer.startUsingItem(pHand);
        return InteractionResult.CONSUME;

    }

    @Override
    public Predicate<ItemStack> getAllSupportedProjectiles() {
        return ARROW_ONLY;
    }

}

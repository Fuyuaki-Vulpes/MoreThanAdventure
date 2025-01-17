package com.fuyuaki.morethanadventure.world.item.weaponry;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;

public class ArcheryItem extends BowItem {
    private final float damageArrow;
    private final float pullDurationTicks;
    private final float inaccuracy;

    public ArcheryItem(Properties properties, float damage,boolean reinforced, float pullTicks, float inaccuracy) {
        super(properties.durability(reinforced ? 512 : 384).enchantable(1));
        this.damageArrow = damage;
        this.pullDurationTicks = pullTicks;
        this.inaccuracy = inaccuracy;
    }

    @Override
    public boolean releaseUsing(ItemStack pStack, Level pLevel, LivingEntity pEntityLiving, int pTimeLeft) {
        if (pEntityLiving instanceof Player player) {
            int i = this.getUseDuration(pStack, pEntityLiving) - pTimeLeft;

            i = net.neoforged.neoforge.event.EventHooks.onArrowLoose(pStack, pLevel, player, i,true);

            if (i < 0) return false;
            float f = this.getPowerForCharge(i);
            if (!((double) f < 0.1)) {
                List<ItemStack> list = draw(pStack, Items.ARROW.getDefaultInstance(), player);
                if (pLevel instanceof ServerLevel serverlevel) {
                    this.shoot(serverlevel, player, player.getUsedItemHand(), pStack, list, f * 4.0F, this.getInaccuracy(), f >= 0.8F, null);
                }

                pLevel.playSound(
                        null,
                        player.getX(),
                        player.getY(),
                        player.getZ(),
                        SoundEvents.ARROW_SHOOT,
                        SoundSource.PLAYERS,
                        1.0F,
                        1.0F / (pLevel.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F
                );
                player.awardStat(Stats.ITEM_USED.get(this));
            }
        }
        return true;
    }

    public float getDamageModifier() {
        return damageArrow;
    }

    public float getPullDurationTicks() {
        return pullDurationTicks;
    }

    public float getInaccuracy() {
        return inaccuracy;
    }


    public float getPowerForCharge(int charge) {
        float f = (float)charge / this.getPullDurationTicks();
        f = (f * f + f * 2.0F) / 3.0F;
        if (f > 1.0F) {
            f = 1.0F;
        }

        return f;
    }

}



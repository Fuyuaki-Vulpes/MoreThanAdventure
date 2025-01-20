package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class FlailItem extends WeaponItem{

    protected static final float attackSpeed = -2.2F;
    protected static final int attackDamage = 2;
    protected static final float range = 4.0F;

    public FlailItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,2.0F ,properties);
    }
    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_PUNCH.get();
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_FLAIL_ACTIONS.contains(itemAbility);
    }
}

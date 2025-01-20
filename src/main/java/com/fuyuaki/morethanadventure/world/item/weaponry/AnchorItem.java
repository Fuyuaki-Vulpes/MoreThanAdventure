package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class AnchorItem extends WeaponItem{

    protected static final float attackSpeed = -3.5025F;
    protected static final int attackDamage = 12;
    protected static final float range = 3.5F;

    public AnchorItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,3.5F ,properties);
    }
    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_PUNCH.get();
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_ANCHOR_ACTIONS.contains(itemAbility);
    }
}

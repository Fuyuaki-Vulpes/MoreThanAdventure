package com.fuyuaki.morethanadventure.world.item.weaponry;

import net.minecraft.world.item.ToolMaterial;

public class FlailItem extends WeaponItem{

    protected static final float attackSpeed = -2.5F;
    protected static final int attackDamage = 6;
    protected static final float range = 2.0F;

    public FlailItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,2.0F ,properties);
    }
}

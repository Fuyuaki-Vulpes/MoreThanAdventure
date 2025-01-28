package com.fuyuaki.morethanadventure.world.item.weaponry;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.fuyuaki.morethanadventure.world.item.MTAToolMaterials;
import com.fuyuaki.morethanadventure.world.item.WeaponAbilities;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.neoforge.common.ItemAbility;

public class FlailItem extends WeaponItem{

    protected static final float attackSpeed = -2.5F;
    protected static final float attackDamage = 4;
    protected static final float range = 10.0F;

    protected final ToolMaterial toolMaterial;
    public FlailItem(ToolMaterial tier, Properties properties) {
        super(tier, attackDamage, attackSpeed,range ,properties);

        this.toolMaterial = tier;
    }

    @Override
    public boolean spawnsParticleOnTarget() {
        return true;
    }

    @Override
    public SoundEvent getSwingSound() {
        return MtaSounds.FLAIL_SWING.get();
    }


    @Override
    public ParticleOptions getWeaponHitParticles() {
        if (toolMaterial.equals(ToolMaterial.WOOD)) return MtaParticles.FLAIL_WOOD.get();
        if (toolMaterial.equals(ToolMaterial.STONE)) return MtaParticles.FLAIL_STONE.get();
        if (toolMaterial.equals(ToolMaterial.GOLD)) return MtaParticles.FLAIL_GOLD.get();
        if (toolMaterial.equals(ToolMaterial.DIAMOND)) return MtaParticles.FLAIL_DIAMOND.get();
        if (toolMaterial.equals(ToolMaterial.NETHERITE)) return MtaParticles.FLAIL_NETHERITE.get();
        if (toolMaterial.equals(MTAToolMaterials.COPPER)) return MtaParticles.FLAIL_COPPER.get();
        if (toolMaterial.equals(MTAToolMaterials.NETHERSTEEL)) return MtaParticles.FLAIL_NETHERSTEEL.get();
        return MtaParticles.FLAIL_IRON.get();
    }

    @Override
    public SoundEvent getWeaponHitSound() {
        return MtaSounds.WEAPON_FLAIL.get();
    }
    @Override
    public boolean canPerformAction(ItemStack stack, ItemAbility itemAbility) {
        return WeaponAbilities.DEFAULT_FLAIL_ACTIONS.contains(itemAbility);
    }
}

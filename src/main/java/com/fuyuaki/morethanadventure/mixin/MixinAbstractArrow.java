package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.world.item.weaponry.ArcheryItem;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

@Mixin(AbstractArrow.class)
public abstract class MixinAbstractArrow extends Projectile {

    @Shadow @Nullable public IntOpenHashSet piercingIgnoreEntityIds;

    @Shadow public double baseDamage;

    @Shadow @Nullable private ItemStack firedFromWeapon;

    @Shadow public abstract byte getPierceLevel();

    protected MixinAbstractArrow(EntityType<? extends Projectile> p_37248_, Level p_37249_) {
        super(p_37248_, p_37249_);
    }

    @Inject(method = "onHitEntity",at = @At("HEAD"))
    private void onHitEntityMixin(EntityHitResult result, CallbackInfo ci){
        if (this.piercingIgnoreEntityIds == null || this.getPierceLevel() == 0){
            if (this.firedFromWeapon != null && firedFromWeapon.getItem() instanceof ArcheryItem archeryItem) {
                this.baseDamage = this.baseDamage * archeryItem.getDamageModifier();
            }
        }
    }
}

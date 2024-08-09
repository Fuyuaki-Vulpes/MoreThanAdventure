package com.fuyuvulpes.morethanadventure.mixin;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.openjdk.nashorn.internal.ir.annotations.Ignore;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TamableAnimal.class)
public abstract class TamableAnimalMixin extends Animal {
    @Shadow public abstract boolean isTame();



    protected TamableAnimalMixin(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @SuppressWarnings("DataFlowIssue")
    @Inject(method = "applyTamingSideEffects()V", at = @At("HEAD"))
    private void tamingSideEffects(CallbackInfo ci) {

        if (this.isTame()) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(80.0);
            this.setHealth(40.0F);
        }
    }

}

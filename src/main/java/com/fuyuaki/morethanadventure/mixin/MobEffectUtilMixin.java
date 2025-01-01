package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.world.item.accessories.talisman.AttributeModifierTalismanItem;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobEffectUtil.class)
public class MobEffectUtilMixin {


    @Inject(method = "hasWaterBreathing",at = @At("RETURN"), cancellable = true)
    private static void hasWaterBreathing(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        if (AttributeModifierTalismanItem.enableScubaGearEffects(entity)){
            cir.setReturnValue(true);

        }
    }


}

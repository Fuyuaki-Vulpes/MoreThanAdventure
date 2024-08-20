package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.world.item.MTAEnchantmentProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.item.enchantment.providers.EnchantmentProvider;
import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(VanillaEnchantmentProviders.class)
public interface VanillaEnchantmentProviderMixin {


    @Inject(method = "bootstrap(Lnet/minecraft/data/worldgen/BootstrapContext;)V",at = @At("TAIL"))
    private static void addModBootstrap(BootstrapContext<EnchantmentProvider> pContext, CallbackInfo ci){
        MTAEnchantmentProvider.bootstrap(pContext);
    }
}

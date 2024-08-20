package com.fuyuaki.morethanadventure.world.item;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.providers.EnchantmentProvider;
import net.minecraft.world.item.enchantment.providers.EnchantmentsByCostWithDifficulty;
import net.minecraft.world.item.enchantment.providers.VanillaEnchantmentProviders;

public interface MTAEnchantmentProvider extends VanillaEnchantmentProviders{
    ResourceKey<EnchantmentProvider> WITHER_JUGGERNAUT = VanillaEnchantmentProviders.create("wither_juggernaut");

    static void bootstrap(BootstrapContext<EnchantmentProvider> pContext) {
        HolderGetter<Enchantment> holdergetter = pContext.lookup(Registries.ENCHANTMENT);
        pContext.register(WITHER_JUGGERNAUT, new EnchantmentsByCostWithDifficulty(holdergetter.getOrThrow(EnchantmentTags.ON_RANDOM_LOOT), 5, 17));


    }

}


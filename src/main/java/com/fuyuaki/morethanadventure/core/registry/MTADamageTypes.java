package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTADamageTypes {
    public static final ResourceKey<DamageType> BLEEDING = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, "bleeding"));
    public static final ResourceKey<DamageType> VENOM = ResourceKey.create(Registries.DAMAGE_TYPE, ResourceLocation.fromNamespaceAndPath(MODID, "venom"));



}

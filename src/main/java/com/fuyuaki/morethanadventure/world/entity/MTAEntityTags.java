package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class MTAEntityTags {
        public static final TagKey<EntityType<?>> DARK = create("dark");



        private static TagKey<EntityType<?>> create(String pName) {
                return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace(pName));
        }


}

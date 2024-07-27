package com.fuyuvulpes.morethanadventure.core.registry;

import com.fuyuvulpes.morethanadventure.world.entity.FallenSamurai;
import com.fuyuvulpes.morethanadventure.world.entity.YukiOnna;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);


    public static final DeferredHolder<EntityType<?>,EntityType<FallenSamurai>> FALLEN_SAMURAI = ENTITY.register("fallen_samurai",
            () -> EntityType.Builder.<FallenSamurai>of(FallenSamurai::new, MobCategory.MONSTER)
                    .sized(0.8f,2.2F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID, "fallen_samurai").toString()));



    public static final DeferredHolder<EntityType<?>,EntityType<YukiOnna>> YUKI_ONNA = ENTITY.register("yuki_onna",
            () -> EntityType.Builder.<YukiOnna>of(YukiOnna::new, MobCategory.MONSTER)
                    .sized(0.8f,1.9F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"fallen_samurai").toString()));


    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }
}

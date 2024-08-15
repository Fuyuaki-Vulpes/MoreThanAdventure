package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);


    public static final DeferredHolder<EntityType<?>,EntityType<FallenSamurai>> FALLEN_SAMURAI = ENTITY.register("fallen_samurai",
            () -> EntityType.Builder.<FallenSamurai>of(FallenSamurai::new, MobCategory.MONSTER)
                    .sized(0.8f,2.2F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID, "fallen_samurai").toString()));



    public static final DeferredHolder<EntityType<?>,EntityType<YukiOnna>> YUKI_ONNA = ENTITY.register("yuki_onna",
            () -> EntityType.Builder.<YukiOnna>of(YukiOnna::new, MobCategory.MONSTER)
                    .sized(0.8f,1.9F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"yuki_onna").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Butterfly>> BUTTERFLY = ENTITY.register("butterfly",
            () -> EntityType.Builder.<Butterfly>of(Butterfly::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"butterfly").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BeardedDragon>> BEARDED_DRAGON = ENTITY.register("bearded_dragon",
            () -> EntityType.Builder.<BeardedDragon>of(BeardedDragon::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"bearded_dragon").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Capybara>> CAPIBARA = ENTITY.register("capybara",
            () -> EntityType.Builder.<Capybara>of(Capybara::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"capybara").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Duck>> DUCK = ENTITY.register("duck",
            () -> EntityType.Builder.<Duck>of(Duck::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"duck").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Ferret>> FERRET = ENTITY.register("ferret",
            () -> EntityType.Builder.<Ferret>of(Ferret::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"ferret").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<HorseshoeCrab>> HORSESHOE_CRAB = ENTITY.register("horseshoe_crab",
            () -> EntityType.Builder.<HorseshoeCrab>of(HorseshoeCrab::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"horseshoe_crab").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Jellyfish>> JELLYFISH = ENTITY.register("jellyfish",
            () -> EntityType.Builder.<Jellyfish>of(Jellyfish::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"jellyfish").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Octopus>> OCTOPUS = ENTITY.register("octopus",
            () -> EntityType.Builder.<Octopus>of(Octopus::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"octopus").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Owl>> OWL = ENTITY.register("owl",
            () -> EntityType.Builder.<Owl>of(Owl::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"owl").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Penguin>> PENGUIN = ENTITY.register("penguin",
            () -> EntityType.Builder.<Penguin>of(Penguin::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"penguin").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<GreatWhiteShark>> GREAT_WHITE_SHARK = ENTITY.register("great_white_shark",
            () -> EntityType.Builder.<GreatWhiteShark>of(GreatWhiteShark::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"great_white_shark").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Shrimp>> SHRIMP = ENTITY.register("shirmp",
            () -> EntityType.Builder.<Shrimp>of(Shrimp::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"shrimp").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Toucan>> TOUCAN = ENTITY.register("toucan",
            () -> EntityType.Builder.<Toucan>of(Toucan::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"toucan").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Raccoon>> RACCOON = ENTITY.register("raccoon",
            () -> EntityType.Builder.<Raccoon>of(Raccoon::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"raccoon").toString()));


    public static final DeferredHolder<EntityType<?>,EntityType<ThrownNetheriteTrident>> NETHERITE_TRIDENT = ENTITY.register("netherite_trident",
            () -> EntityType.Builder.<ThrownNetheriteTrident>of(ThrownNetheriteTrident::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"netherite_trident").toString()));


    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }
}

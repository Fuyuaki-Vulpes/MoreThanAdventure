package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.world.entity.Arrows.MTAArrowEntity;
import com.fuyuaki.morethanadventure.world.entity.WitherJuggernaut;
import com.fuyuaki.morethanadventure.world.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
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

    public static final DeferredHolder<EntityType<?>,EntityType<WitherJuggernaut>> WITHER_JUGGERNAUT = ENTITY.register("wither_juggernaut",
            () -> EntityType.Builder.<WitherJuggernaut>of(WitherJuggernaut::new, MobCategory.MONSTER)
                    .sized(0.9f,3.0F)
                    .fireImmune()
                    .build(ResourceLocation.fromNamespaceAndPath(MODID, "wither_juggernaut").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<YukiOnna>> YUKI_ONNA = ENTITY.register("yuki_onna",
            () -> EntityType.Builder.<YukiOnna>of(YukiOnna::new, MobCategory.MONSTER)
                    .sized(0.8f,1.9F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"yuki_onna").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<IcicleCreeper>> ICICLE_CREEPER = ENTITY.register("icicle_creeper",
            () -> EntityType.Builder.<IcicleCreeper>of(IcicleCreeper::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"icicle_creeper").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ArmoredSkeleton>> ARMORED_SKELETON = ENTITY.register("armored_skeleton",
            () -> EntityType.Builder.<ArmoredSkeleton>of(ArmoredSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"armored_skeleton").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BlackWidow>> BLACK_WIDOW = ENTITY.register("black_widow",
            () -> EntityType.Builder.<BlackWidow>of(BlackWidow::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"black_widow").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<CharredSkeleton>> CHARRED_SKELETON = ENTITY.register("charred_skeleton",
            () -> EntityType.Builder.<CharredSkeleton>of(CharredSkeleton::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"charred_skeleton").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<CorrosiveCube>> CORROSIVE_CUBE = ENTITY.register("corrosive_cube",
            () -> EntityType.Builder.<CorrosiveCube>of(CorrosiveCube::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .spawnDimensionsScale(4.0F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"corrosive_cube").toString()));
    public static final DeferredHolder<EntityType<?>,EntityType<FrostedSlime>> FROSTED_SLIME = ENTITY.register("frosted_slime",
            () -> EntityType.Builder.<FrostedSlime>of(FrostedSlime::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .spawnDimensionsScale(4.0F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"frosted_slime").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<GlowSpider>> GLOW_SPIDER = ENTITY.register("glow_spider",
            () -> EntityType.Builder.<GlowSpider>of(GlowSpider::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"glow_spider").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Host>> HOST = ENTITY.register("host",
            () -> EntityType.Builder.<Host>of(Host::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"host").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<MossyZombie>> MOSSY_ZOMBIE = ENTITY.register("mossy_zombie",
            () -> EntityType.Builder.<MossyZombie>of(MossyZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"mossy_zombie").toString()));


    public static final DeferredHolder<EntityType<?>,EntityType<SkeletonFighter>> SKELETON_FIGHTER = ENTITY.register("skeleton_fighter",
            () -> EntityType.Builder.<SkeletonFighter>of(SkeletonFighter::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"skeleton_fighter").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ToxicZombie>> TOXIC_ZOMBIE = ENTITY.register("toxic_zombie",
            () -> EntityType.Builder.<ToxicZombie>of(ToxicZombie::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"toxic_zombie").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ZombifiedMiner>> ZOMBIFIED_MINER = ENTITY.register("zombified_miner",
            () -> EntityType.Builder.<ZombifiedMiner>of(ZombifiedMiner::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"zombified_miner").toString()));





    public static final DeferredHolder<EntityType<?>,EntityType<Butterfly>> BUTTERFLY = ENTITY.register("butterfly",
            () -> EntityType.Builder.<Butterfly>of(Butterfly::new, MobCategory.CREATURE)
                    .sized(0.3f,0.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"butterfly").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<BeardedDragon>> BEARDED_DRAGON = ENTITY.register("bearded_dragon",
            () -> EntityType.Builder.<BeardedDragon>of(BeardedDragon::new, MobCategory.CREATURE)
                    .sized(0.6f,0.30F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"bearded_dragon").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Capybara>> CAPIBARA = ENTITY.register("capybara",
            () -> EntityType.Builder.<Capybara>of(Capybara::new, MobCategory.CREATURE)
                    .sized(0.8f,0.6F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"capybara").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Duck>> DUCK = ENTITY.register("duck",
            () -> EntityType.Builder.<Duck>of(Duck::new, MobCategory.CREATURE)
                    .sized(0.5f,0.5F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"duck").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Ferret>> FERRET = ENTITY.register("ferret",
            () -> EntityType.Builder.<Ferret>of(Ferret::new, MobCategory.CREATURE)
                    .sized(0.8f,0.33F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"ferret").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<HorseshoeCrab>> HORSESHOE_CRAB = ENTITY.register("horseshoe_crab",
            () -> EntityType.Builder.<HorseshoeCrab>of(HorseshoeCrab::new, MobCategory.WATER_CREATURE)
                    .sized(0.7f,0.25F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"horseshoe_crab").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Jellyfish>> JELLYFISH = ENTITY.register("jellyfish",
            () -> EntityType.Builder.<Jellyfish>of(Jellyfish::new, MobCategory.WATER_CREATURE)
                    .sized(0.8f,0.5F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"jellyfish").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Octopus>> OCTOPUS = ENTITY.register("octopus",
            () -> EntityType.Builder.<Octopus>of(Octopus::new, MobCategory.WATER_CREATURE)
                    .sized(1.5f,0.6F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"octopus").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Owl>> OWL = ENTITY.register("owl",
            () -> EntityType.Builder.<Owl>of(Owl::new, MobCategory.CREATURE)
                    .sized(0.7f,0.7F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"owl").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Penguin>> PENGUIN = ENTITY.register("penguin",
            () -> EntityType.Builder.<Penguin>of(Penguin::new, MobCategory.CREATURE)
                    .sized(0.55f,0.95F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"penguin").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<GreatWhiteShark>> GREAT_WHITE_SHARK = ENTITY.register("great_white_shark",
            () -> EntityType.Builder.<GreatWhiteShark>of(GreatWhiteShark::new, MobCategory.WATER_CREATURE)
                    .sized(3.5f,1.3F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"great_white_shark").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Shrimp>> SHRIMP = ENTITY.register("shirmp",
            () -> EntityType.Builder.<Shrimp>of(Shrimp::new, MobCategory.WATER_CREATURE)
                    .sized(0.4f,0.35F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"shrimp").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Toucan>> TOUCAN = ENTITY.register("toucan",
            () -> EntityType.Builder.<Toucan>of(Toucan::new, MobCategory.CREATURE)
                    .sized(0.45f,0.45f)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"toucan").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<Raccoon>> RACCOON = ENTITY.register("raccoon",
            () -> EntityType.Builder.<Raccoon>of(Raccoon::new, MobCategory.CREATURE)
                    .sized(0.9f,0.62F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"raccoon").toString()));




    public static final DeferredHolder<EntityType<?>,EntityType<Wispfly>> WISPFLY = ENTITY.register("wispfly",
            () -> EntityType.Builder.<Wispfly>of(Wispfly::new, MobCategory.CREATURE)
                    .sized(0.4f,0.4F)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"wispfly").toString()));







    public static final DeferredHolder<EntityType<?>,EntityType<ThrownNetheriteTrident>> NETHERITE_TRIDENT = ENTITY.register("netherite_trident",
            () -> EntityType.Builder.<ThrownNetheriteTrident>of(ThrownNetheriteTrident::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"netherite_trident").toString()));

    public static final DeferredHolder<EntityType<?>,EntityType<ThrownMysticMermaidsTrident>> MYSTIC_MERMAIDS_TRIDENT = ENTITY.register("mystic_mermaids_trident",
            () -> EntityType.Builder.<ThrownMysticMermaidsTrident>of(ThrownMysticMermaidsTrident::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"mystic_mermaids_trident").toString()));


    public static final DeferredHolder<EntityType<?>,EntityType<MTAArrowEntity>> MTA_ARROW = ENTITY.register("mta_arrow",
            () -> EntityType.Builder.<MTAArrowEntity>of(MTAArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .build(ResourceLocation.fromNamespaceAndPath(MODID,"mta_arrow").toString()));


    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }
}

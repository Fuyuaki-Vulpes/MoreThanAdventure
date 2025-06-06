package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.entity.*;
import com.fuyuaki.morethanadventure.world.entity.arrows.MTAArrowEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY = DeferredRegister.create(Registries.ENTITY_TYPE, MODID);



    public static final DeferredHolder<EntityType<?>, EntityType<SoulOrb>> SOUL_ORB = ENTITY.register("soul_orb",
            () -> EntityType.Builder.<SoulOrb>of(SoulOrb::new, MobCategory.MISC)
                    .noLootTable()
                    .sized(0.5F, 0.5F)
                    .clientTrackingRange(6)
                    .updateInterval(20)
                    .build(entityKey("soul_orb"))

    );

//Boats

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> ALPINE_BOAT = ENTITY.register("alpine_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.ALPINE_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("alpine_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> ALPINE_CHEST_BOAT = ENTITY.register("alpine_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.ALPINE_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("alpine_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> AVOCADO_BOAT = ENTITY.register("avocado_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.AVOCADO_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("avocado_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> AVOCADO_CHEST_BOAT = ENTITY.register("avocado_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.AVOCADO_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("avocado_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> BOGGED_OAK_BOAT = ENTITY.register("bogged_oak_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.BOGGED_OAK_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("bogged_oak_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> BOGGED_OAK_CHEST_BOAT = ENTITY.register("bogged_oak_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.BOGGED_OAK_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("bogged_oak_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> IPE_BOAT = ENTITY.register("ipe_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.IPE_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("ipe_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> IPE_CHEST_BOAT = ENTITY.register("ipe_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.IPE_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("ipe_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> MANGO_BOAT = ENTITY.register("mango_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.MANGO_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("mango_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> MANGO_CHEST_BOAT = ENTITY.register("mango_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.MANGO_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("mango_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> MAPLE_BOAT = ENTITY.register("maple_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.MAPLE_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("maple_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> MAPLE_CHEST_BOAT = ENTITY.register("maple_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.MAPLE_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("maple_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> PALM_BOAT = ENTITY.register("palm_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.PALM_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("palm_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> PALM_CHEST_BOAT = ENTITY.register("palm_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.PALM_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("palm_chest_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<Boat>> SEAWOOD_BOAT = ENTITY.register("seawood_boat",
        () -> EntityType.Builder.<Boat>of(boatFactory(() -> MtaItems.SEAWOOD_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("seawood_boat")));

public static final DeferredHolder<EntityType<?>, EntityType<ChestBoat>> SEAWOOD_CHEST_BOAT = ENTITY.register("seawood_chest_boat",
        () -> EntityType.Builder.of(chestBoatFactory(() -> MtaItems.SEAWOOD_CHEST_BOAT.get()), MobCategory.MISC)
                .noLootTable()
                .sized(1.375F, 0.5625F)
                .eyeHeight(0.5625F)
                .clientTrackingRange(10)
                .build(entityKey("seawood_chest_boat")));

// Tamable

    public static final DeferredHolder<EntityType<?>,EntityType<BeardedDragon>> BEARDED_DRAGON = ENTITY.register("bearded_dragon",
            () -> EntityType.Builder.<BeardedDragon>of(BeardedDragon::new, MobCategory.CREATURE)
                    .sized(0.6f,0.30F)
                    .build(entityKey("bearded_dragon")));

    public static final DeferredHolder<EntityType<?>,EntityType<Capybara>> CAPIBARA = ENTITY.register("capybara",
            () -> EntityType.Builder.<Capybara>of(Capybara::new, MobCategory.CREATURE)
                    .sized(0.8f,0.6F)
                    .build(entityKey("capybara")));

    public static final DeferredHolder<EntityType<?>,EntityType<Duck>> DUCK = ENTITY.register("duck",
            () -> EntityType.Builder.<Duck>of(Duck::new, MobCategory.CREATURE)
                    .sized(0.5f,0.5F)
                    .build(entityKey("duck")));

    public static final DeferredHolder<EntityType<?>,EntityType<Ferret>> FERRET = ENTITY.register("ferret",
            () -> EntityType.Builder.<Ferret>of(Ferret::new, MobCategory.CREATURE)
                    .sized(0.8f,0.33F)
                    .build(entityKey("ferret")));

    public static final DeferredHolder<EntityType<?>,EntityType<HorseshoeCrab>> HORSESHOE_CRAB = ENTITY.register("horseshoe_crab",
            () -> EntityType.Builder.<HorseshoeCrab>of(HorseshoeCrab::new, MobCategory.WATER_CREATURE)
                    .sized(0.7f,0.25F)
                    .build(entityKey("horseshoe_crab")));

    public static final DeferredHolder<EntityType<?>,EntityType<Octopus>> OCTOPUS = ENTITY.register("octopus",
            () -> EntityType.Builder.<Octopus>of(Octopus::new, MobCategory.WATER_CREATURE)
                    .sized(1.5f,0.6F)
                    .build(entityKey("octopus")));

    public static final DeferredHolder<EntityType<?>,EntityType<Owl>> OWL = ENTITY.register("owl",
            () -> EntityType.Builder.<Owl>of(Owl::new, MobCategory.CREATURE)
                    .sized(0.7f,0.7F)
                    .build(entityKey("owl")));

    public static final DeferredHolder<EntityType<?>,EntityType<Penguin>> PENGUIN = ENTITY.register("penguin",
            () -> EntityType.Builder.<Penguin>of(Penguin::new, MobCategory.CREATURE)
                    .sized(0.55f,0.95F)
                    .build(entityKey("penguin")));

    public static final DeferredHolder<EntityType<?>,EntityType<Raccoon>> RACCOON = ENTITY.register("raccoon",
            () -> EntityType.Builder.<Raccoon>of(Raccoon::new, MobCategory.CREATURE)
                    .sized(0.9f,0.62F)
                    .build(entityKey("raccoon")));

    public static final DeferredHolder<EntityType<?>,EntityType<Toucan>> TOUCAN = ENTITY.register("toucan",
            () -> EntityType.Builder.<Toucan>of(Toucan::new, MobCategory.CREATURE)
                    .sized(0.45f,0.45f)
                    .build(entityKey("toucan")));

    public static final DeferredHolder<EntityType<?>,EntityType<Wispfly>> WISPFLY = ENTITY.register("wispfly",
            () -> EntityType.Builder.<Wispfly>of(Wispfly::new, MobCategory.CREATURE)
                    .sized(0.4f,0.4F)
                    .build(entityKey("wispfly")));


// Passive


    public static final DeferredHolder<EntityType<?>,EntityType<Butterfly>> BUTTERFLY = ENTITY.register("butterfly",
            () -> EntityType.Builder.<Butterfly>of(Butterfly::new, MobCategory.AMBIENT)
                    .sized(0.3f,0.3F)
                    .build(entityKey("butterfly")));

    public static final DeferredHolder<EntityType<?>,EntityType<Deer>> DEER = ENTITY.register("deer",
            () -> EntityType.Builder.<Deer>of(Deer::new, MobCategory.CREATURE)
                    .sized(0.9F, 1.6F).eyeHeight(1.35F)
                    .build(entityKey("deer")));

    public static final DeferredHolder<EntityType<?>,EntityType<Jellyfish>> JELLYFISH = ENTITY.register("jellyfish",
            () -> EntityType.Builder.<Jellyfish>of(Jellyfish::new, MobCategory.WATER_CREATURE)
                    .sized(0.9f,0.9F)
                    .build(entityKey("jellyfish")));

    public static final DeferredHolder<EntityType<?>,EntityType<Shrimp>> SHRIMP = ENTITY.register("shirmp",
            () -> EntityType.Builder.<Shrimp>of(Shrimp::new, MobCategory.WATER_CREATURE)
                    .sized(0.4f,0.35F)
                    .build(entityKey("shrimp")));


//Neutral


    public static final DeferredHolder<EntityType<?>,EntityType<GreatWhiteShark>> GREAT_WHITE_SHARK = ENTITY.register("great_white_shark",
            () -> EntityType.Builder.<GreatWhiteShark>of(GreatWhiteShark::new, MobCategory.WATER_CREATURE)
                    .sized(3.5f,1.3F)
                    .build(entityKey("great_white_shark")));

    public static final DeferredHolder<EntityType<?>,EntityType<Turkey>> TURKEY = ENTITY.register("turkey",
            () -> EntityType.Builder.<Turkey>of(Turkey::new, MobCategory.CREATURE)
                    .sized(1.1f,1.35f).eyeHeight(1.25F)
                    .build(entityKey("turkey")));


//Hostile


    public static final DeferredHolder<EntityType<?>,EntityType<FallenSamurai>> FALLEN_SAMURAI = ENTITY.register("fallen_samurai",
            () -> EntityType.Builder.<FallenSamurai>of(FallenSamurai::new, MobCategory.MONSTER)
                    .sized(0.8f,2.2F)
                    .build(entityKey("fallen_samurai")));

    public static final DeferredHolder<EntityType<?>,EntityType<YukiOnna>> YUKI_ONNA = ENTITY.register("yuki_onna",
            () -> EntityType.Builder.<YukiOnna>of(YukiOnna::new, MobCategory.MONSTER)
                    .sized(0.8f,1.9F)
                    .build(entityKey("yuki_onna")));

    public static final DeferredHolder<EntityType<?>,EntityType<IcicleCreeper>> ICICLE_CREEPER = ENTITY.register("icicle_creeper",
            () -> EntityType.Builder.<IcicleCreeper>of(IcicleCreeper::new, MobCategory.MONSTER)
                    .sized(0.6F, 1.7F)
                    .build(entityKey("icicle_creeper")));

    public static final DeferredHolder<EntityType<?>,EntityType<ArmoredSkeleton>> ARMORED_SKELETON = ENTITY.register("armored_skeleton",
            () -> EntityType.Builder.<ArmoredSkeleton>of(ArmoredSkeleton::new, MobCategory.MONSTER)
                    .sized(0.675F, 2.1F)
                    .build(entityKey("armored_skeleton")));
    public static final DeferredHolder<EntityType<?>,EntityType<WitherSoldierEntity>> WITHER_SOLDIER = ENTITY.register("wither_soldier",
            () -> EntityType.Builder.<WitherSoldierEntity>of(WitherSoldierEntity::new, MobCategory.MONSTER)
                    .fireImmune()
                    .immuneTo(Blocks.WITHER_ROSE)
                    .sized(0.7F, 2.4F)
                    .eyeHeight(2.1F)
                    .ridingOffset(-0.875F)
                    .build(entityKey("wither_soldier")));

    public static final DeferredHolder<EntityType<?>,EntityType<BlackWidow>> BLACK_WIDOW = ENTITY.register("black_widow",
            () -> EntityType.Builder.<BlackWidow>of(BlackWidow::new, MobCategory.MONSTER)
                    .sized(1.55F, 0.725F)
                    .build(entityKey("black_widow")));

    public static final DeferredHolder<EntityType<?>,EntityType<CharredSkeleton>> CHARRED_SKELETON = ENTITY.register("charred_skeleton",
            () -> EntityType.Builder.<CharredSkeleton>of(CharredSkeleton::new, MobCategory.MONSTER)
                    .sized(0.675F, 2.1F)
                    .build(entityKey("charred_skeleton")));

    public static final DeferredHolder<EntityType<?>,EntityType<CorrosiveCube>> CORROSIVE_CUBE = ENTITY.register("corrosive_cube",
            () -> EntityType.Builder.<CorrosiveCube>of(CorrosiveCube::new, MobCategory.MONSTER)
                    .sized(0.55F, 0.55F)
                    .spawnDimensionsScale(4.0F)
                    .build(entityKey("corrosive_cube")));
    public static final DeferredHolder<EntityType<?>,EntityType<FrostedSlime>> FROSTED_SLIME = ENTITY.register("frosted_slime",
            () -> EntityType.Builder.<FrostedSlime>of(FrostedSlime::new, MobCategory.MONSTER)
                    .sized(0.55F, 0.55F)
                    .spawnDimensionsScale(4.0F)
                    .build(entityKey("frosted_slime")));

    public static final DeferredHolder<EntityType<?>,EntityType<GlowSpider>> GLOW_SPIDER = ENTITY.register("glow_spider",
            () -> EntityType.Builder.<GlowSpider>of(GlowSpider::new, MobCategory.MONSTER)
                    .sized(0.725F, 0.40F)
                    .build(entityKey("glow_spider")));

    public static final DeferredHolder<EntityType<?>,EntityType<Host>> HOST = ENTITY.register("host",
            () -> EntityType.Builder.<Host>of(Host::new, MobCategory.MONSTER)
                    .sized(0.85F, 2.05F)
                    .build(entityKey("host")));

    public static final DeferredHolder<EntityType<?>,EntityType<MossyZombie>> MOSSY_ZOMBIE = ENTITY.register("mossy_zombie",
            () -> EntityType.Builder.<MossyZombie>of(MossyZombie::new, MobCategory.MONSTER)
                    .sized(0.85F, 2.05F)
                    .build(entityKey("mossy_zombie")));


    public static final DeferredHolder<EntityType<?>,EntityType<SkeletonFighter>> SKELETON_FIGHTER = ENTITY.register("skeleton_fighter",
            () -> EntityType.Builder.<SkeletonFighter>of(SkeletonFighter::new, MobCategory.MONSTER)
                    .sized(0.675F, 2.1F)
                    .build(entityKey("skeleton_fighter")));

    public static final DeferredHolder<EntityType<?>,EntityType<ToxicZombie>> TOXIC_ZOMBIE = ENTITY.register("toxic_zombie",
            () -> EntityType.Builder.<ToxicZombie>of(ToxicZombie::new, MobCategory.MONSTER)
                    .sized(0.85F, 2.05F)
                    .build(entityKey("toxic_zombie")));

    public static final DeferredHolder<EntityType<?>,EntityType<ZombifiedMiner>> ZOMBIFIED_MINER = ENTITY.register("zombified_miner",
            () -> EntityType.Builder.<ZombifiedMiner>of(ZombifiedMiner::new, MobCategory.MONSTER)
                    .sized(0.85F, 2.05F)
                    .build(entityKey("zombified_miner")));

    public static final DeferredHolder<EntityType<?>,EntityType<Siren>> SIREN = ENTITY.register("siren",
            () -> EntityType.Builder.<Siren>of(Siren::new, MobCategory.MONSTER)
                    .sized(0.85F, 2.0F)
                    .build(entityKey("siren")));

//Objects



    public static final DeferredHolder<EntityType<?>,EntityType<ThrownNetheriteTrident>> NETHERITE_TRIDENT = ENTITY.register("netherite_trident",
            () -> EntityType.Builder.<ThrownNetheriteTrident>of(ThrownNetheriteTrident::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .noLootTable().build(entityKey("netherite_trident")));

    public static final DeferredHolder<EntityType<?>,EntityType<ThrownMysticMermaidsTrident>> MYSTIC_MERMAIDS_TRIDENT = ENTITY.register("mystic_mermaids_trident",
            () -> EntityType.Builder.<ThrownMysticMermaidsTrident>of(ThrownMysticMermaidsTrident::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .noLootTable().build(entityKey("mystic_mermaids_trident")));


    public static final DeferredHolder<EntityType<?>,EntityType<MTAArrowEntity>> MTA_ARROW = ENTITY.register("mta_arrow",
            () -> EntityType.Builder.<MTAArrowEntity>of(MTAArrowEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).eyeHeight(0.13F).clientTrackingRange(4).updateInterval(20)
                    .noLootTable().build(entityKey("mta_arrow")));


    public static void register(IEventBus eventBus){
        ENTITY.register(eventBus);
    }

    private static EntityType.EntityFactory<Boat> boatFactory(Supplier<Item> boatItemGetter) {
        return (entityType, level) -> new Boat(entityType, level, boatItemGetter);
    }

    private static EntityType.EntityFactory<ChestBoat> chestBoatFactory(Supplier<Item> boatItemGetter) {
        return (entityType, level) -> new ChestBoat(entityType, level, boatItemGetter);
    }

    private static ResourceKey<EntityType<?>> entityKey(String name) {
        return ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(MODID,name));
    }

}

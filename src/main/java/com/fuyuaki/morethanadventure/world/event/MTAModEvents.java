package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttributes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.world.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

@EventBusSubscriber(modid = MODID,bus = EventBusSubscriber.Bus.MOD)
public class MTAModEvents {

    @SubscribeEvent
    public static void registerCapabilitiesEvent(RegisterCapabilitiesEvent event){
        for (Block block : BuiltInRegistries.BLOCK) {

        }


    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){

        event.put(MtaEntityTypes.BEARDED_DRAGON.get(), BeardedDragon.createAttributes().build());
        event.put(MtaEntityTypes.CAPIBARA.get(), Capybara.createAttributes().build());
        event.put(MtaEntityTypes.DUCK.get(), Duck.createAttributes().build());
        event.put(MtaEntityTypes.FERRET.get(), Ferret.createAttributes().build());
        event.put(MtaEntityTypes.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
        event.put(MtaEntityTypes.OCTOPUS.get(), Octopus.createAttributes().build());
        event.put(MtaEntityTypes.OWL.get(), Owl.createAttributes().build());
        event.put(MtaEntityTypes.PENGUIN.get(), Penguin.createAttributes().build());
        event.put(MtaEntityTypes.RACCOON.get(), Raccoon.createAttributes().build());
        event.put(MtaEntityTypes.TOUCAN.get(), Toucan.createAttributes().build());
        event.put(MtaEntityTypes.WISPFLY.get(), Wispfly.createAttributes().build());

        event.put(MtaEntityTypes.BUTTERFLY.get(), Butterfly.createAttributes().build());
        event.put(MtaEntityTypes.DEER.get(), Deer.createAttributes().build());
        event.put(MtaEntityTypes.JELLYFISH.get(), Jellyfish.createAttributes().build());
        event.put(MtaEntityTypes.SHRIMP.get(), Shrimp.createAttributes().build());

        event.put(MtaEntityTypes.GREAT_WHITE_SHARK.get(), GreatWhiteShark.createAttributes().build());
        event.put(MtaEntityTypes.TURKEY.get(), Turkey.createAttributes().build());

        event.put(MtaEntityTypes.ARMORED_SKELETON.get(), ArmoredSkeleton.createAttributes().build());
        event.put(MtaEntityTypes.BLACK_WIDOW.get(), BlackWidow.createAttributes().build());
        event.put(MtaEntityTypes.CHARRED_SKELETON.get(), CharredSkeleton.createAttributes().build());
        event.put(MtaEntityTypes.CORROSIVE_CUBE.get(), CorrosiveCube.createAttributes().build());
        event.put(MtaEntityTypes.FALLEN_SAMURAI.get(), FallenSamurai.createAttributes().build());
        event.put(MtaEntityTypes.FROSTED_SLIME.get(), FrostedSlime.createAttributes().build());
        event.put(MtaEntityTypes.GLOW_SPIDER.get(), GlowSpider.createAttributes().build());
        event.put(MtaEntityTypes.HOST.get(), Host.createAttributes().build());
        event.put(MtaEntityTypes.ICICLE_CREEPER.get(), IcicleCreeper.createAttributes().build());
        event.put(MtaEntityTypes.MOSSY_ZOMBIE.get(), MossyZombie.createAttributes().build());
        event.put(MtaEntityTypes.SIREN.get(), Siren.createAttributes().build());
        event.put(MtaEntityTypes.SKELETON_FIGHTER.get(), SkeletonFighter.createAttributes().build());
        event.put(MtaEntityTypes.TOXIC_ZOMBIE.get(), ToxicZombie.createAttributes().build());
        event.put(MtaEntityTypes.YUKI_ONNA.get(), YukiOnna.createAttributes().build());
        event.put(MtaEntityTypes.WITHER_SOLDIER.get(), WitherSoldierEntity.createAttributes().build());
        event.put(MtaEntityTypes.ZOMBIFIED_MINER.get(), ZombifiedMiner.createAttributes().build());



    }
    @SubscribeEvent
    public static void entityAttributeModification(EntityAttributeModificationEvent event){
        event.add(EntityType.ENDER_DRAGON, Attributes.MAX_HEALTH, 800.0F);
        event.add(EntityType.ENDER_DRAGON, Attributes.ARMOR, 10.0F);

        event.add(EntityType.WITHER, Attributes.MAX_HEALTH, 500.0F);

        event.add(EntityType.ZOMBIE, Attributes.MOVEMENT_SPEED, 0.32F); // Was 0.23F


        event.add(EntityType.SNOW_GOLEM, Attributes.MAX_HEALTH, 10.0F); // Was 4.0F

        event.add(EntityType.IRON_GOLEM, Attributes.MAX_HEALTH, 200.0F);
        event.add(EntityType.IRON_GOLEM, Attributes.ARMOR, 15.0F);
        event.add(EntityType.IRON_GOLEM, Attributes.MOVEMENT_SPEED, 0.18F); // Was 0.25F
        event.add(EntityType.IRON_GOLEM, Attributes.ATTACK_DAMAGE, 25.0F); // Was 15.0F
        event.add(EntityType.IRON_GOLEM, Attributes.FALL_DAMAGE_MULTIPLIER, 0.2F);
        event.add(EntityType.IRON_GOLEM, Attributes.BURNING_TIME, 0.2F);
        event.add(EntityType.IRON_GOLEM, Attributes.ATTACK_KNOCKBACK, 0.15F);


        event.add(EntityType.PLAYER, MTAAttributes.SOUL_GATHERING, 1.0F);
    }



    @SubscribeEvent
    public static void spawnPlacements(RegisterSpawnPlacementsEvent event){


        event.register(MtaEntityTypes.BEARDED_DRAGON.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkDesertAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.CAPIBARA.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkLandSwimmerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.DUCK.get(),
                MTAPlacementTypes.GROUND_OR_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkLandSwimmerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.FERRET.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Ferret::checkAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.HORSESHOE_CRAB.get(),
                MTAPlacementTypes.GROUND_OR_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkLandSwimmerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.OCTOPUS.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.OCEAN_FLOOR,
                MTASpawnRules::checkWaterAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.OWL.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING,
                MTASpawnRules::checkBirdSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.PENGUIN.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSnowAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.RACCOON.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Raccoon::checkAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.TOUCAN.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING,
                MTASpawnRules::checkBirdSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.WISPFLY.get(),
                MTAPlacementTypes.GROUND_OR_AIR,
                Heightmap.Types.WORLD_SURFACE,
                Wispfly::checkWispSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);


        event.register(MtaEntityTypes.BUTTERFLY.get(),
                MTAPlacementTypes.GROUND_OR_AIR,
                Heightmap.Types.MOTION_BLOCKING,
                MTASpawnRules::checkBirdSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.DEER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkLandSwimmerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.JELLYFISH.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSeaAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.SHRIMP.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSeaAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);


        event.register(MtaEntityTypes.GREAT_WHITE_SHARK.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSeaAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.TURKEY.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING,
                MTASpawnRules::checkBirdSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);


        event.register(MtaEntityTypes.ARMORED_SKELETON.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ArmoredSkeleton::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.BLACK_WIDOW.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                BlackWidow::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.CHARRED_SKELETON.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                IcicleCreeper::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.CORROSIVE_CUBE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                CorrosiveCube::checkSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.FALLEN_SAMURAI.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FallenSamurai::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.FROSTED_SLIME.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FrostedSlime::checkSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.GLOW_SPIDER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                GlowSpider::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.HOST.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Host::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.ICICLE_CREEPER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                IcicleCreeper::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.MOSSY_ZOMBIE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MossyZombie::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.SIREN.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Siren::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.SKELETON_FIGHTER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                SkeletonFighter::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.TOXIC_ZOMBIE.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ToxicZombie::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.YUKI_ONNA.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                YukiOnna::canSpawn,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.WITHER_SOLDIER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WitherSoldierEntity::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.ZOMBIFIED_MINER.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ZombifiedMiner::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);


        event.register(EntityType.CAMEL,
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkDesertAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
    }

    @SubscribeEvent
    private static void registerScreens(RegisterMenuScreensEvent event) {
    }

}


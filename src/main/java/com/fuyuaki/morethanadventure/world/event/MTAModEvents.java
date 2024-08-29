package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import com.fuyuaki.morethanadventure.game.capabilities.block.SprinkerWrapper;
import com.fuyuaki.morethanadventure.world.block.Sprinkler;
import com.fuyuaki.morethanadventure.world.entity.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

@EventBusSubscriber(modid = MODID,bus = EventBusSubscriber.Bus.MOD)
public class MTAModEvents {

    @SubscribeEvent
    public static void registerCapabilitiesEvent(RegisterCapabilitiesEvent event){
        for (Block block : BuiltInRegistries.BLOCK) {
            if (block.getClass() == Sprinkler.class) {
                event.registerBlock(Capabilities.FluidHandler.BLOCK, (level, pos, blockState, blockEntity, context) -> new SprinkerWrapper(level,pos), block);
            }


        }
    }

    @SubscribeEvent
    public static void entityAttributes(EntityAttributeCreationEvent event){
        event.put(MtaEntityTypes.YUKI_ONNA.get(), YukiOnna.createAttributes().build());
        event.put(MtaEntityTypes.FALLEN_SAMURAI.get(), FallenSamurai.createAttributes().build());
        event.put(MtaEntityTypes.WITHER_JUGGERNAUT.get(), WitherJuggernaut.createAttributes().build());
        event.put(MtaEntityTypes.BUTTERFLY.get(), Butterfly.createAttributes().build());
        event.put(MtaEntityTypes.BEARDED_DRAGON.get(), BeardedDragon.createAttributes().build());
        event.put(MtaEntityTypes.CAPIBARA.get(), Capybara.createAttributes().build());
        event.put(MtaEntityTypes.DUCK.get(), Duck.createAttributes().build());
        event.put(MtaEntityTypes.FERRET.get(), Ferret.createAttributes().build());
        event.put(MtaEntityTypes.GREAT_WHITE_SHARK.get(), GreatWhiteShark.createAttributes().build());
        event.put(MtaEntityTypes.HORSESHOE_CRAB.get(), HorseshoeCrab.createAttributes().build());
        event.put(MtaEntityTypes.JELLYFISH.get(), Jellyfish.createAttributes().build());
        event.put(MtaEntityTypes.OCTOPUS.get(), Octopus.createAttributes().build());
        event.put(MtaEntityTypes.OWL.get(), Owl.createAttributes().build());
        event.put(MtaEntityTypes.PENGUIN.get(), Penguin.createAttributes().build());
        event.put(MtaEntityTypes.RACCOON.get(), Raccoon.createAttributes().build());
        event.put(MtaEntityTypes.SHRIMP.get(), Shrimp.createAttributes().build());
        event.put(MtaEntityTypes.TOUCAN.get(), Toucan.createAttributes().build());
    }



    @SubscribeEvent
    public static void spawnPlacements(RegisterSpawnPlacementsEvent event){
        event.register(MtaEntityTypes.YUKI_ONNA.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                YukiOnna::canSpawn,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.FALLEN_SAMURAI.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                FallenSamurai::checkMonsterSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.BUTTERFLY.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING,
                MTASpawnRules::checkBirdSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
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
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkLandSwimmerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.FERRET.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Ferret::checkAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.GREAT_WHITE_SHARK.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSeaAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.HORSESHOE_CRAB.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkLandSwimmerSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.JELLYFISH.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSeaAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.OCTOPUS.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkWaterAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.OWL.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
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
        event.register(MtaEntityTypes.SHRIMP.get(),
                SpawnPlacementTypes.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkSeaAnimalSpawnRules,
                RegisterSpawnPlacementsEvent.Operation.OR);
        event.register(MtaEntityTypes.TOUCAN.get(),
                SpawnPlacementTypes.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                MTASpawnRules::checkBirdSpawnRules,
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


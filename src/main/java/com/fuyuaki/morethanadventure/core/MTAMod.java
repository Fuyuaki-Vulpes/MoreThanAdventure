package com.fuyuaki.morethanadventure.core;

import com.fuyuaki.morethanadventure.core.registry.*;
import com.fuyuaki.morethanadventure.game.capabilities.block.SprinkerWrapper;
import com.fuyuaki.morethanadventure.game.client.particle.GeyserParticle;
import com.fuyuaki.morethanadventure.game.client.particle.SprinklerParticle;
import com.fuyuaki.morethanadventure.game.client.renderer.block.SprinklerRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.*;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaTerrablender;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.surface.MtaSurfaceRules;
import com.fuyuaki.morethanadventure.world.block.Sprinkler;
import com.fuyuaki.morethanadventure.world.entity.*;
import com.fuyuaki.morethanadventure.core.registry.MtaArmorMats;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterColorHandlersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import terrablender.api.SurfaceRuleManager;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MTAMod.MODID)
public class MTAMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "morethanadventure";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public MTAMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        MtaEntityTypes.register(modEventBus);
        MtaBlockEntities.register(modEventBus);
        MtaBlocks.register(modEventBus);
        MTAPlacers.register(modEventBus);
        MtaItems.register(modEventBus);
        MtaEffects.register(modEventBus);
        MtaFeatures.register(modEventBus);
        MtaParticles.register(modEventBus);
        MtaArmorMats.register(modEventBus);
        MtaBiomes.addBiomes();

        MtaTabs.register(modEventBus);



        NeoForge.EVENT_BUS.register(this);


        modContainer.registerConfig(ModConfig.Type.COMMON, MTACommonConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            MtaTerrablender.registerBiomes();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,MODID,MtaSurfaceRules.makeOverworld());
        });
    }

    public static void setupRenderTypes(){
        RenderType transparentRenderType = RenderType.cutoutMipped();
        RenderType cutoutRenderType = RenderType.cutout();
        RenderType translucentRenderType = RenderType.translucent();

        setRenderType(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), cutoutRenderType);

    }
    public static void setRenderType(Block block, RenderType renderType){
        ItemBlockRenderTypes.setRenderLayer(block, renderType);
    }




    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Thank you for downloading More Than Adventure!");
    }

    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            event.enqueueWork(() -> {
                setupRenderTypes();
            });
        }



        @SubscribeEvent
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(MtaBlockEntities.SPRINKLER.get(), context -> new SprinklerRenderer());
            event.registerEntityRenderer(MtaEntityTypes.YUKI_ONNA.get(), YukiOnnaRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.FALLEN_SAMURAI.get(), FallenSamuraiRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.BUTTERFLY.get(), ButterflyRender::new);
            event.registerEntityRenderer(MtaEntityTypes.BEARDED_DRAGON.get(), BeardedDragonRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.CAPIBARA.get(), CapybaraRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.DUCK.get(), DuckRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.FERRET.get(), FerretRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.GREAT_WHITE_SHARK.get(), GreatWhiteSharkRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.HORSESHOE_CRAB.get(), HorseshoeCrabRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.JELLYFISH.get(), JellyfishRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.OCTOPUS.get(), OctopusRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.OWL.get(), OwlRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.PENGUIN.get(), PenguinRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.RACCOON.get(), RaccoonRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.SHRIMP.get(), ShrimpRenderer::new);
            event.registerEntityRenderer(MtaEntityTypes.TOUCAN.get(), ToucanRenderer::new);

        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

        }

        @SubscribeEvent
        public static void particleFactory(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(MtaParticles.GEYSER_WATER.get(), GeyserParticle.Water::new);
            event.registerSpriteSet(MtaParticles.GEYSER_LAVA.get(), GeyserParticle.Lava::new);
            event.registerSpriteSet(MtaParticles.SPRINKLER.get(), SprinklerParticle.Builder::new);

        }
        @SubscribeEvent
        public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
            event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), MtaBlocks.PALM_LEAVES.get());
        }

        @SubscribeEvent
        public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
            event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), MtaBlocks.PALM_LEAVES);
        }
    }


    @EventBusSubscriber(modid = MODID,bus = EventBusSubscriber.Bus.MOD)
    public static class ModEvents{
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
                    Butterfly::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.BEARDED_DRAGON.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    BeardedDragon::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.CAPIBARA.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Capybara::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.DUCK.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Duck::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.FERRET.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Ferret::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.GREAT_WHITE_SHARK.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    GreatWhiteShark::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.HORSESHOE_CRAB.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    HorseshoeCrab::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.JELLYFISH.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Jellyfish::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.OCTOPUS.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Octopus::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.OWL.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Owl::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.PENGUIN.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Penguin::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.RACCOON.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Raccoon::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.SHRIMP.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Shrimp::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(MtaEntityTypes.TOUCAN.get(),
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Toucan::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);
            event.register(EntityType.CAMEL,
                    SpawnPlacementTypes.ON_GROUND,
                    Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Animal::checkAnimalSpawnRules,
                    RegisterSpawnPlacementsEvent.Operation.OR);

        }

        @SubscribeEvent
        private static void registerScreens(RegisterMenuScreensEvent event) {
        }
    }

}

package com.fuyuvulpes.morethanadventure.core;

import com.fuyuvulpes.morethanadventure.core.registry.*;
import com.fuyuvulpes.morethanadventure.game.capabilities.block.SprinkerWrapper;
import com.fuyuvulpes.morethanadventure.game.client.renderer.block.SprinklerRenderer;
import com.fuyuvulpes.morethanadventure.game.client.renderer.entity.FallenSamuraiRenderer;
import com.fuyuvulpes.morethanadventure.game.client.renderer.entity.YukiOnnaRenderer;
import com.fuyuvulpes.morethanadventure.world.block.Sprinkler;
import com.fuyuvulpes.morethanadventure.world.entity.FallenSamurai;
import com.fuyuvulpes.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

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
        MtaItems.register(modEventBus);
        MtaEffects.register(modEventBus);
        MtaFeatures.register(modEventBus);
        MtaParticles.register(modEventBus);
        MtaArmorMats.register(modEventBus);


        MtaTabs.register(modEventBus);



        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, MTAServerConfig.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    public static void setupRenderTypes(){
        RenderType transparentRenderType = RenderType.cutoutMipped();
        RenderType cutoutRenderType = RenderType.cutout();
        RenderType translucentRenderType = RenderType.translucent();
/*
        setRenderType(YoaBlocks.BLISSWOOD_LEAVES.get(), transparentRenderType);
        setRenderType(YoaBlocks.BLISSWOOD_DOOR.get(), cutoutRenderType);
        setRenderType(YoaBlocks.BLISSWOOD_SAPLING.get(), cutoutRenderType);
        setRenderType(YoaBlocks.BLISSWOOD_TRAPDOOR.get(), cutoutRenderType);
  */
    }
    public static void setRenderType(Block block, RenderType renderType){
        ItemBlockRenderTypes.setRenderLayer(block, renderType);
    }


    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
       // if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
         //   event.accept(EXAMPLE_BLOCK_ITEM);
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

        }

        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {

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

        }

        @SubscribeEvent
        private static void registerScreens(RegisterMenuScreensEvent event) {
        }
    }

}

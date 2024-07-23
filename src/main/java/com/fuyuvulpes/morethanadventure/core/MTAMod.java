package com.fuyuvulpes.morethanadventure.core;

import com.fuyuvulpes.morethanadventure.core.registry.*;
import com.fuyuvulpes.morethanadventure.game.capabilities.block.SprinkerWrapper;
import com.fuyuvulpes.morethanadventure.game.client.model.entity.SprinklerRenderer;
import com.fuyuvulpes.morethanadventure.world.block.Sprinkler;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
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
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

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


        MtaTabs.register(modEventBus);



        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.SERVER, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

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
        public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
            event.registerBlockEntityRenderer(MtaBlockEntities.SPRINKLER.get(), context -> new SprinklerRenderer());

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



    }
}

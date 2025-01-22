package com.fuyuaki.morethanadventure.core.mod;

import com.fuyuaki.morethanadventure.core.deferred_registries.*;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaTerrablender;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.surface.MtaSurfaceRules;
import com.fuyuaki.morethanadventure.network.MTANetwork;
import com.mojang.logging.LogUtils;
import io.wispforest.accessories.networking.AccessoriesNetworking;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
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


    public MTAMod(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        MTANetwork.init();
        MTAComponents.register(modEventBus);
        MTAAttachments.register(modEventBus);
        MtaEntityTypes.register(modEventBus);
        MtaBlockEntities.register(modEventBus);
        MtaBlocks.register(modEventBus);
        MTAPlacers.register(modEventBus);
        MtaItems.register(modEventBus);
        MtaParticles.register(modEventBus);
        MtaEffects.register(modEventBus);
        MtaFeatures.register(modEventBus);
        MtaBiomes.addBiomes();
        MtaSounds.register(modEventBus);
        MtaLootModifier.register(modEventBus);

        MtaTabs.register(modEventBus);



        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, MTAConfigs.Common.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, MTAConfigs.Client.SPEC);
    }

    public static void setupRenderTypes() {
        RenderType transparentRenderType = RenderType.cutoutMipped();
        RenderType cutoutRenderType = RenderType.cutout();
        RenderType translucentRenderType = RenderType.translucent();
        //setRenderType(MtaBlocks.SCATTERED_LEAVES.get(), cutoutRenderType);
        setRenderType(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), cutoutRenderType);
        setRenderType(MtaBlocks.SHALLOW_GRASS.get(), cutoutRenderType);

    }

    private static void setRenderType(Block block, RenderType type) {
        ItemBlockRenderTypes.setRenderLayer(block,type);

    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            MtaTerrablender.registerBiomes();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,MODID,MtaSurfaceRules.makeOverworld());
        });

    }





    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Thank you for downloading More Than Adventure!");
    }




}

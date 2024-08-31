package com.fuyuaki.morethanadventure.core;

import com.fuyuaki.morethanadventure.core.registry.*;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaTerrablender;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.surface.MtaSurfaceRules;
import com.fuyuaki.morethanadventure.core.registry.MtaArmorMats;
import com.fuyuaki.morethanadventure.core.registry.MtaSounds;
import com.mojang.logging.LogUtils;
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
        MtaSounds.register(modEventBus);
        MtaLootModifier.register(modEventBus);

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
        setRenderType(MtaBlocks.GRASSY_DIRT.get(), cutoutRenderType);
        setRenderType(MtaBlocks.PALM_LEAVES.get(), cutoutRenderType);
        setRenderType(MtaBlocks.SWEET_BERRY_LEAVES.get(), cutoutRenderType);
        setRenderType(MtaBlocks.SCATTERED_LEAVES.get(), cutoutRenderType);

    }
    public static void setRenderType(Block block, RenderType renderType){
        ItemBlockRenderTypes.setRenderLayer(block, renderType);
    }




    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Thank you for downloading More Than Adventure!");
    }




}

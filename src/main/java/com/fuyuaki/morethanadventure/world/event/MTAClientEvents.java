package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.*;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.NetheriteTridentModel;
import com.fuyuaki.morethanadventure.game.client.particle.GeyserParticle;
import com.fuyuaki.morethanadventure.game.client.particle.SprinklerParticle;
import com.fuyuaki.morethanadventure.game.client.renderer.MTAItemWithoutLevelRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.block.SprinklerRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.*;
import com.fuyuaki.morethanadventure.world.item.MtaItemProperties;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.jarjar.nio.util.Lazy;
import net.neoforged.neoforge.client.event.*;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;


@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MTAClientEvents
{
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            MTAMod.setupRenderTypes();
            MtaItemProperties.addCustomItemProperties();

        });

    }



    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(MtaBlockEntities.SPRINKLER.get(), context -> new SprinklerRenderer());
        event.registerEntityRenderer(MtaEntityTypes.YUKI_ONNA.get(), YukiOnnaRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.FALLEN_SAMURAI.get(), FallenSamuraiRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.WITHER_JUGGERNAUT.get(), WitherJuggernautRenderer::new);
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

        //ITEM & BLOCK
        event.registerEntityRenderer(MtaEntityTypes.NETHERITE_TRIDENT.get(), ThrownNetheriteTridentRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.MTA_ARROW.get(), MTAArrowRenderer::new);

    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MTAModelLayers.NETHERITE_TRIDENT, NetheriteTridentModel::createBodyLayer);

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


    @SubscribeEvent
    public static void clientExtensionEvent(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            private final Lazy<BlockEntityWithoutLevelRenderer> ister = Lazy.of(() -> MTAItemWithoutLevelRenderer.INSTANCE);
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ister.get();
            }
        }, MtaItems.NETHERITE_TRIDENT.get()
                );
    }
    @SubscribeEvent
    public static void clientReloadListenersEvent(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(
                MTAItemWithoutLevelRenderer.INSTANCE
        );
    }



}
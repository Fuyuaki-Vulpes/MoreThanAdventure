package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.*;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.*;
import com.fuyuaki.morethanadventure.game.client.particle.GeyserParticle;
import com.fuyuaki.morethanadventure.game.client.particle.SprinklerParticle;
import com.fuyuaki.morethanadventure.game.client.renderer.MTAItemWithoutLevelRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.block.SprinklerRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.*;
import com.fuyuaki.morethanadventure.world.item.MtaItemProperties;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
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
        event.registerBlockEntityRenderer(MtaBlockEntities.SPRINKLER.get(), SprinklerRenderer::new);

        event.registerEntityRenderer(MtaEntityTypes.YUKI_ONNA.get(), YukiOnnaRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.FALLEN_SAMURAI.get(), FallenSamuraiRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.ICICLE_CREEPER.get(), IcicleCreeperRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.ARMORED_SKELETON.get(), ArmoredSkeletonRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.BLACK_WIDOW.get(), BlackWidowRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.CHARRED_SKELETON.get(), CharredSkeletonRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.CORROSIVE_CUBE.get(), CorrosiveCubeRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.FROZEN_SLIME.get(), FrozenSlimeRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.GLOW_SPIDER.get(), GlowSpiderRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.HOST.get(), HostRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.MOSSY_ZOMBIE.get(), MossyZombieRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.SKELETON_FIGHTER.get(), SkeletonFighterRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.TOXIC_ZOMBIE.get(), ToxicZombieRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.ZOMBIFIED_MINER.get(), ZombifiedMinerRenderer::new);


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
        event.registerEntityRenderer(MtaEntityTypes.MYSTIC_MERMAIDS_TRIDENT.get(), ThrownMysticMermaidsTridentRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.MTA_ARROW.get(), MTAArrowRenderer::new);

    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MTAModelLayers.SPRINKLER, SprinklerRenderer::createBodyLayer);



        event.registerLayerDefinition(MTAModelLayers.NETHERITE_TRIDENT, NetheriteTridentModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.MYSTIC_MERMAIDS_TRIDENT, MysticMermaidsTridentModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BEARDED_DRAGON, BeardedDragonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CAPYBARA, CapybaraModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.DUCK, DuckModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FALLEN_SAMURAI, FallenSamuraiModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FERRET, FerretModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.GREAT_WHITE_SHARK, GreatWhiteSharkModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.HORSESHOE_CRAB, HorseshoeCrabModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ICICLE_CREEPER, IcicleCreeperModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.JELLYFISH, JellyfishModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.OCTOPUS, OctopusModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.OWL, OwlModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.PENGUIN, PenguinModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.RACCOON, RaccoonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.SHRIMP, ShrimpModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.TOUCAN, ToucanModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.WITHER_JUGGERNAUT, WitherJuggernautModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.YUKI_ONNA, YukiOnnaModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void modelEvent(ModelEvent.RegisterAdditional event) {

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
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), MtaBlocks.SCATTERED_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getEvergreenColor(), MtaBlocks.SWEET_BERRY_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.GRASSY_DIRT.get());
    }

    @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), MtaBlocks.PALM_LEAVES);
        event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), MtaBlocks.SCATTERED_LEAVES);
        event.register((pStack, pTintIndex) -> FoliageColor.getEvergreenColor(), MtaBlocks.SWEET_BERRY_LEAVES);
        event.register((pStack, pTintIndex) -> GrassColor.getDefaultColor(), MtaBlocks.GRASSY_DIRT);
    }


    @SubscribeEvent
    public static void clientExtensionEvent(RegisterClientExtensionsEvent event) {
        event.registerItem(new IClientItemExtensions() {
            private final Lazy<BlockEntityWithoutLevelRenderer> ister = Lazy.of(() -> MTAItemWithoutLevelRenderer.INSTANCE);
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return ister.get();
            }
        }, MtaItems.NETHERITE_TRIDENT.get(), MtaItems.MYSTIC_MERMAIDS_TRIDENT.get()
                );
    }
    @SubscribeEvent
    public static void clientReloadListenersEvent(RegisterClientReloadListenersEvent event) {
        event.registerReloadListener(
                MTAItemWithoutLevelRenderer.INSTANCE
        );
    }



}
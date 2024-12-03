package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.MTAMod;
import com.fuyuaki.morethanadventure.core.registry.*;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.entity.*;
import com.fuyuaki.morethanadventure.game.client.model.player.SirenModel;
import com.fuyuaki.morethanadventure.game.client.particle.GeyserParticle;
import com.fuyuaki.morethanadventure.game.client.particle.PoisonBubble;
import com.fuyuaki.morethanadventure.game.client.particle.SprinklerParticle;
import com.fuyuaki.morethanadventure.game.client.particle.UnpoppableBubble;
import com.fuyuaki.morethanadventure.game.client.renderer.MTAItemWithoutLevelRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.block.SprinklerRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.*;
import com.fuyuaki.morethanadventure.game.client.renderer.player.SirenRenderLayer;
import com.fuyuaki.morethanadventure.world.item.MtaItemProperties;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.resources.PlayerSkin;
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
        event.registerEntityRenderer(MtaEntityTypes.FROSTED_SLIME.get(), FrostedSlimeRenderer::new);
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


        LayerDefinition humanoidModel = LayerDefinition.create(HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F), 64, 64);
        LayerDefinition humanoidOuterArmor = LayerDefinition.create(HumanoidArmorModel.createBodyLayer(LayerDefinitions.OUTER_ARMOR_DEFORMATION), 64, 32);
        LayerDefinition humanoidInnerArmor = LayerDefinition.create(HumanoidArmorModel.createBodyLayer(LayerDefinitions.INNER_ARMOR_DEFORMATION), 64, 32);
        LayerDefinition skeletonLayer = SkeletonModel.createBodyLayer();
        LayerDefinition spiderLayer = SpiderModel.createSpiderBodyLayer();
        LayerDefinition skullLayer = SkullModel.createHumanoidHeadLayer();
        LayerDefinition creeperLayer = CreeperModel.createBodyLayer(CubeDeformation.NONE);
        LayerDefinition creeperArmorLayer = CreeperModel.createBodyLayer(new CubeDeformation(2.0F));


        event.registerLayerDefinition(MTAModelLayers.SPRINKLER, SprinklerRenderer::createBodyLayer);



        event.registerLayerDefinition(MTAModelLayers.NETHERITE_TRIDENT, NetheriteTridentModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.MYSTIC_MERMAIDS_TRIDENT, MysticMermaidsTridentModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON, ArmoredSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BEARDED_DRAGON, BeardedDragonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BLACK_WIDOW, BlackWidowModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY_PATTERN, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY_OVERLAY, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CAPYBARA, CapybaraModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON, CharredSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CORROSIVE_CUBE, CorrosiveCubeModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.DUCK, DuckModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FALLEN_SAMURAI, FallenSamuraiModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FERRET, FerretModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FROZEN_SLIME, FrostedSlimeModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.GLOW_SPIDER, GlowSpiderModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.GREAT_WHITE_SHARK, GreatWhiteSharkModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.HORSESHOE_CRAB, HorseshoeCrabModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.HOST,HostModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ICICLE_CREEPER, IcicleCreeperModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.JELLYFISH, JellyfishModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE, () -> LayerDefinition.create(MossyZombieModel.createMesh(CubeDeformation.NONE, 0.0f),64,32));
        event.registerLayerDefinition(MTAModelLayers.OCTOPUS, OctopusModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.OWL, OwlModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.PENGUIN, PenguinModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.RACCOON, RaccoonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.SHRIMP, ShrimpModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.SKELETON_FIGHTER, SkeletonFighterModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.TOUCAN, ToucanModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE, () -> LayerDefinition.create(ToxicZombieModel.createMesh(CubeDeformation.NONE, 0.0f),64,32));
        event.registerLayerDefinition(MTAModelLayers.WITHER_JUGGERNAUT, WitherJuggernautModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.YUKI_ONNA, YukiOnnaModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER, () -> LayerDefinition.create(ZombifiedMinerModel.createMesh(CubeDeformation.NONE, 0.0f),64,32));

        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.HOST_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.HOST_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.SKELETON_FIGHTER_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.SKELETON_FIGHTER_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_INNER_ARMOR, () -> humanoidInnerArmor);


        event.registerLayerDefinition(MTAModelLayers.SIREN_LAYER, SirenModel::createBodyLayer);

    }
    @SubscribeEvent
    public static void modelEvent(ModelEvent.RegisterAdditional event) {

    }

    @SubscribeEvent
    public static void particleFactory(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(MtaParticles.GEYSER_WATER.get(), GeyserParticle.Water::new);
        event.registerSpriteSet(MtaParticles.GEYSER_LAVA.get(), GeyserParticle.Lava::new);
        event.registerSpriteSet(MtaParticles.SPRINKLER.get(), SprinklerParticle.Builder::new);
        event.registerSpriteSet(MtaParticles.UNPOPPABLE_BUBBLE.get(), UnpoppableBubble.Provider::new);
        event.registerSpriteSet(MtaParticles.POISON_BUBBLE.get(), PoisonBubble.Provider::new);

    }
    @SubscribeEvent
    public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), MtaBlocks.PALM_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), MtaBlocks.SCATTERED_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getEvergreenColor(), MtaBlocks.SWEET_BERRY_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.GRASSY_DIRT.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.PERMAFROST_GRASS.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.SHALLOW_GRASS.get());
    }

    @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), MtaBlocks.PALM_LEAVES);
        event.register((pStack, pTintIndex) -> FoliageColor.getDefaultColor(), MtaBlocks.SCATTERED_LEAVES);
        event.register((pStack, pTintIndex) -> FoliageColor.getEvergreenColor(), MtaBlocks.SWEET_BERRY_LEAVES);
        event.register((pStack, pTintIndex) -> GrassColor.getDefaultColor(), MtaBlocks.GRASSY_DIRT);
        event.register((pStack, pTintIndex) -> GrassColor.getDefaultColor(), MtaBlocks.PERMAFROST_GRASS);
        event.register((pStack, pTintIndex) -> GrassColor.getDefaultColor(), MtaBlocks.SHALLOW_GRASS);
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


    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
        event.register(MTAKeybinds.SKILL_USE.get());
        event.register(MTAKeybinds.SKILL_CYCLE.get());
    }

    @SubscribeEvent
    public static void addLayer(final EntityRenderersEvent.AddLayers event) {
        for(PlayerSkin.Model skin : event.getSkins()) {
            LivingEntityRenderer<AbstractClientPlayer, PlayerModel<AbstractClientPlayer>> renderer = event.getSkin(skin);
            if(renderer != null) {
                renderer.addLayer(new SirenRenderLayer<>(renderer,event.getContext()));
            }
        }
    }



}
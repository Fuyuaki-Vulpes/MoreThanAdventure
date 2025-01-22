package com.fuyuaki.morethanadventure.world.event;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlockEntities;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaBlocks;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEntityTypes;
import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.fuyuaki.morethanadventure.core.mod.MTAMod;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.model.block.SprinklerModel;
import com.fuyuaki.morethanadventure.game.client.model.entity.*;
import com.fuyuaki.morethanadventure.game.client.particle.*;
import com.fuyuaki.morethanadventure.game.client.renderer.MTASheets;
import com.fuyuaki.morethanadventure.game.client.renderer.block.SprinklerRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.*;
import com.fuyuaki.morethanadventure.game.client.renderer.special.MermaidTridentSpecialRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.special.NetheriteTridentSpecialRenderer;
import com.fuyuaki.morethanadventure.game.client.renderer.special.SprinklerSpecialRenderer;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshTransformer;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.*;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;


@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class MTAClientEvents {
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {

        event.enqueueWork(() -> {
            MTAMod.setupRenderTypes();
        });

    }


    @SubscribeEvent
    public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {

        //MOBS

        event.registerEntityRenderer(MtaEntityTypes.BEARDED_DRAGON.get(), BeardedDragonRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.CAPIBARA.get(), CapybaraRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.DUCK.get(), DuckRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.FERRET.get(), FerretRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.HORSESHOE_CRAB.get(), HorseshoeCrabRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.OCTOPUS.get(), OctopusRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.OWL.get(), OwlRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.PENGUIN.get(), PenguinRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.RACCOON.get(), RaccoonRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.TOUCAN.get(), ToucanRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.WISPFLY.get(), WispflyRenderer::new);

        event.registerEntityRenderer(MtaEntityTypes.BUTTERFLY.get(), ButterflyRender::new);
        event.registerEntityRenderer(MtaEntityTypes.DEER.get(), DeerRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.JELLYFISH.get(), JellyfishRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.SHRIMP.get(), ShrimpRenderer::new);

        event.registerEntityRenderer(MtaEntityTypes.GREAT_WHITE_SHARK.get(), GreatWhiteSharkRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.TURKEY.get(), TurkeyRenderer::new);

        event.registerEntityRenderer(MtaEntityTypes.ARMORED_SKELETON.get(), ArmoredSkeletonRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.BLACK_WIDOW.get(), BlackWidowRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.CHARRED_SKELETON.get(), CharredSkeletonRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.CORROSIVE_CUBE.get(), CorrosiveCubeRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.FALLEN_SAMURAI.get(), FallenSamuraiRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.FROSTED_SLIME.get(), FrostedSlimeRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.GLOW_SPIDER.get(), GlowSpiderRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.HOST.get(), HostRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.ICICLE_CREEPER.get(), IcicleCreeperRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.MOSSY_ZOMBIE.get(), MossyZombieRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.SIREN.get(), SirenRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.SKELETON_FIGHTER.get(), SkeletonFighterRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.TOXIC_ZOMBIE.get(), ToxicZombieRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.YUKI_ONNA.get(), YukiOnnaRenderer::new);
        event.registerEntityRenderer(MtaEntityTypes.ZOMBIFIED_MINER.get(), ZombifiedMinerRenderer::new);


        //ITEM & BLOCK

        event.registerBlockEntityRenderer(MtaBlockEntities.SPRINKLER.get(), SprinklerRenderer::new);

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


        event.registerLayerDefinition(MTAModelLayers.SPRINKLER, SprinklerModel::createBodyLayer);


        event.registerLayerDefinition(MTAModelLayers.NETHERITE_TRIDENT, NetheriteTridentModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.MYSTIC_MERMAIDS_TRIDENT, MysticMermaidsTridentModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON, ArmoredSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.BEARDED_DRAGON, BeardedDragonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BLACK_WIDOW, () -> spiderLayer.apply(MeshTransformer.scaling(0.8F)));
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY_PATTERN, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.BUTTERFLY_OVERLAY, ButterflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CAPYBARA, CapybaraModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON, CharredSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON_OVERLAY, CharredSkeletonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CORROSIVE_CUBE, CorrosiveCubeModel::createInnerBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.CORROSIVE_CUBE_OUTER, CorrosiveCubeModel::createOuterBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.DUCK, DuckModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.DEER, DeerModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FALLEN_SAMURAI, FallenSamuraiModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FERRET, FerretModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.FROSTED_SLIME, FrostedSlimeModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.GLOW_SPIDER, () -> spiderLayer.apply(MeshTransformer.scaling(0.4F)));
        event.registerLayerDefinition(MTAModelLayers.GLOW_SPIDER_GLOW, () -> spiderLayer.apply(MeshTransformer.scaling(0.4F)));
        event.registerLayerDefinition(MTAModelLayers.GREAT_WHITE_SHARK, GreatWhiteSharkModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.HORSESHOE_CRAB, HorseshoeCrabModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.HOST, HostModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ICICLE_CREEPER, IcicleCreeperModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.JELLYFISH, JellyfishModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.SIREN, SirenModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE, () -> LayerDefinition.create(MossyZombieModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 32));
        event.registerLayerDefinition(MTAModelLayers.OCTOPUS, OctopusModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.OWL, OwlModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.PENGUIN, PenguinModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.RACCOON, RaccoonModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.SHRIMP, ShrimpModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.SKELETON_FIGHTER, SkeletonFighterModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.TOUCAN, ToucanModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE, () -> LayerDefinition.create(ToxicZombieModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 32));
        event.registerLayerDefinition(MTAModelLayers.TURKEY, TurkeyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.YUKI_ONNA, YukiOnnaModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER, () -> LayerDefinition.create(ZombifiedMinerModel.createMesh(CubeDeformation.NONE, 0.0f), 64, 32));

        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.ARMORED_SKELETON_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.CHARRED_SKELETON_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.HOST_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.HOST_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_BABY, () -> humanoidModel.apply(MossyZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_BABY_OUTER_ARMOR, () -> humanoidOuterArmor.apply(MossyZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.MOSSY_ZOMBIE_BABY_INNER_ARMOR, () -> humanoidInnerArmor.apply(MossyZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.SKELETON_FIGHTER_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.SKELETON_FIGHTER_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_BABY, () -> humanoidModel.apply(ToxicZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_BABY_OUTER_ARMOR, () -> humanoidOuterArmor.apply(ToxicZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.TOXIC_ZOMBIE_BABY_INNER_ARMOR, () -> humanoidInnerArmor.apply(ToxicZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_BABY, () -> humanoidModel.apply(MossyZombieModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_OUTER_ARMOR, () -> humanoidOuterArmor);
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_INNER_ARMOR, () -> humanoidInnerArmor);
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_BABY_OUTER_ARMOR, () -> humanoidOuterArmor.apply(ZombifiedMinerModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.ZOMBIFIED_MINER_BABY_INNER_ARMOR, () -> humanoidInnerArmor.apply(ZombifiedMinerModel.BABY_TRANSFORMER));
        event.registerLayerDefinition(MTAModelLayers.WISPFLY, WispflyModel::createBodyLayer);
        event.registerLayerDefinition(MTAModelLayers.WISPFLY_OUTER_LAYER, WispflyModel::createOuterLayer);


    }

    @SubscribeEvent
    public static void registerSpecialRenderers(RegisterSpecialModelRendererEvent event) {
        event.register(ResourceLocation.fromNamespaceAndPath(MODID, "sprinkler"), SprinklerSpecialRenderer.Unbaked.MAP_CODEC);
        event.register(ResourceLocation.fromNamespaceAndPath(MODID, "netherite_trident"), NetheriteTridentSpecialRenderer.Unbaked.MAP_CODEC);
        event.register(ResourceLocation.fromNamespaceAndPath(MODID, "mermaid_trident"), MermaidTridentSpecialRenderer.Unbaked.MAP_CODEC);
    }

    @SubscribeEvent
    public static void registerSpecialBlockModelRenderers(RegisterSpecialBlockModelRendererEvent event) {
        event.register(MtaBlocks.SPRINKLER.get(),
                new SprinklerSpecialRenderer.Unbaked());

    }


    @SubscribeEvent
    public static void registerAtlases(RegisterMaterialAtlasesEvent event) {
        event.register(MTASheets.SPRINKLER_SHEETS, ResourceLocation.fromNamespaceAndPath(MODID, "sprinkler"));
    }

    @SubscribeEvent
    public static void particleFactory(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(MtaParticles.GEYSER_WATER.get(), GeyserParticle.Water::new);
        event.registerSpriteSet(MtaParticles.GEYSER_LAVA.get(), GeyserParticle.Lava::new);
        event.registerSpriteSet(MtaParticles.SPRINKLER.get(), SprinklerParticle.Builder::new);
        event.registerSpriteSet(MtaParticles.UNPOPPABLE_BUBBLE.get(), UnpoppableBubble.Provider::new);
        event.registerSpriteSet(MtaParticles.POISON_BUBBLE.get(), PoisonBubble.Provider::new);
        event.registerSpriteSet(MtaParticles.BLOOD.get(), BloodParticle.Provider::new);

        event.registerSpriteSet(MtaParticles.RAINDROP.get(), RainParticle.Provider::new);
        event.registerSpriteSet(MtaParticles.SNOWFLAKE.get(), SnowflakeParticle.Provider::new);

        event.registerSpriteSet(MtaParticles.SLASH_ATTACK.get(), AttackParticle.Provider::new);
        event.registerSpriteSet(MtaParticles.STAB_ATTACK.get(), AttackParticle.Provider::new);
        event.registerSpriteSet(MtaParticles.DAGGER_ATTACK.get(), AttackParticle.Provider::new);
        event.registerSpriteSet(MtaParticles.TEAR_ATTACK.get(), AttackParticle.Provider::new);

    }


    @SubscribeEvent
    public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.FOLIAGE_DEFAULT, MtaBlocks.PALM_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.FOLIAGE_DEFAULT, MtaBlocks.SCATTERED_LEAVES.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.GRASSY_DIRT.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.PERMAFROST_GRASS.get());
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageGrassColor(pLevel, pPos) : GrassColor.getDefaultColor(), MtaBlocks.SHALLOW_GRASS.get());
    }

    @SubscribeEvent
    public static void registerBindings(RegisterKeyMappingsEvent event) {
    }


}
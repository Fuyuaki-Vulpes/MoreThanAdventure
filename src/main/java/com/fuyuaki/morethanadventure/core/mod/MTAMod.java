package com.fuyuaki.morethanadventure.core.mod;

import com.fuyuaki.morethanadventure.core.deferred_registries.*;
import com.fuyuaki.morethanadventure.core.deferred_registries.MTATraits;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaTerrablender;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.surface.MtaSurfaceRules;
import com.fuyuaki.morethanadventure.network.MTANetwork;
import com.fuyuaki.morethanadventure.world.block.MTADispenseItemBehavior;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
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
        MTAAttributes.register(modEventBus);
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
        MTAMenuTypes.register(modEventBus);
        MtaLootModifier.register(modEventBus);
        MTAEnchantmentEffect.register(modEventBus);
        MTAEnchantmentEffectsComponents.register(modEventBus);

        MtaTabs.register(modEventBus);
        MTATraits.register(modEventBus);



        NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, MTAConfigs.Common.SPEC);
        modContainer.registerConfig(ModConfig.Type.CLIENT, MTAConfigs.Client.SPEC);
    }

    public static void setupRenderTypes() {
        RenderType transparentRenderType = RenderType.cutoutMipped();
        RenderType cutoutRenderType = RenderType.cutout();
        RenderType translucentRenderType = RenderType.translucent();
        setRenderType(MtaBlocks.CLEAR_QUARTZ_CLUSTER.get(), cutoutRenderType);
        setRenderType(MtaBlocks.PRICKLY_PEAR.get(), cutoutRenderType);
        setRenderType(MtaBlocks.POTTED_PRICKLY_PEAR.get(), cutoutRenderType);
        setRenderType(MtaBlocks.SHALLOW_GRASS.get(), cutoutRenderType);
        setRenderType(MtaBlocks.SAND_GRASS.get(), cutoutRenderType);
        setRenderType(MtaBlocks.BEACHGRASS.get(), cutoutRenderType);
        setRenderType(MtaBlocks.PERMAFROST_GRASS.get(),cutoutRenderType);

        setRenderType(MtaBlocks.ALPINE_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.ALPINE_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.ALPINE_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.ALPINE_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.AVOCADO_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.AVOCADO_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.AVOCADO_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.AVOCADO_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.BOGGED_OAK_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.BOGGED_OAK_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PINK_IPE_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PURPLE_IPE_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.WHITE_IPE_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.YELLOW_IPE_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PINK_IPE_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PURPLE_IPE_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.WHITE_IPE_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.YELLOW_IPE_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.IPE_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.IPE_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MANGO_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MANGO_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MANGO_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MANGO_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MAPLE_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MAPLE_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MAPLE_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.MAPLE_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PALM_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PALM_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PALM_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.PALM_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.SEAWOOD_LEAVES.get(),cutoutRenderType);
        setRenderType(MtaBlocks.SEAWOOD_SAPLING.get(),cutoutRenderType);
        setRenderType(MtaBlocks.SEAWOOD_DOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.SEAWOOD_TRAPDOOR.get(),cutoutRenderType);
        setRenderType(MtaBlocks.CATTAIL.get(),cutoutRenderType);

    }

    private static void setRenderType(Block block, RenderType type) {
        ItemBlockRenderTypes.setRenderLayer(block,type);

    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() ->
        {
            MTADispenseItemBehavior.bootStrap();
            MtaTerrablender.registerBiomes();
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD,MODID,MtaSurfaceRules.makeOverworld());
        });

    }

    public static <T> ResourceKey<T> loadResourceKey(ResourceKey<? extends Registry<T>> registry,String name, CompoundTag tag){
        return ResourceKey.create(registry,
                ResourceLocation.fromNamespaceAndPath(
                        tag.getString(name + "_namespace"),
                        tag.getString(name + "_path")
                )
        );
    }

    public static CompoundTag saveResourceKey(String name,ResourceKey<?> key, CompoundTag tag){
        tag.putString(name + "_namespace",key.location().getNamespace());
        tag.putString(name + "_path",key.location().getPath());
        return tag;
    }


    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        LOGGER.info("Thank you for downloading More Than Adventure!");
    }




}

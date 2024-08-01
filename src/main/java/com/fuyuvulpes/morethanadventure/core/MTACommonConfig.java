package com.fuyuvulpes.morethanadventure.core;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
@EventBusSubscriber(modid = MTAMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MTACommonConfig
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.IntValue SPRINKLER_RANGE = BUILDER
            .comment("Range of effect of the Sprinkler")
            .defineInRange("sprinkler_range", 8, 1, 16);


    static final ModConfigSpec SPEC = BUILDER.build();

    public static int sprinklerRange;

    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {

        sprinklerRange = SPRINKLER_RANGE.get();

    }
}

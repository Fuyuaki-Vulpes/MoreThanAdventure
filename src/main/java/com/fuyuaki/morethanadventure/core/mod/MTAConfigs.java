package com.fuyuaki.morethanadventure.core.mod;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
public class MTAConfigs
{
    public static class Client {
        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

//
//        public static final ModConfigSpec.BooleanValue REVAMPED_RAIN = BUILDER
//                .comment("If rain and thunder should have unique effects")
//                .define("revamped_rain",false);
//




        static final ModConfigSpec SPEC = BUILDER.build();


    }


    public static class Common {

        private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

        public static final ModConfigSpec.IntValue SPRINKLER_RANGE = BUILDER
                .comment("Range of effect of the Sprinkler")
                .defineInRange("sprinkler_range", 8, 1, 16);


        public static final ModConfigSpec.IntValue COMMON_REGION_WEIGHT = BUILDER
                .comment("Weight for the common regions for Terrablender")
                .defineInRange("terrablender_common_weight", 6, 0, Integer.MAX_VALUE);

        public static final ModConfigSpec.IntValue RARE_REGION_WEIGHT = BUILDER
                .comment("Weight for the rare regions for Terrablender")
                .defineInRange("terrablender_common_weight", 4, 0, Integer.MAX_VALUE);


        static final ModConfigSpec SPEC = BUILDER.build();


        private static boolean validateItemName(final Object obj){
            return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(ResourceLocation.parse(itemName));
        }

    }

}

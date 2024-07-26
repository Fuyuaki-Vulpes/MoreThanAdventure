package com.fuyuvulpes.morethanadventure.core.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class MtaTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register("mtatab", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.morethanadventure")) //The language key for the title of your CreativeModeTab
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(MtaItems.NETHERITE_FRACTURE.get()::getDefaultInstance)
            .displayItems((parameters, output) -> {
                //BLOCKS
                output.accept(MtaBlocks.SPRINKLER.get());
                //ITEMS
                output.accept(MtaItems.CLEAR_QUARTZ);
                output.accept(MtaItems.NETHERITE_FRACTURE);
                output.accept(MtaItems.AGATE);
                output.accept(MtaItems.ALEXANDRITE);
                output.accept(MtaItems.AQUAMARINE);
                output.accept(MtaItems.CELESTITE);
                output.accept(MtaItems.GARNET);
                output.accept(MtaItems.MOONSTONE);
                output.accept(MtaItems.ARMAMENT_UPGRADE);
                output.accept(MtaItems.LOYALTY_UPGRADE);
                output.accept(MtaItems.AQUATIC_UPGRADE);
                output.accept(MtaItems.ANGELIC_UPGRADE);
                output.accept(MtaItems.BERSERK_UPGRADE);
                output.accept(MtaItems.FEATHERWEIGHT_UPGRADE);





                //TOOLS



                //FOOD
                output.accept(MtaItems.ONION);
                output.accept(MtaItems.SHRIMP);
                output.accept(MtaItems.COOKED_SHRIMP);
                output.accept(MtaItems.RED_PEPPER);
                output.accept(MtaItems.CHILI_PEPPER);
                output.accept(MtaItems.TOMATO);
                output.accept(MtaItems.RICE);
                output.accept(MtaItems.RICE_BALL);
                output.accept(MtaItems.COCONUT);
                output.accept(MtaItems.COCONUT_MILK);
                output.accept(MtaItems.COCONUT_SLICE);
                output.accept(MtaItems.SPICE_MIX);
                output.accept(MtaItems.SWEET_BEEF_CURRY);
                output.accept(MtaItems.SWEET_PORK_CURRY);
                output.accept(MtaItems.SWEET_CHICKEN_CURRY);
                output.accept(MtaItems.SWEET_SHRIMP_CURRY);
                output.accept(MtaItems.MILD_BEEF_CURRY);
                output.accept(MtaItems.MILD_PORK_CURRY);
                output.accept(MtaItems.MILD_CHICKEN_CURRY);
                output.accept(MtaItems.MILD_SHRIMP_CURRY);
                output.accept(MtaItems.SPICY_BEEF_CURRY);
                output.accept(MtaItems.SPICY_PORK_CURRY);
                output.accept(MtaItems.SPICY_CHICKEN_CURRY);
                output.accept(MtaItems.SPICY_SHRIMP_CURRY);


                //SPAWNS

                output.accept(MtaItems.YUKI_ONNA_SPAWN_EGG);
            }).build());



    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}

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
            .icon(Items.POTATO::getDefaultInstance)
            .displayItems((parameters, output) -> {
                output.accept(MtaBlocks.SPRINKLER.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());



    public static void register(IEventBus eventBus){
        TABS.register(eventBus);
    }

}

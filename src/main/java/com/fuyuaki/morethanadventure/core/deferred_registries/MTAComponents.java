package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.item.component.CraftableDrink;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAComponents {
    public static final DeferredRegister.DataComponents COMPONENTS = DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE,MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<CraftableDrink>> CRAFTABLE_DRINK = COMPONENTS.registerComponentType(
            "craftable_drink", builder -> builder.persistent(CraftableDrink.CODEC).networkSynchronized(CraftableDrink.STREAM_CODEC).cacheEncoding());

    //public static final DeferredHolder<DataComponentType<?>, DataComponentType<ConditionalEffect<Using>>> USING =
    //        COMPONENTS.registerComponentType("using",
    //                builder -> builder
    //                        .persistent(ConditionalEffect.codec(Using.CODEC, LootContextParamSets.ENCHANTED_ENTITY))
    //                        .build());


    public static void register(IEventBus eventBus){
        COMPONENTS.register(eventBus);
    }


}

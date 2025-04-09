package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.traits.Trait;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTATraits {
    public static final DeferredRegister<Trait> TRAIT_REGISTRY =
            DeferredRegister.create(MTARegistries.Registries.TRAITS,MODID);

    public static final DeferredHolder<Trait, Trait> EMPTY = TRAIT_REGISTRY.register("empty", () -> new Trait(Component.empty(), true));

    public static void register(IEventBus eventBus){
        TRAIT_REGISTRY.register(eventBus);

    }
}

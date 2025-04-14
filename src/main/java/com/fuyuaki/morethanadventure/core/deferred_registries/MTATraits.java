package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.traits.ParticleEmitterTrait;
import com.fuyuaki.morethanadventure.game.species.traits.core.Trait;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.Vec3;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTATraits {
    public static final DeferredRegister<Trait> TRAIT_REGISTRY =
            DeferredRegister.create(MTARegistries.Registries.TRAITS,MODID);

    public static final DeferredHolder<Trait, Trait> EMPTY = TRAIT_REGISTRY.register("empty", () -> new Trait(Component.empty(), true));


    public static final DeferredHolder<Trait, Trait> FLAME_TRAIT = TRAIT_REGISTRY.register("flame_trait",
            () -> new ParticleEmitterTrait(ParticleTypes.FLAME, new Vec3(1.0F,0.0F,1.0F), new Vec3(2.0F,0.5F,2.0F),
                    Component.empty(), false));

    public static void register(IEventBus eventBus){
        TRAIT_REGISTRY.register(eventBus);

    }
}

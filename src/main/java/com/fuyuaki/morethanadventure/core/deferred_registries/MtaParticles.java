package com.fuyuaki.morethanadventure.core.deferred_registries;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, MODID);


    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GEYSER_WATER = simpleParticle("geyser_water",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GEYSER_LAVA = simpleParticle("geyser_lava",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPRINKLER = simpleParticle("sprinkler",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> UNPOPPABLE_BUBBLE = simpleParticle("unpoppable_bubble",false);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> POISON_BUBBLE = simpleParticle("poison_bubble",false);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOOD = simpleParticle("blood_particle",false);

    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SLASH_ATTACK = simpleParticle("slash_attack",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> STAB_ATTACK = simpleParticle("stab_attack",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DAGGER_ATTACK = simpleParticle("dagger_attack",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> TEAR_ATTACK = simpleParticle("tear_attack",false);


    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> WHIP_ATTACK = simpleParticle("whip_attack",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> ANCHOR_ATTACK = simpleParticle("anchor_attack",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_WOOD = simpleParticle("flail_wooden",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_STONE = simpleParticle("flail_stone",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_COPPER = simpleParticle("flail_copper",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_GOLD = simpleParticle("flail_gold",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_IRON = simpleParticle("flail_iron",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_NETHERSTEEL = simpleParticle("flail_nethersteel",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_DIAMOND = simpleParticle("flail_diamond",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> FLAIL_NETHERITE = simpleParticle("flail_netherite",false);


    private static <I extends Block> DeferredHolder<ParticleType<?>, SimpleParticleType> simpleParticle(String name, boolean overrideLimiter) {
        return PARTICLES.register(name, () -> new SimpleParticleType(false));
    }


    public static void register(IEventBus eventBus){
        PARTICLES.register(eventBus);
    }
}

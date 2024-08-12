package com.fuyuaki.morethanadventure.core.registry;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MtaParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(Registries.PARTICLE_TYPE, MODID);


    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GEYSER_WATER = simpleParticle("geyser_water",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> GEYSER_LAVA = simpleParticle("geyser_lava",false);
    public static final DeferredHolder<ParticleType<?>, SimpleParticleType> SPRINKLER = simpleParticle("sprinkler",false);



    private static <I extends Block> DeferredHolder<ParticleType<?>, SimpleParticleType> simpleParticle(String name, boolean overrideLimiter) {
        return PARTICLES.register(name, () -> new SimpleParticleType(false));
    }


    public static void register(IEventBus eventBus){
        PARTICLES.register(eventBus);
    }
}

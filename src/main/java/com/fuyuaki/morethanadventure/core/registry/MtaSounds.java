package com.fuyuaki.morethanadventure.core.registry;

import com.fuyuaki.morethanadventure.core.MTAMod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class MtaSounds {
    public static DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, MTAMod.MODID);


    public static final Supplier<SoundEvent> CAPYBARA_HURT = registerSoundEvent("capybara_hurt");
    public static final Supplier<SoundEvent> DUCK_AMBIENT_1 = registerSoundEvent("duck_ambient_1");
    public static final Supplier<SoundEvent> DUCK_AMBIENT_2 = registerSoundEvent("duck_ambient_2");
    public static final Supplier<SoundEvent> DUCK_LAUGH_1 = registerSoundEvent("duck_laugh_1");


    private static Supplier<SoundEvent> registerSoundEvent (String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(MTAMod.MODID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}

package com.fuyuaki.morethanadventure.core.deferred_registries;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAAttributes {
    private static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(Registries.ATTRIBUTE, MODID);


    public static final Holder<Attribute> SOUL_GATHERING = ATTRIBUTES.register("soul_gathering",
            () -> new RangedAttribute("mta.soul_gathering",
                    1.0D, 1.0D, 10.0)
                    .setSyncable(true)
                    .setSentiment(Attribute.Sentiment.NEUTRAL));


    public static final Holder<Attribute> MAGIC_STORAGE_SCALE = ATTRIBUTES.register("magic_storage",
            () -> new RangedAttribute("mta.magic_storage",
                    1.0D, 0.1D, 100.0)
                    .setSyncable(true)
                    .setSentiment(Attribute.Sentiment.NEUTRAL));


    public static void register(IEventBus eventBus){
        ATTRIBUTES.register(eventBus);
    }

}

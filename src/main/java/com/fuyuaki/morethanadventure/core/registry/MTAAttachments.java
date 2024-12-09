package com.fuyuaki.morethanadventure.core.registry;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MTAAttachments {

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MODID);



    public static void register(IEventBus eventBus){
        ATTACHMENTS.register(eventBus);
    }




}

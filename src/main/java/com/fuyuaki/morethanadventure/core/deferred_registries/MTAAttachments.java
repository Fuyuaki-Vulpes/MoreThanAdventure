package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.world.entity.attachments.RespawnablePetsAttachment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAAttachments {

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MODID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<RespawnablePetsAttachment>> PETS_TO_RESPAWN = ATTACHMENTS.register("pets_to_respawn",
            () -> AttachmentType.serializable(RespawnablePetsAttachment::new)
                    .copyOnDeath().build()
    );


    public static void register(IEventBus eventBus){
        ATTACHMENTS.register(eventBus);
    }




}

package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import com.fuyuaki.morethanadventure.world.entity.attachments.RespawnablePetsAttachment;
import com.fuyuaki.morethanadventure.world.entity.attachments.SoulCharge;
import com.fuyuaki.morethanadventure.world.entity.attachments.SpeciesAttachment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.ArrayList;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTAAttachments {

    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MODID);

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<RespawnablePetsAttachment>> PETS_TO_RESPAWN = ATTACHMENTS
            .register("pets_to_respawn",
            () -> AttachmentType.serializable( ()  -> new RespawnablePetsAttachment(new ArrayList<>()))
                    .copyOnDeath().build()
            );

    public static final DeferredHolder<AttachmentType<?>, AttachmentType<SoulCharge>> SOUL_CHARGE = ATTACHMENTS
            .register("soul_charge",
                    () -> AttachmentType.serializable(() -> new SoulCharge(200)).copyOnDeath().build()

            );
    public static final DeferredHolder<AttachmentType<?>, AttachmentType<SpeciesAttachment>> SPECIES = ATTACHMENTS
            .register("species",
                    () -> AttachmentType.serializable(SpeciesAttachment::new).copyOnDeath().build()

            );



    public static void register(IEventBus eventBus){
        ATTACHMENTS.register(eventBus);
    }




}

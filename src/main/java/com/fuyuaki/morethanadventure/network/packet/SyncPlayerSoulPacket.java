package com.fuyuaki.morethanadventure.network.packet;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.world.entity.attachments.SoulCharge;
import io.wispforest.accessories.networking.client.SyncData;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import net.minecraft.world.entity.player.Player;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public record SyncPlayerSoulPacket(SoulCharge soulCharge) {

    public static StructEndec<SyncPlayerSoulPacket> ENDEC = StructEndecBuilder.of(
            SoulCharge.ENDEC.fieldOf("soulCharge", SyncPlayerSoulPacket::soulCharge),
            SyncPlayerSoulPacket::new
    );



    @OnlyIn(Dist.CLIENT)
    public static void handlePacket(SyncPlayerSoulPacket packet, Player player) {
        player.setData(MTAAttachments.SOUL_CHARGE,packet.soulCharge);

    }


}

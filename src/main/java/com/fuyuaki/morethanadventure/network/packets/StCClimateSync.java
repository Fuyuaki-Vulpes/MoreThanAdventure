package com.fuyuaki.morethanadventure.network.packets;

import com.fuyuaki.morethanadventure.world.level.weather.MTAClimate;
import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import net.minecraft.world.entity.player.Player;

public record StCClimateSync(
        float windDirection,
        float temperature,
        float humidity,
        float rainIntensity,
        float windIntensity,
        boolean rain,
        boolean snow,
        boolean thunder
) {


    public static StructEndec<StCClimateSync> ENDEC = StructEndecBuilder.of(
            Endec.FLOAT.fieldOf("wind", StCClimateSync::windDirection),
            Endec.FLOAT.fieldOf("temperature", StCClimateSync::temperature),
            Endec.FLOAT.fieldOf("humidity", StCClimateSync::humidity),
            Endec.FLOAT.fieldOf("rainIntensity", StCClimateSync::rainIntensity),
            Endec.FLOAT.fieldOf("windIntensity", StCClimateSync::windIntensity),
            Endec.BOOLEAN.fieldOf("rain", StCClimateSync::rain),
            Endec.BOOLEAN.fieldOf("snow", StCClimateSync::snow),
            Endec.BOOLEAN.fieldOf("thunder", StCClimateSync::thunder),
            StCClimateSync::new
    );

    public static void handlePacket(StCClimateSync packet, Player player) {
        MTAClimate.syncClimateDataFromServer(packet.windDirection(), packet.temperature(), packet.humidity(), packet.rainIntensity(), packet.windIntensity(), packet.rain(), packet.snow(), packet.thunder());
    }

}

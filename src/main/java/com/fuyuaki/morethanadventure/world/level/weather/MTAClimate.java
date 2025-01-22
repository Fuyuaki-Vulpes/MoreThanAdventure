package com.fuyuaki.morethanadventure.world.level.weather;

import com.fuyuaki.morethanadventure.world.level.weather.wind.WeatherControl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;

public class MTAClimate {

    private static WeatherControl weatherControl = null;



    public static void tickClient(ClientLevel level, Minecraft minecraft){
        WeatherParticleControl.update(level,minecraft.cameraEntity, minecraft.getFrameTimeNs());

    }

    public static void tickServer(ServerLevel level){
        if(weatherControl != null) {
            weatherControl.tick(level);

        }
    }

    public static void load(LevelAccessor accessor) {
        if (accessor.getServer().getWorldData() == null) return;

        weatherControl = new WeatherControl().from(accessor.getServer().getWorldData().createTag(accessor.registryAccess(),null));
    }

    public static void save(LevelAccessor accessor) {
        if (accessor.getServer().getWorldData() == null) return;
        weatherControl.save(accessor.getServer().getWorldData().createTag(accessor.registryAccess(),null));
    }

    public static WeatherControl getWeatherControl() {
        return weatherControl;
    }

}

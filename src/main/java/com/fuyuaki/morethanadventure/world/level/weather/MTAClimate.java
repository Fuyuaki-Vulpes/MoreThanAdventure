package com.fuyuaki.morethanadventure.world.level.weather;

import com.fuyuaki.morethanadventure.network.MTANetwork;
import com.fuyuaki.morethanadventure.network.packets.StCClimateSync;
import com.fuyuaki.morethanadventure.world.level.weather.wind.WeatherControl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.LevelAccessor;

public class MTAClimate {

    private static WeatherControl weatherControl = null;

    private static int ticks = 0;


    private static ClimateData climateData = new ClimateData(0,0,0,0, 0, false,false,false);



    public static void tickClient(ClientLevel level, Minecraft minecraft){
        WeatherParticleControl.update(level,minecraft.cameraEntity, minecraft.getFrameTimeNs());


    }

    public static void tickServer(ServerLevel level){
        if(weatherControl != null) {
            weatherControl.tick(level);

        }
        ticks++;
        if (ticks >= 5){
            level.players().forEach(MTAClimate::sendClimateData);
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

    public static ClimateData getClimateData() {
        return climateData;
    }

    public static void syncClimateDataFromServer(float windDirection, float temperature, float humidity, float rainIntensity, float windIntensity, boolean rain, boolean snow, boolean thunder){
        climateData = new ClimateData(windDirection,temperature,humidity,rainIntensity,windIntensity,rain,snow,thunder);
    }

    public static ClimateData getClimmateData(ServerPlayer player){
        WeatherControl.WindData data = weatherControl.getWindData();
        WeatherControl.ChunkWindData  chunkData = data.getChunkWindData(player.chunkPosition(),player.level());
        float dayCycle = ((float) player.level().getTimeOfDay(0) * 2 - 1);
        float windDirection = data.getWindDirectionDegrees();
        float temperature = chunkData.getLogicalTemperature(player);
        float humidity = chunkData.getLogicalHumidity(player);
        float rainIntensity = chunkData.getRainStrenght();
        float windIntensity = chunkData.getWindStrenght(dayCycle);
        boolean rain = chunkData.isRaining();
        boolean snow = chunkData.isSnowing();
        boolean thunder = chunkData.isThundering(dayCycle);
        return new ClimateData(windDirection,temperature,humidity,rainIntensity,windIntensity,rain,snow,thunder);
    }
    public static void sendClimateData(ServerPlayer player){
        WeatherControl.WindData data = weatherControl.getWindData();
        WeatherControl.ChunkWindData  chunkData = data.getChunkWindData(player.chunkPosition(),player.level());
        float dayCycle = ((float) player.level().getTimeOfDay(0) * 2 - 1);
        float windDirection = data.getWindDirectionDegrees();
        float temperature = chunkData.getLogicalTemperature(player);
        float humidity = chunkData.getLogicalHumidity(player);
        float rainIntensity = chunkData.getRainStrenght();
        float windIntensity = chunkData.getWindStrenght(dayCycle);
        boolean rain = chunkData.isRaining();
        boolean snow = chunkData.isSnowing();
        boolean thunder = chunkData.isThundering(dayCycle);

        MTANetwork.sendToPlayer(player,new StCClimateSync(windDirection,temperature,humidity,rainIntensity,windIntensity,rain,snow,thunder));
    }

    public record ClimateData(float windDirection, float temperature, float humidity, float rainIntensity, float windIntensity, boolean rain, boolean snow, boolean thunder){

    }

}

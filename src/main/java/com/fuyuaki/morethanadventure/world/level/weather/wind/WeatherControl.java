package com.fuyuaki.morethanadventure.world.level.weather.wind;

import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.SectionPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;

import java.util.*;

public class WeatherControl{

    private static final Logger LOGGER = LogUtils.getLogger();

    static WindData windData;


    public static void tick(ServerLevel level){
        if (level.isClientSide() || !level.dimensionTypeRegistration().is(BuiltinDimensionTypes.OVERWORLD)) return;
        if (windData == null) windData = new WindData();
        windData.tick(level);

    }


    public void setWindData(WindData windData) {
        WeatherControl.windData = windData;
    }

    public WeatherControl from(CompoundTag tag){
        LOGGER.info("Loading Wind Data");
        WeatherControl control = new WeatherControl();
        WindData data = new WindData();
        if (!tag.contains("WindData")) return control;
        control.setWindData(WindData.fromTag(data.read(tag.getCompound("WindData"))));

        if (windData == null) windData = new WindData();

        return control;
    }


    public CompoundTag save(CompoundTag tag) {
        LOGGER.info("Saving Wind Data");
        if (windData == null) windData = new WindData();
        CompoundTag compoundtag = windData.write(new CompoundTag());
        tag.put("WindData", compoundtag);

        return tag;
    }

    public static WindData getWindData() {
        return windData;
    }

    public static class WindData{

        float windDirection;
        List<ChunkPos> knownChunks;
        Map<ChunkPos,ChunkWindData> chunkWindDataMap ;
        private int tickCount;


        public float getChunkWindStrenght(ServerLevel level, ChunkPos center) {
            ChunkWindData chunk = getChunkWindData(center,level);
            List<Float> toChunks = new ArrayList<>();
            List<Float> fromChunks = new ArrayList<>();

            float dayCycle = -((float) level.getTimeOfDay(0) * 2 - 1);

            for (ChunkPos pos : ChunkPos.rangeClosed(center,1).toList()){
                if (pos != center) {
                    ChunkWindData chunk1 = getChunkWindData(pos, level);
                    float pressure = chunk1.getLogicalPressure(dayCycle) - chunk.getLogicalPressure(dayCycle);
                    if (chunk1.getLogicalPressure(dayCycle) > chunk.getLogicalPressure(dayCycle)) {
                        fromChunks.add(pressure);
                    }
                    if (chunk1.getLogicalPressure(dayCycle) < chunk.getLogicalPressure(dayCycle)) {
                        toChunks.add(pressure);
                    }
                }
            }
            if (toChunks.isEmpty()){
                return 0.0F;
            }
            if (fromChunks.isEmpty()){
                return 1.0F;
            }
            float wind = 0;
            for (Float float1 : fromChunks){
                wind += float1;
            }
            for (Float float1 : toChunks){
                wind += float1;
            }
            wind = wind / toChunks.size() + fromChunks.size();

            return wind;
        }

        public Vec3 getChunkWindDirection(ServerLevel level, ChunkPos center) {
            ChunkWindData chunk = getChunkWindData(center,level);
            Vec3 direction = new Vec3(0,0,0);

            float dayCycle = -((float) level.getTimeOfDay(0) * 2 - 1);

            for (ChunkPos pos : ChunkPos.rangeClosed(center,1).toList()){
                if (pos != center) {

                    ChunkWindData chunk1 = getChunkWindData(pos, level);
                    Vec3 offset = new Vec3(pos.x - center.x, 0, pos.z - center.z);
                    if (chunk1.getLogicalPressure(dayCycle) > chunk.getLogicalPressure(dayCycle)) {
                        direction = direction.subtract(offset);
                    }
                    if (chunk1.getLogicalPressure(dayCycle) < chunk.getLogicalPressure(dayCycle)) {
                        direction = direction.add(offset);
                    }
                }
            }


            return direction.normalize().add(0,chunk.airTemperature,0);
        }

        public WindData(){
            this.windDirection = 0.0F;
            this.chunkWindDataMap= new HashMap<>();
            this.knownChunks = new ArrayList<>();
            this.tickCount = 0;
        }

        public void tick(ServerLevel level){
            this.tickCount++;
            this.rotateWind(level.getRandom().nextFloat() * 4 - 2);

            if (this.tickCount >= 5 ){
                List<ServerPlayer> players = level.players();
                for (ServerPlayer player : players) {

                    int xPos = SectionPos.posToSectionCoord(player.getOnPos().getX());
                    int zPos = SectionPos.posToSectionCoord(player.getOnPos().getZ());
                    for (int xOff = -4; xOff < 4; xOff++) {
                        for (int zOff = -4; zOff < 4; zOff++) {
                            int x = xPos + xOff;
                            int z = zPos + zOff;
                            LevelChunk levelchunk = level.getChunk(x, z);

                            if (levelchunk != null && level.isLoaded(levelchunk.getPos().getWorldPosition().atY(70))) {
                                tickChunk(levelchunk.getPos(), level);
                            }
                        }
                    }
                }
                this.tickCount = 0;

            }
        }

        private void tickChunk(ChunkPos chunkPos, Level level) {
            ChunkWindData chunk = getChunkWindData(chunkPos,level);

            float xWind = Mth.clamp(Mth.cos(this.windDirection * (float) (Math.PI / 180.0)) * 20,-1,1);
            float zWind =  Mth.clamp(-Mth.sin(this.windDirection * (float) (Math.PI / 180.0)) * 20,-1,1);

            float dayCycle = ((float) level.getTimeOfDay(0) * 2 - 1);
                for (ChunkPos pos : ChunkPos.rangeClosed(chunkPos, 1).toList()) {
                    if (pos != chunkPos) {
                        ChunkWindData chunk1 = getChunkWindData(pos, level);

                        if (chunk1.getLogicalPressure(dayCycle) > chunk.getLogicalPressure(dayCycle)) {
                            chunk1 = chunk.moveFrom(chunk1,
                                    (chunk1.getLogicalPressure(dayCycle) - chunk.getLogicalPressure(dayCycle)) * 0.2F
                            );
                        }
                        if (chunkPos.x - xWind == pos.x) {
                            chunk1 = chunk.moveFrom(chunk1, 0.05F);

                        }
                        if (chunkPos.z - zWind == pos.z) {
                            chunk1 = chunk.moveFrom(chunk1, 0.05F);

                        }
                        this.chunkWindDataMap.put(pos, chunk1);
                    }
                }

            chunk.tick();
            this.chunkWindDataMap.put(chunkPos,chunk);
        }

        public ChunkWindData getChunkWindData(ChunkPos pos, Level level) {
            if (!chunkWindDataMap.containsKey(pos)){
                chunkWindDataMap.put(pos,ChunkWindData.makeChunkWindData(level, pos.x, pos.z));

            }
            return chunkWindDataMap.get(pos);
        }

        public float getWindDirectionDegrees() {
            return windDirection;
        }
        public float getWindDirectionRadians() {
            return Mth.DEG_TO_RAD * windDirection;
        }

        public void setWindDirection(float windDirection) {
            this.windDirection = windDirection;
        }
        public void setWindDirectionFromRad(double windDirection) {
            this.windDirection = (float) (windDirection * Mth.RAD_TO_DEG);
        }
        public void rotateWind(float degrees){
            this.windDirection = this.windDirection + degrees;
            if (this.windDirection > 180){
                this.windDirection = this.windDirection - 360;
            }if (this.windDirection < -180){
                this.windDirection = this.windDirection + 360;
            }
        }


        public CompoundTag write(CompoundTag tag){
            tag.putFloat("GlobalWindDirection", windDirection);
            ListTag listTag = new ListTag();
            for( int n = 0; n < knownChunks.size(); n++){
                CompoundTag tag1 = new CompoundTag();
                CompoundTag chunkWindData = this.chunkWindDataMap.get(knownChunks.get(n)).save(new CompoundTag());;
                CompoundTag chunkPos = new CompoundTag();
                chunkPos.putInt("X",knownChunks.get(n).x);
                chunkPos.putInt("Z",knownChunks.get(n).z);
                tag1.put("ChunkPos",chunkPos);
                tag1.put("ChunkWindData",chunkWindData);

                listTag.add(n,tag1);
            }

            tag.put("KnownChunks",listTag);

            return tag;
        }

        public CompoundTag read(CompoundTag tag){
            this.windDirection = tag.getFloat("GlobalWindDirection");
            ListTag listTag = tag.getList("KnownChunks",10);
            for (int i = 0; i < listTag.size(); i++){
                CompoundTag t = listTag.getCompound(i).getCompound("ChunkPos");
                CompoundTag t1 = listTag.getCompound(i).getCompound("ChunkWindData");
                ChunkPos pos = new ChunkPos(t.getInt("X"),t.getInt("Z"));
                ChunkWindData data = ChunkWindData.load(t1);
                this.chunkWindDataMap.put(pos,data);
                this.knownChunks.add(i,pos);
            }
            return tag;
        }

        public static WindData fromTag(CompoundTag tag){
            WindData wind = new WindData();
            wind.setWindDirection(tag.getFloat("GlobalWindDirection"));
            ListTag listTag = tag.getList("KnownChunks",10);

            for (int i = 0; i < listTag.size(); i++){
                CompoundTag t = listTag.getCompound(i).getCompound("ChunkPos");
                CompoundTag t1 = listTag.getCompound(i).getCompound("ChunkWindData");
                ChunkPos pos = new ChunkPos(t.getInt("X"),t.getInt("Z"));
                ChunkWindData data = ChunkWindData.load(t1);
                wind.chunkWindDataMap.put(pos,data);
                wind.knownChunks.add(i,pos);
            }
            return wind;
        }
    }

    public static class ChunkWindData{


        float localPressure;
        float storedTemperature;
        float wetness;

        float pressure;

        float density;
        float charge;
        float humidity;
        float airTemperature;
        float airHumidity;

        float processingPressure;
        float processingDensity;
        float processingCharge;
        float processingHumidity;
        float processingAirTemperature;
        float processingAirHumidity;
        int ticks;


        public ChunkWindData(float wetness, float storedTemperature, float localPressure) {
            this(wetness,storedTemperature,localPressure,0,0,0,0,0);
        }

        public ChunkWindData(float wetness, float storedTemperature, float localPressure, float density, float charge, float humidity, float airTemperature, float airHumidity) {
            this.wetness = wetness;
            this.storedTemperature = storedTemperature;
            this.pressure = 0;
            this.localPressure = localPressure;
            this.density = density;
            this.charge = charge;
            this.humidity = humidity;
            this.airTemperature = airTemperature;
            this.airHumidity = airHumidity;
            this.processingPressure = 0;
            this.processingDensity = 0;
            this.processingCharge = 0;
            this.processingHumidity = 0;
            this.processingAirTemperature = 0;
            this.processingAirHumidity = 0;
            this.ticks = 0;
        }

        public ChunkWindData(float wetness, float storedTemperature, float localPressure, float pressure, float density, float charge, float humidity, float airTemperature, float airHumidity, float processingPressure, float processingDensity, float processingCharge, float processingHumidity, float processingAirTemperature, float processingAirHumidity) {
            this.wetness = wetness;
            this.storedTemperature = storedTemperature;
            this.pressure = pressure;
            this.localPressure = localPressure;
            this.density = density;
            this.charge = charge;
            this.humidity = humidity;
            this.airTemperature = airTemperature;
            this.airHumidity = airHumidity;
            this.processingPressure = processingPressure;
            this.processingDensity = processingDensity;
            this.processingCharge = processingCharge;
            this.processingHumidity = processingHumidity;
            this.processingAirTemperature = processingAirTemperature;
            this.processingAirHumidity = processingAirHumidity;
            this.ticks = 0;
        }



        public static ChunkWindData makeChunkWindData(Level level, int x, int z){
            float localPressure;
            float storedTemperature;
            float wetness;



            if (level != null){
                ChunkPos chunkpos = new ChunkPos(x, z);

                LevelChunk levelchunk = level.getChunk(x, z);

                if (levelchunk == null) {
                    localPressure = 0;
                    storedTemperature = 0;
                    wetness = 0;
                } else {
                    BlockPos blockpos = chunkpos.getWorldPosition().atY(90);
                    int a = level.getHeight(Heightmap.Types.WORLD_SURFACE, blockpos.getX() + 8, blockpos.getZ() + 8);
                    blockpos = blockpos.atY(a);
                    float t = ((float) a - level.getSeaLevel()) / (level.getSeaLevel());
                    localPressure = Math.clamp(t, -1.5F,1.5F) * -1.0F;
                    Holder<Biome> biome = level.getBiome(blockpos);
                    wetness = biome.value().getModifiedClimateSettings().downfall();
                    storedTemperature =  (biome.value().getModifiedClimateSettings().temperature() - 0.5F) * 0.5F;



                }
            }else {
                localPressure = 0;
                wetness = 0;
                storedTemperature = 0;
            }

            return new ChunkWindData(wetness,storedTemperature,localPressure);
        }



        public float getLogicalPressure(float dayCycle) {
            return (this.pressure + (this.localPressure * dayCycle)) / 2;
        }

        public boolean isRaining() {
            return this.density > 0.2F && this.getRainStrenght() > 0.1;
        }

        public boolean isSnowing() {
            return (this.airTemperature * this.storedTemperature) * this.wetness < 0.0F;
        }

        public boolean isThundering(float dayCycle) {
            return this.charge > 0.3F && (this.getLogicalPressure(dayCycle) < 0.2F || this.density > 1.2F);
        }

        public float getRainStrenght() {
            return this.density * this.airHumidity / 2;
        }

        public float getWindStrenght(float dayCycle) {
            return -this.getLogicalPressure(dayCycle)
                    * (this.airHumidity / 2)
                    - this.getLogicalPressure(dayCycle) * 0.5F
                    + this.airTemperature
                    ;
        }





        public CompoundTag save(CompoundTag tag){
            tag.putFloat("Wetness",this.wetness);
            tag.putFloat("StoredTemperature",this.storedTemperature);
            tag.putFloat("LocalPressure",this.localPressure);
            tag.putFloat("Pressure",this.pressure);
            tag.putFloat("Density",this.density);
            tag.putFloat("Charge",this.charge);
            tag.putFloat("Humidity",this.humidity);
            tag.putFloat("AirTemperature",this.airTemperature);
            tag.putFloat("AirHumidity",this.airHumidity);
            CompoundTag processing = new CompoundTag();
            processing.putFloat("Pressure",this.processingPressure);
            processing.putFloat("Density",this.processingDensity);
            processing.putFloat("Charge",this.processingCharge);
            processing.putFloat("Humidity",this.processingHumidity);
            processing.putFloat("AirTemperature",this.processingAirTemperature);
            processing.putFloat("AirHumidity",this.processingAirHumidity);
            tag.put("Processing",processing);
            return tag;
        }


        private static float safelyLoad(float number){
            return Float.isNaN(number) ? 0 : number;
        }

        public static ChunkWindData load(CompoundTag tag){
            float wetness = safelyLoad(tag.getFloat("Wetness"));
            float temp = safelyLoad(tag.getFloat("StoredTemperature"));
            float pressure = safelyLoad(tag.getFloat("Pressure"));
            float localPressure = safelyLoad(tag.getFloat("LocalPressure"));
            float density = safelyLoad(tag.getFloat("Density"));
            float charge = safelyLoad(tag.getFloat("Charge"));
            float humidity = safelyLoad(tag.getFloat("Humidity"));
            float airTemperature = safelyLoad(tag.getFloat("AirTemperature"));
            float airHumidity = safelyLoad(tag.getFloat("AirHumidity"));
            CompoundTag processing = tag.getCompound("Processing");

            float processingPressure = safelyLoad(processing.getFloat("Pressure"));
            float processingDensity = safelyLoad(processing.getFloat("Density"));
            float processingCharge = safelyLoad(processing.getFloat("Charge"));
            float processingHumidity = safelyLoad(processing.getFloat("Humidity"));
            float processingAirTemperature = safelyLoad(processing.getFloat("AirTemperature"));
            float processingAirHumidity = safelyLoad(processing.getFloat("AirHumidity"));
            return new ChunkWindData(wetness,
                    temp,
                    pressure,
                    localPressure,
                    density,
                    charge,
                    humidity,
                    airTemperature,
                    airHumidity,
                    processingPressure,
                    processingDensity,
                    processingCharge,
                    processingHumidity,
                    processingAirTemperature,
                    processingAirHumidity
            );
        }

        public void tick() {

            this.ticks++;
            if (ticks >= 4){

            this.processingAirTemperature = Mth.clamp(this.processingAirTemperature,-1.0F,1.0F);
            this.processingAirHumidity = Mth.clamp(this.processingAirHumidity,-1.0F,1.0F);
            this.processingHumidity = Mth.clamp(this.processingHumidity,-1.0F,1.0F);
            this.processingDensity = Mth.clamp(this.processingDensity,-2.0F,2.0F);
            this.processingCharge = Mth.clamp(this.processingCharge,0.0F,3.0F);
            this.processingPressure = Mth.clamp(this.processingPressure,-1.0F,1.0F);

                if (Math.abs(this.processingAirTemperature) > 0.6F ){
                    this.processingCharge += RandomSource.create().nextFloat() * 0.3F;
                }
                if (this.processingDensity > 0.2F){
                    this.processingPressure += this.processingDensity / 3;
                }

                ticks = 0;

                this.pressure += this.processingPressure;
                this.processingPressure = 0;

                this.density += this.processingDensity;
                this.processingDensity = 0;

                this.charge += this.processingCharge;
                this.processingCharge = 0;

                this.humidity += this.processingHumidity;
                this.processingHumidity = 0;

                this.airTemperature += this.processingAirTemperature;
                this.processingAirTemperature = 0;

                this.airHumidity += this.processingAirHumidity;
                this.processingAirHumidity = 0;


            }
            RandomSource rand = RandomSource.create();

           if (rand.nextBoolean()){
               if (rand.nextFloat() < 0.1F){
                   float w = Mth.cos(this.storedTemperature) * this.wetness / 10;
                   this.humidity += w  * rand.nextFloat();

                   }
               if (rand.nextFloat() < 0.2F){
                   float temp = Mth.cos(this.storedTemperature) * this.humidity;
                   this.airHumidity += temp * rand.nextFloat() / 10;
               }
               if (this.airTemperature > rand.nextFloat() * 1.5F || this.storedTemperature > rand.nextFloat() * 3){
                   float exchange = rand.nextFloat() / 100 ;
                   if (this.humidity - exchange > 0) {
                       this.humidity -= exchange;
                       this.airHumidity += exchange;
                       this.density += exchange;
                   }
               }
               if (rand.nextFloat() < 0.2F){
                   this.airTemperature += this.storedTemperature * rand.nextFloat() / 5;
               }
           }
           if (rand.nextFloat() < 0.3){
               if (this.humidity != 0.0F){
                   this.humidity = Mth.lerp(rand.nextFloat() / 10, this.humidity,0.0F);
               }
               if (this.airHumidity > 0.0F){
                   this.airHumidity = Mth.lerp(rand.nextFloat() / 10,this.airHumidity,0.0F);
               }
               if (Mth.abs(this.airTemperature) > 0.0F){
                   this.airTemperature = Mth.lerp(rand.nextFloat() / 10,this.airTemperature,0.0F);

               }
           }
            if (this.isRaining()){
                if (this.humidity < 1.0F){
                    this.humidity = Mth.lerp(rand.nextFloat() / 3, this.humidity,1.0F);
                }
                if (this.airHumidity > 0.0F){
                    this.airHumidity = Mth.lerp(rand.nextFloat() / 5,this.airHumidity,0.0F);
                }
                if (Mth.abs(this.airTemperature) > 0.0F){
                    this.airTemperature = Mth.lerp(rand.nextFloat() / 2,this.airTemperature,0.0F);

                }
                if (this.pressure > 0.0F){
                    this.pressure = Mth.lerp(rand.nextFloat() * rand.nextIntBetweenInclusive(10,100),this.pressure,0.0F);

                }
                this.density -= Mth.lerp(rand.nextFloat() * rand.nextIntBetweenInclusive(10,100),this.density,0.0F);
            }

            this.airTemperature = Mth.clamp(this.airTemperature,-1.0F,1.0F);
            this.airHumidity = Mth.clamp(this.airHumidity,-1.0F,1.0F);
            this.humidity = Mth.clamp(this.humidity,-1.0F,1.0F);
            this.density = Mth.clamp(this.density,-2.0F,2.0F);
            this.charge = Mth.clamp(this.charge,0.0F,3.0F);
            this.pressure = Mth.clamp(this.pressure,-1.0F,1.0F);


        }


        public void makeThunder(ServerLevel level){
            this.charge -= level.random.nextFloat() / 4;
        }
        public ChunkWindData moveFrom(ChunkWindData chunk1, float baseRate) {

            float rate = baseRate / 100;
            this.processingPressure += chunk1.pressure * rate;
            chunk1.processingPressure -= chunk1.pressure * rate;

            this.processingDensity += chunk1.density * rate;
            chunk1.processingDensity -= chunk1.density * rate;

            this.processingCharge += chunk1.charge * rate;
            chunk1.processingCharge -= chunk1.charge * rate;

            this.processingHumidity += chunk1.humidity * rate;
            chunk1.processingHumidity -= chunk1.humidity * rate;

            this.processingAirHumidity += chunk1.airHumidity * rate;
            chunk1.processingAirHumidity -= chunk1.airHumidity * rate;

            this.processingAirTemperature += chunk1.airTemperature * rate;
            chunk1.processingAirTemperature -= chunk1.airTemperature * rate;

            return chunk1;
        }

        public float getLogicalTemperature(Player player) {
            float localTemperature = (this.storedTemperature + this.airTemperature) * ( this.humidity + this.airHumidity);

            if (this.isRaining()){
                localTemperature = localTemperature * (1 - this.getRainStrenght());
            }

            return localTemperature;
        }

        public float getLogicalHumidity(Player player) {
            return this.humidity + this.airHumidity;
        }
    }
}

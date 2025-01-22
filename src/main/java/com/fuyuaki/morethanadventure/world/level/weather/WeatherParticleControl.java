package com.fuyuaki.morethanadventure.world.level.weather;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;

public class WeatherParticleControl {
    private static final BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();


    public static void spawner(ClientLevel level, Holder<Biome> biome, double x, double y, double z){
        Biome.Precipitation precipitation = biome.value().getPrecipitationAt(level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, pos),level.getSeaLevel());
        if (precipitation == Biome.Precipitation.RAIN){
            if (level.getRandom().nextFloat() < 0.6 ){
                level.addParticle(MtaParticles.RAINDROP.get(), x, y, z, 0, 0, 0);

            }
        }
        else if (precipitation == Biome.Precipitation.SNOW){
         if (level.getRandom().nextFloat() < 0.4 ){
             level.addParticle(MtaParticles.SNOWFLAKE.get(), x, y, z, 0, 0, 0);

         }
        }

    }


    public static void update(ClientLevel level, Entity entity, float partialTick){
        if (level.isRainingAt(entity.getOnPos().above()) ||  level.getBiome(entity.getOnPos().above()).value().getPrecipitationAt(pos, level.getSeaLevel()) == Biome.Precipitation.SNOW){
            int density;
            if (level.isThundering()){
                density = (int) (level.getRainLevel(partialTick) * 300);
            }else {
                density = (int) (level.getRainLevel(partialTick) * 150);
            }
            RandomSource randomSource = RandomSource.create();
            for (int w = 0; w < density; w++ ){

                double x = randomSource.nextIntBetweenInclusive(-20,20);
                double y = randomSource.nextIntBetweenInclusive(10,30);
                double z = randomSource.nextIntBetweenInclusive(-20,20);

                pos.set(x + entity.getX(), y + entity.getY(), z + entity.getZ());
                if (level.getHeight(Heightmap.Types.MOTION_BLOCKING, pos.getX(), pos.getZ()) > pos.getY())
                    continue;

                spawner(level,
                        level.getBiome(pos),
                        pos.getX() + randomSource.nextFloat(),
                        pos.getY() + randomSource.nextFloat(),
                        pos.getZ() + randomSource.nextFloat());
            }
        }

    }

}

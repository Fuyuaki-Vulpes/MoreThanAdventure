package com.fuyuaki.morethanadventure.game.species.traits;

import com.fuyuaki.morethanadventure.game.species.traits.core.TickingTrait;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class ParticleEmitterTrait extends TickingTrait {

    private final ParticleOptions particle;
    private final Vec3 offsetMax;
    private final Vec3 offsetMin;

    public ParticleEmitterTrait(ParticleOptions particleOptions, Vec3 offsetMin,Vec3 offsetMax, Component description, boolean hidden) {
        super(1, description, hidden);
        this.particle = particleOptions;
        this.offsetMin = offsetMin;
        this.offsetMax = offsetMax;
    }

    @Override
    public void tick(Player player) {
        for (int i = 0; i < 10; i++){
            if (player.getRandom().nextFloat() < 0.5F){
                float position = player.getRandom().nextFloat();
                float positionB = 1- position;

                double xDiff = offsetMax.x - offsetMin.x;
                double xOff = (xDiff * player.getRandom().nextDouble() + offsetMin.x) * position;
                double yDiff = offsetMax.x - offsetMin.y;
                double yOff = xDiff * player.getRandom().nextDouble() + offsetMin.y;
                double zDiff = offsetMax.x - offsetMin.z;
                double zOff = (xDiff * player.getRandom().nextDouble() + offsetMin.z) * positionB;

                double xOff1 = player.getRandom().nextBoolean() ? -xOff : xOff;
                double yOff1 = player.getRandom().nextBoolean() ? -yOff : yOff;
                double zOff1 = player.getRandom().nextBoolean() ? -zOff : zOff;

                ((ServerLevel)(player.level())).sendParticles(particle,
                        player.getX() + xOff1,
                        player.getY() + yOff1,
                        player.getZ() + zOff1 ,player.getRandom().nextIntBetweenInclusive(1,6),
                        0, 0,0,0);
            }
        }
    }
}

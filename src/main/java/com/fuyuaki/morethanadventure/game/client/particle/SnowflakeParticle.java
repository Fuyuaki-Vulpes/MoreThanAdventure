package com.fuyuaki.morethanadventure.game.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class SnowflakeParticle extends WeatherParticle{
    private final int lifetimeMax;

    public SnowflakeParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z, false);
        this.gravity = 0.5F;
        this.yd = -0.6F;
        this.alpha = 0.0F;
        this.quadSize =  0.2F * (this.random.nextFloat() * 0.6F + 0.2F) * 2.0F;
        this.lifetimeMax = this.getLifetime();
    }

    @Override
    public void tick() {

        if (this.alpha < 1.0F){
            this.alpha += 0.2F;
        }

        Vec3 dir = new Vec3(this.xd, this.yd, this.zd);
        dir.yRot(this.random.nextIntBetweenInclusive(-10,10));
        dir.multiply(1,random.nextFloat() + 0.5,1);
        dir.add(0,this.gravity * this.random.nextFloat(),0);

        dir.lerp(new Vec3(0.05,0.3, 0.05),random.nextFloat() / 2);

        this.xd = dir.x;
        this.yd = dir.y;
        this.zd = dir.z;

        if (this.lifetime < this.lifetimeMax / 2){
            this.scale((float) this.lifetime / ((float) this.lifetimeMax / 2));
        }

        super.tick();

    }

    @OnlyIn(Dist.CLIENT)

    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet sprites) {
            this.sprite = sprites;
        }

        public Particle createParticle(
                SimpleParticleType type,
                ClientLevel level,
                double x,
                double y,
                double z,
                double xSpeed,
                double ySpeed,
                double zSpeed
        ) {
            SnowflakeParticle snowflakeParticle = new SnowflakeParticle(level, x, y, z);
            snowflakeParticle.pickSprite(this.sprite);
            return snowflakeParticle;
        }
    }
}

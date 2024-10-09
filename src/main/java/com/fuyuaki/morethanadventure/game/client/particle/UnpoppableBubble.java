package com.fuyuaki.morethanadventure.game.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class UnpoppableBubble extends TextureSheetParticle {
    protected UnpoppableBubble(ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
        super(level, x, y, z, xSpeed, ySpeed, zSpeed);
        this.setSize(0.02F, 0.02F);
        this.quadSize = this.quadSize * (this.random.nextFloat() * 0.6F + 0.2F);
        this.xd = xSpeed / (Math.random() * 0.8 + 0.5) + (Math.random() * 2.0 - 1.0) * 0.02F;
        this.yd = ySpeed / (Math.random() * 0.8 + 0.5) + (Math.random() * 2.0 - 1.0) * 0.02F;
        this.zd = zSpeed / (Math.random() * 0.8 + 0.5) + (Math.random() * 2.0 - 1.0) * 0.02F;
        this.lifetime = (int)(60.0 / (Math.random() * 0.8 + 0.2)) + 10;

    }
    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        } else {
            this.yd += 0.002;
            this.move(this.xd, this.yd, this.zd);
            this.xd *= 0.995F;
            this.yd *= 0.995F;
            this.zd *= 0.995F;
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
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
            UnpoppableBubble bubbleparticle = new UnpoppableBubble(level, x, y, z, xSpeed, ySpeed, zSpeed);
            bubbleparticle.pickSprite(this.sprite);
            return bubbleparticle;
        }
    }
}

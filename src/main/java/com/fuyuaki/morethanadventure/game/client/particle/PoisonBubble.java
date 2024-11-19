package com.fuyuaki.morethanadventure.game.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.tags.FluidTags;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class PoisonBubble extends TextureSheetParticle {

    private final SpriteSet sprites;

    public PoisonBubble(ClientLevel level, double x, double y, double z, SpriteSet sprites) {
        super(level, x, y, z);
        this.gravity = -0.125F;
        this.sprites = sprites;
        this.setSpriteFromAge(sprites);
        this.setSize(0.05F, 0.05F);

        this.quadSize = this.quadSize * (this.random.nextFloat() * 0.6F + 0.2F);

        this.xd = 0.1F + (Math.random() * 2.0 - 1.0) * 0.02F;
        this.yd = 0.3F + (Math.random() * 2.0 - 1.0) * 0.02F;
        this.zd = 0.1F + (Math.random() * 2.0 - 1.0) * 0.02F;
        this.lifetime = 9 + this.random.nextInt(4);
    }


    @Override
    public void tick() {
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {
            this.setSpriteFromAge(this.sprites);
        }
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
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
            PoisonBubble poisonBubble = new PoisonBubble(level, x, y, z, sprite);
            return poisonBubble;
        }
    }
}

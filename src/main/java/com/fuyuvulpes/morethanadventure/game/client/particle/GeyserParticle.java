package com.fuyuvulpes.morethanadventure.game.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class GeyserParticle extends TextureSheetParticle {
    protected GeyserParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ, 0.0F,0.0F,0.0F);
        this.gravity = 0.62F;
        this.friction = 0.999F;
        this.xd *= 0.3F * this.random.nextFloat();
        this.yd *= 3.2F;
        this.zd *= 0.3F * this.random.nextFloat();
        this.yd = (double)(this.random.nextFloat() * 1.5F + 0.05F);
        this.quadSize = this.quadSize * (this.random.nextFloat() * 4.0F + 0.2F);
        this.lifetime = (int)(24.0 / (Math.random() * 0.8 + 0.2));
    }



    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }



    @Override
    public float getQuadSize(float pScaleFactor) {
        float f = ((float)this.age + pScaleFactor) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }


    @OnlyIn(Dist.CLIENT)
    public static class Water implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Water(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(
                SimpleParticleType pType,
                ClientLevel pLevel,
                double pX,
                double pY,
                double pZ,
                double pXSpeed,
                double pYSpeed,
                double pZSpeed
        ) {
            GeyserParticle geyserParticle = new GeyserParticle(pLevel, pX, pY, pZ);
            geyserParticle.pickSprite(this.sprite);
            return geyserParticle;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Lava implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Lava(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

        public Particle createParticle(
                SimpleParticleType pType,
                ClientLevel pLevel,
                double pX,
                double pY,
                double pZ,
                double pXSpeed,
                double pYSpeed,
                double pZSpeed
        ) {
            GeyserParticle geyserParticle = new GeyserParticle(pLevel, pX, pY, pZ);
            geyserParticle.pickSprite(this.sprite);
            return geyserParticle;
        }
    }

}

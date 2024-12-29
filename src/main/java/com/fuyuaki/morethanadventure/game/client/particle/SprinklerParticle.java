package com.fuyuaki.morethanadventure.game.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.valueproviders.UniformFloat;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class SprinklerParticle extends TextureSheetParticle {
    protected SprinklerParticle(ClientLevel pLevel, double pX, double pY, double pZ) {
        super(pLevel, pX, pY, pZ, 0.0F,0.0F,0.0F);
        this.gravity = 0.62F;
        this.friction = 0.999F;
        this.xd *= 2.6F * this.random.nextFloat();
        this.yd *= 0.4F;
        this.zd *= 2.6F * this.random.nextFloat();
        this.yd = (double)(this.random.nextFloat() * 0.8F + 0.05F);
        this.xd = (double)(this.random.nextFloat() * UniformFloat.of(-1.75F,1.75F).sample(this.random) + 0.05F);
        this.zd = (double)(this.random.nextFloat() * UniformFloat.of(-1.75F,1.75F).sample(this.random) + 0.05F);
        this.quadSize = this.quadSize * (this.random.nextFloat() * 4.0F + 0.2F);
        this.lifetime = (int)(12.0 / (Math.random() * 0.8 + 0.2));
    }



    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick() {

        boolean still = (this.xd > -0.05 && this.xd < 0.05F) || (this.zd > -0.05 && this.zd < 0.05F);
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.age++ >= this.lifetime) {
            this.remove();
        } else {

            this.yd = this.yd - 0.25 * (double)this.gravity;

            this.move(this.xd, this.yd, this.zd);
            if (this.speedUpWhenYMotionIsBlocked && this.y == this.yo) {
                this.xd *= 1.1;
                this.zd *= 1.1;
            }
//            this.xd = this.xd * (double)this.friction;
//            this.yd = this.yd * (double)this.friction;
//            this.zd = this.zd * (double)this.friction;
            if (this.onGround) {
                this.remove();

            }
        }
    }

    @Override
    public float getQuadSize(float pScaleFactor) {
        float f = ((float)this.age + pScaleFactor) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f);
    }


    @OnlyIn(Dist.CLIENT)
    public static class Builder implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Builder(SpriteSet pSprites) {
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
            SprinklerParticle sprinklerParticle = new SprinklerParticle(pLevel, pX, pY, pZ);
            sprinklerParticle.pickSprite(this.sprite);
            return sprinklerParticle;
        }
    }
}

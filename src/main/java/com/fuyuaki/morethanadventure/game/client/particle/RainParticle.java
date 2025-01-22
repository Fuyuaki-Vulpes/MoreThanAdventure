package com.fuyuaki.morethanadventure.game.client.particle;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.AxisAngle4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

public class RainParticle extends WeatherParticle{
    public RainParticle(ClientLevel level, double x, double y, double z) {
        super(level, x, y, z, true);
        Vec3 vec3 = Minecraft.getInstance().cameraEntity.position();
        this.alpha = (float) ((level.random.nextFloat() * 0.6) + 0.4);
        this.yd = -1.5F;
        this.quadSize = 0.05F;
        this.roll = (float) (Math.atan2(x - vec3.x, z - vec3.z) + Mth.HALF_PI - 0.5 + level.random.nextFloat());

    }


    @Override
    public void render(VertexConsumer buffer, Camera renderInfo, float partialTicks) {
        Vec3 vec3 = renderInfo.getPosition();
        float x = (float) (Mth.lerp(partialTicks, this.xo, this.x) - vec3.x());
        float y = (float) (Mth.lerp(partialTicks, this.yo, this.y) - vec3.y());
        float z = (float) (Mth.lerp(partialTicks, this.zo, this.z) - vec3.z());

        Vec3 delta = new Vec3(this.xd,this.yd,this.zd);
        float angle = (float) Math.acos(delta.normalize().y);
        Vector3f axis = new  Vector3f((float) -delta.z, (float) delta.y, (float) delta.x).normalize();
        Quaternionf quaternion = new Quaternionf(new AxisAngle4f(angle, axis));
        quaternion.mul(Axis.YN.rotation(this.roll));

        float f = this.getQuadSize(partialTicks);
        float f1 = this.getU0();
        float f2 = this.getU1();
        float f3 = this.getV0();
        float f4 = this.getV1();
        int l = this.getLightColor(partialTicks);
        quaternion = this.flipItTurnwaysIfBackfaced(quaternion, new Vector3f(x, y, z));
        Vec3 deltaB = delta.scale(0.2F);

        Vector3f offset = new Vector3f((float) (x - deltaB.x), (float) (y - deltaB.y), (float) (z - deltaB.z));
        Vector3f offsetB = new Vector3f((float) (x + deltaB.x), (float) (y + deltaB.y), (float) (z + deltaB.z));

        this.renderVertex(buffer, quaternion, offsetB.x, offsetB.y, offsetB.z, 1.0F, -1.0F, f, f2, f4, l);
        this.renderVertex(buffer, quaternion, offset.x,offset.y, offset.z, 1.0F, 1.0F, f, f2, f3, l);
        this.renderVertex(buffer, quaternion, offset.x, offset.y, offset.z, -1.0F, 1.0F, f, f1, f3, l);
        this.renderVertex(buffer, quaternion, offsetB.x, offsetB.y, offsetB.z, -1.0F, -1.0F, f, f1, f4, l);

    }


    public Quaternionf flipItTurnwaysIfBackfaced(Quaternionf quaternion, Vector3f toCamera) {
        Vector3f normal = new Vector3f(0, 0, 1);
        normal.rotate(quaternion).normalize();
        float dot = normal.dot(toCamera);
        if (dot > 0) {
            return quaternion.mul(Axis.YP.rotation(Mth.PI));
        }
        else return quaternion;
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
            RainParticle particle = new RainParticle(level, x, y, z);
            particle.pickSprite(sprite);
            return particle;
        }
    }

}

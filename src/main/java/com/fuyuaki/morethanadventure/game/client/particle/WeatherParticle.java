package com.fuyuaki.morethanadventure.game.client.particle;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaParticles;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.common.Tags;
import org.joml.AxisAngle4d;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.awt.*;

public class WeatherParticle extends TextureSheetParticle {

    public WeatherParticle(ClientLevel level, double x, double y, double z,boolean applyTint) {
        super(level, x, y, z);
        if (applyTint){
            applyWaterTint(this,level,BlockPos.containing(x,y,z));
        }
        this.gravity = 0.90F;
        this.yd = -gravity;
        this.xd = 0.2F;
        this.zd = 0.3F;
        this.lifetime = (int)(48.0F * (this.random.nextFloat() * 0.6F + 0.4F));
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <= 0) {
            this.remove();
        } else {
            this.move(this.xd, this.yd, this.zd);

            if (this.stoppedByCollision) {
                if (Math.random() < 0.5) {
                    this.remove();
                }

            }

        }
    }

    public static void applyWaterTint(TextureSheetParticle particle, ClientLevel clientLevel, BlockPos blockPos) {
        final Color waterColor = new Color(BiomeColors.getAverageWaterColor(clientLevel, blockPos));
        final Color fogColor = new Color(clientLevel.getBiome(blockPos).value().getFogColor());
        float rCol = (Mth.lerp(0.5F, waterColor.getRed(), fogColor.getRed()) / 255F);
        float gCol = (Mth.lerp(0.5F, waterColor.getGreen(), fogColor.getGreen()) / 255F);
        float bCol = (Mth.lerp(0.5F, waterColor.getBlue(), fogColor.getBlue()) / 255F);
        particle.setColor(rCol, gCol, bCol);
    }




}




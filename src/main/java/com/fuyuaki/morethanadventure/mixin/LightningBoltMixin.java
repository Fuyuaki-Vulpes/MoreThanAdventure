package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LightningBolt.class)
public abstract class LightningBoltMixin extends Entity {


    public LightningBoltMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Shadow
    public long seed;




    @WrapWithCondition(method = "tick",
            at = @At(value = "INVOKE",
                    target = "Lnet/minecraft/world/level/Level;playLocalSound(DDDLnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"
            ,ordinal = 0))
    private boolean thunderAudioDelay(Level instance, double x, double y, double z, SoundEvent sound, SoundSource category, float volume, float pitch, boolean distanceDelay) {

        double d0 = Minecraft.getInstance().gameRenderer.getMainCamera().getPosition().distanceToSqr(x,y,z);
        double d1 = Math.sqrt(d0);

        if (d1 < 50){
            return true;
        }else if (d1 >= 50 && d1 < 200){

            Minecraft.getInstance().getSoundManager().playDelayed(new SimpleSoundInstance(
                    MtaSounds.LIGHTNING_BOLT_THUNDER_FAR.get(),
                    category,
                    volume,
                    pitch,
                    RandomSource.create(this.seed), x,y,z
            ), (int) (d1 * 0.2));

        }else if (d1 >= 200){

            Minecraft.getInstance().getSoundManager().playDelayed(new SimpleSoundInstance(
                    MtaSounds.LIGHTNING_BOLT_THUNDER_VERY_FAR.get(),
                    category,
                    volume,
                    pitch,
                    RandomSource.create(this.seed), x,y,z
            ), (int) (d1 * 0.2));

        }


        return false;
    }


}

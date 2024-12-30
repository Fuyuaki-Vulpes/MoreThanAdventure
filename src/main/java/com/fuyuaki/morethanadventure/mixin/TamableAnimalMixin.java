package com.fuyuaki.morethanadventure.mixin;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.world.entity.attachments.RespawnablePetsAttachment;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.UUID;

@Mixin(TamableAnimal.class)
public abstract class TamableAnimalMixin extends Animal {
    @Shadow public abstract boolean isTame();


    @Shadow @Nullable public abstract UUID getOwnerUUID();



    protected TamableAnimalMixin(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Inject(method = "die", at = @At("HEAD"))
    private void respawn(DamageSource cause, CallbackInfo ci) {
        if (this.getOwnerUUID() != null) {
            if (!this.level().getPlayerByUUID(this.getOwnerUUID()).hasData(MTAAttachments.PETS_TO_RESPAWN)) {
                this.level().getPlayerByUUID(this.getOwnerUUID()).setData(MTAAttachments.PETS_TO_RESPAWN, new RespawnablePetsAttachment());
            }
            RespawnablePetsAttachment attachment = this.level().getPlayerByUUID(this.getOwnerUUID()).getData(MTAAttachments.PETS_TO_RESPAWN);
            attachment.add(this);
            this.level().getPlayerByUUID(this.getOwnerUUID()).setData(MTAAttachments.PETS_TO_RESPAWN, attachment);

        }
    }

}

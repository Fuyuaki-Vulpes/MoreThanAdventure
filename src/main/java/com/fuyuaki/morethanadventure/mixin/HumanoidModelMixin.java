package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.game.client.PlayerModelOverlayUtil;
import com.fuyuaki.morethanadventure.game.client.model.player.SirenModel;
import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.ArmedModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public abstract class HumanoidModelMixin<T extends LivingEntity> extends AgeableListModel<T> implements ArmedModel, HeadedModel{

    @Shadow @Final public ModelPart head;
    @Shadow
    @Final public ModelPart hat;
    @Shadow @Final public ModelPart rightArm;
    @Shadow @Final public ModelPart leftArm;
    @Shadow public float swimAmount;
    @Shadow protected abstract HumanoidArm getAttackArm(T entity);
/*
    @Inject(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/HumanoidModel;getAttackArm(Lnet/minecraft/world/entity/LivingEntity;)Lnet/minecraft/world/entity/HumanoidArm;", shift = At.Shift.AFTER), cancellable = true)
    private void onSetupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if(entity.isInWater()) {
            if(entity instanceof Player player && PlayerModelOverlayUtil.shouldRenderSirenParts(entity)){
                HumanoidArm arm = this.getAttackArm(entity);
                float right = arm == HumanoidArm.RIGHT && this.attackTime > 0 ? 0 : this.swimAmount;
                float left = arm == HumanoidArm.LEFT && this.attackTime > 0 ? 0 : this.swimAmount;
                if(!entity.isUsingItem()) {
                    float x = (-Mth.PI * 0.9F) + SirenModel.getAngleWithOffset(ageInTicks, 0.7F, 0.035F, Mth.PI / 10);
                    float z = Mth.PI / 10;
                    this.rightArm.xRot = Mth.lerp(right, this.rightArm.xRot, x);
                    this.leftArm.xRot = Mth.lerp(left, this.leftArm.xRot, x);
                    this.rightArm.zRot = Mth.lerp(right, this.rightArm.zRot, z);
                    this.leftArm.zRot = Mth.lerp(left, this.leftArm.zRot, -z);
                    this.hat.copyFrom(this.head);
                    ci.cancel();
                }
            }
        }
    }
    @ModifyArg(method = "setupAnim(Lnet/minecraft/world/entity/LivingEntity;FFFFF)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/HumanoidModel;rotlerpRad(FFF)F", ordinal = 0), index = 2)
    private float modifyFloat(float original) {
        return -Mth.PI / 3 ;
    }

*/
}



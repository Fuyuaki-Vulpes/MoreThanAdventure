package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.layers.FakeArmorLayer;
import com.fuyuaki.morethanadventure.game.client.renderer.entity.state.WitherSoldierRenderState;
import com.fuyuaki.morethanadventure.world.entity.WitherSoldierEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.AbstractSkeletonRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.neoforged.neoforge.common.Tags;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class WitherSoldierRenderer extends AbstractSkeletonRenderer<WitherSoldierEntity, WitherSoldierRenderState> {
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/wither_soldier.png");
    public static final ResourceLocation ARMOR_TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID,"textures/entity/skeleton/wither_soldier_overlay.png");

    public WitherSoldierRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,MTAModelLayers.WITHER_SOLDIER, MTAModelLayers.WITHER_SOLDIER_INNER_ARMOR, MTAModelLayers.WITHER_SOLDIER_OUTER_ARMOR);
        this.addLayer(new FakeArmorLayer<>(this, pContext.getModelSet(), MTAModelLayers.WITHER_SOLDIER_ARMOR, ARMOR_TEXTURE));
    }

    @Override
    public WitherSoldierRenderState createRenderState() {
        return new WitherSoldierRenderState();
    }

    @Override
    public ResourceLocation getTextureLocation(WitherSoldierRenderState p_368654_) {
        return TEXTURE;
    }

    protected HumanoidModel.ArmPose getArmPose(WitherSoldierEntity mob, HumanoidArm arm) {
        if (arm == mob.getMainArm()){
            if (mob.isAggressive()){
                if (mob.getMainHandItem().is(Tags.Items.TOOLS_BOW)) return HumanoidModel.ArmPose.BOW_AND_ARROW;
            }
            if (mob.isUsingItem() && mob.getUseItemRemainingTicks() > 0){
                if (mob.getMainHandItem().is(Tags.Items.TOOLS_CROSSBOW)) return HumanoidModel.ArmPose.CROSSBOW_CHARGE;

            }else{
                if (mob.getMainHandItem().is(Tags.Items.TOOLS_CROSSBOW)) return HumanoidModel.ArmPose.CROSSBOW_HOLD;

            }

        }
        if (mob.isUsingItem() && mob.getUseItemRemainingTicks() > 0){
            if (mob.getUseItem().is(Tags.Items.TOOLS_SHIELD)) return HumanoidModel.ArmPose.BLOCK;
        }

        return HumanoidModel.ArmPose.EMPTY;
    }
}

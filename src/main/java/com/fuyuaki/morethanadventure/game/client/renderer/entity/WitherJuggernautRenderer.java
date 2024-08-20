package com.fuyuaki.morethanadventure.game.client.renderer.entity;

import com.fuyuaki.morethanadventure.game.client.model.entity.WitherJuggernautModel;
import com.fuyuaki.morethanadventure.world.entity.WitherJuggernaut;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.renderer.GeoEntityRenderer;
import software.bernie.geckolib.renderer.layer.BlockAndItemGeoLayer;

public class WitherJuggernautRenderer extends GeoEntityRenderer<WitherJuggernaut> {

    protected ItemStack mainHandItem;
    protected ItemStack offhandItem;

    private static final String LEFT_HAND = "left_hand";
    private static final String RIGHT_HAND = "right_hand";

    public WitherJuggernautRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new WitherJuggernautModel());

        addRenderLayer(new BlockAndItemGeoLayer<>(this) {
            @Override
            protected @Nullable ItemStack getStackForBone(GeoBone bone, WitherJuggernaut animatable) {
                return switch (bone.getName()) {
                    case LEFT_HAND -> animatable.isLeftHanded() ?
                            WitherJuggernautRenderer.this.mainHandItem : WitherJuggernautRenderer.this.offhandItem;
                    case RIGHT_HAND -> animatable.isLeftHanded() ?
                            WitherJuggernautRenderer.this.offhandItem : WitherJuggernautRenderer.this.mainHandItem;
                    default -> null;
                };
            }

            @Override
            protected ItemDisplayContext getTransformTypeForStack(GeoBone bone, ItemStack stack, WitherJuggernaut animatable) {
                return switch (bone.getName()) {
                    case LEFT_HAND, RIGHT_HAND -> ItemDisplayContext.THIRD_PERSON_RIGHT_HAND;
                    default -> ItemDisplayContext.NONE;
                };
            }

            @Override
            protected void renderStackForBone(PoseStack poseStack, GeoBone bone, ItemStack stack, WitherJuggernaut animatable, MultiBufferSource bufferSource, float partialTick, int packedLight, int packedOverlay) {
                if (stack == WitherJuggernautRenderer.this.mainHandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem)
                        poseStack.translate(0, 0.125, -0.25);
                }
                else if (stack == WitherJuggernautRenderer.this.offhandItem) {
                    poseStack.mulPose(Axis.XP.rotationDegrees(-90f));

                    if (stack.getItem() instanceof ShieldItem) {
                        poseStack.translate(0, 0.125, 0.25);
                        poseStack.mulPose(Axis.YP.rotationDegrees(180));
                    }
                }

                super.renderStackForBone(poseStack, bone, stack, animatable, bufferSource, partialTick, packedLight, packedOverlay);
            }
        });
    }



    @Override
    public void preRender(PoseStack poseStack, WitherJuggernaut animatable, BakedGeoModel model, @Nullable MultiBufferSource bufferSource, @Nullable VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, colour);


        this.mainHandItem = animatable.getMainHandItem();
        this.offhandItem = animatable.getOffhandItem();
    }



}

package com.fuyuaki.morethanadventure.game.client.renderer.block;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.game.client.model.MTAModelLayers;
import com.fuyuaki.morethanadventure.world.block.Sprinkler;
import com.fuyuaki.morethanadventure.world.block.entity.SprinklerEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class SprinklerRenderer<T extends SprinklerEntity> implements BlockEntityRenderer<T> {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart tip;

    public static final Material LOCATION = new Material(
            TextureAtlas.LOCATION_BLOCKS, ResourceLocation.fromNamespaceAndPath(MODID, "entity/sprinkler")
    );

    public SprinklerRenderer(BlockEntityRendererProvider.Context context) {
        ModelPart modelpart = context.bakeLayer(MTAModelLayers.SPRINKLER);

        this.root = modelpart.getChild("root");
        this.head = this.root.getChild("head");
        this.tip = this.head.getChild("tip");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create().texOffs(0, 38).addBox(-4.0F, 7.0F, -4.0F, 8.0F, 5.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-8.0F, 12.0F, -8.0F, 16.0F, 12.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition head = root.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 28).addBox(-2.0F, -6.0F, -2.0F, 4.0F, 6.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 7.0F, 0.0F));

        PartDefinition tip = head.addOrReplaceChild("tip", CubeListBuilder.create().texOffs(16, 30).addBox(-3.0F, -1.0F, -3.0F, 6.0F, 2.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(40, 32).addBox(-2.0F, -3.0F, -2.0F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -7.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void render(T blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        Level level = blockEntity.getLevel();
        boolean flag = level != null;
        BlockState blockstate = flag ? blockEntity.getBlockState() : MtaBlocks.SPRINKLER.get().defaultBlockState();
        VertexConsumer vertexconsumer = LOCATION.buffer(bufferSource, RenderType::entityCutout);
        float offset = 17;
        float r = 0;

        if (blockstate.getBlock() instanceof Sprinkler) {
            float f = blockstate.getValue(Sprinkler.ON) ? 0.1F : -0.1F;
            if (offset >= 7 && offset <= 17) offset += f;
            if (offset > 17) offset = 17;
            if (offset < 7) offset = 7;
            if (blockstate.getValue(Sprinkler.ON)) {
                r += 0.1F;
                if (r > Math.PI) r = 0;

            } else {
                r = 0;
            }

        }
        this.tip.yRot = r;
        this.head.y = offset;

        this.root.render(poseStack, vertexconsumer, packedLight, packedOverlay);
    }
}

package com.fuyuaki.morethanadventure.game.client.model.entity;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.state.SlimeRenderState;

import java.util.Arrays;

public class FrostedSlimeModel<T extends SlimeRenderState> extends EntityModel<T> {

    private static final int SEGMENT_COUNT = 8;
    private final ModelPart root;
    private final ModelPart[] bodyCubes = new ModelPart[8];

    public FrostedSlimeModel(ModelPart root) {
        super (root);
        this.root = root;
        Arrays.setAll(this.bodyCubes, p_170709_ -> root.getChild(getSegmentName(p_170709_)));

    }



private static String getSegmentName(int index) {
    return "cube" + index;
}
    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        for (int i = 0; i < 8; i++) {
            int j = 0;
            int k = i;
            if (i == 2) {
                j = 24;
                k = 10;
            } else if (i == 3) {
                j = 24;
                k = 19;
            }

            partdefinition.addOrReplaceChild(
                    getSegmentName(i), CubeListBuilder.create().texOffs(j, k).addBox(-4.0F, (float)(16 + i), -4.0F, 8.0F, 1.0F, 8.0F), PartPose.ZERO
            );
        }

        partdefinition.addOrReplaceChild("inside_cube", CubeListBuilder.create().texOffs(0, 16).addBox(-2.0F, 18.0F, -2.0F, 4.0F, 4.0F, 4.0F), PartPose.ZERO);
        return LayerDefinition.create(meshdefinition, 64, 32);
    }
    @Override
    public void setupAnim(T state) {
        super.setupAnim(state);
        float f = Math.max(0.0F, state.squish);

        for (int i = 0; i < this.bodyCubes.length; i++) {
            this.bodyCubes[i].y = (float)(-(4 - i)) * f * 1.7F;
        }
    }

}

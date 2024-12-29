package com.fuyuaki.morethanadventure.game.client.model.block;


import com.fuyuaki.morethanadventure.world.block.Sprinkler;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.Function;

public class SprinklerModel extends Model {
    private final ModelPart root;
    private final ModelPart head;
    private final ModelPart tip;

    public SprinklerModel(ModelPart root) {
        super(root, RenderType::entityCutout);

        this.root = root.getChild("root");
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

    public void setupAnim(boolean on) {
        float offset = 17;
        float r = 0;
        float f = on ? 0.1F : -0.1F;
        if (offset >= 7 && offset <= 17) offset += f;
        if (offset > 17) offset = 17;
        if (offset < 7) offset = 7;
        if (on) {
            r += 0.1F;
            if (r > Math.PI) r = 0;

        } else {
            r = 0;
        }
        this.tip.yRot = r;
        this.head.y = offset;
    }


}

package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.Butterfly;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;

public class ButterflyModel extends HierarchicalModel<Butterfly> {
    private final ModelPart root;

    public ButterflyModel(ModelPart root) {
        this.root = root.getChild("root");
    }

    @Override
    public void setupAnim(Butterfly entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public ModelPart root() {
        return null;
    }
}

package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.BlackWidow;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.SpiderModel;
import net.minecraft.client.model.geom.ModelPart;

public class BlackWidowModel <T extends BlackWidow> extends HierarchicalModel<T> {

    @Override
    public ModelPart root() {
        return null;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}

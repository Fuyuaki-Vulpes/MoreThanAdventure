package com.fuyuaki.morethanadventure.game.client.model.entity;

import com.fuyuaki.morethanadventure.world.entity.FrozenSlime;
import com.fuyuaki.morethanadventure.world.entity.YukiOnna;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.SlimeModel;
import net.minecraft.client.model.geom.ModelPart;

public class FrozenSlimeModel <T extends FrozenSlime> extends HierarchicalModel<T> {

    @Override
    public ModelPart root() {
        return null;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }
}

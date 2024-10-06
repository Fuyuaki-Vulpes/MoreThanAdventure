package com.fuyuaki.morethanadventure.world.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public abstract class AbstractCreeperVariant extends Creeper {
    public AbstractCreeperVariant(EntityType<? extends AbstractCreeperVariant> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }


    @Override
    public void tick() {
        doParticles(this.position());
        super.tick();
    }
    protected abstract void doParticles(Vec3 pos);


}

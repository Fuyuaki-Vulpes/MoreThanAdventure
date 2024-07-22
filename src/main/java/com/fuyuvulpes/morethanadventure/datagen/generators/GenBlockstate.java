package com.fuyuvulpes.morethanadventure.datagen.generators;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import static com.fuyuvulpes.morethanadventure.core.MTAMod.MODID;

public class GenBlockstate extends BlockStateProvider {
    public GenBlockstate(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}

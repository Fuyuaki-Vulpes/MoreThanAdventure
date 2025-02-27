package com.fuyuaki.morethanadventure.core.datagen.tags;

import com.fuyuaki.morethanadventure.core.registry.MTADamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;
import net.neoforged.neoforge.common.Tags;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GenDamageTypeTags extends DamageTypeTagsProvider {
    public GenDamageTypeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(DamageTypeTags.BYPASSES_ARMOR).add(
                MTADamageTypes.BLEEDING,
                MTADamageTypes.VENOM
        );
        this.tag(DamageTypeTags.BYPASSES_RESISTANCE).add(
                MTADamageTypes.BLEEDING
        );

        this.tag(Tags.DamageTypes.IS_POISON).add(MTADamageTypes.VENOM);
        this.tag(DamageTypeTags.NO_KNOCKBACK).add(
                MTADamageTypes.VENOM,
                MTADamageTypes.BLEEDING
        );

        this.tag(DamageTypeTags.NO_ANGER).add(
                MTADamageTypes.VENOM,
                MTADamageTypes.BLEEDING
        );


    }
}

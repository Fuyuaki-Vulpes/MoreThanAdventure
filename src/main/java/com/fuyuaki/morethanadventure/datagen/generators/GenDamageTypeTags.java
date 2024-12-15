package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MTADamageTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageType;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.openjdk.nashorn.internal.ir.annotations.Ignore;

import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenDamageTypeTags extends DamageTypeTagsProvider {
    public GenDamageTypeTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MODID, existingFileHelper);
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

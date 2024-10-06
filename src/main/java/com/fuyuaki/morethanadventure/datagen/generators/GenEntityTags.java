package com.fuyuaki.morethanadventure.datagen.generators;

import com.fuyuaki.morethanadventure.core.registry.MtaEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class GenEntityTags extends EntityTypeTagsProvider {
    public GenEntityTags(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pProvider, MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(EntityTypeTags.IMPACT_PROJECTILES)
                .add(
                        MtaEntityTypes.NETHERITE_TRIDENT.get(),
                        MtaEntityTypes.MYSTIC_MERMAIDS_TRIDENT.get()
                );
        this.tag(EntityTypeTags.POWDER_SNOW_WALKABLE_MOBS)
                .add(
                        MtaEntityTypes.ICICLE_CREEPER.get(),
                        EntityType.SNOW_GOLEM
                );
        this.tag(EntityTypeTags.FREEZE_IMMUNE_ENTITY_TYPES)
                .add(
                        MtaEntityTypes.ICICLE_CREEPER.get(),
                        MtaEntityTypes.YUKI_ONNA.get()
                );
        this.tag(EntityTypeTags.AQUATIC)
                .add(
                        MtaEntityTypes.GREAT_WHITE_SHARK.get(),
                        MtaEntityTypes.JELLYFISH.get(),
                        MtaEntityTypes.OCTOPUS.get(),
                        MtaEntityTypes.SHRIMP.get()
                );
    }
}

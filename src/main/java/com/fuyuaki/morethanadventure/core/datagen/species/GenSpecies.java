package com.fuyuaki.morethanadventure.core.datagen.species;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.game.species.SpeciesHolder;
import com.fuyuaki.morethanadventure.game.species.data.SpeciesProvider;
import com.fuyuaki.morethanadventure.game.species.data.SpeciesSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class GenSpecies extends SpeciesProvider {
    public GenSpecies(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries,
                List.of(
                new MTADefaultSpecies()
        )
        );
    }


    static class MTADefaultSpecies implements SpeciesSubProvider {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<SpeciesHolder> writer) {

            Species.Builder.species().human(writer);

            Species.Builder.species()
                    .withIcon(MODID, "giant")
                    .makeDescription(MODID,"giant")
                    .magicAffinity(0.5F)
                    .setSize(2.0F)
                    .addModifier(
                            new Species.AttributeModifierType(Attributes.MAX_HEALTH,24.0F, AttributeModifier.Operation.ADD_VALUE)
                    )
                    .save(
                            writer,
                            ResourceLocation.fromNamespaceAndPath(MODID,"giant")
                    );

            Species.Builder.species()
                    .withIcon(MODID, "dwarf")
                    .makeDescription(MODID,"dwarf")
                    .magicAffinity(1.2F)
                    .setSize(0.4F)
                    .addModifier(
                            new Species.AttributeModifierType(Attributes.MAX_HEALTH,24.0F, AttributeModifier.Operation.ADD_VALUE),
                            new Species.AttributeModifierType(Attributes.BLOCK_BREAK_SPEED,0.2F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    )
                    .save(
                            writer,
                            ResourceLocation.fromNamespaceAndPath(MODID,"dwarf")
                    );

            Species.Builder.species()
                    .withIcon(MODID, "elf")
                    .makeDescription(MODID,"elf")
                    .magicAffinity(3.0F)
                    .setSize(1.0F)
                    .addModifier(
                            new Species.AttributeModifierType(Attributes.MAX_HEALTH,-4.0F, AttributeModifier.Operation.ADD_VALUE),
                            new Species.AttributeModifierType(Attributes.JUMP_STRENGTH,0.3F, AttributeModifier.Operation.ADD_VALUE),
                            new Species.AttributeModifierType(Attributes.FALL_DAMAGE_MULTIPLIER,-0.6F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                            new Species.AttributeModifierType(Attributes.SAFE_FALL_DISTANCE,6.0F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),
                            new Species.AttributeModifierType(Attributes.BLOCK_BREAK_SPEED,-0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                    )
                    .save(
                            writer,
                            ResourceLocation.fromNamespaceAndPath(MODID,"elf")
                    );


        }
    }
}

package com.fuyuaki.morethanadventure.game.species;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttributes;
import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.fuyuaki.morethanadventure.game.species.traits.core.Trait;


import com.fuyuaki.morethanadventure.world.entity.attachments.SpeciesAttachment;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Stream;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public record Species(ResourceLocation icon, ResourceLocation id, String description, float playerSize,  float magicAffinity, List<AttributeModifierType> modifiers, List<Trait> traits) {
    public static final Codec<Species> CODEC = RecordCodecBuilder.<Species>create(
                    instance -> instance.group(
                                    ResourceLocation.CODEC.fieldOf("icon").forGetter(Species::icon),
                                    ResourceLocation.CODEC.fieldOf("id").forGetter(Species::id),
                                    Codec.STRING.fieldOf("key").forGetter(Species::description),
                                    Codec.FLOAT.fieldOf("player_scale").forGetter(Species::playerSize),
                                    Codec.FLOAT.fieldOf("magic_affinity").forGetter(Species::magicAffinity),
                                AttributeModifierType.CODEC.listOf().fieldOf("modifiers").forGetter(Species::modifiers),
                                    Trait.CODEC.listOf().fieldOf("type").forGetter(Species::traits)
                            )
                            .apply(instance,Species::new)
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, Species> STREAM_CODEC = StreamCodec.composite(
            ResourceLocation.STREAM_CODEC,
            Species::icon,
            ResourceLocation.STREAM_CODEC,
            Species::id,
            ByteBufCodecs.STRING_UTF8,
            Species::description,
            ByteBufCodecs.FLOAT,
            Species::playerSize,
            ByteBufCodecs.FLOAT,
            Species::magicAffinity,
            AttributeModifierType.STREAM_CODEC.apply(ByteBufCodecs.list()),
            Species::modifiers,
            Trait.STREAM_CODEC.apply(ByteBufCodecs.list()),
            Species::traits,
            Species::new
    );



    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof Species species && this.id.equals(species.id)) {
                return true;
            }

            return false;
        }
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return this.id.toString();
    }

    public String getNameKey(){
        return this.id.getNamespace() + ".species." + this.id.getPath();
    }

    public static Species getSpeciesFromKey(ResourceKey<Species> ID, Level level){
        return level.registryAccess().lookup(MTARegistries.Keys.SPECIES).get().getValue(ID);
    }
    public static Optional<Holder.Reference<Species>> getSpeciesFromKeyOptional(ResourceKey<Species> ID, Level level){
        return level.registryAccess().lookup(MTARegistries.Keys.SPECIES).get().get(ID);
    }

    public static Stream<ResourceKey<Species>> getAllSpeciesKeys(Level level){
        return level.registryAccess().lookup(MTARegistries.Keys.SPECIES).orElseThrow().listElementIds();
    }
    public static Stream<Species> getAllSpecies(Level level){
        return  level.registryAccess().lookup(MTARegistries.Keys.SPECIES).orElseThrow().listElementIds()
                .map(key -> getSpeciesFromKey(key,level));
    }




    public static @Nullable SpeciesAttachment get(Player player){
        return player.hasData(MTAAttachments.SPECIES.get()) ? player.getData(MTAAttachments.SPECIES.get()) : null;
    }

    public static void set(Player player, SpeciesAttachment attachment){
        player.setData(MTAAttachments.SPECIES.get(),attachment);
    }

    public Multimap<Holder<Attribute>, AttributeModifier> getScaleModifiers(){
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> map = new ImmutableMultimap.Builder<>();
        map.put(Attributes.SCALE,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_modifier"),
                        this.playerSize - 1.0F,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        map.put(Attributes.BLOCK_INTERACTION_RANGE,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_reach_block"),
                        Math.max(0.0F,this.playerSize - 1.0F),
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        map.put(Attributes.ENTITY_INTERACTION_RANGE,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_reach_entity"),
                        Math.max(0.0F,this.playerSize - 1.0F),
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        map.put(Attributes.STEP_HEIGHT,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_step"),
                        Math.max(0.0F,this.playerSize - 1.0F),
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        map.put(Attributes.SAFE_FALL_DISTANCE,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_fall"),
                        Math.max(-0.1F,this.playerSize - 1.0F),
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        map.put(Attributes.JUMP_STRENGTH,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_jump"),
                        Math.max(0.0F,this.playerSize - 1.0F) / 3.0F,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        map.put(Attributes.MOVEMENT_SPEED,
                new AttributeModifier(
                        ResourceLocation.withDefaultNamespace("species_scale_movement"),
                        Math.clamp(this.playerSize - 1.0F,-0.6F, 1.5F) / 2.0F,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));

        return map.build();
    }
    public AttributeModifier getMagicModifier(){
        return new AttributeModifier(ResourceLocation.withDefaultNamespace("species_magic_modifier"),this.magicAffinity - 1.0F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL);
    }

    public Multimap<Holder<Attribute>, AttributeModifier> modifierMap(){
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> map = new ImmutableMultimap.Builder<>();
        this.modifiers.forEach(modifierType -> {
            map.put(modifierType.attribute, modifierType.getModifier(modifierType));
        });
        this.getScaleModifiers().asMap().forEach((attribute,modifiers) -> {
            modifiers.forEach(attributeModifier -> {
                map.put(attribute, attributeModifier);
            });

        });
         map.put(MTAAttributes.MAGIC_STORAGE_SCALE, this.getMagicModifier());

        return map.build();

    }


    public record AttributeModifierType(Holder<Attribute> attribute, double amount, AttributeModifier.Operation operation) {
        public static final Codec<AttributeModifierType> CODEC = RecordCodecBuilder.create(
                p_348388_ -> p_348388_.group(
                                Attribute.CODEC.fieldOf("type").forGetter(AttributeModifierType::attribute),
                                Codec.DOUBLE.fieldOf("amount").forGetter(AttributeModifierType::amount),
                                AttributeModifier.Operation.CODEC.fieldOf("operation").forGetter(AttributeModifierType::operation)                        )
                        .apply(p_348388_, AttributeModifierType::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, AttributeModifierType> STREAM_CODEC = StreamCodec.composite(
                Attribute.STREAM_CODEC,
                AttributeModifierType::attribute,
                ByteBufCodecs.DOUBLE,
                AttributeModifierType::amount,
                AttributeModifier.Operation.STREAM_CODEC,
                AttributeModifierType::operation,
                AttributeModifierType::new
        );


        public boolean matches(Holder<Attribute> attribute, ResourceLocation id) {
            return attribute.equals(this.attribute) && getModifier(this.attribute,this.amount,this.operation).is(id);
        }

        private AttributeModifier getModifier(Holder<Attribute> attribute, double amount, AttributeModifier.Operation operation) {
            return new AttributeModifier(ResourceLocation.withDefaultNamespace(attribute.getKey().location().getPath() + "_species_modifier_" + operation.getSerializedName()), amount,operation);
        }
        private AttributeModifier getModifier(AttributeModifierType type) {
            Holder<Attribute> attribute = type.attribute;
            double amount = type.amount;
            AttributeModifier.Operation operation = type.operation;

            return new AttributeModifier(ResourceLocation.withDefaultNamespace(attribute.getKey().location().getPath() + "_species_modifier_" + operation.getSerializedName()), amount,operation);
        }
    }


    public static class Builder{

        private ResourceLocation icon = ResourceLocation.withDefaultNamespace("empty_species_icon");
        private ResourceLocation id = ResourceLocation.withDefaultNamespace("empty_species");
        private float size = 1.0f;
        private List<AttributeModifierType> modifier = new ArrayList<>();
        private List<Trait> trait =  new ArrayList<>();
        private String descriptionKey = MODID + ".species.description.missing";
        private float magic = 1.0F;

        public static Species.Builder species(){
            return new Species.Builder();
        }

        private Species.Builder self() {
            return (Species.Builder) this;
        }

        public Species.Builder withIcon(ResourceLocation path){
            this.icon = path;
            return this;
        }
        public Species.Builder withIcon(String modid, String iconName){
            this.icon = ResourceLocation.fromNamespaceAndPath(modid,"textures/gui/species/icon/" + iconName);
            return this;
        }

        public Species.Builder descriptionKey(String key){
            this.descriptionKey = key;
            return this;
        }
        public Species.Builder makeDescription(String modId, String speciesName){
            this.descriptionKey = modId + ".species.description." + speciesName;
            return this;
        }

        public Species.Builder scale(float multiplier){
            this.size = this.size * multiplier;
            return this;
        }
        public Species.Builder setSize(float s){
            this.size = s;
            return this;
        }
        public Species.Builder magicAffinity(float m){
            this.magic = m;
            return this;
        }

        public Species.Builder addModifier(AttributeModifierType toAdd){
            this.modifier.add(toAdd);
            return this;
        }
        public Species.Builder addModifier(List<AttributeModifierType> toAdd){
            this.modifier.addAll(toAdd);
            return this;
        }

        public Species.Builder addModifier(AttributeModifierType... toAdd){
            this.modifier.addAll(Arrays.stream(toAdd).toList());
            return this;
        }

        public Species.Builder fromModifiers(List<AttributeModifierType> from){
            this.modifier = from;
            return this;
        }

        public Species.Builder fromModifiers(AttributeModifierType... from){
            this.modifier = Arrays.stream(from).toList();
            return this;
        }

        public Species.Builder addTrait(Trait toAdd){
            this.trait.add(toAdd);
            return this;
        }
        public Species.Builder addTrait(List<Trait> toAdd){
            this.trait.addAll(toAdd);
            return this;
        }

        public Species.Builder addTrait(Trait... toAdd){
            this.trait.addAll(Arrays.stream(toAdd).toList());
            return this;
        }

        public Species.Builder fromTraits(List<Trait> from){
            this.trait = from;
            return this;
        }

        public Species.Builder fromTraits(Trait... from){
            this.trait = Arrays.stream(from).toList();
            return this;
        }

        public SpeciesHolder human(Consumer<SpeciesHolder> saver){
            return Builder.species()
                    .withIcon(MODID, "human")
                    .makeDescription(MODID,"human")
                    .magicAffinity(1.0F)
                    .save(
                            saver,
                            ResourceLocation.fromNamespaceAndPath(MODID,"human")
                    );
        }

        public SpeciesHolder build(ResourceLocation id) {
            this.id = id;
            return new SpeciesHolder(
                    new Species(this.icon, this.id,this.descriptionKey, this.size, this.magic, this.modifier,this.trait),id
            );
        }

        public SpeciesHolder save(Consumer<SpeciesHolder> saver, ResourceLocation id) {
            SpeciesHolder advancementholder = self().build(id);
            saver.accept(advancementholder);
            return advancementholder;
        }
    }

}

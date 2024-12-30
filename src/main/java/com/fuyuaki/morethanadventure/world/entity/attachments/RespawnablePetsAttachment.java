package com.fuyuaki.morethanadventure.world.entity.attachments;

import com.fuyuaki.morethanadventure.mixin.TamableAnimalMixin;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.attachment.IAttachmentHolder;
import net.neoforged.neoforge.attachment.IAttachmentSerializer;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RespawnablePetsAttachment implements INBTSerializable<CompoundTag> {

    protected List<Pets> pets = new ArrayList<>();

    public RespawnablePetsAttachment() {
    }

    public void add(Entity pet){
        this.pets.add(Pets.of(pet));
    }



    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        System.out.println("Serializing");
        if (this.pets.isEmpty()) return new CompoundTag();
        ListTag nbtTagList = new ListTag();
        for (Pets pet : this.pets) {
            nbtTagList.add(pet.entityData.copyTag());
        }
        CompoundTag nbt = new CompoundTag();
        nbt.put("Pets", nbtTagList);
        return null;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {

        ListTag tagList = nbt.getList("Pets", Tag.TAG_LIST);
        if (tagList.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        for (int i = 0; i < tagList.size(); i++) {
            CompoundTag tag = tagList.getCompound(i);
            tagList.forEach(pet -> this.pets.add(new Pets(CustomData.of(tag))));

        }
    }

    public void respawnPets(Level level, Player player){
        if (pets.isEmpty()) {
            return;
        }
        for (Pets pet : pets){
            CompoundTag compoundtag = pet.entityData.copyTag();
            Entity entity = pet.createEntity(level);
            if (entity instanceof TamableAnimal animal) {
                animal.setOrderedToSit(true);
            }
            if (player.getSleepingPos().isPresent()) {
                entity.moveTo(player.getSleepingPos().get().getBottomCenter());
            }
            else {
                entity.moveTo(player.position());
            }

            level.addFreshEntity(entity);

            ((ServerPlayer)player).sendSystemMessage(Component.translatable("respawn.mta.pet",entity.getDisplayName(),
                    Component.literal(entity.blockPosition().getX() + ", " + entity.blockPosition().getY() + ", "+ entity.blockPosition().getZ())
                    ),
                    false);
        }
        this.pets.clear();
    }

    public static record Pets(CustomData entityData) {
        public static final Codec<Pets> CODEC = RecordCodecBuilder.create(
                p_337984_ -> p_337984_.group(
                                CustomData.CODEC.optionalFieldOf("entity_data", CustomData.EMPTY).forGetter(Pets::entityData)
                        )
                        .apply(p_337984_, Pets::new)
        );
        public static final Codec<List<Pets>> LIST_CODEC = CODEC.listOf();
        public static final StreamCodec<ByteBuf, Pets> STREAM_CODEC = StreamCodec.composite(
                CustomData.STREAM_CODEC,
                Pets::entityData,
                Pets::new
        );


        public static Pets of(Entity entity){
            CompoundTag compoundtag = new CompoundTag();
            entity.save(compoundtag);
            return new Pets(CustomData.of(compoundtag));
        }

        @Nullable
        public Entity createEntity(Level level) {
            CompoundTag compoundtag = this.entityData.copyTag();
            Entity entity = EntityType.loadEntityRecursive(compoundtag, level, EntitySpawnReason.LOAD, p_331097_ -> p_331097_);
            if (entity != null) {
                entity.setNoGravity(false);
                if (entity instanceof LivingEntity living){
                    living.setHealth(living.getMaxHealth());
                }
                entity.setDeltaMovement(Vec3.ZERO);
                return entity;
            } else {
                return null;
            }
        }


    }
}


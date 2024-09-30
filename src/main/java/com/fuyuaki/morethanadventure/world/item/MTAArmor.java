package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaArmorMats;
import com.google.common.base.Suppliers;
import dev.shadowsoffire.apothic_attributes.api.ALObjects;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForgeMod;

import java.util.*;
import java.util.function.Supplier;

public class MTAArmor extends ArmorItem {
    protected final UUID FULL_SET_UUID = UUID.fromString("78f6b05d-a0ff-4b5e-86dc-9b397d5b7878");
    private static final ArmorMaterial SENTINEL = MtaArmorMats.GREAT_SENTINEL.value();
    private static final ArmorMaterial KNIGHT = MtaArmorMats.HOLY_KNIGHT.value();
    private static final ArmorMaterial MERMAID = MtaArmorMats.MYSTIC_MERMAID.value();
    private static final ArmorMaterial REAPER = MtaArmorMats.SILENT_REAPER.value();
    private static final ArmorMaterial ANGEL = MtaArmorMats.TEMPLE_ANGEL.value();
    private static final ArmorMaterial BERSERKER = MtaArmorMats.WRATHFUL_BERSERKER.value();
    private static final ArmorMaterial ROGUE = MtaArmorMats.SHADOW_ROGUE.value();

    //ATTRIBUTES

    private final Supplier<ItemAttributeModifiers> attributeModifiers;



    public MTAArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    int i = pMaterial.value().getDefense(pType);
                    float f = pMaterial.value().toughness();
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(pType.getSlot());
                    ResourceLocation resourcelocation = ResourceLocation.withDefaultNamespace("armor." + pType.getName());
                    builder.add(
                            Attributes.ARMOR, new AttributeModifier(resourcelocation, (double)i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );
                    builder.add(
                            Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourcelocation, (double)f, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );

                    float f1 = pMaterial.value().knockbackResistance();
                    if (f1 > 0.0F) {
                        builder.add(
                                Attributes.KNOCKBACK_RESISTANCE,
                                new AttributeModifier(resourcelocation, (double)f1, AttributeModifier.Operation.ADD_VALUE),
                                equipmentslotgroup
                        );
                    }
                    return resolveAttributeModifiers(pMaterial,pType,builder).build();
                }
        );
    }

    @Override
    public ItemAttributeModifiers getDefaultAttributeModifiers() {
        return this.attributeModifiers.get();
    }


    //MOB EFFECTS

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity living){
            if (!pLevel.isClientSide()){
                estimateEffects(living,pLevel,pSlotId);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

    }

    protected void estimateEffects(LivingEntity entity, Level level, int pSlotId){
        boolean hasHelmet = entity.getItemBySlot(Type.HELMET.getSlot()).getItem() instanceof ArmorItem;
        boolean hasChestplate = entity.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem() instanceof ArmorItem;
        boolean hasLeggings = entity.getItemBySlot(Type.LEGGINGS.getSlot()).getItem() instanceof ArmorItem;
        boolean hasBoots = entity.getItemBySlot(Type.BOOTS.getSlot()).getItem() instanceof ArmorItem;

        //USED ARMADILLO SO IT DOESN'T BREAK FROM NULL!!!
        ArmorMaterial helmet = ArmorMaterials.ARMADILLO.value();
        ArmorMaterial chestplate = ArmorMaterials.ARMADILLO.value();
        ArmorMaterial leggings = ArmorMaterials.ARMADILLO.value();
        ArmorMaterial boots = ArmorMaterials.ARMADILLO.value();

        if (hasHelmet) helmet = ((ArmorItem)entity.getItemBySlot(Type.HELMET.getSlot()).getItem()).getMaterial().value();
        if (hasChestplate) chestplate = ((ArmorItem)entity.getItemBySlot(Type.CHESTPLATE.getSlot()).getItem()).getMaterial().value();
        if (hasLeggings) leggings = ((ArmorItem)entity.getItemBySlot(Type.LEGGINGS.getSlot()).getItem()).getMaterial().value();
        if (hasBoots) boots = ((ArmorItem)entity.getItemBySlot(Type.BOOTS.getSlot()).getItem()).getMaterial().value();

        
        doSentinelEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == SENTINEL,
                hasChestplate && chestplate == SENTINEL,
                hasLeggings && leggings == SENTINEL,
                hasBoots && boots == SENTINEL);
        doKnightEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == KNIGHT,
                hasChestplate && chestplate == KNIGHT,
                hasLeggings && leggings == KNIGHT,
                hasBoots && boots == KNIGHT);
        doMermaidEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == MERMAID,
                hasChestplate && chestplate == MERMAID,
                hasLeggings && leggings == MERMAID,
                hasBoots && boots == MERMAID);
        doReaperEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == REAPER,
                hasChestplate && chestplate == REAPER,
                hasLeggings && leggings == REAPER,
                hasBoots && boots == REAPER);
        doAngelEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == ANGEL,
                hasChestplate && chestplate == ANGEL,
                hasLeggings && leggings == ANGEL,
                hasBoots && boots == ANGEL);
        doBerserkerEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == BERSERKER,
                hasChestplate && chestplate == BERSERKER,
                hasLeggings && leggings == BERSERKER,
                hasBoots && boots == BERSERKER);
        doRogueEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == ROGUE,
                hasChestplate && chestplate == ROGUE,
                hasLeggings && leggings == ROGUE,
                hasBoots && boots == ROGUE);

    }

    /*
    3 -> Boots
    2 -> Chestplate
    1 -> Leggings
    0 -> Boots
     */


    protected void doSentinelEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {

        }

        if (head || chest || legs || feet){
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 0, false, false, false));

        }
        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3, 4, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 2, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false, false));


        }
    }

    protected void doKnightEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {

        }

        if (head || chest || legs || feet){
            entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 3, 1, false, false, false));

        }
        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 3, 0, false, false, false));

        }
    }

    protected void doMermaidEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {

        }

        if (head || chest || legs || feet){

        }


        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 3, 0, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 3, 0, false, false, false));
        }
    }

    protected void doReaperEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {

        }

        if (head || chest || legs || feet){

        }


        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.TRIAL_OMEN, 3, 0, false, false, false));
        }
    }

    protected void doAngelEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){

        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {

        }

        if (head || chest || legs || feet){
            entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3, 3, false, false, false));

        }

        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 3, 0, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3, 5, false, false, false));

        }
    }

    protected void doBerserkerEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {

        }

        if (head || chest || legs || feet){
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 0, false, false, false));

        }

        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, 2, false, false, false));

        }
    }

    protected void doRogueEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet) {
        if (head) {

        }

        if (chest) {

        }

        if (legs) {

        }

        if (feet) {
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false, false));

        }


        if (head || chest || legs || feet) {
        }
        if (head && chest && legs && feet) {
            if (entity.isCrouching()) {
                entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3, 0, false, false, false));
            }
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false, false));

        }
    }


    //ATTRIBUTES

    protected ItemAttributeModifiers.Builder resolveAttributeModifiers(Holder<ArmorMaterial> material, Type type, ItemAttributeModifiers.Builder builder){
        if ( material.value() == SENTINEL){
            return sentinelAttributes(type,builder);
        }else
            if ( material.value() == KNIGHT){
                return knightAttributes(type,builder);
        }else
            if ( material.value() == MERMAID){
                return mermaidAttributes(type,builder);
        }else
            if ( material.value() == REAPER){
                return reaperAttributes(type,builder);
        }else
            if ( material.value() == ANGEL){
                return angelAttributes(type,builder);
        }else
            if ( material.value() == BERSERKER){
                return berserkerAttributes(type,builder);
        }else
            if ( material.value() == ROGUE){
                return rogueAttributes(type,builder);
        }
        return builder;
    }


    protected ItemAttributeModifiers.Builder sentinelAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());



        if (type == Type.HELMET){
            builder.add(ALObjects.Attributes.DODGE_CHANCE,new AttributeModifier(location,0.02F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(ALObjects.Attributes.GHOST_HEALTH,new AttributeModifier(location,1.0F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.CHESTPLATE){
            builder.add(ALObjects.Attributes.DODGE_CHANCE,new AttributeModifier(location,0.1F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(ALObjects.Attributes.GHOST_HEALTH,new AttributeModifier(location,4.0F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.LEGGINGS){
            builder.add(ALObjects.Attributes.DODGE_CHANCE,new AttributeModifier(location,0.05F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(ALObjects.Attributes.GHOST_HEALTH,new AttributeModifier(location,2.0F,AttributeModifier.Operation.ADD_VALUE),slot);


        }else if (type == Type.BOOTS){
            builder.add(ALObjects.Attributes.DODGE_CHANCE,new AttributeModifier(location,0.02F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(ALObjects.Attributes.GHOST_HEALTH,new AttributeModifier(location,1.0F,AttributeModifier.Operation.ADD_VALUE),slot);


        }
        builder.add(Attributes.MOVEMENT_SPEED,new AttributeModifier(location,-0.1F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);


        return builder;
    }

    protected ItemAttributeModifiers.Builder knightAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());



        if (type == Type.HELMET){
            builder.add(ALObjects.Attributes.CRIT_CHANCE,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.CHESTPLATE){
            builder.add(ALObjects.Attributes.OVERHEAL,new AttributeModifier(location,0.4F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.LEGGINGS){
            builder.add(ALObjects.Attributes.CURRENT_HP_DAMAGE,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.BOOTS){
            builder.add(Attributes.STEP_HEIGHT,new AttributeModifier(location,0.5F,AttributeModifier.Operation.ADD_VALUE),slot);

        }

        return builder;
    }

    protected ItemAttributeModifiers.Builder mermaidAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());


        if (type == Type.HELMET){
            builder.add(Attributes.OXYGEN_BONUS, new AttributeModifier(location,4.0F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.CHESTPLATE){
            builder.add(Attributes.SUBMERGED_MINING_SPEED, new AttributeModifier(location,3.0F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.LEGGINGS){
            builder.add(NeoForgeMod.SWIM_SPEED,new AttributeModifier(location,0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),slot);

        }else if (type == Type.BOOTS){
            builder.add(Attributes.WATER_MOVEMENT_EFFICIENCY,new AttributeModifier(location,0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),slot);
        }

        return builder;
    }

    protected ItemAttributeModifiers.Builder reaperAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());


        if (type == Type.HELMET){
            builder.add(ALObjects.Attributes.CRIT_CHANCE, new AttributeModifier(location,0.3F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.CHESTPLATE){
            builder.add(ALObjects.Attributes.CRIT_DAMAGE, new AttributeModifier(location,1.1F, AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(ALObjects.Attributes.LIFE_STEAL, new AttributeModifier(location,0.2F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.LEGGINGS){
            builder.add(Attributes.SNEAKING_SPEED,new AttributeModifier(location,0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),slot);

        }else if (type == Type.BOOTS){
            builder.add(Attributes.SAFE_FALL_DISTANCE,new AttributeModifier(location,4.0F, AttributeModifier.Operation.ADD_VALUE),slot);
        }

        return builder;
    }

    protected ItemAttributeModifiers.Builder angelAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());



        if (type == Type.HELMET){

        }else if (type == Type.CHESTPLATE){
            builder.add(Attributes.GRAVITY, new AttributeModifier(location,-0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (type == Type.LEGGINGS){

        }else if (type == Type.BOOTS){
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER, new AttributeModifier(location,-0.2F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);
            builder.add(Attributes.SAFE_FALL_DISTANCE, new AttributeModifier(location,4.0F, AttributeModifier.Operation.ADD_VALUE),slot);


        }

        return builder;
    }

    protected ItemAttributeModifiers.Builder berserkerAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());



        if (type == Type.HELMET){
            builder.add(Attributes.ATTACK_DAMAGE,new AttributeModifier(location,2.4F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.ATTACK_KNOCKBACK,new AttributeModifier(location,0.4F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.CHESTPLATE){
            builder.add(ALObjects.Attributes.LIFE_STEAL,new AttributeModifier(location,0.1F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(ALObjects.Attributes.GHOST_HEALTH,new AttributeModifier(location,4.0F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.LEGGINGS){
            builder.add(ALObjects.Attributes.ARMOR_SHRED,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (type == Type.BOOTS){
            builder.add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE,new AttributeModifier(location,0.1F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.SWEEPING_DAMAGE_RATIO,new AttributeModifier(location,0.7F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.MOVEMENT_EFFICIENCY,new AttributeModifier(location,0.3F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER,new AttributeModifier(location,0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }

        return builder;
    }

    protected ItemAttributeModifiers.Builder rogueAttributes(Type type, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + type.getName());



        if (type == Type.HELMET){
            builder.add(Attributes.BLOCK_INTERACTION_RANGE,new AttributeModifier(location,0.35F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (type == Type.CHESTPLATE){
            builder.add(Attributes.ATTACK_SPEED,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (type == Type.LEGGINGS){
            builder.add(Attributes.JUMP_STRENGTH,new AttributeModifier(location,0.6F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER,new AttributeModifier(location,-0.5F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (type == Type.BOOTS){
            builder.add(Attributes.SAFE_FALL_DISTANCE,new AttributeModifier(location,6.0F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.GRAVITY,new AttributeModifier(location,-0.4F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);
            builder.add(Attributes.SNEAKING_SPEED,new AttributeModifier(location,0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }

        return builder;
    }
}


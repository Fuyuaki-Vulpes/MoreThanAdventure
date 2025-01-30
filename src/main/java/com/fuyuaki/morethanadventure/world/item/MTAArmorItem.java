package com.fuyuaki.morethanadventure.world.item;


import com.fuyuaki.morethanadventure.core.registry.MTAArmorMats;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForgeMod;

import java.util.List;
import java.util.UUID;

public class MTAArmorItem extends ArmorItem {

    protected final UUID FULL_SET_UUID = UUID.fromString("78f6b05d-a0ff-4b5e-86dc-9b397d5b7878");
    private static final ArmorMaterial SENTINEL = MTAArmorMats.GREAT_SENTINEL;
    private static final ArmorMaterial KNIGHT = MTAArmorMats.HOLY_KNIGHT;
    private static final ArmorMaterial MERMAID = MTAArmorMats.MYSTIC_MERMAID;
    private static final ArmorMaterial REAPER = MTAArmorMats.SILENT_REAPER;
    private static final ArmorMaterial ANGEL = MTAArmorMats.TEMPLE_ANGEL;
    private static final ArmorMaterial ICICLE = MTAArmorMats.FREEZING_ICICLE;
    private static final ArmorMaterial BERSERKER = MTAArmorMats.WRATHFUL_BERSERKER;
    private static final ArmorMaterial ROGUE = MTAArmorMats.SHADOW_ROGUE;




    public MTAArmorItem(ArmorMaterial pMaterial, ArmorType pArmorType, Properties pProperties) {
        super(pMaterial, pArmorType,
                pProperties
                        .stacksTo(1)
                        .fireResistant()
                        .rarity(Rarity.EPIC)
                        .attributes(createAttributes(pArmorType,pMaterial))
                        .enchantable(pMaterial.enchantmentValue())
                        .component(DataComponents.EQUIPPABLE, Equippable.builder(pArmorType.getSlot()).setEquipSound(pMaterial.equipSound()).setAsset(pMaterial.assetId()).build())
                        .repairable(pMaterial.repairIngredient())
        );


    }

    private static ItemAttributeModifiers createAttributes(ArmorType type, ArmorMaterial material) {
        int i = material.defense().getOrDefault(type, 0);
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(type.getSlot());
        ResourceLocation resourcelocation = ResourceLocation.withDefaultNamespace("armor." + type.getName());
        builder.add(
                Attributes.ARMOR, new AttributeModifier(resourcelocation, (double)i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
        );
        builder.add(
                Attributes.ARMOR_TOUGHNESS,
                new AttributeModifier(resourcelocation, (double)material.toughness(), AttributeModifier.Operation.ADD_VALUE),
                equipmentslotgroup
        );
        if (material.knockbackResistance() > 0.0F) {
            builder.add(
                    Attributes.KNOCKBACK_RESISTANCE,
                    new AttributeModifier(resourcelocation, (double)material.knockbackResistance(), AttributeModifier.Operation.ADD_VALUE),
                    equipmentslotgroup
            );
        }

        return resolveAttributeModifiers(material,type,builder).build();
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

    protected static void estimateEffects(LivingEntity entity, Level level, int pSlotId){
        boolean hasHelmet = entity.getItemBySlot(ArmorType.HELMET.getSlot()).getItem() instanceof ArmorItem;
        boolean hasChestplate = entity.getItemBySlot(ArmorType.CHESTPLATE.getSlot()).getItem() instanceof ArmorItem;
        boolean hasLeggings = entity.getItemBySlot(ArmorType.LEGGINGS.getSlot()).getItem() instanceof ArmorItem;
        boolean hasBoots = entity.getItemBySlot(ArmorType.BOOTS.getSlot()).getItem() instanceof ArmorItem;

        ResourceKey<EquipmentAsset> helmet = ArmorMaterials.ARMADILLO_SCUTE.assetId();
        ResourceKey<EquipmentAsset> chestplate = ArmorMaterials.ARMADILLO_SCUTE.assetId();
        ResourceKey<EquipmentAsset> leggings = ArmorMaterials.ARMADILLO_SCUTE.assetId();
        ResourceKey<EquipmentAsset> boots = ArmorMaterials.ARMADILLO_SCUTE.assetId();

        ItemStack helmetItem = (entity.getItemBySlot(ArmorType.HELMET.getSlot()));
        ItemStack chestItem = (entity.getItemBySlot(ArmorType.CHESTPLATE.getSlot()));
        ItemStack legItem = (entity.getItemBySlot(ArmorType.LEGGINGS.getSlot()));
        ItemStack bootItem =  (entity.getItemBySlot(ArmorType.BOOTS.getSlot()));

        if (hasHelmet) helmet = helmetItem.get(DataComponents.EQUIPPABLE).assetId().get();
        if (hasChestplate) chestplate = chestItem.get(DataComponents.EQUIPPABLE).assetId().get();
        if (hasLeggings) leggings = legItem.get(DataComponents.EQUIPPABLE).assetId().get();
        if (hasBoots) boots = bootItem.get(DataComponents.EQUIPPABLE).assetId().get();

        List<ResourceKey<EquipmentAsset>> equipments = List.of(helmet,chestplate,leggings,boots);

        if(equipments.contains(SENTINEL.assetId())) doSentinelEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == SENTINEL.assetId(),
                hasChestplate && chestplate == SENTINEL.assetId(),
                hasLeggings && leggings == SENTINEL.assetId(),
                hasBoots && boots == SENTINEL.assetId());

        if(equipments.contains(KNIGHT.assetId())) doKnightEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == KNIGHT.assetId(),
                hasChestplate && chestplate == KNIGHT.assetId(),
                hasLeggings && leggings == KNIGHT.assetId(),
                hasBoots && boots == KNIGHT.assetId());

        if(equipments.contains(MERMAID.assetId())) doMermaidEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == MERMAID.assetId(),
                hasChestplate && chestplate == MERMAID.assetId(),
                hasLeggings && leggings == MERMAID.assetId(),
                hasBoots && boots == MERMAID.assetId());

        if(equipments.contains(REAPER.assetId())) doReaperEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == REAPER.assetId(),
                hasChestplate && chestplate == REAPER.assetId(),
                hasLeggings && leggings == REAPER.assetId(),
                hasBoots && boots == REAPER.assetId());

        if(equipments.contains(ANGEL.assetId())) doAngelEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == ANGEL.assetId(),
                hasChestplate && chestplate == ANGEL.assetId(),
                hasLeggings && leggings == ANGEL.assetId(),
                hasBoots && boots == ANGEL.assetId());

        if(equipments.contains(ICICLE.assetId())) doIcicleEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == ICICLE.assetId(),
                hasChestplate && chestplate == ICICLE.assetId(),
                hasLeggings && leggings == ICICLE.assetId(),
                hasBoots && boots == ICICLE.assetId());

        if(equipments.contains(BERSERKER.assetId())) doBerserkerEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == BERSERKER.assetId(),
                hasChestplate && chestplate == BERSERKER.assetId(),
                hasLeggings && leggings == BERSERKER.assetId(),
                hasBoots && boots == BERSERKER.assetId());

        if(equipments.contains(ROGUE.assetId())) doRogueEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == ROGUE.assetId(),
                hasChestplate && chestplate == ROGUE.assetId(),
                hasLeggings && leggings == ROGUE.assetId(),
                hasBoots && boots == ROGUE.assetId());

    }

    protected static void doSentinelEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;
        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }

        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 3, 4, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 2, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false, false));
        }

        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, Math.min(i,2), false, false, false));

    }

    protected static void doKnightEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;

        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }

        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 3, 0, false, false, false));

        }
        entity.addEffect(new MobEffectInstance(MobEffects.LUCK, 3, 1, false, false, false));

    }

    protected static void doMermaidEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;

        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }



        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 3, 0, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 3, 0, false, false, false));
        }
    }

    protected static void doReaperEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;

        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }



        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.TRIAL_OMEN, 3, 0, false, false, false));
        }
    }

    protected static void doAngelEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;


        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }


        if (head && chest && legs && feet){
            entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 3, 0, false, false, false));

        }
        entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 3, i + 1, false, false, false));

    }


    protected static void doIcicleEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;
        if (head) {
            i++;
        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }


        if (head && chest && legs && feet){

        }

        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, i, false, false, false));

    }

    protected static void doBerserkerEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){
        int i = 0;
        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;

        }

        if (head && chest && legs && feet){

        }

        entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3, i, false, false, false));

    }

    protected static void doRogueEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet) {
        int i = 0;

        if (head) {
            i++;

        }

        if (chest) {
            i++;

        }

        if (legs) {
            i++;

        }

        if (feet) {
            i++;
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false, false));

        }

        if (head && chest && legs && feet) {
            if (entity.isCrouching()) {
                entity.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY, 3, 0, false, false, false));
            }
        }

        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false, false));


    }


    //ATTRIBUTES

    protected static ItemAttributeModifiers.Builder resolveAttributeModifiers(ArmorMaterial material, ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        if ( material == SENTINEL){
            return sentinelAttributes(ArmorType,builder);
        }else
            if ( material == KNIGHT){
                return knightAttributes(ArmorType,builder);
        }else
            if ( material == MERMAID){
                return mermaidAttributes(ArmorType,builder);
        }else
            if ( material == REAPER){
                return reaperAttributes(ArmorType,builder);
        }else
            if ( material == ANGEL){
                return angelAttributes(ArmorType,builder);
        }else
            if ( material == ICICLE){
                return icicleAttributes(ArmorType,builder);
        }else
            if ( material == BERSERKER){
                return berserkerAttributes(ArmorType,builder);
        }else
            if ( material == ROGUE){
                return rogueAttributes(ArmorType,builder);
        }
        return builder;
    }


    protected static ItemAttributeModifiers.Builder sentinelAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());



        if (ArmorType == ArmorType.HELMET){
        }else if (ArmorType == ArmorType.CHESTPLATE){
        }else if (ArmorType == ArmorType.LEGGINGS){

        }else if (ArmorType == ArmorType.BOOTS){
        }
        builder.add(Attributes.MOVEMENT_SPEED,new AttributeModifier(location,-0.1F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);


        return builder;
    }

    protected static ItemAttributeModifiers.Builder knightAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());



        if (ArmorType == ArmorType.HELMET){

        }else if (ArmorType == ArmorType.CHESTPLATE){

        }else if (ArmorType == ArmorType.LEGGINGS){

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.STEP_HEIGHT,new AttributeModifier(location,0.5F,AttributeModifier.Operation.ADD_VALUE),slot);

        }

        return builder;
    }

    protected static ItemAttributeModifiers.Builder mermaidAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());


        if (ArmorType == ArmorType.HELMET){
            builder.add(Attributes.OXYGEN_BONUS, new AttributeModifier(location,4.0F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.CHESTPLATE){
            builder.add(Attributes.SUBMERGED_MINING_SPEED, new AttributeModifier(location,3.0F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.LEGGINGS){
            builder.add(NeoForgeMod.SWIM_SPEED,new AttributeModifier(location,0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),slot);

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.WATER_MOVEMENT_EFFICIENCY,new AttributeModifier(location,0.1F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),slot);
        }

        return builder;
    }

    protected static ItemAttributeModifiers.Builder reaperAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());


        if (ArmorType == ArmorType.HELMET){

        }else if (ArmorType == ArmorType.CHESTPLATE){

        }else if (ArmorType == ArmorType.LEGGINGS){
            builder.add(Attributes.SNEAKING_SPEED,new AttributeModifier(location,0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL),slot);

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.SAFE_FALL_DISTANCE,new AttributeModifier(location,4.0F, AttributeModifier.Operation.ADD_VALUE),slot);
        }

        return builder;
    }

    protected static ItemAttributeModifiers.Builder angelAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());



        if (ArmorType == ArmorType.HELMET){

        }else if (ArmorType == ArmorType.CHESTPLATE){
            builder.add(Attributes.GRAVITY, new AttributeModifier(location,-0.4F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (ArmorType == ArmorType.LEGGINGS){

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER, new AttributeModifier(location,-0.2F, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);
            builder.add(Attributes.SAFE_FALL_DISTANCE, new AttributeModifier(location,4.0F, AttributeModifier.Operation.ADD_VALUE),slot);


        }

        return builder;
    }

    protected static ItemAttributeModifiers.Builder icicleAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());



        if (ArmorType == ArmorType.HELMET){
            builder.add(Attributes.BURNING_TIME, new AttributeModifier(location,-0.2F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.CHESTPLATE){
            builder.add(Attributes.BURNING_TIME, new AttributeModifier(location,-0.2F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.LEGGINGS){
            builder.add(Attributes.BURNING_TIME, new AttributeModifier(location,-0.2F, AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.BURNING_TIME, new AttributeModifier(location,-0.2F, AttributeModifier.Operation.ADD_VALUE),slot);

        }

        return builder;
    }

    protected static ItemAttributeModifiers.Builder berserkerAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());



        if (ArmorType == ArmorType.HELMET){
            builder.add(Attributes.ATTACK_DAMAGE,new AttributeModifier(location,2.4F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.ATTACK_KNOCKBACK,new AttributeModifier(location,0.4F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.CHESTPLATE){

        }else if (ArmorType == ArmorType.LEGGINGS){
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.EXPLOSION_KNOCKBACK_RESISTANCE,new AttributeModifier(location,0.1F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.SWEEPING_DAMAGE_RATIO,new AttributeModifier(location,0.7F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.MOVEMENT_EFFICIENCY,new AttributeModifier(location,0.3F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER,new AttributeModifier(location,0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }

        return builder;
    }

    protected static ItemAttributeModifiers.Builder rogueAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
        EquipmentSlotGroup slot = EquipmentSlotGroup.bySlot(ArmorType.getSlot());
        ResourceLocation location = ResourceLocation.withDefaultNamespace("armor." + ArmorType.getName());



        if (ArmorType == ArmorType.HELMET){
            builder.add(Attributes.BLOCK_INTERACTION_RANGE,new AttributeModifier(location,0.35F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (ArmorType == ArmorType.CHESTPLATE){
            builder.add(Attributes.ATTACK_SPEED,new AttributeModifier(location,0.2F,AttributeModifier.Operation.ADD_VALUE),slot);

        }else if (ArmorType == ArmorType.LEGGINGS){
            builder.add(Attributes.JUMP_STRENGTH,new AttributeModifier(location,0.6F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.FALL_DAMAGE_MULTIPLIER,new AttributeModifier(location,-0.5F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }else if (ArmorType == ArmorType.BOOTS){
            builder.add(Attributes.SAFE_FALL_DISTANCE,new AttributeModifier(location,6.0F,AttributeModifier.Operation.ADD_VALUE),slot);
            builder.add(Attributes.GRAVITY,new AttributeModifier(location,-0.4F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);
            builder.add(Attributes.SNEAKING_SPEED,new AttributeModifier(location,0.3F,AttributeModifier.Operation.ADD_MULTIPLIED_BASE),slot);

        }

        return builder;
    }
}


package com.fuyuaki.morethanadventure.world.item;

import com.fuyuaki.morethanadventure.core.registry.MtaArmorMats;
import com.google.common.base.Suppliers;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
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
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.NeoForgeMod;

import java.util.UUID;
import java.util.function.Supplier;

public class MTAArmor extends ArmorItem {
    protected final UUID FULL_SET_UUID = UUID.fromString("78f6b05d-a0ff-4b5e-86dc-9b397d5b7878");
    private static final ArmorMaterial SENTINEL = MtaArmorMats.GREAT_SENTINEL;
    private static final ArmorMaterial KNIGHT = MtaArmorMats.HOLY_KNIGHT;
    private static final ArmorMaterial MERMAID = MtaArmorMats.MYSTIC_MERMAID;
    private static final ArmorMaterial REAPER = MtaArmorMats.SILENT_REAPER;
    private static final ArmorMaterial ANGEL = MtaArmorMats.TEMPLE_ANGEL;
    private static final ArmorMaterial ICICLE = MtaArmorMats.FREEZING_ICICLE;
    private static final ArmorMaterial BERSERKER = MtaArmorMats.WRATHFUL_BERSERKER;
    private static final ArmorMaterial ROGUE = MtaArmorMats.SHADOW_ROGUE;

    //ATTRIBUTES

    private final Supplier<ItemAttributeModifiers> attributeModifiers;



    public MTAArmor(ArmorMaterial pMaterial, ArmorType pArmorType, Properties pProperties) {
        super(pMaterial, pArmorType, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
        this.attributeModifiers = Suppliers.memoize(
                () -> {
                    int i = pMaterial.defense().get(pArmorType);
                    float f = pMaterial.toughness();
                    ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
                    EquipmentSlotGroup equipmentslotgroup = EquipmentSlotGroup.bySlot(pArmorType.getSlot());
                    ResourceLocation resourcelocation = ResourceLocation.withDefaultNamespace("armor." + pArmorType.getName());
                    builder.add(
                            Attributes.ARMOR, new AttributeModifier(resourcelocation, (double)i, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );
                    builder.add(
                            Attributes.ARMOR_TOUGHNESS, new AttributeModifier(resourcelocation, (double)f, AttributeModifier.Operation.ADD_VALUE), equipmentslotgroup
                    );

                    float f1 = pMaterial.knockbackResistance();
                    if (f1 > 0.0F) {
                        builder.add(
                                Attributes.KNOCKBACK_RESISTANCE,
                                new AttributeModifier(resourcelocation, (double)f1, AttributeModifier.Operation.ADD_VALUE),
                                equipmentslotgroup
                        );
                    }
                    return resolveAttributeModifiers(pMaterial,pArmorType,builder).build();
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
        boolean hasHelmet = entity.getItemBySlot(ArmorType.HELMET.getSlot()).getItem() instanceof ArmorItem;
        boolean hasChestplate = entity.getItemBySlot(ArmorType.CHESTPLATE.getSlot()).getItem() instanceof ArmorItem;
        boolean hasLeggings = entity.getItemBySlot(ArmorType.LEGGINGS.getSlot()).getItem() instanceof ArmorItem;
        boolean hasBoots = entity.getItemBySlot(ArmorType.BOOTS.getSlot()).getItem() instanceof ArmorItem;

        //USED ARMADILLO SO IT DOESN'T BREAK FROM NULL!!!
        ArmorMaterial helmet = ArmorMaterials.ARMADILLO_SCUTE;
        ArmorMaterial chestplate = ArmorMaterials.ARMADILLO_SCUTE;
        ArmorMaterial leggings = ArmorMaterials.ARMADILLO_SCUTE;
        ArmorMaterial boots = ArmorMaterials.ARMADILLO_SCUTE;

        if (hasHelmet) helmet = (entity.getItemBySlot(ArmorType.HELMET.getSlot()).get(DataComponents.EQUIPPABLE).assetId());
        if (hasChestplate) chestplate = (entity.getItemBySlot(ArmorType.CHESTPLATE.getSlot()).getItem());
        if (hasLeggings) leggings = (entity.getItemBySlot(ArmorType.LEGGINGS.getSlot()).getItem());
        if (hasBoots) boots = (entity.getItemBySlot(ArmorType.BOOTS.getSlot()).getItem());

        
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
        doIcicleEffects(entity,
                level,pSlotId,
                hasHelmet && helmet == ICICLE,
                hasChestplate && chestplate == ICICLE,
                hasLeggings && leggings == ICICLE,
                hasBoots && boots == ICICLE);
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


    protected void doIcicleEffects(LivingEntity entity, Level level, int pSlotId, boolean head, boolean chest, boolean legs, boolean feet){

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
            entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3, 0, false, false, false));
            entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3, 2, false, false, false));
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

    protected ItemAttributeModifiers.Builder resolveAttributeModifiers(ArmorMaterial material, ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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


    protected ItemAttributeModifiers.Builder sentinelAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder knightAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder mermaidAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder reaperAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder angelAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder icicleAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder berserkerAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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

    protected ItemAttributeModifiers.Builder rogueAttributes(ArmorType ArmorType, ItemAttributeModifiers.Builder builder){
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


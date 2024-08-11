package com.fuyuvulpes.morethanadventure.world.item;

import com.fuyuvulpes.morethanadventure.core.registry.MtaArmorMats;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class MTAArmor extends ArmorItem {
    protected final UUID FULL_SET_UUID = UUID.fromString("78f6b05d-a0ff-4b5e-86dc-9b397d5b7878");
    private final ArmorMaterial SENTINEL = MtaArmorMats.GREAT_SENTINEL.value();
    private final ArmorMaterial KNIGHT = MtaArmorMats.HOLY_KNIGHT.value();
    private final ArmorMaterial MERMAID = MtaArmorMats.MYSTIC_MERMAID.value();
    private final ArmorMaterial ANGEL = MtaArmorMats.TEMPLE_ANGEL.value();
    private final ArmorMaterial BERSERKER = MtaArmorMats.WRATHFUL_BERSERKER.value();
    private final ArmorMaterial ROGUE = MtaArmorMats.SHADOW_ROGUE.value();


    public MTAArmor(Holder<ArmorMaterial> pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties.stacksTo(1).fireResistant().rarity(Rarity.EPIC));
    }


    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity living){
            if (!pLevel.isClientSide()){
                estimateEffects(living,pLevel);
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);

    }

    protected void estimateEffects(LivingEntity entity, Level level){
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
                level,
                hasHelmet && helmet == SENTINEL,
                hasChestplate && chestplate == SENTINEL,
                hasLeggings && leggings == SENTINEL,
                hasBoots && boots == SENTINEL);
        doKnightEffects(entity,
                level,
                hasHelmet && helmet == KNIGHT,
                hasChestplate && chestplate == KNIGHT,
                hasLeggings && leggings == KNIGHT,
                hasBoots && boots == KNIGHT);
        doMermaidEffects(entity,
                level,
                hasHelmet && helmet == MERMAID,
                hasChestplate && chestplate == MERMAID,
                hasLeggings && leggings == MERMAID,
                hasBoots && boots == MERMAID);
        doAngelEffects(entity,
                level,
                hasHelmet && helmet == ANGEL,
                hasChestplate && chestplate == ANGEL,
                hasLeggings && leggings == ANGEL,
                hasBoots && boots == ANGEL);
        doBerserkerEffects(entity,
                level,
                hasHelmet && helmet == BERSERKER,
                hasChestplate && chestplate == BERSERKER,
                hasLeggings && leggings == BERSERKER,
                hasBoots && boots == BERSERKER);
        doRogueEffects(entity,
                level,
                hasHelmet && helmet == ROGUE,
                hasChestplate && chestplate == ROGUE,
                hasLeggings && leggings == ROGUE,
                hasBoots && boots == ROGUE);

    }



    protected void doSentinelEffects(LivingEntity entity, Level level, boolean head, boolean chest, boolean legs, boolean feet){
        if (head){

        }
        if (chest){

        }
        if (legs){

        }
        if (feet){

        }
        if (head && chest && legs && feet){

        }
    }

    protected void doKnightEffects(LivingEntity entity, Level level, boolean head, boolean chest, boolean legs, boolean feet){
        if (head){

        }
        if (chest){

        }
        if (legs){

        }
        if (feet){

        }
        if (head && chest && legs && feet){

        }
    }

    protected void doMermaidEffects(LivingEntity entity, Level level, boolean head, boolean chest, boolean legs, boolean feet){
        if (head){

        }
        if (chest){

        }
        if (legs){

        }
        if (feet){

        }
        if (head && chest && legs && feet){

        }
    }

    protected void doAngelEffects(LivingEntity entity, Level level, boolean head, boolean chest, boolean legs, boolean feet){
        if (head){

        }
        if (chest){

        }
        if (legs){

        }
        if (feet){

        }
        if (head && chest && legs && feet){

        }
    }

    protected void doBerserkerEffects(LivingEntity entity, Level level, boolean head, boolean chest, boolean legs, boolean feet){
        if (head){

        }
        if (chest){

        }
        if (legs){

        }
        if (feet){

        }
        if (head && chest && legs && feet){

        }
    }

    protected void doRogueEffects(LivingEntity entity, Level level, boolean head, boolean chest, boolean legs, boolean feet){
        if (head){

        }
        if (chest){

        }
        if (legs){

        }
        if (feet){

        }
        if (head && chest && legs && feet){

        }
    }
}


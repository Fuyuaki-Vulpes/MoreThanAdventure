package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.world.item.component.PullingComponent;
import com.fuyuaki.morethanadventure.world.item.enchantment.DisarmEnchantmentEffect;
import com.fuyuaki.morethanadventure.world.item.enchantment.HitAndBuffEnchantmentEffect;
import com.fuyuaki.morethanadventure.world.item.enchantment.PullingEnchantmentEffect;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.*;
import net.minecraft.world.item.enchantment.effects.DamageImmunity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.Vec3;

import java.util.List;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaEnchantments {
   public static final ResourceKey<Enchantment> DISARM = ResourceKey.create(Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath(MODID, "disarm"));
   public static final ResourceKey<Enchantment> HIT_AND_RUN = ResourceKey.create(Registries.ENCHANTMENT,
           ResourceLocation.fromNamespaceAndPath(MODID, "hit_and_run"));
   public static final ResourceKey<Enchantment> SNAG = ResourceKey.create(Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath(MODID, "snag"));
   public static final ResourceKey<Enchantment> STRAFING = ResourceKey.create(Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath(MODID, "strafing"));



    public static void bootstrap(BootstrapContext<Enchantment> context){
        HolderGetter<DamageType> damageType = context.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Enchantment> enchantment = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> item = context.lookup(Registries.ITEM);
        HolderGetter<Block> block = context.lookup(Registries.BLOCK);
        HolderGetter<EntityType<?>> entity = context.lookup(Registries.ENTITY_TYPE);

        register(context, DISARM, Enchantment.enchantment(Enchantment.definition(item.getOrThrow(MtaTags.Items.ANCHOR_ENCHANTMENTS),
                item.getOrThrow(MtaTags.Items.ANCHOR_ENCHANTMENTS), 15, 1,
                Enchantment.dynamicCost(5,8), Enchantment.dynamicCost(25, 8), 3, EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM, new DisarmEnchantmentEffect(LevelBasedValue.constant(4F))));

        register(context, SNAG, Enchantment.enchantment(Enchantment.definition(item.getOrThrow(MtaTags.Items.WHIP_ENCHANTMENTS),
                item.getOrThrow(MtaTags.Items.WHIP_ENCHANTMENTS), 20, 3,
                Enchantment.dynamicCost(5,8), Enchantment.dynamicCost(25, 8), 3, EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM, new DisarmEnchantmentEffect(LevelBasedValue.perLevel(1F))));

        register(context, HIT_AND_RUN, Enchantment.enchantment(Enchantment.definition(item.getOrThrow(ItemTags.BOW_ENCHANTABLE),
                20,3, Enchantment.dynamicCost(5,8), Enchantment.dynamicCost(25,8), 3, EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.ATTACKER,
                        new HitAndBuffEnchantmentEffect(LevelBasedValue.perLevel(0.1F), Attributes.MOVEMENT_SPEED, 0.1F, AttributeModifier.Operation.ADD_VALUE, 100,
                                ResourceLocation.fromNamespaceAndPath(MODID, "hit_and_run"))));

        register(context, STRAFING, Enchantment.enchantment(Enchantment.definition(item.getOrThrow(ItemTags.BOW_ENCHANTABLE),
                item.getOrThrow(ItemTags.BOW_ENCHANTABLE), 15, 5,
                Enchantment.dynamicCost(5,8), Enchantment.dynamicCost(25, 8), 3, EquipmentSlotGroup.MAINHAND))
                .withEffect(MTAEnchantmentEffect.PULLING.get(),
                        new PullingEnchantmentEffect(ResourceLocation.fromNamespaceAndPath(MODID, "enchantment.pulling"), 0.1F, LevelBasedValue.perLevel(0.1F),
                                Attributes.MOVEMENT_SPEED, AttributeModifier.Operation.ADD_VALUE)));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }
}

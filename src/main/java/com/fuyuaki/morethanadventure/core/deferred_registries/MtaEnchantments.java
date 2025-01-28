package com.fuyuaki.morethanadventure.core.deferred_registries;

import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.world.item.enchantment.DisarmEnchantmentEffect;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.EnchantmentTarget;
import net.minecraft.world.item.enchantment.LevelBasedValue;
import net.minecraft.world.level.block.Block;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MtaEnchantments {
   public static final ResourceKey<Enchantment> DISARM = ResourceKey.create(Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath(MODID, "disarm"));
   public static final ResourceKey<Enchantment> SNAG = ResourceKey.create(Registries.ENCHANTMENT,
        ResourceLocation.fromNamespaceAndPath(MODID, "snag"));



    public static void bootstrap(BootstrapContext<Enchantment> context){
        HolderGetter<DamageType> damageType = context.lookup(Registries.DAMAGE_TYPE);
        HolderGetter<Enchantment> enchantment = context.lookup(Registries.ENCHANTMENT);
        HolderGetter<Item> item = context.lookup(Registries.ITEM);
        HolderGetter<Block> block = context.lookup(Registries.BLOCK);
        HolderGetter<EntityType<?>> entity = context.lookup(Registries.ENTITY_TYPE);

        register(context, DISARM, Enchantment.enchantment(Enchantment.definition(item.getOrThrow(MtaTags.Items.ANCHOR_ENCHANTMENTS),
                item.getOrThrow(MtaTags.Items.ANCHOR_ENCHANTMENTS), 100, 1,
                Enchantment.dynamicCost(5,8), Enchantment.dynamicCost(25, 8), 3, EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM, new DisarmEnchantmentEffect(LevelBasedValue.constant(4F))));

        register(context, SNAG, Enchantment.enchantment(Enchantment.definition(item.getOrThrow(MtaTags.Items.WHIP_ENCHANTMENTS),
                item.getOrThrow(MtaTags.Items.WHIP_ENCHANTMENTS), 100, 3,
                Enchantment.dynamicCost(5,8), Enchantment.dynamicCost(25, 8), 3, EquipmentSlotGroup.MAINHAND))
                .withEffect(EnchantmentEffectComponents.POST_ATTACK, EnchantmentTarget.ATTACKER, EnchantmentTarget.VICTIM, new DisarmEnchantmentEffect(LevelBasedValue.perLevel(1F))));
    }

    private static void register(BootstrapContext<Enchantment> context, ResourceKey<Enchantment> key, Enchantment.Builder builder) {
        context.register(key, builder.build(key.location()));
    }
}

package com.fuyuaki.morethanadventure.world.item;

import com.google.common.collect.Sets;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.ItemAbility;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WeaponAbilities extends ItemAbilities {
    public static final Set<ItemAbility> DEFAULT_ANCHOR_ACTIONS = of(SWORD_DIG, SWORD_SWEEP, PICKAXE_DIG);
    public static final Set<ItemAbility> DEFAULT_CLAW_ACTIONS = of(SWORD_DIG, SHEARS_DIG);
    public static final Set<ItemAbility> DEFAULT_CLAYMORE_ACTIONS = of(SWORD_DIG);
    public static final Set<ItemAbility> DEFAULT_CUTLASS_ACTIONS = of(SWORD_DIG);
    public static final Set<ItemAbility> DEFAULT_DAGGER_ACTIONS = of(SWORD_DIG, SHEARS_HARVEST, SHEARS_CARVE, SHEARS_DISARM, SHEARS_TRIM);
    public static final Set<ItemAbility> DEFAULT_DOUBLE_AXE_ACTIONS = of(SWORD_DIG, AXE_DIG,AXE_WAX_OFF);
    public static final Set<ItemAbility> DEFAULT_FLAIL_ACTIONS = of(SWORD_DIG, SWORD_SWEEP);
    public static final Set<ItemAbility> DEFAULT_GLAIVE_ACTIONS = of(SWORD_DIG);
    public static final Set<ItemAbility> DEFAULT_HALBERD_ACTIONS = of(SWORD_DIG, AXE_DIG,AXE_STRIP,AXE_SCRAPE);
    public static final Set<ItemAbility> DEFAULT_KATANA_ACTIONS = of(SWORD_DIG, SHEARS_DISARM);
    public static final Set<ItemAbility> DEFAULT_RAPIER_ACTIONS = of(SWORD_DIG);
    public static final Set<ItemAbility> DEFAULT_SCYTHE_ACTIONS = of(SWORD_DIG, HOE_DIG,HOE_TILL);
    public static final Set<ItemAbility> DEFAULT_SICKLE_ACTIONS = of(SWORD_DIG, HOE_DIG,HOE_TILL);
    public static final Set<ItemAbility> DEFAULT_SPEAR_ACTIONS = of(SWORD_DIG);
    public static final Set<ItemAbility> DEFAULT_TWINBLADE_ACTIONS = of(SWORD_DIG);


    private static Set<ItemAbility> of(ItemAbility... actions) {
        return Stream.of(actions).collect(Collectors.toCollection(Sets::newIdentityHashSet));
    }


}

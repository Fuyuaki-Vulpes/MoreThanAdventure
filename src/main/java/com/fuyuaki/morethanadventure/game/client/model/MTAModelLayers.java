package com.fuyuaki.morethanadventure.game.client.model;

import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.MTAMod.MODID;

public class MTAModelLayers {

    //ITEMS
    public static final ModelLayerLocation NETHERITE_TRIDENT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "netherite_trident"), "main");
    public static final ModelLayerLocation MYSTIC_MERMAIDS_TRIDENT = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "mystic_mermaid_trident"), "main");

    //BLOCKS
    public static final ModelLayerLocation SPRINKLER = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, "sprinkler"), "main");


    //ENTITIES
    public static final ModelLayerLocation ARMORED_SKELETON = register("armored_skeleton");
    public static final ModelLayerLocation BEARDED_DRAGON = register("bearded_dragon");
    public static final ModelLayerLocation BLACK_WIDOW = register("black_widow");
    public static final ModelLayerLocation BUTTERFLY = register("butterfly");
    public static final ModelLayerLocation BUTTERFLY_PATTERN = register("butterfly");
    public static final ModelLayerLocation BUTTERFLY_OVERLAY = register("butterfly");
    public static final ModelLayerLocation CAPYBARA = register("capybara");
    public static final ModelLayerLocation CHARRED_SKELETON = register("charred_skeleton");
    public static final ModelLayerLocation CORROSIVE_CUBE = register("corrosive_cube");
    public static final ModelLayerLocation CORROSIVE_CUBE_OUTER = register("corrosive_cube_outer");
    public static final ModelLayerLocation DEER = register("deer");
    public static final ModelLayerLocation DUCK = register("duck");
    public static final ModelLayerLocation FALLEN_SAMURAI = register("fallen_samurai");
    public static final ModelLayerLocation FERRET = register("ferret");
    public static final ModelLayerLocation FROSTED_SLIME = register("frosted_slime");
    public static final ModelLayerLocation GLOW_SPIDER = register("glow_spider");
    public static final ModelLayerLocation GLOW_SPIDER_GLOW = register("glow_spider_glow");
    public static final ModelLayerLocation GREAT_WHITE_SHARK = register("great_white_shark");
    public static final ModelLayerLocation HORSESHOE_CRAB = register("horseshoe_crab");
    public static final ModelLayerLocation HOST = register("host");
    public static final ModelLayerLocation ICICLE_CREEPER = register("icicle_creeper");
    public static final ModelLayerLocation JELLYFISH = register("jellyfish");
    public static final ModelLayerLocation SIREN = register("siren");
    public static final ModelLayerLocation MOSSY_ZOMBIE = register("mossy_zombie");
    public static final ModelLayerLocation OCTOPUS = register("octopus");
    public static final ModelLayerLocation OWL = register("owl");
    public static final ModelLayerLocation PENGUIN = register("penguin");
    public static final ModelLayerLocation RACCOON = register("raccoon");
    public static final ModelLayerLocation SHRIMP = register("shrimp");
    public static final ModelLayerLocation SKELETON_FIGHTER = register("skeleton_fighter");
    public static final ModelLayerLocation TOUCAN = register("toucan");
    public static final ModelLayerLocation TOXIC_ZOMBIE = register("toxic_zombie");
    public static final ModelLayerLocation TURKEY = register("turkey");
    public static final ModelLayerLocation YUKI_ONNA = register("yuki_onna");
    public static final ModelLayerLocation ZOMBIFIED_MINER = register("zombified_miner");
    public static final ModelLayerLocation ARMORED_SKELETON_OUTER_ARMOR = register("armored_skeleton_outer_armor");
    public static final ModelLayerLocation ARMORED_SKELETON_INNER_ARMOR = register("armored_skeleton_inner_armor");
    public static final ModelLayerLocation CHARRED_SKELETON_OUTER_ARMOR = register("charred_skeleton_outer_armor");
    public static final ModelLayerLocation CHARRED_SKELETON_INNER_ARMOR = register("charred_skeleton_inner_armor");
    public static final ModelLayerLocation HOST_OUTER_ARMOR = register("host_outer_armor");
    public static final ModelLayerLocation HOST_INNER_ARMOR = register("host_inner_armor");
    public static final ModelLayerLocation MOSSY_ZOMBIE_OUTER_ARMOR = register("mossy_zombie_outer_armor");
    public static final ModelLayerLocation MOSSY_ZOMBIE_INNER_ARMOR = register("mossy_zombie_inner_armor");
    public static final ModelLayerLocation SKELETON_FIGHTER_OUTER_ARMOR = register("skeleton_fighter_outer_armor");
    public static final ModelLayerLocation SKELETON_FIGHTER_INNER_ARMOR = register("skeleton_fighter_inner_armor");
    public static final ModelLayerLocation TOXIC_ZOMBIE_OUTER_ARMOR = register("toxic_zombie_outer_armor");
    public static final ModelLayerLocation TOXIC_ZOMBIE_INNER_ARMOR = register("toxic_zombie_inner_armor");
    public static final ModelLayerLocation ZOMBIFIED_MINER_OUTER_ARMOR = register("zombified_miner_outer_armor");
    public static final ModelLayerLocation ZOMBIFIED_MINER_INNER_ARMOR = register("zombified_miner_inner_armor");
    public static final ModelLayerLocation WISPFLY = register("wispfly");
    public static final ModelLayerLocation WISPFLY_OUTER_LAYER = register("wispfly_outer_layer");




    public static final ModelLayerLocation SIREN_LAYER = register("siren_tail");



    private static ModelLayerLocation register(String name){
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, name), "main");
    }
}

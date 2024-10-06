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
    public static final ModelLayerLocation BEARDED_DRAGON = register("bearded_dragon");
    public static final ModelLayerLocation BUTTERFLY = register("butterfly");
    public static final ModelLayerLocation CAPYBARA = register("capybara");
    public static final ModelLayerLocation DUCK = register("duck");
    public static final ModelLayerLocation FALLEN_SAMURAI = register("fallen_samurai");
    public static final ModelLayerLocation FERRET = register("ferret");
    public static final ModelLayerLocation GREAT_WHITE_SHARK = register("great_white_shark");
    public static final ModelLayerLocation HORSESHOE_CRAB = register("horseshoe_crab");
    public static final ModelLayerLocation ICICLE_CREEPER = register("icicle_creeper");
    public static final ModelLayerLocation JELLYFISH = register("jellyfish");
    public static final ModelLayerLocation OCTOPUS = register("octopus");
    public static final ModelLayerLocation OWL = register("owl");
    public static final ModelLayerLocation PENGUIN = register("penguin");
    public static final ModelLayerLocation RACCOON = register("raccoon");
    public static final ModelLayerLocation SHRIMP = register("shrimp");
    public static final ModelLayerLocation TOUCAN = register("toucan");
    public static final ModelLayerLocation WITHER_JUGGERNAUT = register("wither_juggernaut");
    public static final ModelLayerLocation YUKI_ONNA = register("yuki_onna");

    private static ModelLayerLocation register(String name){
        return new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MODID, name), "main");
    }
}

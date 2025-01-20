package com.fuyuaki.morethanadventure.game.client.renderer;

import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;

import static com.fuyuaki.morethanadventure.core.mod.MTAMod.MODID;

public class MTASheets {
    public static final ResourceLocation SPRINKLER_SHEETS = ResourceLocation.fromNamespaceAndPath(MODID,"textures/atlas/sprinkler.png");

    public static Material createSprinklerMaterial() {
        return new Material(SPRINKLER_SHEETS,  ResourceLocation.fromNamespaceAndPath(MODID, "textures/entity/sprinkler.png"));
    }
}

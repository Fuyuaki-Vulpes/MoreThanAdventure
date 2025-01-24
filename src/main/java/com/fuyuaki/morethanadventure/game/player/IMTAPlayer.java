package com.fuyuaki.morethanadventure.game.player;


import net.minecraft.world.item.ItemStack;

public interface IMTAPlayer {


    boolean hasAttackedWithOffhand();
    ItemStack getOffhandWeaponItem();

}

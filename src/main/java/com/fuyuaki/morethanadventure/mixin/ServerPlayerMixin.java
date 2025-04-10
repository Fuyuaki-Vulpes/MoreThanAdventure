package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.world.entity.attachments.SpeciesAttachment;
import com.google.common.collect.ImmutableList;
import com.mojang.authlib.GameProfile;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ServerPlayer.class)
public abstract class ServerPlayerMixin extends Player {


    @Shadow public abstract ServerLevel serverLevel();

    public ServerPlayerMixin(Level pLevel, BlockPos pPos, float pYRot, GameProfile pGameProfile) {
        super(pLevel, pPos, pYRot, pGameProfile);
    }


    @Inject(method = "restoreFrom(Lnet/minecraft/server/level/ServerPlayer;Z)V", at = @At("TAIL"))
    private void keepExpOnDeath(ServerPlayer pThat, boolean pKeepEverything, CallbackInfo ci){
        this.experienceLevel = Math.max(pThat.experienceLevel - 10, 0);
        this.totalExperience = pThat.totalExperience;
    }

    @Inject(method = "restoreFrom(Lnet/minecraft/server/level/ServerPlayer;Z)V", at = @At("HEAD"))
    private void restoreFromHead(ServerPlayer that, boolean keepEverything, CallbackInfo ci) {
        SpeciesAttachment.sync(that,this);
        Inventory thatInventory = that.getInventory();
        if (!(keepEverything && this.serverLevel().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY) || that.isSpectator())) {
            for (List<ItemStack> list : ImmutableList.of(thatInventory.items, thatInventory.armor, thatInventory.offhand)) {
                for (int i = 0; i < list.size(); i++) {
                    ItemStack itemstack = list.get(i);
                    if (itemstack.is(Items.RECOVERY_COMPASS)) {
                        this.getInventory().add(i,itemstack);
                        that.getInventory().removeItem(i,itemstack.getCount());
                    }
                }
            }
        }
    }







}


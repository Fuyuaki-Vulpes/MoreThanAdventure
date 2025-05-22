package com.fuyuaki.morethanadventure.game.species.traits.core;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttachments;
import com.fuyuaki.morethanadventure.core.mod.MTAUtils;
import com.fuyuaki.morethanadventure.game.species.Species;
import com.fuyuaki.morethanadventure.world.entity.util.MTAPlayer;
import net.minecraft.world.entity.player.Player;

public class TraitListener {

    public static void runTraitTicks(Player player){
        if (!player.hasData(MTAAttachments.SPECIES.get())) return;

        Species species = ((MTAPlayer)player).getSpecies();
        species.traits().forEach(trait -> {
            if (trait instanceof TickingTrait tickingTrait && tickingTrait.shouldTick(player) && tickingTrait.active(player)){
                tickingTrait.tick(player);
            }
        });
    }

    public static void runToggleTraits(Player player){
        if (!player.hasData(MTAAttachments.SPECIES.get())) return;

        Species species =  ((MTAPlayer)player).getSpecies();
        species.traits().forEach(trait -> {
            if (trait instanceof TickingTrait tickingTrait && tickingTrait.shouldTick(player) && tickingTrait.active(player)){
                tickingTrait.tick(player);
            }
        });
    }



}

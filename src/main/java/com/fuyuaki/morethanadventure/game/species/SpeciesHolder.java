package com.fuyuaki.morethanadventure.game.species;

import com.fuyuaki.morethanadventure.game.species.trait.Trait;
import net.minecraft.world.entity.player.Player;

import java.util.List;

public class SpeciesHolder {
    private final Species definition;
    private final boolean visibleInMenu;

    public SpeciesHolder(Species definition, boolean active) {
        this.definition = definition;
        this.visibleInMenu = active;
    }

    public Species definition() {
        return definition;
    }

    public boolean active() {
        return visibleInMenu;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        } else {
            if (other instanceof SpeciesHolder speciesHolder && this.definition.equals(speciesHolder.definition)) {
                return true;
            }

            return false;
        }
    }

    public void tickTraits(Player player){
        this.definition.traits().forEach(trait -> {
            trait.tick(player,player.level());
        });
    }

    public boolean hasTrait(Trait trait){
        return this.definition.traits().contains(trait);
    }

    public List<Trait> getTraits(){
        return this.definition.traits();
    }

    public List<Species.AttributeModifierType> getAttributeModifiers(){
        return this.definition.modifiers();
    }


    @Override
    public String toString() {
        return this.definition.id().toString();
    }
}

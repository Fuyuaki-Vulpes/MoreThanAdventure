package com.fuyuaki.morethanadventure.game.species.trait;

import com.fuyuaki.morethanadventure.game.species.Species;
import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import java.util.*;

public class TraitsTree {

    private final Map<ResourceLocation, TraitHolder> nodes = new Object2ObjectOpenHashMap<>();
    private static final Logger LOGGER = LogUtils.getLogger();



    public Collection<TraitHolder> getSpecies() {
        return this.nodes.values();
    }

    public TraitHolder get(ResourceLocation id){
        return  this.nodes.get(id);
    }
    public TraitHolder get(Species definition){
        return this.nodes.get(definition.id());
    }

    private void remove(TraitHolder node) {

        LOGGER.info("Forgot about trait {}", node.definition());
        this.nodes.remove(node.definition().id());
        if (nodes.containsValue(node)) {
            this.nodes.remove(node.definition().id());
        }
    }

    public void remove(Set<ResourceLocation> idSet) {
        for (ResourceLocation resourcelocation : idSet) {
            TraitHolder TraitHolder = this.nodes.get(resourcelocation);
            if (TraitHolder == null) {
                LOGGER.warn("Told to remove trait {} but I don't know what that is", resourcelocation);
            } else {
                this.remove(TraitHolder);
            }
        }
    }

    public void addAll(Collection<TraitHolder> TraitHolders) {
        List<TraitHolder> list = new ArrayList<>(TraitHolders);

        while (!list.isEmpty()) {
            if (!list.removeIf(this::tryInsert)) {
                LOGGER.error("Couldn't load trait: {}", list);
                break;
            }
        }

        LOGGER.info("Loaded {} trait", this.nodes.size());
    }

    private boolean tryInsert(TraitHolder TraitHolder) {
        if (this.nodes.containsValue(TraitHolder) || this.nodes.containsKey(TraitHolder.definition().id())){
            return false;
        }
        this.nodes.put(TraitHolder.definition().id(), TraitHolder);
        return true;
    }


    public void clear() {
        this.nodes.clear();
    }
}

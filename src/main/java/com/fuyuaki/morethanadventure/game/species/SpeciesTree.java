package com.fuyuaki.morethanadventure.game.species;

import com.mojang.logging.LogUtils;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

import java.util.*;

public class SpeciesTree {
    private final Map<ResourceLocation, SpeciesHolder> nodes = new Object2ObjectOpenHashMap<>();
    private static final Logger LOGGER = LogUtils.getLogger();



    public Collection<SpeciesHolder> getSpecies() {
        return this.nodes.values();
    }

    public SpeciesHolder get(ResourceLocation id){
        return  this.nodes.get(id);
    }
    public SpeciesHolder get(Species definition){
        return this.nodes.get(definition.id());
    }

    private void remove(SpeciesHolder node) {

        LOGGER.info("Forgot about species {}", node.definition());
        this.nodes.remove(node.definition().id());
        if (nodes.containsValue(node)) {
            this.nodes.remove(node.definition().id());
        }
    }

    public void remove(Set<ResourceLocation> idSet) {
        for (ResourceLocation resourcelocation : idSet) {
            SpeciesHolder speciesHolder = this.nodes.get(resourcelocation);
            if (speciesHolder == null) {
                LOGGER.warn("Told to remove species {} but I don't know what that is", resourcelocation);
            } else {
                this.remove(speciesHolder);
            }
        }
    }

    public void addAll(Collection<SpeciesHolder> speciesHolders) {
        List<SpeciesHolder> list = new ArrayList<>(speciesHolders);

        while (!list.isEmpty()) {
            if (!list.removeIf(this::tryInsert)) {
                LOGGER.error("Couldn't load species: {}", list);
                break;
            }
        }

        LOGGER.info("Loaded {} species", this.nodes.size());
    }

    private boolean tryInsert(SpeciesHolder speciesHolder) {
        if (this.nodes.containsValue(speciesHolder) || this.nodes.containsKey(speciesHolder.definition().id())){
            return false;
        }
        this.nodes.put(speciesHolder.definition().id(), speciesHolder);
        return true;
    }


    public void clear() {
        this.nodes.clear();
    }
}

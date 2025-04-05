package com.fuyuaki.morethanadventure.game.species.trait.type;

import com.fuyuaki.morethanadventure.core.registry.MTARegistries;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class TraitType {

    private final Holder<TraitType> builtInRegistryHolder = MTARegistries.Registries.TRAIT_TYPE.wrapAsHolder(this);



    public static final Codec<Holder<TraitType>> CODEC = MTARegistries.Registries.TRAIT_TYPE
            .holderByNameCodec()
            .validate(
                    p_381630_ -> p_381630_.is(TraitTypes.EMPTY.get().builtInRegistryHolder().getKey())
                            ? DataResult.error(() -> "Item must not be morethanadventure:empty")
                            : DataResult.success(p_381630_)
            );

    public Holder<TraitType> builtInRegistryHolder() {
        return this.builtInRegistryHolder;
    }



}

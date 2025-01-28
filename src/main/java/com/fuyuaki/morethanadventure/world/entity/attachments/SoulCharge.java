package com.fuyuaki.morethanadventure.world.entity.attachments;

import com.fuyuaki.morethanadventure.core.deferred_registries.MTAAttributes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.wispforest.endec.Endec;
import io.wispforest.endec.StructEndec;
import io.wispforest.endec.impl.StructEndecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Player;
import net.neoforged.neoforge.common.util.INBTSerializable;
import org.jetbrains.annotations.UnknownNullability;

public class SoulCharge implements INBTSerializable<CompoundTag> {

    public static StructEndec<SoulCharge> ENDEC = StructEndecBuilder.of(
            Endec.FLOAT.fieldOf("charge", SoulCharge::getCharge),
            Endec.FLOAT.fieldOf("incoming", SoulCharge::getIncomingCharge),
            Endec.INT.fieldOf("max", SoulCharge::getMaxCharge),
            Endec.INT.fieldOf("limit", SoulCharge::getLowMaxLimit),
            SoulCharge::new
    );

    float charge = 0;
    float incomingCharge = 0;
    int maxCharge;
    public final int lowMaxLimit;


    public SoulCharge(int c) {
        this.maxCharge = c;
        lowMaxLimit = c;
    }


    public SoulCharge(float charge, float incoming, int maxCharge, int lowLimit) {
        this.charge = charge;
        this.incomingCharge = incoming;
        this.maxCharge = maxCharge;
        lowMaxLimit = lowLimit;
    }

    public float getCharge() {
        return charge;
    }

    public float getIncomingCharge() {
        return incomingCharge;
    }

    public int getMaxCharge() {
        return maxCharge;
    }

    public int getLowMaxLimit() {
        return lowMaxLimit;
    }

    public void tick(){
        if (this.incomingCharge > 0) {

            this.charge = Math.min(this.charge + 1, this.maxCharge);
            if (this.charge >= this.maxCharge){
                this.incomingCharge = 0;
            }
            this.incomingCharge--;
        }
    }

    public boolean drainCharge(float cost){
        if (cost > charge) return false;
        charge -= cost;
        return true;
    }
    public void addCharge(float toAdd, Player player){
        if (player.getAttributes().hasAttribute(MTAAttributes.SOUL_GATHERING)){
            toAdd = (float) (toAdd * player.getAttributes().getValue(MTAAttributes.SOUL_GATHERING));
        }
        this.incomingCharge = toAdd ;
    }

    public void setMaxCharge(int maxCharge) {
        this.maxCharge = Math.max(maxCharge, this.lowMaxLimit);
    }
    public void addToMaxCharge(int toAdd){
        this.maxCharge += toAdd;
    }


    public void removeFromMaxCharge(int toRemove){
        if (this.maxCharge - toRemove > this.lowMaxLimit) this.maxCharge = this.lowMaxLimit;
        else {
            this.maxCharge -= toRemove;
        }
    }


    @Override
    public @UnknownNullability CompoundTag serializeNBT(HolderLookup.Provider provider) {
        CompoundTag tag = new CompoundTag();
        tag.putFloat("Charge",this.charge);
        tag.putFloat("IncomingCharge",this.incomingCharge);
        tag.putInt("MaxCharge",this.maxCharge);
        return tag;
    }

    @Override
    public void deserializeNBT(HolderLookup.Provider provider, CompoundTag nbt) {
        this.charge = nbt.getFloat("Charge");
        this.incomingCharge = nbt.getFloat("IncomingCharge");
        this.maxCharge = nbt.getInt("MaxCharge");

    }
}

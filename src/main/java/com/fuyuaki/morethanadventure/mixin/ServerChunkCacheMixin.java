package com.fuyuaki.morethanadventure.mixin;


import com.fuyuaki.morethanadventure.core.deferred_registries.MtaEffects;
import com.fuyuaki.morethanadventure.world.mob_effect.renderer.StunRenderer;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.server.level.ChunkMap;
import net.minecraft.server.level.DistanceManager;
import net.minecraft.server.level.ServerChunkCache;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.LocalMobCapCalculator;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.chunk.ChunkSource;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;

@Mixin(ServerChunkCache.class)
public abstract class ServerChunkCacheMixin{


    @Shadow @Final public ServerLevel level;

    @Shadow private boolean spawnEnemies;

    @Shadow private boolean spawnFriendlies;

    @Shadow @Nullable private NaturalSpawner.SpawnState lastSpawnState;

    @Shadow @Final public ChunkMap chunkMap;

    @Shadow protected abstract void getFullChunk(long chunkPos, Consumer<LevelChunk> fullChunkGetter);

    @Shadow @Final private DistanceManager distanceManager;



    //Spawns Animals regardless of chunk stuff
    @Inject(method = "tickChunks(Lnet/minecraft/util/profiling/ProfilerFiller;JLjava/util/List;)V", at = @At(value = "HEAD"))
    private void tickChunksMixin(ProfilerFiller profiler, long timeInhabited, List<LevelChunk> chunks, CallbackInfo ci) {
        profiler.popPush("naturalSpawnCount");
        int i = this.distanceManager.getNaturalSpawnChunkCount();

        NaturalSpawner.SpawnState naturalspawner$spawnstate = NaturalSpawner.createState(
                i, this.level.getAllEntities(), this::getFullChunk, new LocalMobCapCalculator(this.chunkMap)
        );
        this.lastSpawnState = naturalspawner$spawnstate;
        profiler.popPush("spawnAndTick");
        boolean flag = this.level.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING);
        int j = this.level.getGameRules().getInt(GameRules.RULE_RANDOMTICKING);
        float time = this.level.getLevelData().getDayTime() % 24000L;
        boolean flag1 =
                (time > 100  && time < 1000)||
                (time > 1500  && time < 2000)||
                (time > 2500  && time < 3000)||
                (time > 3500  && time < 3700)||
                (time > 4000  && time < 5000)||
                (time > 6000  && time < 6500)||
                (time > 9000  && time < 9500)||
                (time > 11700  && time < 12000);

        List<MobCategory> list;
        if (flag && flag1) {
            list = NaturalSpawner.getFilteredSpawningCategories(naturalspawner$spawnstate, false, false, true);
        } else {
            list = List.of();
        }

        for (LevelChunk levelchunk : chunks) {
            ChunkPos chunkpos = levelchunk.getPos();
            levelchunk.incrementInhabitedTime(timeInhabited);
            if (!list.isEmpty() && this.level.getWorldBorder().isWithinBounds(chunkpos)) {
                NaturalSpawner.spawnForChunk(this.level, levelchunk, naturalspawner$spawnstate, list);
            }

            if (this.level.shouldTickBlocksAt(chunkpos.toLong())) {
                this.level.tickChunk(levelchunk, j);
            }
        }

    }
}

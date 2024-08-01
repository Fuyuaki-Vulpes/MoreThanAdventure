package com.fuyuvulpes.morethanadventure.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.List;

public class OreVeinConfiguration implements FeatureConfiguration {
    public static final Codec<OreVeinConfiguration> CODEC = RecordCodecBuilder.create(
            p_67849_ -> p_67849_.group(
                            Codec.list(OreVeinConfiguration.TargetBlockState.CODEC).fieldOf("targets").forGetter(p_161027_ -> p_161027_.targetStates),
                            Codec.intRange(0, 64).fieldOf("length").forGetter(p_161025_ -> p_161025_.maxLenght),
                            BlockState.CODEC.fieldOf("block").forGetter(vein -> vein.oreBlock),
                            BlockState.CODEC.fieldOf("vein").forGetter(vein -> vein.veinBlock)
                    )
                    .apply(p_67849_, OreVeinConfiguration::new)
    );


    public final List<OreVeinConfiguration.TargetBlockState> targetStates;
    public final int maxLenght;
    public final BlockState oreBlock;
    public final BlockState veinBlock;

    public OreVeinConfiguration(List<TargetBlockState> targetStates, int maxLenght, BlockState oreBlock, BlockState veinBlock) {
        this.targetStates = targetStates;
        this.maxLenght = maxLenght;
        this.oreBlock = oreBlock;
        this.veinBlock = veinBlock;
    }


    public static class TargetBlockState {
        public static final Codec<OreVeinConfiguration.TargetBlockState> CODEC = RecordCodecBuilder.create(
                p_161039_ -> p_161039_.group(
                                RuleTest.CODEC.fieldOf("target").forGetter(p_161043_ -> p_161043_.target),
                                BlockState.CODEC.fieldOf("state").forGetter(p_161041_ -> p_161041_.state)
                        )
                        .apply(p_161039_, OreVeinConfiguration.TargetBlockState::new)
        );
        public final RuleTest target;
        public final BlockState state;

        TargetBlockState(RuleTest p_161036_, BlockState p_161037_) {
            this.target = p_161036_;
            this.state = p_161037_;
        }
    }

}

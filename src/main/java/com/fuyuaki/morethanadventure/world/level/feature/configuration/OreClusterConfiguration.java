package com.fuyuaki.morethanadventure.world.level.feature.configuration;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

public class OreClusterConfiguration implements FeatureConfiguration {
    public static final Codec<OreClusterConfiguration> CODEC = RecordCodecBuilder.create(
            p_67849_ -> p_67849_.group(
                            RuleTest.CODEC.fieldOf("targets").forGetter(p_161027_ -> p_161027_.targetStates),
                            Codec.intRange(0, 64).fieldOf("length").forGetter(p_161025_ -> p_161025_.maxLenght),
                            Codec.intRange(0, 64).fieldOf("min_branches").forGetter(p_161025_ -> p_161025_.minBranches),
                            Codec.intRange(0, 64).fieldOf("max_branches").forGetter(p_161025_ -> p_161025_.maxBranches),
                            Codec.intRange(0, 64).fieldOf("thickness").forGetter(p_161025_ -> p_161025_.thickness),
                            Codec.floatRange(0, 1).fieldOf("ore_chance").forGetter(p_161025_ -> p_161025_.oreChance),
                            BlockState.CODEC.fieldOf("block").forGetter(vein -> vein.oreBlock),
                            BlockState.CODEC.fieldOf("vein").forGetter(vein -> vein.veinBlock)
                    )
                    .apply(p_67849_, OreClusterConfiguration::new)
    );


    public final RuleTest targetStates;
    public final int maxLenght;
    public final int minBranches;
    public final int maxBranches;
    public final int thickness;
    public final float oreChance;
    public final BlockState oreBlock;
    public final BlockState veinBlock;

    public OreClusterConfiguration(RuleTest targetStates, int maxLenght, int minBranches, int maxBranches, int thickness, float oreChance, BlockState oreBlock, BlockState veinBlock) {
        this.targetStates = targetStates;
        this.maxLenght = maxLenght;
        this.minBranches = minBranches;
        this.maxBranches = maxBranches;
        this.thickness = thickness;
        this.oreChance = oreChance;
        this.oreBlock = oreBlock;
        this.veinBlock = veinBlock;
    }


    public static class TargetBlockState {
        public static final Codec<OreClusterConfiguration.TargetBlockState> CODEC = RecordCodecBuilder.create(
                p_161039_ -> p_161039_.group(
                                RuleTest.CODEC.fieldOf("target").forGetter(p_161043_ -> p_161043_.target),
                                BlockState.CODEC.fieldOf("state").forGetter(p_161041_ -> p_161041_.state)
                        )
                        .apply(p_161039_, OreClusterConfiguration.TargetBlockState::new)
        );
        public final RuleTest target;
        public final BlockState state;

        TargetBlockState(RuleTest p_161036_, BlockState p_161037_) {
            this.target = p_161036_;
            this.state = p_161037_;
        }
    }

}

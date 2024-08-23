package com.fuyuaki.morethanadventure.game.worldgen.biomes.surface;

import com.fuyuaki.morethanadventure.core.registry.MtaBlocks;
import com.fuyuaki.morethanadventure.core.registry.MtaTags;
import com.fuyuaki.morethanadventure.game.worldgen.biomes.MtaBiomes;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Noises;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.VerticalAnchor;

public class MtaSurfaceRules {

    private static final SurfaceRules.RuleSource AIR = makeStateRule(Blocks.AIR);
    private static final SurfaceRules.RuleSource BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final SurfaceRules.RuleSource LIGHT_BLUE_TERRACOTTA = makeStateRule(Blocks.LIGHT_BLUE_TERRACOTTA);
    private static final SurfaceRules.RuleSource CYAN_TERRACOTTA = makeStateRule(Blocks.CYAN_TERRACOTTA);
    private static final SurfaceRules.RuleSource LIGHT_GRAY_TERRACOTTA = makeStateRule(Blocks.LIGHT_GRAY_TERRACOTTA);
    private static final SurfaceRules.RuleSource TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final SurfaceRules.RuleSource STONE = makeStateRule(Blocks.STONE);
    private static final SurfaceRules.RuleSource DIRT = makeStateRule(Blocks.DIRT);
    private static final SurfaceRules.RuleSource PODZOL = makeStateRule(Blocks.PODZOL);
    private static final SurfaceRules.RuleSource GRASSY_DIRT = makeStateRule(MtaBlocks.GRASSY_DIRT.get());
    private static final SurfaceRules.RuleSource COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final SurfaceRules.RuleSource GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final SurfaceRules.RuleSource SAND = makeStateRule(Blocks.SAND);
    private static final SurfaceRules.RuleSource SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final SurfaceRules.RuleSource SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final SurfaceRules.RuleSource POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final SurfaceRules.RuleSource WATER = makeStateRule(Blocks.WATER);
    private static final SurfaceRules.RuleSource LAVA = makeStateRule(Blocks.LAVA);
    private static final SurfaceRules.RuleSource MAGMA = makeStateRule(Blocks.MAGMA_BLOCK);
    private static final SurfaceRules.RuleSource OBSIDIAN = makeStateRule(Blocks.OBSIDIAN);
    private static final SurfaceRules.RuleSource TUFF = makeStateRule(Blocks.TUFF);
    private static final SurfaceRules.RuleSource SMOOTH_BASALT = makeStateRule(Blocks.SMOOTH_BASALT);
    private static final SurfaceRules.RuleSource GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final SurfaceRules.RuleSource CALCITE = makeStateRule(Blocks.CALCITE);





    public static SurfaceRules.RuleSource makeOverworld() {

        SurfaceRules.ConditionSource isAtOrAboveWaterLevel = SurfaceRules.waterBlockCheck(-1, 0);
        SurfaceRules.ConditionSource sixBelowWater = SurfaceRules.waterStartCheck(-6, -1);
        SurfaceRules.RuleSource grassSurface = SurfaceRules.sequence(SurfaceRules.ifTrue(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        SurfaceRules.ConditionSource isTop5Blocks = SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0);
        SurfaceRules.ConditionSource isHole = SurfaceRules.hole();
        SurfaceRules.ConditionSource isSteep = SurfaceRules.steep();

        SurfaceRules.RuleSource powderedSnowSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, POWDER_SNOW),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, POWDER_SNOW)
        );

        SurfaceRules.RuleSource snowSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, SNOW_BLOCK),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, SNOW_BLOCK)
        );

        SurfaceRules.RuleSource gravelStoneSurface = SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, GRAVEL),
                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, STONE)
        );
        SurfaceRules.RuleSource sandstoneLinedSand = SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, SANDSTONE), SAND);

        return
                SurfaceRules.sequence(
                        //SURFACE
                        SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
                                SurfaceRules.ifTrue(
                                        sixBelowWater,
                                        SurfaceRules.sequence(
                                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR,
                                                        SurfaceRules.sequence(
                                                                SurfaceRules.ifTrue(SurfaceRules.isBiome(MtaBiomes.OASIS),
                                                                        SurfaceRules.sequence(
                                                                                SurfaceRules.ifTrue(
                                                                                        SurfaceRules.noiseCondition
                                                                                                (Noises.GRAVEL, -0.25D, 0.3D),
                                                                                        grassSurface),
                                                                                SAND
                                                                        ))

                                                        )
                                                ),
                                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR,
                                                        SurfaceRules.ifTrue(SurfaceRules.isBiome(MtaBiomes.OASIS),
                                                                SurfaceRules.sequence(

                                                                        SurfaceRules.ifTrue(
                                                                                SurfaceRules.noiseCondition
                                                                                        (Noises.GRAVEL, -0.1D, 0.1D),
                                                                                DIRT),
                                                                        sandstoneLinedSand
                                                                ))
                                                ),
                                                SurfaceRules.ifTrue(SurfaceRules.DEEP_UNDER_FLOOR,
                                                        SurfaceRules.ifTrue(SurfaceRules.isBiome(MtaBiomes.OASIS),
                                                                SurfaceRules.sequence(

                                                                        SurfaceRules.ifTrue(
                                                                                SurfaceRules.noiseCondition
                                                                                        (Noises.GRAVEL, -0.1D, 0.1D),
                                                                                STONE),
                                                                        SANDSTONE
                                                                ))
                                                ),


                                                SurfaceRules.ifTrue(SurfaceRules.isBiome(MtaBiomes.GRAVELLY_RIVER),
                                                        SurfaceRules.ifTrue(
                                                                SurfaceRules.noiseCondition
                                                                        (Noises.GRAVEL, -0.3D, 0.3D),
                                                                gravelStoneSurface)),

                                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, grassSurface)
                                        )
                                )
                        ),

                        //BELLOW SURFACE

                        SurfaceRules.ifTrue(SurfaceRules.isBiome(MtaBiomes.CRYSTALLINE_GROTTO),
                                SurfaceRules.sequence(
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, -0.04D, 0.0D),
                                                CALCITE),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, -0.23D, -0.2D),
                                                CALCITE),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, -0.8D, -0.68D),
                                                CALCITE),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, 0.45D, 0.77D),
                                                CALCITE),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, 0.82D, 0.85D),
                                                CALCITE),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, 0.95D, 1.0D),
                                                CALCITE),
                                        SurfaceRules.ifTrue(
                                                SurfaceRules.noiseCondition
                                                        (Noises.CALCITE, -0.5D, -0.45D),
                                                CALCITE)
                                )

                        )


                );
    }

    private static SurfaceRules.RuleSource makeStateRule(Block block)
    {
        return SurfaceRules.state(block.defaultBlockState());
    }


    private static SurfaceRules.ConditionSource surfaceNoiseAbove(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, p_194809_ / 8.25D, Double.MAX_VALUE);
    }
    private static SurfaceRules.ConditionSource surfaceNoiseBelow(double p_194809_) {
        return SurfaceRules.noiseCondition(Noises.SURFACE, Double.MIN_VALUE, p_194809_ / 8.25D);
    }



}

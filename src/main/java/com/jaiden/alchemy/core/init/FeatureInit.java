package com.jaiden.alchemy.core.init;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;

public class FeatureInit {

    public static void generateOres(final BiomeLoadingEvent event) {
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.SILVER_ORE.get().defaultBlockState(), 6, 32, 80, 5);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.TIN_ORE.get().defaultBlockState(), 8, 30, 100, 13);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.ZINC_ORE.get().defaultBlockState(), 9, 60, 120, 10);
        addOre(event, OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.COPPER_ORE.get().defaultBlockState(), 9, 50, 100, 10);
    }

    public static void addOre(final BiomeLoadingEvent event, RuleTest rule, BlockState state, int veinSize, int minHeight, int maxHeight, int amount) {
        event.getGeneration().addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(new OreFeatureConfig(rule, state, veinSize))
                        .decorated(Placement.RANGE.configured(new TopSolidRangeConfig(minHeight, 0, maxHeight)))
                        .squared().count(amount));
    }

}

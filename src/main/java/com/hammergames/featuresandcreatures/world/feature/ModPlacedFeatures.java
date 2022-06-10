package com.hammergames.featuresandcreatures.world.feature;

import net.minecraft.core.Holder;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class ModPlacedFeatures {
    public static final Holder<PlacedFeature> BLOOD_PLACED = PlacementUtils.register("blood_placed",
            ModConfiguredFeature.BLOOD_SPAWN, VegetationPlacements.treePlacement(
                    PlacementUtils.countExtra(5,0.5f,2)));

}

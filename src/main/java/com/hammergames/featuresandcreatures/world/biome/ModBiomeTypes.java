package com.hammergames.featuresandcreatures.world.biome;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomeTypes {
    public static final ResourceKey<Biome> HOT_RED = register("hot_red");

    public static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(FeaturesAndCreatures.MOD_ID, name));
    }
}

package com.hammergames.featuresandcreatures.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BLOODFRUIT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.POISON, 300, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 300, 0), 1f).build();
    public static final FoodProperties ROASTED_BLOODFRUIT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 160, 0), 1f).build();
    public static final FoodProperties BLOOD_WORM = (new FoodProperties.Builder()).nutrition(1).saturationMod(0F).fast().build();
    public static final FoodProperties BLOODY_STEW = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 0), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600, 0), 1f).build();
}

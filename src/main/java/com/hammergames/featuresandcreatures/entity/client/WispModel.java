package com.hammergames.featuresandcreatures.entity.client;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.entity.custom.WispEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WispModel extends AnimatedGeoModel<WispEntity> {
    @Override
    public ResourceLocation getModelLocation(WispEntity object) {
        return new ResourceLocation(FeaturesAndCreatures.MOD_ID, "geo/wisp.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(WispEntity object) {
        return new ResourceLocation(FeaturesAndCreatures.MOD_ID,"textures/entity/wisp/wisp.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(WispEntity animatable) {
        return new ResourceLocation(FeaturesAndCreatures.MOD_ID,"animations/wisp.animation/json");
    }
}

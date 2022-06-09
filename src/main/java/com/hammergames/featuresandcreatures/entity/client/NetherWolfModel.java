package com.hammergames.featuresandcreatures.entity.client;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.entity.custom.NetherWolfEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class NetherWolfModel extends AnimatedGeoModel<NetherWolfEntity> {
    @Override
    public ResourceLocation getModelLocation(NetherWolfEntity object) {

        return new ResourceLocation(FeaturesAndCreatures.MOD_ID, "geo/nether_wolf.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(NetherWolfEntity object) {
        return new ResourceLocation(FeaturesAndCreatures.MOD_ID,"textures/entity/nether_wolf/nether_wolf.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(NetherWolfEntity animatable) {
        return new ResourceLocation(FeaturesAndCreatures.MOD_ID,"animations/nether_wolf.animation/json");
    }
}

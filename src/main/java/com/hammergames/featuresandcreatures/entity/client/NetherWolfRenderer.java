package com.hammergames.featuresandcreatures.entity.client;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.entity.custom.NetherWolfEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class NetherWolfRenderer extends GeoEntityRenderer<NetherWolfEntity> {
    public NetherWolfRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new NetherWolfModel());
        this.shadowRadius = 0.8f;
    }

    @Override
    public ResourceLocation getTextureLocation(NetherWolfEntity instance) {
        return new ResourceLocation(FeaturesAndCreatures.MOD_ID, "textures/entity/nether_wolf/nether_wolf.png");
    }

    @Override
    public RenderType getRenderType(NetherWolfEntity animatable, float partialTicks, PoseStack stack, MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        stack.scale(1f, 1f, 1f);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}

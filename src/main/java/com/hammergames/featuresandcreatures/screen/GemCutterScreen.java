package com.hammergames.featuresandcreatures.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class GemCutterScreen extends AbstractContainerScreen<GemCutterMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(FeaturesAndCreatures.MOD_ID, "textures/gui/gem_cutter_gui.png");

    public GemCutterScreen(GemCutterMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTicks, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        //GUI ANIMATIONS
        if(menu.isCrafting()) {
            if(menu.getScaledPaperProgress() <= 56)
            {
                blit(pPoseStack, x + 33, y + 31, 176, 35, menu.getScaledPaperProgress(), 14);
            } else {
                blit(pPoseStack, x + 33, y + 31, 176, 35, 56, 14);
                blit(pPoseStack, x + 89, y + 29, 176, 49, menu.getScaledPaperProgress() - 56, 18);
            }
            //blit(pPoseStack, x + 89, y + 29, 176, 49, 37, 18);

            blit(pPoseStack, x + 149, y + 30, 207, 7, menu.getScaledProgress(), 16);

        }

        if(menu.hasFuel()) {
            if(menu.getScaledFuelProgress() <= 74){
                blit(pPoseStack, x + 50, y + 60, 176, 23, menu.getScaledFuelProgress(), 5);
            } else {
                blit(pPoseStack, x + 50, y + 60, 176, 23, 74, 5);
                blit(pPoseStack, x + 124, y + 59, 176, 28, menu.getScaledFuelProgress() - 74, 6);
            }


        }
    }

    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
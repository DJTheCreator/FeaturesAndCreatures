package com.hammergames.featuresandcreatures;

import com.hammergames.featuresandcreatures.block.ModBlocks;
import com.hammergames.featuresandcreatures.entity.ModEntityTypes;
import com.hammergames.featuresandcreatures.entity.client.NetherWolfRenderer;
import com.hammergames.featuresandcreatures.entity.client.WispRenderer;
import com.hammergames.featuresandcreatures.item.ModItems;
import com.hammergames.featuresandcreatures.util.ModTags;
import com.hammergames.featuresandcreatures.world.biome.ModRegion;
import com.hammergames.featuresandcreatures.world.biome.ModSurfaceRuleData;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(FeaturesAndCreatures.MOD_ID)
public class FeaturesAndCreatures
{
    public static final String MOD_ID = "featuresandcreatures";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public FeaturesAndCreatures() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register((eventBus));

        ModTags.register();

        ModEntityTypes.register(eventBus);

        GeckoLib.initialize();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        eventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.DREAM_DOOR.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_BRAMBLES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EYE_FAN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_EYES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_SPROUTS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_SPROUTS_TALL.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLOOD_WORM.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GEM_CUTTER.get(), RenderType.cutout());


        EntityRenderers.register(ModEntityTypes.WISP.get(), WispRenderer::new);
        EntityRenderers.register(ModEntityTypes.NETHER_WOLF.get(), NetherWolfRenderer::new);

    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() ->
        {
            Regions.register(new ModRegion(new ResourceLocation(MOD_ID, "overworld"), 100));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, ModSurfaceRuleData.makeRules());
        });
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}

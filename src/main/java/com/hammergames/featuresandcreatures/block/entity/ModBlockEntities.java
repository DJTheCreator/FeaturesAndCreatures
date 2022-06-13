package com.hammergames.featuresandcreatures.block.entity;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, FeaturesAndCreatures.MOD_ID);

    public static final RegistryObject<BlockEntityType<GemCutterBlockEntity>> GEM_CUTTER = BLOCK_ENTITIES.register("gem_cutter", () ->
            BlockEntityType.Builder.of(GemCutterBlockEntity::new, ModBlocks.GEM_CUTTER.get()).build(null));

    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}

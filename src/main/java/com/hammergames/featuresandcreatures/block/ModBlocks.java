package com.hammergames.featuresandcreatures.block;

import com.hammergames.featuresandcreatures.FeaturesAndCreatures;
import com.hammergames.featuresandcreatures.block.custom.ModHurtCarpetBlock;
import com.hammergames.featuresandcreatures.block.custom.ModNetherrackSaplingBlock;
import com.hammergames.featuresandcreatures.block.custom.ModUnflammableRotatedPillarBlock;
import com.hammergames.featuresandcreatures.item.ModCreativeModeTab;
import com.hammergames.featuresandcreatures.item.ModItems;
import com.hammergames.featuresandcreatures.world.feature.tree.BloodTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, FeaturesAndCreatures.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)), ModCreativeModeTab.FEATURESANDCREATURES);

    //Dream Dimension
    public static final RegistryObject<Block> DREAM_PLANKS = registerBlock("dream_planks", () ->
            new Block(BlockBehaviour.Properties.of(Material.WOOD).strength(2f).sound(SoundType.WOOD)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_GRASS_BLOCK = registerBlock("dream_grass_block", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1.5f).sound(SoundType.STONE)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_ROCK = registerBlock("dream_rock", () ->
            new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2f).sound(SoundType.STONE)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> DREAM_DOOR = registerBlock("dream_door", () ->
            new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD).strength(2.0f).sound(SoundType.WOOD)), ModCreativeModeTab.FEATURESANDCREATURES);


    //Blood Biome
    public static final RegistryObject<Block> BLOOD_LOG = registerBlock("blood_log", () ->
            new ModUnflammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> STRIPPED_BLOOD_LOG = registerBlock("stripped_blood_log", () ->
            new ModUnflammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> FLESH_BLOCK = registerBlock("flesh_block", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.HONEY_BLOCK)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_LEAVES = registerBlock("blood_leaves", () ->
            new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES).sound(SoundType.SWEET_BERRY_BUSH)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {return false;}}, ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_SAPLING = registerBlock("blood_sapling", () ->
            new ModNetherrackSaplingBlock(new BloodTreeGrower(),BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_BRAMBLES = registerBlock("blood_brambles", () ->
            new ModHurtCarpetBlock(BlockBehaviour.Properties.of(Material.STONE).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> EYE_FAN = registerBlock("eye_fan", () ->
            new Block(BlockBehaviour.Properties.copy(Blocks.GRASS).sound(SoundType.SWEET_BERRY_BUSH)), ModCreativeModeTab.FEATURESANDCREATURES);
    public static final RegistryObject<Block> BLOOD_WORM = registerBlock("blood_worm", () ->
            new SeaPickleBlock(BlockBehaviour.Properties.copy(Blocks.SEA_PICKLE).sound(SoundType.HONEY_BLOCK)), ModCreativeModeTab.FEATURESANDCREATURES);




    //These methods create an item for the blocks automatically
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
    {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab)
    {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

package com.hammergames.featuresandcreatures.block.custom;

import com.hammergames.featuresandcreatures.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;

public class ModUnflammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModUnflammableRotatedPillarBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return false;
    }

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, Level world, BlockPos pos, Player player, ItemStack stack, ToolAction toolAction) {
        if(stack.getItem() instanceof AxeItem) {
            if(state.is(ModBlocks.BLOOD_LOG.get())) {
                return ModBlocks.STRIPPED_BLOOD_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, world, pos, player, stack, toolAction);
    }
}

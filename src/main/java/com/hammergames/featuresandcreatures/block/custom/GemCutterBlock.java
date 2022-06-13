package com.hammergames.featuresandcreatures.block.custom;

import com.hammergames.featuresandcreatures.block.entity.GemCutterBlockEntity;
import com.hammergames.featuresandcreatures.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class GemCutterBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public GemCutterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
    }

    private static final VoxelShape SHAPE_N = Stream.of(
            Block.box(0, 0, 0, 16, 14, 16),
            Block.box(1, 14, 8, 2, 18, 15),
            Block.box(14, 14, 8, 15, 18, 15),
            Block.box(2, 14, 14, 6, 18, 15),
            Block.box(10, 14, 14, 14, 18, 15),
            Block.box(6.5, 14, 13, 9.5, 16, 16),
            Block.box(6.5, 16, 13, 9.5, 17, 16),
            Block.box(7.5, 17, 14, 8.5, 18, 15),
            Block.box(6.5, 18.1, 13, 9.5, 18.1, 16),
            Block.box(6.5, 16, 13, 9.5, 16, 16),
            Block.box(14, 15, 6, 15, 18, 7),
            Block.box(9, 14, 15, 16, 15, 15.9),
            Block.box(15, 14, 6, 16, 15, 15),
            Block.box(4, 15.5, 2.5, 12, 15.5, 10.5),
            Block.box(6.5, 14, 5, 9.5, 15, 8),
            Block.box(7.5, 15, 6, 8.5, 16, 7)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_W = Stream.of(
            Block.box(0, 0, 0, 16, 14, 16),
            Block.box(8, 14, 14, 15, 18, 15),
            Block.box(8, 14, 1, 15, 18, 2),
            Block.box(14, 14, 10, 15, 18, 14),
            Block.box(14, 14, 2, 15, 18, 6),
            Block.box(13, 14, 6.5, 16, 16, 9.5),
            Block.box(13, 16, 6.5, 16, 17, 9.5),
            Block.box(14, 17, 7.5, 15, 18, 8.5),
            Block.box(13, 18.1, 6.5, 16, 18.1, 9.5),
            Block.box(13, 16, 6.5, 16, 16, 9.5),
            Block.box(6, 15, 1, 7, 18, 2),
            Block.box(15, 14, 0, 15.9, 15, 7),
            Block.box(6, 14, 0, 15, 15, 1),
            Block.box(2.5, 15.5, 4, 10.5, 15.5, 12),
            Block.box(5, 14, 6.5, 8, 15, 9.5),
            Block.box(6, 15, 7.5, 7, 16, 8.5)
            ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_S = Stream.of(
            Block.box(0, 0, 0, 16, 14, 16),
            Block.box(14, 14, 1, 15, 18, 8),
            Block.box(1, 14, 1, 2, 18, 8),
            Block.box(10, 14, 1, 14, 18, 2),
            Block.box(2, 14, 1, 6, 18, 2),
            Block.box(6.5, 14, 0, 9.5, 16, 3),
            Block.box(6.5, 16, 0, 9.5, 17, 3),
            Block.box(7.5, 17, 1, 8.5, 18, 2),
            Block.box(6.5, 18.1, 0, 9.5, 18.1, 3),
            Block.box(6.5, 16, 0, 9.5, 16, 3),
            Block.box(1, 15, 9, 2., 18, 10),
            Block.box(0, 14, 0, 7, 15, 1),
            Block.box(0, 14, 1, 1, 15, 10),
            Block.box(4, 15.5, 5.5, 12, 15.5, 13.5),
            Block.box(6.5, 14, 8, 9.5, 15, 11),
            Block.box(7.5, 15, 9, 8.5, 16, 10)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    private static final VoxelShape SHAPE_E = Stream.of(
            Block.box(0, 0, 0, 16, 14, 16),
            Block.box(1, 14, 1, 8, 18, 2),
            Block.box(1, 14, 14, 8, 18, 15),
            Block.box(1, 14, 2, 2, 18, 6),
            Block.box(1, 14, 10, 2, 18, 14),
            Block.box(0, 14, 6.5, 3, 16, 9.5),
            Block.box(0, 16, 6.5, 3, 17, 9.5),
            Block.box(1, 17, 7.5, 2, 18, 8.5),
            Block.box(0, 18.1, 6.5, 3, 18.1, 9.5),
            Block.box(0, 16, 6.5, 3, 16, 9.5),
            Block.box(9, 15, 14, 10, 18, 15),
            Block.box(0, 14, 9, 1, 15, 16),
            Block.box(1, 14, 15, 10, 15, 16),
            Block.box(5.5, 15.5, 4, 13.5, 15.5, 12),
            Block.box(8, 14, 6.5, 11, 15, 9.5),
            Block.box(9, 15, 7.5, 10, 16, 8.5)
    ).reduce((v1, v2) -> Shapes.join(v1, v2, BooleanOp.OR)).get();

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        switch(pState.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case WEST:
                return SHAPE_W;
            case EAST:
                return SHAPE_E;
            case SOUTH:
                return SHAPE_S;
            default:
                return SHAPE_N;
        }
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if(pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if(blockEntity instanceof GemCutterBlockEntity) {
                ((GemCutterBlockEntity) blockEntity).drops();
            }
        }
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof GemCutterBlockEntity) {
                NetworkHooks.openGui(((ServerPlayer)pPlayer), (GemCutterBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new GemCutterBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState, BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.GEM_CUTTER.get(), GemCutterBlockEntity::tick);
    }
}

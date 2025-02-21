package com.fuyuaki.morethanadventure.world.block;

import com.fuyuaki.morethanadventure.core.deferred_registries.MtaSounds;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.neoforge.common.Tags;

public class CactusShrubBlock extends BushBlock implements BonemealableBlock{
    public static final BooleanProperty SPIKY = BooleanProperty.create("spiky");

    public static final MapCodec<CactusShrubBlock> CODEC = simpleCodec(CactusShrubBlock::new);
    protected static final float AABB_OFFSET = 6.0F;
    protected static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);


    public CactusShrubBlock(Properties p_57318_) {
        super(p_57318_);
        this.registerDefaultState(this.stateDefinition.any().setValue(SPIKY, true));

    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return CODEC;
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SPIKY);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (stack.canPerformAction(ItemAbilities.SHEARS_HARVEST)){
            level.setBlock(pos,state.setValue(SPIKY,false),3);
            level.playSound(player, pos.getX(), pos.getY(), pos.getZ(), MtaSounds.PRICKLY_PEAR_SHEAR.get(), SoundSource.BLOCKS, 1.0F, 1.0F);
            level.gameEvent(player, GameEvent.SHEAR, pos);

            player.swing(hand);
            stack.hurtAndBreak(1,player, LivingEntity.getSlotForHand(hand));
            return InteractionResult.SUCCESS;
        }
        return super.useItemOn(stack, state, level, pos, player, hand, hitResult);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_255692_, BlockPos p_57326_, BlockState p_57327_) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_222583_, RandomSource p_222584_, BlockPos p_222585_, BlockState p_222586_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource p_222579_, BlockPos pos, BlockState p_222581_) {
        popResource(level, pos, new ItemStack(this));

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(BlockTags.DIRT) || state.getBlock() instanceof net.minecraft.world.level.block.FarmBlock || state.is(BlockTags.SAND);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof LivingEntity && entity.getType() != EntityType.FOX && entity.getType() != EntityType.BEE && entity.getType() != EntityType.CAMEL) {
            entity.makeStuckInBlock(state, new Vec3(0.8F, 0.75, 0.8F));
            if (level instanceof ServerLevel serverlevel) {
                Vec3 vec3 = entity.isControlledByClient() ? entity.getKnownMovement() : entity.oldPosition().subtract(entity.position());
                if (vec3.horizontalDistanceSqr() > 0.0) {
                    double d0 = Math.abs(vec3.x());
                    double d1 = Math.abs(vec3.z());
                    if (d0 >= 0.003F || d1 >= 0.003F) {
                        entity.hurtServer(serverlevel, level.damageSources().cactus(), 1.0F);
                    }
                }

                return;
            }
        }
    }

}

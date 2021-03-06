package com.dbydd.suuuuuper_herbal_tea.blocks;

import com.dbydd.suuuuuper_herbal_tea.blocks.tileentitys.TileSink;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;

import javax.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public class BlockSink extends BlockBase {
    public BlockSink() {
        super(Properties.create(Material.ROCK).notSolid().hardnessAndResistance(3).lightValue(1));
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        if (!worldIn.isRemote()) {
            if (handIn == Hand.MAIN_HAND) {
                ItemStack heldItem = player.getHeldItem(handIn);
                LazyOptional<IFluidHandlerItem> capability = heldItem.getCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY);
                capability.ifPresent(iFluidHandlerItem -> {
                    boolean isempty = true;
                    int tanks = iFluidHandlerItem.getTanks();
                    for (int i = 0; i < tanks; i++) {
                        isempty = iFluidHandlerItem.getFluidInTank(i).isEmpty();
                    }

                    if (isempty) {
                        iFluidHandlerItem.fill(new FluidStack(Fluids.WATER, Integer.MAX_VALUE), IFluidHandler.FluidAction.EXECUTE);
                        player.playSound(SoundEvents.ITEM_BUCKET_FILL, SoundCategory.BLOCKS, 1, 1);
                    } else {
                        iFluidHandlerItem.drain(Integer.MAX_VALUE, IFluidHandler.FluidAction.EXECUTE);
                        player.playSound(SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1, 1);
                    }
                    player.setHeldItem(handIn, iFluidHandlerItem.getContainer());
                });
            }
        }
        return ActionResultType.SUCCESS;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new TileSink();
    }
}

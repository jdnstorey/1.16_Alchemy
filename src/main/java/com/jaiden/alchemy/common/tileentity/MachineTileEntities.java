package com.jaiden.alchemy.common.tileentity;

import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;

public abstract class MachineTileEntities extends TileEntity implements ITickableTileEntity {
    public final LazyOptional<IItemHandlerModifiable> INVENTORY = LazyOptional.of(this::createInventory);

    public MachineTileEntities(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public abstract IItemHandlerModifiable createInventory();

    @Override
    public void tick() {

    }
}
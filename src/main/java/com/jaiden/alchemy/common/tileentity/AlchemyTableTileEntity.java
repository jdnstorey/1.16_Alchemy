package com.jaiden.alchemy.common.tileentity;

import com.jaiden.alchemy.core.init.ItemInit;
import com.jaiden.alchemy.core.init.TileEntityTypesInit;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AlchemyTableTileEntity extends TileEntity {

    private final LazyOptional<IItemHandlerModifiable> inventory = LazyOptional.of(this::createInventory);

    public AlchemyTableTileEntity() {
        super(TileEntityTypesInit.ALCHEMY_TABLE_TILE_ENTITY.get());
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(Direction.Plane.HORIZONTAL.test(side) && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return inventory.cast();
        } else {
            return super.getCapability(cap, side);
        }
    }

    public IItemHandlerModifiable getInventory() {
        return inventory.orElseThrow(() -> new IllegalStateException("Inventory not created properly"));
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.put("inventory", ((ItemStackHandler) getInventory()).serializeNBT());
        return compound;
    }

    @Nonnull
    @Override
    public void load(BlockState blockstate, CompoundNBT compound) {
        super.load(blockstate, compound);
        ((ItemStackHandler) getInventory()).deserializeNBT((CompoundNBT) compound.get("inventory"));
        this.setChanged();
    }

    @Nonnull
    public IItemHandlerModifiable createInventory() {
        return new ItemStackHandler(4){
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot == 2) {
                    return stack.getItem() == Items.COAL;
                } else {
                    return false;
                }
            }
        };
    }

}

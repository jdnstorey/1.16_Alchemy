package com.jaiden.alchemy.common.tileentity;

import com.jaiden.alchemy.core.init.ItemInit;
import com.jaiden.alchemy.core.init.TileEntityTypesInit;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
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

public class QuarryTileEntity extends TileEntity {

    public final LazyOptional<IItemHandlerModifiable> INVENTORY = LazyOptional.of(this::createInventory);

    public QuarryTileEntity() {
        super(TileEntityTypesInit.QUARRY_TILE_ENTITY_TYPE.get());
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nonnull Direction side) {
        if(Direction.Plane.HORIZONTAL.test(side) && cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY){
            return INVENTORY.cast();
        } else {
            return super.getCapability(cap, side);
        }
    }

    public IItemHandlerModifiable getInventory() {
        return INVENTORY.orElseThrow(() -> new IllegalStateException("Inventory not created properly"));
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.put("inventory", ((ItemStackHandler) getInventory()).serializeNBT());
        return compound;
    }


    public void load(BlockState blockstate, CompoundNBT compound) {
        super.load(blockstate, compound);
        ((ItemStackHandler) getInventory()).deserializeNBT((CompoundNBT) compound.get("inventory"));
        this.setChanged();
    }

    public @NotNull IItemHandlerModifiable createInventory() {
        return new ItemStackHandler(18){
            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                if (slot < 12) {
                    return stack.getItem() == ItemInit.SILVER_BLOCK.get();
                } else {
                    return false;
                }
            }
        };
    }
}

package com.jaiden.alchemy.common.container;

import com.jaiden.alchemy.common.tileentity.AlchemyTableTileEntity;
import com.jaiden.alchemy.core.init.BlockInit;
import com.jaiden.alchemy.core.init.ContainerTypesInit;
import com.jaiden.alchemy.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class AlchemyTableContainer extends Container {

    public static final TranslationTextComponent title = new TranslationTextComponent("container.alchemy_table");

    public static AlchemyTableContainer getClientContainer(int id, PlayerInventory playerInventory, PacketBuffer buffer) {
        return new AlchemyTableContainer(id, new InvWrapper(playerInventory), new ItemStackHandler(4), playerInventory.player, BlockPos.ZERO);
    }
    public static IContainerProvider getServerContainerProvider(AlchemyTableTileEntity te, BlockPos activationPos){
        return (id, playerInventory, serverPlayer) -> new AlchemyTableContainer(id, new InvWrapper(playerInventory), te.getInventory(), playerInventory.player, activationPos);
    }

    private final IWorldPosCallable worldPosCallable;

    protected AlchemyTableContainer(int id, IItemHandlerModifiable playerInventory, IItemHandlerModifiable storageInventory,
                              PlayerEntity player, BlockPos pos) {
        super(ContainerTypesInit.ALCHEMY_TABLE_CONTAINER_TYPE.get(), id);
        worldPosCallable = IWorldPosCallable.create(player.level, pos);

        //player inventory
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new SlotItemHandler(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        //hotbar
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new SlotItemHandler(playerInventory, i, 8 + i * 18, 142));
        }

        //storage inventory
        for (int k = 0; k < 4; ++k) {
            //for(int j = 0; j < 2; ++j){}
            // fuel slot
            if (k == 0) {
                this.addSlot(new FuelSlot(storageInventory, k, 17, 47));
            } else {
                this.addSlot(new SlotItemHandler(storageInventory, 1, 71, 18));
                this.addSlot(new SlotItemHandler(storageInventory, 2, 71, 47));
                this.addSlot(new OutputSlot(storageInventory, 3, 116, 33));
            }
        }
    }

    //this is how to make a fuel slot
    public static class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return stack.getItem() == ItemInit.FUEL_CELL_FULL.get() || stack.getItem() == ItemInit.FUEL_CELL_EMPTY.get();
        }
    }

    //output slot
    public static class OutputSlot extends SlotItemHandler {
        public OutputSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }

        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return false;
        }
    }



    @Override
    public boolean stillValid(PlayerEntity player) {
        return stillValid(worldPosCallable, player, BlockInit.ALCHEMY_TABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index){
        if(index >= 36){
            moveItemStackTo(this.getItems().get(index), 0, 35, false);
        } else {
            moveItemStackTo(this.getItems().get(index), 36, 40, false);
        }
        return ItemStack.EMPTY;
    }

}

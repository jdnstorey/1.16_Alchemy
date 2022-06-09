package com.jaiden.alchemy.common.container;

import com.jaiden.alchemy.common.tileentity.QuarryTileEntity;
import com.jaiden.alchemy.core.init.BlockInit;
import com.jaiden.alchemy.core.init.ContainerTypesInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

public class QuarryContainer extends Container {

    public static final TranslationTextComponent title = new TranslationTextComponent("container.quarry");

    public static QuarryContainer getClientContainer(int id, PlayerInventory playerInventory, PacketBuffer buffer) {
        return new QuarryContainer(id, new InvWrapper(playerInventory), new ItemStackHandler(18), playerInventory.player, BlockPos.ZERO);
    }
    public static IContainerProvider getServerContainerProvider(QuarryTileEntity te, BlockPos activationPos){
        return (id, playerInventory, serverPlayer) -> new QuarryContainer(id, new InvWrapper(playerInventory), te.getHandler(), playerInventory.player, activationPos);
    }

    private final IWorldPosCallable worldPosCallable;

    public QuarryContainer(int id, IItemHandlerModifiable playerInventory, IItemHandlerModifiable storageInventory,
                              PlayerEntity player, BlockPos pos) {
        super(ContainerTypesInit.QUARRY_CONTAINER_TYPE.get(), id);
        worldPosCallable = IWorldPosCallable.create(player.level, pos);

        //player inventory
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 9; j++){
                this.addSlot(new SlotItemHandler(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }
        //hotbar
        for(int i = 0; i < 9; i++){
            this.addSlot(new SlotItemHandler(playerInventory, i, 8 + i * 18, 142));
        }

        //storage inventory
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 9; j++){
                this.addSlot(new SlotItemHandler(storageInventory, j + i * 9 + 9, 8 + j * 18, 23 + i * 18));

                /* fuel slot
                this.addSlot(new FuelSlot(storageInventory, i, 9=(i/3)*18, 18 + (i%3)*18));
                 */
            }
        }
    }

    //this is how to make a fuel slot
    /*
    public static class FuelSlot extends SlotItemHandler {
        public FuelSlot(IItemHandler itemHandler, int index, int xPosition, int yPosition) {
            super(itemHandler, index, xPosition, yPosition);
        }
        @Override
        public boolean mayPlace(@Nonnull ItemStack stack) {
            return stack.getItem() == ItemInit.FUEL.get();
        }
     }
     */

    @Override
    public boolean stillValid(@NotNull PlayerEntity player) {
        return stillValid(worldPosCallable, player, BlockInit.QUARRY.get());
    }

    @Override
    public ItemStack quickMoveStack(PlayerEntity player, int index){
        if(index >= 36){
            moveItemStackTo(this.getItems().get(index), 0, 35, false);
        } else {
            moveItemStackTo(this.getItems().get(index), 36, 36 + 18, false);
        }
        return ItemStack.EMPTY;
    }

}

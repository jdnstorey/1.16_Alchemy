package com.jaiden.alchemy.core.itemgroup;

import com.jaiden.alchemy.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class AlchemyItemGroup extends ItemGroup {

    public static final AlchemyItemGroup ALCHEMY_TAB = new AlchemyItemGroup(ItemGroup.TABS.length, "alchemy_tab");

    public AlchemyItemGroup(int index, String label) { super(index, label); }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.SILVER_BAR.get());
    }
}

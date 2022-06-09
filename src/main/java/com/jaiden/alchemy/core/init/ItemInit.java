package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;
import com.jaiden.alchemy.common.block.QuarryBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.jaiden.alchemy.core.itemgroup.AlchemyItemGroup.ALCHEMY_TAB;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Alchemy.MODID);

    // silver
    public static final RegistryObject<Item> SILVER_BAR = ITEMS.register("silver_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> SILVER_ORE = ITEMS.register("silver_ore",
            () -> new BlockItem(BlockInit.SILVER_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> SILVER_BLOCK = ITEMS.register("silver_block",
            () -> new BlockItem(BlockInit.SILVER_BLOCK.get(),
                    new Item.Properties().tab(ALCHEMY_TAB)));


    //tin
    public static final RegistryObject<Item> TIN_BAR = ITEMS.register("tin_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<Item> TIN_LUMP = ITEMS.register("tin_lump",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> TIN_ORE = ITEMS.register("tin_ore",
            () -> new BlockItem(BlockInit.TIN_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_TAB)));

    //quarry
    public static final RegistryObject<BlockItem> QUARRY = ITEMS.register("quarry",
            () -> new BlockItem(BlockInit.QUARRY.get(),
                    new Item.Properties().tab(ALCHEMY_TAB)));
}

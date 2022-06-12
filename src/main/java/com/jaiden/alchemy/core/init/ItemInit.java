package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.jaiden.alchemy.core.itemgroup.AlchemyItemGroup.ALCHEMY_BLOCKS;
import static com.jaiden.alchemy.core.itemgroup.AlchemyItemGroup.ALCHEMY_TAB;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Alchemy.MODID);

    // silver
    public static final RegistryObject<Item> SILVER_BAR = ITEMS.register("silver_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> SILVER_ORE = ITEMS.register("silver_ore",
            () -> new BlockItem(BlockInit.SILVER_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //tin
    public static final RegistryObject<Item> TIN_BAR = ITEMS.register("tin_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> TIN_ORE = ITEMS.register("tin_ore",
            () -> new BlockItem(BlockInit.TIN_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //copper
    public static final RegistryObject<Item> COPPER_BAR = ITEMS.register("copper_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> COPPER_ORE = ITEMS.register("copper_ore",
            () -> new BlockItem(BlockInit.COPPER_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //zinc
    public static final RegistryObject<Item> ZINC_BAR = ITEMS.register("zinc_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> ZINC_ORE = ITEMS.register("zinc_ore",
            () -> new BlockItem(BlockInit.ZINC_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //lead
    public static final RegistryObject<Item> LEAD_BAR = ITEMS.register("lead_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> LEAD_ORE = ITEMS.register("lead_ore",
            () -> new BlockItem(BlockInit.LEAD_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //nickel
    public static final RegistryObject<Item> NICKEL_BAR = ITEMS.register("nickel_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> NICKEL_ORE = ITEMS.register("nickel_ore",
            () -> new BlockItem(BlockInit.NICKEL_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //titanium
    public static final RegistryObject<Item> TITANIUM_BAR = ITEMS.register("titanium_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> TITANIUM_ORE = ITEMS.register("titanium_ore",
            () -> new BlockItem(BlockInit.TITANIUM_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //aluminium
    public static final RegistryObject<Item> ALUMINIUM_BAR = ITEMS.register("aluminium_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> ALUMINIUM_ORE = ITEMS.register("aluminium_ore",
            () -> new BlockItem(BlockInit.ALUMINIUM_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));

    //platinum
    public static final RegistryObject<Item> PLATINUM_BAR = ITEMS.register("platinum_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<BlockItem> PLATINUM_ORE = ITEMS.register("platinum_ore",
            () -> new BlockItem(BlockInit.PLATINUM_ORE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));



    // ----------------- ALLOYS ------------------
    //steel
    public static final RegistryObject<Item> STEEL_BAR = ITEMS.register("steel_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));

    //bronze
    public static final RegistryObject<Item> BRONZE_BAR = ITEMS.register("bronze_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));

    //brass
    public static final RegistryObject<Item> BRASS_BAR = ITEMS.register("brass_bar",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));



    // ----------------- ITEMS -----------------

    // ----------------- ENERGY -----------------
    // fuel
    public static final RegistryObject<Item> FUEL_CELL_EMPTY = ITEMS.register("fuel_cell_empty",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));
    public static final RegistryObject<Item> FUEL_CELL_FULL = ITEMS.register("fuel_cell_full",
            () -> new Item(new Item.Properties().tab(ALCHEMY_TAB)));





    //alchemy table
    public static final RegistryObject<BlockItem> ALCHEMY_TABLE = ITEMS.register("alchemy_table",
            () -> new BlockItem(BlockInit.ALCHEMY_TABLE.get(),
                    new Item.Properties().tab(ALCHEMY_BLOCKS)));
}

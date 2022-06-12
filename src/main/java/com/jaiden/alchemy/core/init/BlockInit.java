package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;

import com.jaiden.alchemy.common.block.AlchemyTable;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Alchemy.MODID);
    public static final AbstractBlock.Properties ORE_PROPERTIES = AbstractBlock.Properties.of(Material.METAL).strength(2f);

    //silver
    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    //tin
    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE)));

    //copper
    public static final RegistryObject<Block> COPPER_ORE = BLOCKS.register("copper_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE)));

    //zinc
    public static final RegistryObject<Block> ZINC_ORE = BLOCKS.register("zinc_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE)));

    //lead
    public static final RegistryObject<Block> LEAD_ORE = BLOCKS.register("lead_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    //nickel
    public static final RegistryObject<Block> NICKEL_ORE = BLOCKS.register("nickel_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));

    //titanium
    public static final RegistryObject<Block> TITANIUM_ORE = BLOCKS.register("titanium_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(5).sound(SoundType.STONE)));

    //aluminium
    public static final RegistryObject<Block> ALUMINIUM_ORE = BLOCKS.register("aluminium_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(3).sound(SoundType.STONE)));

    //platinum
    public static final RegistryObject<Block> PLATINUM_ORE = BLOCKS.register("platinum_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(4).sound(SoundType.STONE)));


    public static final RegistryObject<AlchemyTable> ALCHEMY_TABLE = BLOCKS.register("alchemy_table", AlchemyTable::new);
}



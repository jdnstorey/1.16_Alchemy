package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;

import com.jaiden.alchemy.common.block.QuarryBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Alchemy.MODID);
    public static final AbstractBlock.Properties ORE_PROPERTIES = AbstractBlock.Properties.of(Material.METAL).strength(2f);

    public static final RegistryObject<Block> SILVER_ORE = BLOCKS.register("silver_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(2).sound(SoundType.STONE)));
    public static final RegistryObject<Block> SILVER_BLOCK = BLOCKS.register("silver_block", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(2)));

    public static final RegistryObject<Block> TIN_ORE = BLOCKS.register("tin_ore", () -> new Block(
            ORE_PROPERTIES.harvestTool(ToolType.PICKAXE).harvestLevel(1).sound(SoundType.STONE)));

    public static final RegistryObject<QuarryBlock> QUARRY = BLOCKS.register("quarry", QuarryBlock::new);
}



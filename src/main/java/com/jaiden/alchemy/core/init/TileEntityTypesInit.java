package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;
import com.jaiden.alchemy.common.tileentity.AlchemyTableTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Alchemy.MODID);


    public static final RegistryObject<TileEntityType<AlchemyTableTileEntity>> ALCHEMY_TABLE_TILE_ENTITY = TILE_ENTITY_TYPE.register(
            "alchemy_table", () -> TileEntityType.Builder.of(AlchemyTableTileEntity::new, BlockInit.ALCHEMY_TABLE.get()).build(null));

}

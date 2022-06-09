package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;
import com.jaiden.alchemy.common.tileentity.QuarryTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypesInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPE =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Alchemy.MODID);

    public static final RegistryObject<TileEntityType<QuarryTileEntity>> QUARRY_TILE_ENTITY_TYPE = TILE_ENTITY_TYPE.register(
            "quarry", () -> TileEntityType.Builder.of(QuarryTileEntity::new, BlockInit.QUARRY.get()).build(null));

}

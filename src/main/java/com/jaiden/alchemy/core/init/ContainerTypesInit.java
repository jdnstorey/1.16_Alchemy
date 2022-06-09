package com.jaiden.alchemy.core.init;

import com.jaiden.alchemy.Alchemy;
import com.jaiden.alchemy.common.container.QuarryContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerTypesInit {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, Alchemy.MODID);


    public static final RegistryObject<ContainerType<QuarryContainer>> QUARRY_CONTAINER_TYPE = CONTAINER_TYPES.register(
            "quarry", () -> IForgeContainerType.create(QuarryContainer::getClientContainer)
    );

}

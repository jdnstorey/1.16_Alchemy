package com.jaiden.alchemy.core.util;

import com.jaiden.alchemy.Alchemy;
import com.jaiden.alchemy.client.gui.QuarryGUI;
import com.jaiden.alchemy.core.init.ContainerTypesInit;
import net.minecraft.client.gui.ScreenManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Alchemy.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event){
        ScreenManager.register(ContainerTypesInit.QUARRY_CONTAINER_TYPE.get(), QuarryGUI::new);
    }

}

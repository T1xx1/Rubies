package net.t1xx1.rubies;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

@Mod(value = Rubies.MODID, dist = Dist.CLIENT)
@EventBusSubscriber(modid = Rubies.MODID, value = Dist.CLIENT)
public class RubiesClient {
    public RubiesClient(ModContainer container) {

    }

    @SubscribeEvent
    static void onClientSetup(FMLClientSetupEvent event) {

    }
}

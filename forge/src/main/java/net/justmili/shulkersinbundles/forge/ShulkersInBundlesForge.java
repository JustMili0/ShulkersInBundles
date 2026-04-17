package net.justmili.shulkersinbundles.forge;

import net.justmili.shulkersinbundles.ShulkersInBundles;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ShulkersInBundles.MOD_ID)
public class ShulkersInBundlesForge {
    public ShulkersInBundlesForge(FMLJavaModLoadingContext context) {
        ShulkersInBundles.init();

        FMLClientSetupEvent.getBus(context.getModBusGroup()).addListener(ShulkersInBundlesForge::onInitializeClient);
    }

    public static void onInitializeClient(FMLClientSetupEvent event) {
        ShulkersInBundles.init();
    }
}

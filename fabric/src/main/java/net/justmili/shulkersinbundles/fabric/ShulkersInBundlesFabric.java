package net.justmili.shulkersinbundles.fabric;

import net.fabricmc.api.ModInitializer;
import net.justmili.shulkersinbundles.ShulkersInBundles;

public class ShulkersInBundlesFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ShulkersInBundles.init();
    }
}
